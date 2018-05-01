package com.ms.dao;

import com.ms.model.FitGymUser;

import java.util.List;

public interface UserDAO {
    void addUser (FitGymUser fitGymUser);
    List<FitGymUser> listUser();
    void updateUser (FitGymUser fitGymUser);
    FitGymUser getUserById (int id);
}
