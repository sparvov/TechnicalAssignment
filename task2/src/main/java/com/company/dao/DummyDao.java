package com.company.dao;

import java.util.List;

import com.company.domain.Hobby;

// This abstract class should be extended by some others with realisation of abstract methods
public abstract class DummyDao {

    public abstract List<Hobby> getHobbies(String name);

    public abstract Double getHobbyAverageCost(Hobby name);

}
