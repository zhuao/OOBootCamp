package com.tw.bootcamp.bridge;

import com.tw.bootcamp.bridge.domain.Book;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ControllerTest {

    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void should_get_book_by_book_id() {
        String bookId = "123456";

        Book book = controller.getBook(bookId);

        assertThat(book.getId(), is(bookId));
        assertThat(book.getName(), is("abc"));
    }
}
