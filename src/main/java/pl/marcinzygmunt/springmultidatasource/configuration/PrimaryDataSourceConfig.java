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
        basePackages = "pl.marcinzygmunt.springmultidatasource.primary",
        entityManagerFactoryRef = "primaryEntityManager",
        transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDataSourceConfig {

    private final DataSourceHelper helperDataSource;

    public PrimaryDataSourceConfig(DataSourceHelper helperDataSource) {
        this.helperDataSource = helperDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean primaryEntityManager() {
        return helperDataSource.prepareEntityManager(primaryDataSource());
    }

    @Bean
    public DataSource primaryDataSource() {
        return helperDataSource.prepareDataSource(
                "datasource.primary.jdbcUrl",
                "datasource.primary.username",
                "datasource.primary.password",
                "datasource.primary.jdbcDriver"
        );

    }

    @Bean
    public PlatformTransactionManager primaryTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(primaryEntityManager().getObject());
        return transactionManager;
    }
}
