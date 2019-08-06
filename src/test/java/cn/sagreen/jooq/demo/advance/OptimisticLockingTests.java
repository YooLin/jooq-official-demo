package cn.sagreen.jooq.demo.advance;

import cn.sagreen.jooq.demo.JooqDemoApplicationTests;
import cn.sagreen.jooq.demo.tables.records.BookRecord;
import org.jooq.DSLContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static cn.sagreen.jooq.demo.tables.Book.BOOK;

/**
 * @author linyicong
 * @since 2019-08-06
 */
public class OptimisticLockingTests extends JooqDemoApplicationTests {
    @Autowired
    private DSLContext dslContext;

    @Test
    public void testOptimisticLocking() {
        // 1. Fetch a book two times
        BookRecord book1 = dslContext.fetchOne(BOOK, BOOK.ID.eq(3));
        BookRecord book2 = dslContext.fetchOne(BOOK, BOOK.ID.eq(3));

        // 2. Change the title and store this book. The underlying database record has not been modified, it can be safely updated.
        book1.setTitle("Optimistic Locking");
        book1.store();

        // 3. Book2 still references the original TITLE value, but the database holds a new value from book1.store().
        book2.setTitle("1984");
        // 4. This store() will thus fail:
        book2.store();
    }
}
