package com.simple.item.config

import com.simple.item.repository.EscrowRepository
import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackageClasses = [EscrowRepository::class])
@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.PROXY)
class JpaConfig (private val env: Environment){
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    fun escrowDataSource(): DataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean
    fun entityManagerFactoryBuilder(): EntityManagerFactoryBuilder {
        return EntityManagerFactoryBuilder(HibernateJpaVendorAdapter(), HashMap<String, Any>(), null)
    }

    @Bean
    fun entityManagerFactory(
        @Qualifier("entityManagerFactoryBuilder") builder: EntityManagerFactoryBuilder,
        @Qualifier("escrowDataSource") dataSource: DataSource, jpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        return builder.dataSource(dataSource).packages(EscrowRepository::class.java).persistenceUnit("escrow")
            .properties(jpaProperties).build()
    }

    @Primary
    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        val tm = JpaTransactionManager()
        tm.entityManagerFactory = entityManagerFactory
        return tm
    }

    @Bean
    fun jpaProperties(): JpaProperties {
        val showSql = env.getProperty("spring.jpa.properties.hibernate.show_sql")!!
        val formatSql = env.getProperty("spring.jpa.properties.hibernate.format_sql")!!
        val useSqlComments = env.getProperty("spring.jpa.properties.hibernate.use_sql_comments")!!
        return JpaProperties(showSql, formatSql, useSqlComments)
    }
}
