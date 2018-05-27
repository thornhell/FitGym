package com.ms.dao;

import com.ms.model.FitGymUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@Repository
public class UserDAOImplementation implements UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDAOImplementation.class);

    @Autowired
    private SessionFactory sessionFactory;

    public FitGymUser findUserByEmail(String email) {
        FitGymUser userDetails = null;
        Criteria criteria = sessionFactory.openSession().createCriteria(FitGymUser.class);
        criteria.add(Restrictions.eq("email", email));
        List<FitGymUser> entityList = criteria.list();
        if(!entityList.isEmpty()) {
            userDetails = entityList.get(0);
        }
        return userDetails;
    }


    public FitGymUser findUserByFirgymid(String fitgymid){
        FitGymUser userDetails = null;
        Criteria criteria = sessionFactory.openSession().createCriteria(FitGymUser.class);
        criteria.add(Restrictions.eq("fitgymid", fitgymid));
        List<FitGymUser> entityList = criteria.list();
        if(!entityList.isEmpty()) {
            userDetails = entityList.get(0);
        }
        return userDetails;
    }

    public List<FitGymUser> getUserDetails() {
        Criteria criteria = sessionFactory.openSession().createCriteria(FitGymUser.class);
        return criteria.list();
    }
}
