package com.example.appandcomponents.book;

import java.util.List;

public class StubBooksRepository implements BookRepository {
    private List<Book> getAll_returnValue;

    public void setGetAll_returnValue(List<Book> books) {
        this.getAll_returnValue = books;
    }

    @Override
    public List<Book> getAll() {
        return getAll_returnValue;
    }
}
