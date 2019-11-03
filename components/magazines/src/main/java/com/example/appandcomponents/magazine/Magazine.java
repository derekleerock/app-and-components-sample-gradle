package com.example.appandcomponents.magazine;

import java.util.Objects;

public class Magazine {
    private final String name;
    private final String issue;

    public Magazine(String name, String issue) {
        this.name = name;
        this.issue = issue;
    }

    public String getName() {
        return name;
    }

    public String getIssue() {
        return issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(name, magazine.name) &&
                Objects.equals(issue, magazine.issue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, issue);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "name='" + name + '\'' +
                ", issue='" + issue + '\'' +
                '}';
    }
}
