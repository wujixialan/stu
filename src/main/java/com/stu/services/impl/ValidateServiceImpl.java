package com.stu.services.impl;

import com.stu.services.ValidateService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidateServiceImpl implements ValidateService {
    /**
     * 判断那个字段有错误，然后返回具体的信息。
     *
     * @param br：传入的是具体的 BindingResult 属性，在这个属性中可以获取相应的字段信息。
     * @return：然后返回一个 map。
     */
    public Map<Object, Object> validateUser(BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", 400);
        FieldError fe;
        if (br.hasFieldErrors("userId")) {
            fe = br.getFieldError("userId");
            map.put(fe.getField(), "userId");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("username")) {
            fe = br.getFieldError("username");
            map.put(fe.getField(), "username");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("password")) {
            fe = br.getFieldError("password");
            map.put(fe.getField(), "password");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        }
        return null;
    }

    /**
     * 验证学生基本信息
     * 判断那个字段有错误，然后返回具体的信息。
     *
     * @param br ：传入的是具体的 BindingResult 属性，在这个属性中可以获取相应的字段信息。
     * @return：然后返回一个 map。
     */
    @Override
    public Map<Object, Object> validateStudent(BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", 400);
        FieldError fe;
        if (br.hasFieldErrors("sid")) {
            fe = br.getFieldError("sid");
            map.put(fe.getField(), "sid");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("name")) {
            fe = br.getFieldError("name");
            map.put(fe.getField(), "name");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("origin")) {
            fe = br.getFieldError("origin");
            map.put(fe.getField(), "origin");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("origin")) {
            fe = br.getFieldError("origin");
            map.put(fe.getField(), "origin");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("idCard")) {
            fe = br.getFieldError("idCard");
            map.put(fe.getField(), "idCard");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("address")) {
            fe = br.getFieldError("address");
            map.put(fe.getField(), "address");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        }
        return null;
    }

    /**
     * 验证学生成绩的填写
     * 判断那个字段有错误，然后返回具体的信息。
     *
     * @param br ：传入的是具体的 BindingResult 属性，在这个属性中可以获取相应的字段信息。
     * @return：然后返回一个 map。
     */
    @Override
    public Map<Object, Object> validateMark(BindingResult br) {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", 400);
        FieldError fe;
        System.out.println("validateMark");
        if (br.hasFieldErrors("subjectId")) {
            fe = br.getFieldError("subjectId");
            map.put(fe.getField(), "subjectId");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("subjectName")) {
            fe = br.getFieldError("subjectName");
            map.put(fe.getField(), "subjectName");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("score")) {
            fe = br.getFieldError("score");
            map.put(fe.getField(), "score");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("subjectType")) {
            fe = br.getFieldError("subjectType");
            map.put(fe.getField(), "subjectType");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("team")) {
            fe = br.getFieldError("team");
            map.put(fe.getField(), "team");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("credit")) {
            fe = br.getFieldError("credit");
            map.put(fe.getField(), "credit");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        } else if (br.hasFieldErrors("gpa")) {
            fe = br.getFieldError("gpa");
            map.put(fe.getField(), "gpa");
            map.put(fe.getField() + "Field", fe.getDefaultMessage());
            return map;
        }
        return null;
    }
}
