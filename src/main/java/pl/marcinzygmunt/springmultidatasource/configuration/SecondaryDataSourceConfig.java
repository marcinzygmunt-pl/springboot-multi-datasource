package pl.marcinzygmunt.springmultidatasource.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "pl.marcinzygmunt.springmultidatasource.secondary",
        entityManagerFactoryRef = "secondaryEntityManager",
        transactionManagerRef = "secondaryTransactionManager"
)
public class SecondaryDataSourceConfig {

    private final DataSourceHelper helperDataSource;

    public SecondaryDataSourceConfig(DataSourceHelper helperDataSource) {
        this.helperDataSource = helperDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManager() {
        return helperDataSource.prepareEntityManager(secondaryDataSource());
    }

    @Bean
    public DataSource secondaryDataSource() {
        return helperDataSource.prepareDataSource(
                "datasource.secondary.jdbcUrl",
                "datasource.secondary.username",
                "datasource.secondary.password",
                "datasource.secondary.jdbcDriver"
        );
    }

    @Bean
    public PlatformTransactionManager secondaryTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(secondaryEntityManager().getObject());
        return transactionManager;
    }
}
