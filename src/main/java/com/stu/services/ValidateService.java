package com.stu.services;

import org.springframework.validation.BindingResult;

import java.util.Map;

public interface ValidateService {
    /**
     * 验证用户注册和登录
     * 判断那个字段有错误，然后返回具体的信息。
     * @param br：传入的是具体的 BindingResult 属性，在这个属性中可以获取相应的字段信息。
     * @return：然后返回一个 map。
     */
    public Map<Object, Object> validateUser(BindingResult br);

    /**
     * 验证学生基本信息
     * 判断那个字段有错误，然后返回具体的信息。
     * @param br：传入的是具体的 BindingResult 属性，在这个属性中可以获取相应的字段信息。
     * @return：然后返回一个 map。
     */
    public Map<Object,Object> validateStudent(BindingResult br);

    /**
     * 验证学生成绩的填写
     * 判断那个字段有错误，然后返回具体的信息。
     * @param br：传入的是具体的 BindingResult 属性，在这个属性中可以获取相应的字段信息。
     * @return：然后返回一个 map。
     */
    public Map<Object,Object> validateMark(BindingResult br);
}
