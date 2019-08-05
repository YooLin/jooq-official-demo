package cn.sagreen.jooq.demo.advance;

import cn.sagreen.jooq.demo.JooqDemoApplicationTests;
import cn.sagreen.jooq.demo.tables.Author;
import cn.sagreen.jooq.demo.tables.pojos.AuthorDO;
import cn.sagreen.jooq.demo.util.ConditionUtils;
import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author linyicong
 * @since 2019-08-01
 */
public class DynamicQueryTests extends JooqDemoApplicationTests {
    @Autowired
    private DSLContext dslContext;

    @Test
    public void testDynamicQuery() {
        // param: George
        // String name = "George";

        // param: null
        String name = null;

        // dynamic query code
        List<AuthorDO> authorDOList = this.dslContext.selectFrom(Author.AUTHOR)
                .where(ConditionUtils.onlyIfNotNull(Author.AUTHOR.FIRST_NAME::eq, name))
                .fetchInto(AuthorDO.class);
        Assert.assertFalse(CollectionUtils.isEmpty(authorDOList));
    }
}
