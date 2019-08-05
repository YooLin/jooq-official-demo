package cn.sagreen.jooq.demo.strategy;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

/**
 * JOOQ 代码生成自定义POJO名称策略
 *
 * @author linyicong
 * @since 2019-07-31
 */
public class CustomerNameStrategy extends DefaultGeneratorStrategy {
    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        if (mode == Mode.POJO) {
            return super.getJavaClassName(definition, mode).concat("DO");
        }
        return super.getJavaClassName(definition, mode);
    }
}
