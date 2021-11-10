package com.github.alexbabkin.javalang.classesandreflection.reflection;

import java.lang.reflect.Field;

public class Stringifier {

    private static String classFieldsToString(Object obj) throws IllegalAccessException {
        StringBuilder result = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                result.append(String.format(
                        result.length() == 1 ? "%s(%s) = %s" : ", %s(%s) = %s",
                        field.getName(),
                        field.getType().getSimpleName(),
                        field.getType().isPrimitive()
                                ? field.get(obj)
                                : classFieldsToString(field.get(obj))));
            }
            clazz = clazz.getSuperclass();
        }
        result.append("}");
        return result.toString();
    }

    public static String toString(Object obj) throws IllegalAccessException {
        return String.format("%s: %s", obj.getClass().getSimpleName(), classFieldsToString(obj));
    }
}
