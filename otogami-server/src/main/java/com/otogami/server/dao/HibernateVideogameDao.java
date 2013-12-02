package com.otogami.server.dao;

import com.otogami.server.model.VideogameEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("videogameDao")
public class HibernateVideogameDao implements VideogameDao {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public VideogameEntity findById(Long id) {
        return (VideogameEntity) sessionFactory.getCurrentSession().get(VideogameEntity.class, id);
    }

    @Override
    public VideogameEntity findByStoreGameId(String storeId, String storeGameId) {
        return (VideogameEntity) sessionFactory.getCurrentSession().createCriteria(VideogameEntity.class)
                .add(Restrictions.like("storeId", storeId))
                .add(Restrictions.like("storeGameId", storeGameId))
                .uniqueResult();
    }

    @Override
    public List<VideogameEntity> findByPlatform(String platform) {
        return sessionFactory.getCurrentSession().createCriteria(VideogameEntity.class)
                .add(Restrictions.like("platform", platform))
                .list();
    }

    @Override
    public VideogameEntity saveOrUpdate(VideogameEntity videogame) {
        sessionFactory.getCurrentSession().saveOrUpdate(videogame);
        return videogame;
    }

}
