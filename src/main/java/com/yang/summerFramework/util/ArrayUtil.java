package com.yang.summerFramework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @program: summer-framework
 * @description: 数组工具类
 * @author: yang Qiankun
 * @create: 2019-01-13 22:19
 **/
public final class ArrayUtil {

    /**
     * 判断数组是否非空
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtil.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
