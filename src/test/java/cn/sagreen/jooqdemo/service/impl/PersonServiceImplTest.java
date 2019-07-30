package cn.sagreen.jooqdemo.service.impl;

import cn.sagreen.jooqdemo.JooqDemoApplicationTests;
import cn.sagreen.jooqdemo.enums.SexEnum;
import cn.sagreen.jooqdemo.service.PersonService;
import cn.sagreen.jooqdemo.tables.daos.PersonDao;
import cn.sagreen.jooqdemo.tables.records.PersonRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author linyicong
 * @since 2019-07-26
 */
public class PersonServiceImplTest extends JooqDemoApplicationTests {
    @Autowired
    private PersonService personService;

    @Test
    public void testCreate() {
        this.personService.create("YooLin1c", 24, SexEnum.MAN);
    }

    @Test
    public void testQueryById() {
        PersonRecord personRecord = this.personService.queryById(1);
        System.out.println(personRecord);
    }

    @Test
    public void testQueryByName() {
        List<PersonRecord> personRecordList = this.personService.queryByName("lin");
        System.out.println(personRecordList);
    }
}