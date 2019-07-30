package cn.sagreen.jooqdemo.service.impl;

import cn.sagreen.jooqdemo.enums.SexEnum;
import cn.sagreen.jooqdemo.service.PersonService;
import cn.sagreen.jooqdemo.tables.Person;
import cn.sagreen.jooqdemo.tables.records.PersonRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        this.dsl
                .insertInto(Person.PERSON)
                .set(Person.PERSON.ID, 1)
                .set(Person.PERSON.NAME, name)
                .set(Person.PERSON.AGE, age)
                .set(Person.PERSON.SEX, sexEnum.getCode())
                .execute();
    }

    @Override
    public PersonRecord queryById(int id) {
        return this.dsl
                .select()
                .from(Person.PERSON)
                .where(Person.PERSON.ID.eq(id))
                .fetchOneInto(PersonRecord.class);
    }

    @Override
    public List<PersonRecord> queryByName(String name) {
        return this.dsl
                .selectFrom(Person.PERSON)
                .where(Person.PERSON.NAME.likeIgnoreCase(String.format("%%%s%%", name)))
                .fetchInto(PersonRecord.class);
    }
}
