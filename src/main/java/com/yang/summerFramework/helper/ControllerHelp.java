package com.yang.summerFramework.helper;

import com.yang.summerFramework.annotation.Action;
import com.yang.summerFramework.bean.Handler;
import com.yang.summerFramework.bean.Request;
import com.yang.summerFramework.util.ArrayUtil;
import com.yang.summerFramework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: summer-framework
 * @description: 控制器助手类
 * @author: yang Qiankun
 * @create: 2019-01-16 21:27
 **/
public final class ControllerHelp {

    //用于存放请求与处理器的映射关系（简称Action Map）
   private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

   static {
       //获取所有的controller类
       Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
       if (CollectionUtil.isNotEmpty(controllerClassSet)) {
           //遍历这些Controller类
           for (Class<?> controllerClass : controllerClassSet) {
               //获取Controller类中定义的方法
               Method[] methods = controllerClass.getDeclaredMethods();
               if (ArrayUtil.isNotEmpty(methods)) {
                   //遍历这些Controller类中的方法
                   for (Method method : methods) {
                       //判断当前方法是否带有Action注解
                       if (method.isAnnotationPresent(Action.class)) {
                           //从Action注解中获取URL映射规则
                           Action action = method.getAnnotation(Action.class);
                           String mapping = action.value();
                           //验证URL映射规则
                           if (mapping.matches("\\w+:/\\w*")) {
                               String[] array = mapping.split(":");
                               if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                   //获取请求方法与请求路径
                                   String requestMethod = array[0];
                                   String requestPath = array[1];
                                   Request request = new Request(requestMethod,requestPath);
                                   Handler handler = new Handler(controllerClass,method);
                                   //初始化Action Map
                                   ACTION_MAP.put(request,handler);
                               }
                           }
                       }
                   }
               }
           }
       }
   }

    /**
     * 获取Handler
     * @param requestMethod
     * @param requestPath
     * @return
     */
   public static Handler getHandler(String requestMethod,String requestPath) {
       Request request = new Request(requestMethod,requestPath);
       return ACTION_MAP.get(request);
   }
}
