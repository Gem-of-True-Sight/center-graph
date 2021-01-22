package com.gots.cg.core;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class BeanFieldLambda {
    public static <T> String field(IGetter<T> fn) throws Exception {
        SerializedLambda lambda = getSerializedLambda(fn);
        String methodName = lambda.getImplMethodName();
        String prefix = null;
        if (methodName.startsWith("get")) {
            prefix = "get";
        } else if (methodName.startsWith("is")) {
            prefix = "is";
        }
        if (prefix == null) {
            System.out.println("无效的getter方法: " + methodName);
        }

        return toLowerCaseFirstOne(methodName.replaceFirst(prefix, ""));
    }

    public static SerializedLambda getSerializedLambda(Serializable fn) throws Exception {
        Method method = fn.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(Boolean.TRUE);
        SerializedLambda lambda = (SerializedLambda) method.invoke(fn);
        return lambda;
    }

    public static String toLowerCaseFirstOne(String field) {
        if (Character.isLowerCase(field.charAt(0)))
            return field;
        else {
            char firstOne = Character.toLowerCase(field.charAt(0));
            String other = field.substring(1);
            return new StringBuilder().append(firstOne).append(other).toString();
        }
    }
}
