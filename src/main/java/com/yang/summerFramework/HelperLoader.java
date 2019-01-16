package com.yang.summerFramework;

import com.yang.summerFramework.helper.BeanHelper;
import com.yang.summerFramework.helper.ClassHelper;
import com.yang.summerFramework.helper.ControllerHelp;
import com.yang.summerFramework.helper.IocHelper;
import com.yang.summerFramework.util.ClassUtil;

/**
 * @program: summer-framework
 * @description: 加载相应的Helper类
 * @author: yang Qiankun
 * @create: 2019-01-16 22:09
 **/
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelp.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),false);
        }
    }
}
