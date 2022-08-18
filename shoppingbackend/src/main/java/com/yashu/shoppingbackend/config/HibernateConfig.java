package com.yashu.shoppingbackend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.yashu.shoppingbackend"})
@EnableTransactionManagement

public class HibernateConfig {
	
	
	private final static String DATABASE_URL="jdbc:mysql://localhost:3306/onlineshopping";
	private final static String DATABASE_DRIVER="com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQL5Dialect";
	private final static String DATABASE_USERNAME="root";
	private final static String DATABASE_PASSWORD="root";
	
	
	
	@Bean(name="datasource")
	public DataSource getDataSource(){
		
		BasicDataSource datasource=new BasicDataSource();
		
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		return datasource;
	}
	
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource){
		
		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.yashu.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}


	 Properties getHibernateProperties() {
		
		Properties properties= new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTranscationManager(SessionFactory sessionfactory){
		HibernateTransactionManager transcationManager= new HibernateTransactionManager(sessionfactory);
		
		return transcationManager;
		
	}
	
	
	
	
	
	

}
