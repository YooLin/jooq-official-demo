package cn.sagreen.jooqdemo.service.impl;

import cn.sagreen.jooqdemo.JooqDemoApplicationTests;
import cn.sagreen.jooqdemo.enums.SexEnum;
import cn.sagreen.jooqdemo.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author linyicong
 * @since 2019-07-26
 */
public class PersonServiceImplTest extends JooqDemoApplicationTests {
    @Autowired
    private PersonService personService;

    @Test
    public void create() {
        this.personService.create("YooLin1c", 24, SexEnum.MAN);
    }
}