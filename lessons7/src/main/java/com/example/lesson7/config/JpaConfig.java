package com.example.lesson7.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;


@Configuration
@ComponentScan("com.example")
@EnableTransactionManagement
@ConfigurationProperties("hibernate.properties")
@Getter
@Setter
public class JpaConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        try {
            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
            dataSource.setDriverClass(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.example");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.ProgressDialect");
        hibernateProperties.put("hibernate.format_sql", true);
        hibernateProperties.put("hibernate.use_sql_comments", true);
        hibernateProperties.put("hibernate.show_sql", true);
        hibernateProperties.put("hibernate.max_fetch_depth", 3);
        hibernateProperties.put("hibernate.jdbc.batch_size", 10);
        hibernateProperties.put("hibernate.fetch_size", 50);
        return hibernateProperties;
    }
}

