package pl.khuzzuk.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class DAOConfiguration {
    @Bean(name = "primarySource", destroyMethod = "close")
    EntityManagerFactory primarySource() {
        return Persistence.createEntityManagerFactory("jndi.name.myDataSource");
    }

    @Bean(name = "secondarySource", destroyMethod = "close")
    EntityManagerFactory secondarySource() {
        return Persistence.createEntityManagerFactory("jndi.name.mySecondaryDataSource");
    }
}
