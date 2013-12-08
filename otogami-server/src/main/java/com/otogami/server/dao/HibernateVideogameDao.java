package com.otogami.server.dao;

import com.otogami.server.facade.VideogameSearchSpecification;
import com.otogami.server.model.VideogameEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("videogameDao")
public class HibernateVideogameDao implements VideogameDao {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public List<VideogameEntity> find(VideogameSearchSpecification searchSpecification) {
        String query = "from VideogameEntity order by title asc";
        return getSession().createQuery(query).list();
    }

    @Override
    public VideogameEntity findById(Long id) {
        return (VideogameEntity) getSession().get(VideogameEntity.class, id);
    }

    @Override
    public VideogameEntity findByStoreGameId(String storeId, String storeGameId) {
        return (VideogameEntity) getSession().createCriteria(VideogameEntity.class)
                .add(Restrictions.like("storeId", storeId))
                .add(Restrictions.like("storeGameId", storeGameId))
                .uniqueResult();
    }

    @Override
    public List<VideogameEntity> findByPlatform(String platform) {
        return getSession().createCriteria(VideogameEntity.class)
                .add(Restrictions.like("platform", platform))
                .list();
    }

    @Override
    public VideogameEntity saveOrUpdate(VideogameEntity videogame) {
        getSession().saveOrUpdate(videogame);
        return videogame;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
