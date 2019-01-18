package com.yang.summerFramework.bean;

import com.yang.summerFramework.util.CastUtil;

import java.util.Map;

/**
 * @program: summer-framework
 * @description: 请求参数对象
 * @author: yang Qiankun
 * @create: 2019-01-17 21:15
 **/
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型字段
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段细信息
     * @return
     */
    public Map<String,Object> getMap() {
        return paramMap;
    }
}
