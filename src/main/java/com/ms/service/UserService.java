package com.ms.service;

import com.ms.model.FitGymUser;

import java.util.List;

public interface UserService {
    List<FitGymUser> getUserDetails();
    FitGymUser findUserByFirgymid(String fitgymid);
}
