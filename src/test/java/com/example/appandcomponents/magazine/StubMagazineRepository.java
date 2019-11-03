package com.example.appandcomponents.magazine;

import java.util.List;

public class StubMagazineRepository implements MagazineRepository {
    private List<Magazine> getAll_returnValue;

    public <T> void setGetAll_returnValue(List<Magazine> magazines) {
        this.getAll_returnValue = magazines;
    }

    @Override
    public List<Magazine> getAll() {
        return getAll_returnValue;
    }
}
