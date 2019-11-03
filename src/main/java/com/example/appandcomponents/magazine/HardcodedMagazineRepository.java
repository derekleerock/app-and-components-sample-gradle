package com.example.appandcomponents.magazine;

import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Collections.singletonList;

@Repository
public class HardcodedMagazineRepository implements MagazineRepository {
    @Override
    public List<Magazine> getAll() {
        return singletonList(
                new Magazine("Modern Drummer", "December, 2019")
        );
    }
}
