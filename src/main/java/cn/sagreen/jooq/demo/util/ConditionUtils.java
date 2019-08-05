package cn.sagreen.jooq.demo.util;

import lombok.experimental.UtilityClass;
import org.jooq.Condition;
import org.jooq.impl.DSL;

import java.util.function.Function;

/**
 * @author linyicong
 * @since 2019-08-01
 */
@UtilityClass
public class ConditionUtils {
    public <T> Condition onlyIfNotNull(Function<T, Condition> operator, T value) {
        return (value != null) ? operator.apply(value) : DSL.noCondition();
    }
}
