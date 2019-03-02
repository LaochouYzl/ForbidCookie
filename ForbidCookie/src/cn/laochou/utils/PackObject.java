package cn.laochou.utils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 	打包对象
 * @author Administrator
 *
 */
public class PackObject{
	
	public static <T> T getObject(HttpServletRequest request, Class<T> c) {
		T t = null;
		try {
			t = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Enumeration<String> names = request.getParameterNames();
		Method[] methods = c.getDeclaredMethods();
		while(names.hasMoreElements()) {
			String paramName = names.nextElement();
			String setMethodName = reverseSetMethodName(paramName);
			for(Method method : methods) {
				if(setMethodName.equals(method.getName())) {
					try {
						Class<?> paramType = method.getParameterTypes()[0];
						String value = request.getParameter(paramName);
						adapter(t, method, paramType, value);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return t;
	}
	
	
	private static String reverseSetMethodName(String paramName) {
		char firstChar = paramName.charAt(0);
		char toUpper = Character.toUpperCase(firstChar);
		String setMethodName = "set"+String.valueOf(toUpper)+paramName.substring(1);
		return setMethodName;
	}
	
	private static <T> void adapter(T t, Method method, Class<?> paramType,String value) throws IllegalAccessException,InvocationTargetException {
        if (paramType == String.class) {
            method.invoke(t, value);
        } else if (paramType == Integer.class || paramType == int.class) {
            method.invoke(t, Integer.parseInt(value));
        } else if (paramType == Long.class || paramType == long.class) {
            method.invoke(t, Long.parseLong(value));
        } else if (paramType == Boolean.class || paramType == boolean.class) {
            method.invoke(t, Boolean.parseBoolean(value));
        } else if (paramType == Short.class || paramType == short.class) {
            method.invoke(t, Short.parseShort(value));
        } else if (paramType == Float.class || paramType == float.class) {
            method.invoke(t, Float.parseFloat(value));
        } else if (paramType == Double.class || paramType == double.class) {
            method.invoke(t, Double.parseDouble(value));
        } else if (paramType == Character.class || paramType == char.class) {
            char[] cs = value.toCharArray();
            if (cs.length > 1) {
                throw new IllegalArgumentException("参数长度太大");
            }
            method.invoke(t, value.toCharArray()[0]);
        }
    }
	

	
}
