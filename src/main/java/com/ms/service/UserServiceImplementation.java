package com.ms.service;

import com.ms.model.FitGymUser;
import com.ms.dao.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private UserDAO UserDAO;

    public void setUserDAO(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
    }

    @Override
    public void addUser(FitGymUser fitGymUser) {
        this.UserDAO.addUser(fitGymUser);

    }
}
