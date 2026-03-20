package com.azure.cosmosdb.demo;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableConfigurationProperties(CosmosProperties.class)
@EnableJpaRepositories(basePackages = "com.azure.cosmosdb.demo.repository")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class CosmosSpringConfiguration {

    @Bean
    public DataSource dataSource() {
        // Implementation would depend on your specific data source setup
        return null;
    }

    @Entity
    @Table(name = "cosmos_entities")
    public static class CosmosEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "entity_data")
        private String entityData;

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEntityData() {
            return entityData;
        }

        public void setEntityData(String entityData) {
            this.entityData = entityData;
        }
    }

    public interface CosmosEntityRepository extends JpaRepository<CosmosEntity, Long> {
        List<CosmosEntity> findByEntityDataContaining(String entityData);
    }
}