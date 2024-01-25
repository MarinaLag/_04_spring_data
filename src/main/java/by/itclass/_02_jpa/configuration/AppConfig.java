package by.itclass._02_jpa.configuration;

import by.itclass._02_jpa.entities.Airplane;
import by.itclass._02_jpa.entities.Passenger;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.List;

@EnableJpaRepositories(basePackages = "by.itclass._02_jpa.repositories")
public class AppConfig {
    // ИМЯ ОБЪЕКТА ДОЛЖНО СОВПАДАТЬ С ИМЕНЕМ МЕТОДА!!!!
    // ИЛИ  ПЕРЕОПРЕДЕЛЯЕМ Bean - @Bean(name = "entityManagerFactory")

    // vendor - это технология
    // определяет с какаим типом БД мы будем работать
    // работаем над hibernate
    @Bean
    public JpaVendorAdapter vendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    // этот контенер - возьмет vendor и пакет где лежат entities
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean factory(JpaVendorAdapter vendorAdapter){
        var container = new  LocalContainerEntityManagerFactoryBean();
        container.setJpaVendorAdapter(vendorAdapter);
        container.setPackagesToScan("by.itclass._02_jpa.entities");
        return container;
    }

    // entityManagerFactory == factory !!!!!!
    // @Bean(name = "entityManagerFactory")
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


    // создаем самолеты
    @Bean
    public Airplane boeing747(){
        return new Airplane("Boeing-747", 150);
    }

    @Bean
    public Airplane airbus360(){
        return new Airplane("Airbus-360", 360);
    }

    @Bean
    public List<Passenger> passengers(){
        return List.of(
                new Passenger("Vano"),
                new Passenger("Petro"),
                new Passenger("Sergo"),
                new Passenger("Janna")
        );
    }



}
