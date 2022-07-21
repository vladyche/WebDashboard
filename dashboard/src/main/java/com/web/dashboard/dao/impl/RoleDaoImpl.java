package com.web.dashboard.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.web.dashboard.dao.RoleDao;
import com.web.dashboard.entity.Role;

public class RoleDaoImpl implements RoleDao {
	SessionFactory sessionFactory;
	
	public RoleDaoImpl() {}
	
	public RoleDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}

	@Override
	public Role findById(int id) {
		Role role = null;
		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            role = session.createQuery("from Role where id = :id", Role.class)
            		.setParameter("id", id)
            		.getSingleResult();
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        
        return role;
	}

	@Override
	public Role save(Role role) {
		
		try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.persist(role);
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
            
        } finally {
            sessionFactory.close();
        }
		
		return role;
	}

	@Override
	public Role update(Role role) {
		Role r = null;
		
		try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            r = session.merge(role);
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
		
		return r;
	}

	@Override
	public void delete(Role role) {
		try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.remove(role);
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
	}

}
