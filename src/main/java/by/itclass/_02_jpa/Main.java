package by.itclass._02_jpa;

import by.itclass._02_jpa.configuration.AppConfig;
import by.itclass._02_jpa.entities.Airplane;
import by.itclass._02_jpa.repositories.AirplaneRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // получаем контекст - который из AppConfig, получит описание всех Bean
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // создадим repository - который будет работать с нашими методами
        var repository = ctx.getBean(AirplaneRepository.class);
        var airbus = ctx.getBean("airbus360",Airplane.class);


        // "boeing747" имя должно совпадать с именем метода Bean (в AppConfig) !!!!
        System.out.println("=========boeing747===========");
        // создали id = null (0)
        var boeing = ctx.getBean("boeing747",Airplane.class);
        System.out.println("1 We just created: " + boeing);
        // сохранить в БД и получим поле id
        boeing = repository.save(boeing);
        System.out.println("2 Airplane after save: " + boeing);
        // изменили значение кол-во мест
        boeing.setPlace(250);
        // после изменения сохраняем
        boeing = repository.save(boeing);
        System.out.println("3 Airplane after update: " + boeing);


        System.out.println("=========airbus===========");
        System.out.println("1 We just created: " + airbus);

        airbus = repository.save(airbus);
        System.out.println("2 Airplane after save: " + airbus);

        airbus.setPlace(400);
        airbus = repository.save(airbus);
        System.out.println("3 Airplane after update: " + airbus);


    }
}
