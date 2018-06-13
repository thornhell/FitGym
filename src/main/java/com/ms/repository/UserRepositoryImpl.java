package com.ms.repository;

import com.ms.model.FitGymUser;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

   @Autowired
    SessionFactory sessionFactory;

    @Override
    public long allUserCount() {
        return sessionFactory.getCurrentSession().createQuery("from FitGymUser").list().size();
    }

    @Override
    public long allActiveUserCount() {
        return sessionFactory.getCurrentSession().createQuery("from FitGymUser where enabled = true").list().size();

    }

    @Override
    public FitGymUser findByFitgymid(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from FitGymUser where fitgymid = :name");
        query.setParameter("name", name);
        FitGymUser fitGymUser = (FitGymUser)query.uniqueResult();
        return  fitGymUser;
    }

    @Override
    public List<FitGymUser> allUsers() {
//        List<FitGymUser> lista = new ArrayList<FitGymUser>();
        return sessionFactory.getCurrentSession().createQuery("from FitGymUser").list();

    }

    @Override
    public void persist(FitGymUser fitGymUser) {
        sessionFactory.getCurrentSession().persist(fitGymUser);
    }
}
