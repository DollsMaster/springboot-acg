package com.example.springbootacg.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;

public abstract class ConvertorUtils {
    public static <T, R> R convert(T source, Class<R> targetClass) {
        if (source == null) {
            return null;
        }
        Constructor <R> constructor = null;
        try {
            constructor = targetClass.getConstructor();
            R target = constructor.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("拷贝错误");
        }
    }
}
