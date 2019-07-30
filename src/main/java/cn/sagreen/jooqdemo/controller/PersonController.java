package cn.sagreen.jooqdemo.controller;

import cn.sagreen.jooqdemo.tables.daos.PersonDao;
import cn.sagreen.jooqdemo.tables.pojos.Person;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linyicong
 * @since 2019-07-30
 */
@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {
    private PersonDao personDao;

    @GetMapping
    public List<Person> list() {
        return this.personDao.findAll();
    }
}
