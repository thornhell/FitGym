package com.ms.service;

import com.ms.model.FitGymUser;
import com.ms.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserDAO userDAO;

    public List<FitGymUser> getUserDetails() {
        return userDAO.getUserDetails();
    }

    public FitGymUser findUserByFirgymid(String fitgymid){
        return userDAO.findUserByFirgymid(fitgymid);
    }
}
