package com.ms.dao;

import com.ms.model.FitGymUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImplementation implements UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDAOImplementation.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(FitGymUser fitGymUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(fitGymUser);
        logger.info("Utworzono użytkownika" + fitGymUser.getUseremail());
    }

    @Override
    public void updateUser(FitGymUser fitGymUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(fitGymUser);
        logger.info("Zaktualizowano użytkownika" + fitGymUser.getUserimie());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FitGymUser> listUser() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FitGymUser> fitGymUsers = session.createQuery("from FitGymUser").list();
        for (FitGymUser fitGymUser : fitGymUsers) {
            logger.info("Fitgymuser: " + fitGymUser);
        }
        return fitGymUsers;
    }

    @Override
    public FitGymUser getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FitGymUser fitGymUser = (FitGymUser) session.load(FitGymUser.class, new int[(id)]);
        logger.info("Wybrano usera o id: " + fitGymUser);
        return fitGymUser;
    }
}
