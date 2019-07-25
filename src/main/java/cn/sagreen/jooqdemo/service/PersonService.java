package cn.sagreen.jooqdemo.service;

import cn.sagreen.jooqdemo.enums.SexEnum;

/**
 * @author linyicong
 * @since 2019-07-26
 */
public interface PersonService {

    void create(String name, int age, SexEnum sexEnum);
}
