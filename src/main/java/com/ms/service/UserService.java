package com.ms.service;

import com.ms.model.FitGymUser;

import java.util.List;

public interface UserService {
    long allUserCount();
    long allActiveUserCount();
    FitGymUser findByFitgymid(String name);
    List<FitGymUser> allUsers();
    void persist(FitGymUser fitGymUser);
}
