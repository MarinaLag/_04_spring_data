package by.itclass._02_jpa;

import by.itclass._02_jpa.configuration.AppConfig;
import by.itclass._02_jpa.entities.Airplane;
import by.itclass._02_jpa.repositories.AirplaneRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        var repository = ctx.getBean(AirplaneRepository.class);

    /*    System.out.println("=========boeing747===========");
        var airplane = ctx.getBean("boeing747",Airplane.class);
        System.out.println("We just created: " + airplane);

        airplane = repository.save(airplane);
        System.out.println("Airplane after save: " + airplane);

        airplane.setPlace(250);
        airplane = repository.save(airplane);
        System.out.println("Airplane after update: " + airplane);

        System.out.println("=========airbus===========");
        var airbus = ctx.getBean("airbus360",Airplane.class);
        System.out.println("We just created: " + airbus);

        airbus = repository.save(airbus);
        System.out.println("Airplane after save: " + airbus);

        airbus.setPlace(400);
        airbus = repository.save(airbus);
        System.out.println("Airplane after update: " + airbus);

     */
        var boeing = repository.findByModelLike("Boe%");
        var airplane = repository.findByModelLikeAndPlace("air%", 350);
        var airplane1 = repository.findByPlaceBetween(300, 500);
        System.out.println(boeing);
        System.out.println(airplane);
        System.out.println(airplane1);

        List<Airplane> planes = repository.findByPlaceBetween(200, 500);
        planes.forEach(System.out::println);
        System.out.println("--------------");
        planes =repository.allPlaces();
        planes.forEach(System.out::println);

    }
}
