package com.web.dashboard.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.web.dashboard.dao.UserDao;
import com.web.dashboard.entity.User;

public class UserDaoImpl implements UserDao{
	SessionFactory sessionFactory;
	
	public UserDaoImpl() {}
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}
	
	@Override
	public User save(User user) {		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            session.persist(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
            
        } finally {
            sessionFactory.close();
        }
        
		return user;
	}

	@Override
	public User findById(long id) {
		User u = null;
		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            u = session.createQuery("from User where id = :id", User.class)
            		.setParameter("id", id)
            		.getSingleResult();
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }	
        
		return u;
	}

	@Override
	public User findByEmail(String email) {
		User u = null;
		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            u = session.createQuery("from User where email = :email", User.class)
            		.setParameter("email", email)
            		.getSingleResult();
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
		
		return u;
	}

	@Override
	public User update(User user) {		
		User u = null;
		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            u = session.merge(user);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }		

		return u;
	}
	
	@Override
	public void deleteCompletely(User user) {		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.remove(user);
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }		
	}

	@Override
	public void markForDelete(long id) {		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            User user = session.get(User.class, id);
            user.setStatus(false);
          
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }		
	}
	
	@Override
	public List<User> findAll() {		
		List<User> users = null;
		
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            
            users = new LinkedList<User>();            
			users = session.createQuery("from User", User.class).getResultList();
			
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();            
        } finally {
            sessionFactory.close();
        }
        
		return users;
	}
}
