package com.tush.AngularPrj.configuration;


import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tush.AngularPrj.entity.*;



	@Configuration
	@EnableTransactionManagement
	public class HibernateConfiguration {
		
		@Value("${db.driverclass}")
		private String DB_DRIVERCLASS;
		
		@Value("${db.password}")
		private String DB_PASSWORD;
		
		@Value("${db.url}")
		private String DB_URL;
		
		@Value("${db.username}")
		private String DB_USERNAME;
		
		@Value("${hibernate.dialect}")
		private String HIBERNATE_DIALECT;
		
		@Value("${hibernate.show_sql}")
		private String HIBERNATE_SHOW_SQL;
		
		@Value("${hibernate.format_sql}")
		private String HIBERNATE_FORMAT_SQL;
		
		@Value("${hibernate.hbm2ddl.auto}")
		private String HIBERNATE_HBM2DDL_AUTO;
		
		@Value("${entitymanager.packagesToScan}")
		private String ENTITYMANAGER_PACKAGE_TO_SCAN;
		
		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource datasource=new DriverManagerDataSource();
			datasource.setDriverClassName(DB_DRIVERCLASS);
			datasource.setUrl(DB_URL);
			datasource.setPassword(DB_PASSWORD);
			datasource.setUsername(DB_USERNAME);
			return datasource;	
		}
		
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
			sessionFactory.setDataSource(dataSource());
			sessionFactory.setAnnotatedClasses(User.class);
			sessionFactory.setAnnotatedClasses(Employee.class);
			sessionFactory.setAnnotatedClasses(Country.class);
			sessionFactory.setPackagesToScan(ENTITYMANAGER_PACKAGE_TO_SCAN);
			Properties hibernateProperties=new Properties();
			hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
			hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
			hibernateProperties.put("hibernate.format_sql", HIBERNATE_FORMAT_SQL);
			hibernateProperties.put("hibernate.hbm2ddl.auto",HIBERNATE_HBM2DDL_AUTO);	
			sessionFactory.setHibernateProperties(hibernateProperties);
			return sessionFactory;		
		}
		
		@Bean
		public HibernateTransactionManager transactionmanager() {
			HibernateTransactionManager txManager=new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory().getObject());	
			return txManager;	
		}
		
	}




