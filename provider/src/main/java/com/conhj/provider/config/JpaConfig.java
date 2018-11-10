package com.conhj.provider.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.conhj.provider.dao")
public class JpaConfig implements EnvironmentAware {

    private  Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.valueOf(this.environment.getProperty("spring.jpa.database")));
        jpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean(this.environment.getProperty("spring.jpa.hibernate.ddl-auto")));
        jpaVendorAdapter.setShowSql(Boolean.parseBoolean(this.environment.getProperty("spring.jpa.showSql")));
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.conhj.api.po");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        return emf;
    }




}
