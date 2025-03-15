package springboot.acg.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import springboot.acg.common.enums.MsgCodeEnum;

import java.lang.reflect.Constructor;
import java.net.BindException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class ConvertorUtils {

    public static <T, R> List<R> convert(Collection<T> collection, Function<T, R> function) {
        if (collection == null) {
            return null;
        }
        return collection.stream().map(function).collect(Collectors.toList());
    }

    public static  <T, R> R copyProperties(T source, Class<R> targetClass) {
        Constructor<R> constructor = null;
        try {
            constructor = targetClass.getConstructor();
            R target = constructor.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            return null;
        }
    }
    public static <T, R> void addProperties(T source, R target) {
        if (source == null || target == null) {
            return;
        }
        try {
            BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            return;
        }
    }
}
