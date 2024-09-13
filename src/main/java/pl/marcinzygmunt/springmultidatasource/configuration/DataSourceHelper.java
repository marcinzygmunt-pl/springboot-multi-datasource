package pl.marcinzygmunt.springmultidatasource.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;

@Component
public class DataSourceHelper {

    @Autowired
    private Environment env;

    public DataSource prepareDataSource(String url, String user, String pass, String jdbcDriver){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty(url));
        config.setUsername(env.getProperty(user));
        config.setPassword(env.getProperty(pass));
        config.setDriverClassName(env.getProperty(jdbcDriver));
        return new HikariDataSource(config);
    }

    public LocalContainerEntityManagerFactoryBean prepareEntityManager (DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("pl.marcinzygmunt.springmultidatasource");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        final HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        em.setJpaPropertyMap(properties);
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }
}
