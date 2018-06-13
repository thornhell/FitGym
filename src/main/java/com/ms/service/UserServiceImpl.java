package com.ms.service;

import com.ms.model.FitGymUser;
import com.ms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public long allUserCount() {
        return userRepository.allUserCount();
    }

    @Override
    public long allActiveUserCount() {
        return userRepository.allActiveUserCount();
    }

    @Override
    public FitGymUser findByFitgymid(String name){
        return userRepository.findByFitgymid(name);
    }

    @Override
    public List<FitGymUser> allUsers() {
        return userRepository.allUsers();
    }

    @Override
    public void persist(FitGymUser fitGymUser) {
        userRepository.persist(fitGymUser);
    }

}
