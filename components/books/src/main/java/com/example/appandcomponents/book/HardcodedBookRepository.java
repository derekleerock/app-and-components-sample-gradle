package com.example.appandcomponents.book;

import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Collections.singletonList;

@Repository
public class HardcodedBookRepository implements BookRepository {
    @Override
    public List<Book> getAll() {
        return singletonList(
                new Book("Extreme Programming Explained", "Kent Beck")
        );
    }
}
