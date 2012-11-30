package posjava.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import posjava.modelo.Cidade;
import posjava.persistencia.HibernateUtil;

/**
 *
 * @author alan
 */
@Repository
public class DAOCidade {
    
    public void delete(Cidade cidade) {
        Session session = (Session) HibernateUtil.getEntityManager().getDelegate();
        session.delete(cidade);
    }
    
    public void save(Cidade cidade) {
        Session session = (Session) HibernateUtil.getEntityManager().getDelegate();
        session.persist(cidade);
    }
    
    public List list() {
        Session session = (Session) HibernateUtil.getEntityManager().getDelegate();
        Criteria criteria = session.createCriteria(Cidade.class);
        return criteria.list();
    }
    
    public Cidade consulta(Cidade cidade) {
        Session session = (Session) HibernateUtil.getEntityManager().getDelegate();
        Criteria criteria = session.createCriteria(Cidade.class);
        criteria.add(Restrictions.eq("id", cidade.getId()));
        return (Cidade) criteria.uniqueResult();
    }
    
}