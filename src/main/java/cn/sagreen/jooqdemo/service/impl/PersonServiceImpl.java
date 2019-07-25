package cn.sagreen.jooqdemo.service.impl;

import cn.sagreen.jooqdemo.enums.SexEnum;
import cn.sagreen.jooqdemo.service.PersonService;
import cn.sagreen.jooqdemo.tables.Person;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author linyicong
 * @since 2019-07-26
 */
@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private DSLContext dsl;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(String name, int age, SexEnum sexEnum) {
        dsl.insertInto(Person.PERSON)
                .set(Person.PERSON.ID, 1)
                .set(Person.PERSON.NAME, name)
                .set(Person.PERSON.AGE, age)
                .set(Person.PERSON.SEX, sexEnum.getCode())
                .execute();
        int i = 1 / 0;
    }
}
