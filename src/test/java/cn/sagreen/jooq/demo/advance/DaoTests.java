package cn.sagreen.jooq.demo.advance;

import cn.sagreen.jooq.demo.JooqDemoApplicationTests;
import cn.sagreen.jooq.demo.tables.daos.AuthorDao;
import cn.sagreen.jooq.demo.tables.pojos.AuthorDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

/**
 * @author linyicong
 * @since 2019-08-01
 */
public class DaoTests extends JooqDemoApplicationTests {
    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testQueryAll() {
        List<AuthorDO> authorDOList = this.authorDao.findAll();
        Assert.assertFalse(CollectionUtils.isEmpty(authorDOList));
    }

    @Test
    public void testQueryById() {
        int authorId = 1;
        AuthorDO authorDO = this.authorDao.findById(authorId);
        Assert.assertNotNull(authorDO);
    }

    @Test
    public void testQueryBatchByIds() {
        Integer[] authorIds = {1, 2};
        List<AuthorDO> authorDOList = this.authorDao.fetchById(authorIds);
        Assert.assertFalse(CollectionUtils.isEmpty(authorDOList));
    }

    @Test
    public void testAddOne() {
        LocalDate now = LocalDate.now();
        AuthorDO authorDO = new AuthorDO();
        authorDO.setFirstName("yc");
        authorDO.setLastName("lin");
        authorDO.setDateOfBirth(now);
        authorDO.setYearOfBirth(now.getYear());
        this.authorDao.insert(authorDO);
        // can't return generated key
        Assert.assertNull(authorDO.getId());
    }

    /**
     * 表结构中定义为非空，代码生成时，会为其添加 nullable(false) ，更新操作时会将为null的过滤掉不加入到SQL中
     *
     * @see cn.sagreen.jooq.demo.tables.Author#FIRST_NAME
     */
    @Test
    public void testUpdateOne() {
        AuthorDO authorDO = new AuthorDO();
        authorDO.setId(5);
        authorDO.setDistinguished(1);
        this.authorDao.update(authorDO);
    }

    @Test
    public void testDeleteById() {
        int id = 5;
        this.authorDao.deleteById(id);
    }
}
