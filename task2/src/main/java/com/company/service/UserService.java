package com.company.service;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Logger;

import com.company.dao.DummyDao;
import com.company.domain.Hobby;
import com.company.domain.User;

public class UserService {

    private DummyDao dao;

    // This field will never be changed so it can be declare as final to make it immutable
    // Method .getLogger(...) takes class as a parameter, so .toString() is a mistake
    private final Logger logger = Logger.getLogger(User.class.toString());

    public UserService(DummyDao dao) {
        this.dao = dao;
    }

    // In this method the all calculations can be made in one loop, so second loop was removed
    public double calculateHobbyCosts(final User user) {
        double totalCosts = 0;
        Collection<Hobby> userHobbies = getUserHobbies(user);
        for (final Hobby hobby : userHobbies) {
            totalCosts = totalCosts + dao.getHobbyAverageCost(hobby);
        }
        return totalCosts;
    }

    // Looks like this method can be private
    private Collection<Hobby> getUserHobbies(final User user) {
        logger.info("Get " + user.getUserName() + "'s hobbies from database");
        List<Hobby> hobbiesList = dao.getHobbies(user.getUserName());
        return new TreeSet<>(hobbiesList);
    }

}
