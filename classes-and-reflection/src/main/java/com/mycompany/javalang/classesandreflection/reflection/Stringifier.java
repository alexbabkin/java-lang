package com.mycompany.javalang.classesandreflection.reflection;

import java.lang.reflect.Field;

public class Stringifier {

    private static String classFieldsToString(Object obj) throws IllegalAccessException {
        String result = "{";
        Class<?> clazz = obj.getClass();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                result +=
                        String.format(
                                result.length() == 1 ? "%s(%s) = %s" : ", %s(%s) = %s",
                                field.getName(),
                                field.getType().getSimpleName(),
                                field.getType().isPrimitive()
                                        ? field.get(obj)
                                        : classFieldsToString(field.get(obj)));
            }
            clazz = clazz.getSuperclass();
        }
        result += "}";
        return result;
    }

    public static String toString(Object obj) throws IllegalAccessException {
        String result =
                String.format("%s: %s", obj.getClass().getSimpleName(), classFieldsToString(obj));
        return result;
    }
}
