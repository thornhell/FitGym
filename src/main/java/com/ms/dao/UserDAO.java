package com.ms.dao;

import com.ms.model.FitGymUser;

import java.util.List;

public interface UserDAO {
    FitGymUser findUserByEmail(String email);
    FitGymUser findUserByFirgymid(String fitgymid);
    List<FitGymUser> getUserDetails();
}
