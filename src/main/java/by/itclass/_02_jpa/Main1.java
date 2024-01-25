package by.itclass._02_jpa;

import by.itclass._02_jpa.configuration.AppConfig;
import by.itclass._02_jpa.entities.Airplane;
import by.itclass._02_jpa.repositories.AirplaneRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        var repository = ctx.getBean(AirplaneRepository.class);

        var boeing = repository.findByModelLike("Boe%");
        var airbus1 = repository.findByModelLikeAndPlace("Air%", 360);
        var airbus2 = repository.findByModelLikeOrPlace("Air%", 350);

        System.out.println("boeing " + boeing);
        System.out.println("airbus1 " + airbus1);
        System.out.println("airbus2 " + airbus2);

        //var airplane1 = repository.findByPlaceBetween(300, 500);
        // System.out.println(airplane1);

        System.out.println("--------planes---200-500------");
        List<Airplane> planes = repository.findByPlaceBetween(200, 500);
        planes.forEach(System.out::println);

        System.out.println("------allPlaces--------");
        planes = repository.allPlanes();
        planes.forEach(System.out::println);

        System.out.println("------concretePlains--------");
        planes = repository.concretePlains("Boe%",200);
        planes.forEach(System.out::println);

    }
}
