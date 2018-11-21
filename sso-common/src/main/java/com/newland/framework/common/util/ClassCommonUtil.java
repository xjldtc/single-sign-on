package com.newland.framework.common.util;

/**
 * 
 * @author xjldtc
 *
 */
public class ClassCommonUtil {

	/**
	 * @param c 检测是否是此类型  
	 * @param o 被检测类
	 * @author xjldtc
	 * @description: 检测判断是否是该类型
	 */
	public static boolean isCompatible(Class<?> c, Object o) {
		boolean pt = c.isPrimitive();
		if (o == null)
			return !pt;
		if (pt) {
			if (c == int.class)
				c = Integer.class;
			else if (c == boolean.class)
				c = Boolean.class;
			else if (c == long.class)
				c = Long.class;
			else if (c == float.class)
				c = Float.class;
			else if (c == double.class)
				c = Double.class;
			else if (c == char.class)
				c = Character.class;
			else if (c == byte.class)
				c = Byte.class;
			else if (c == short.class)
				c = Short.class;
		}
		if (c == o.getClass())
			return true;
		return c.isInstance(o);
	}
}
