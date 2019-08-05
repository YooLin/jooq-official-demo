package cn.sagreen.jooq.demo.simple;

import cn.sagreen.jooq.demo.JooqDemoApplicationTests;
import cn.sagreen.jooq.demo.tables.Author;
import cn.sagreen.jooq.demo.tables.Book;
import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author linyicong
 * @since 2019-08-01
 */
public class SimpleJOOQTests extends JooqDemoApplicationTests {
    @Autowired
    private DSLContext create;

    @Test
    public void testGetSql() {
        String sql = create.select(Book.BOOK.TITLE, Author.AUTHOR.FIRST_NAME, Author.AUTHOR.LAST_NAME)
                .from(Book.BOOK)
                .join(Author.AUTHOR)
                .on(Book.BOOK.AUTHOR_ID.eq(Author.AUTHOR.ID))
                .where(Book.BOOK.PUBLISHED_IN.eq(1948))
                .getSQL();
        Assert.assertEquals(sql, "select `store`.`book`.`title`, `store`.`author`.`first_name`, `store`.`author`.`last_name` from `store`.`book` join `store`.`author` on `store`.`book`.`author_id` = `store`.`author`.`id` where `store`.`book`.`published_in` = ?");
    }
}
