package com.web.dashboard.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.dashboard.dao.RoleDao;
import com.web.dashboard.dao.UserDao;
import com.web.dashboard.dao.impl.RoleDaoImpl;
import com.web.dashboard.dao.impl.UserDaoImpl;
import com.web.dashboard.entity.Role;
import com.web.dashboard.entity.User;

@Configuration
public class AppBeans {
	
    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .buildSessionFactory();
    }
    
    @Bean
    public UserDao userDao() {
    	return new UserDaoImpl(sessionFactory());
    }
    
    @Bean
    public RoleDao roleDao() {
    	return new RoleDaoImpl(sessionFactory());
    }
    
}
