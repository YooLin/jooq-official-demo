package cn.sagreen.jooqdemo.service;

import cn.sagreen.jooqdemo.enums.SexEnum;
import cn.sagreen.jooqdemo.tables.records.PersonRecord;

import java.util.List;

/**
 * @author linyicong
 * @since 2019-07-26
 */
public interface PersonService {

    void create(String name, int age, SexEnum sexEnum);

    PersonRecord queryById(int id);

    List<PersonRecord> queryByName(String name);
}
