package com.company.domain;

// 1. Field name should be private
// 2. Getters and setters are added

public class Hobby {

    private String name;

    public Hobby() {
    }

    public Hobby(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}