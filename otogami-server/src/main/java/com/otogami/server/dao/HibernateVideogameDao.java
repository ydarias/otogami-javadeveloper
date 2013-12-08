package com.otogami.server.dao;

import com.otogami.server.facade.VideogameSearchSpecification;
import com.otogami.server.model.VideogameEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("videogameDao")
public class HibernateVideogameDao implements VideogameDao {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public List<VideogameEntity> find(VideogameSearchSpecification searchSpecification) {
        String query = new VideogameQueryBuilder(searchSpecification).build();
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

    private class VideogameQueryBuilder {

        List<String> whereClauses = new ArrayList<String>();

        List<String> orderClauses = new ArrayList<String>();

        public VideogameQueryBuilder(VideogameSearchSpecification specification) {
            extractWhereClauses(specification);
            extractOrderClauses(specification);
        }

        public String build() {
            StringBuffer queryBuffer = new StringBuffer();
            queryBuffer.append("from VideogameEntity ");
            addClauses(queryBuffer, whereClauses, "where", "and");
            addClauses(queryBuffer, orderClauses, "order by", ",");

            return queryBuffer.toString();
        }

        private void extractOrderClauses(VideogameSearchSpecification specification) {
            if (specification.isMinorPrice())
                orderClauses.add("price asc ");
            orderClauses.add("title asc ");
        }

        private void extractWhereClauses(VideogameSearchSpecification specification) {
            if (specification.hasTitle()) {
                String title = specification.getTitle().toLowerCase();
                whereClauses.add("lower(title) like '%" + title + "%' ");
            }
            if (specification.hasPlatform()) {
                String platform = specification.getPlatform();
                whereClauses.add("platform = '" + platform + "' ");
            }
            if (specification.isAvailable())
                whereClauses.add("availability = 'InStock' ");
        }

        private void addClauses(StringBuffer buffer, List<String> clauses, String clauseOperator, String clauseSeparator) {
            if (clauses.size() > 0) {
                buffer.append(clauseOperator + " ");
                boolean firstElement = true;
                for (String clause : clauses) {
                    if (!firstElement)
                        buffer.append(clauseSeparator + " ");
                    buffer.append(clause);
                    firstElement = false;
                }
            }
        }

    }

}
