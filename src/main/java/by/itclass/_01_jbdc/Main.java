package by.itclass._01_jbdc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {
    public static void main(String[] args) {
       // var datasource = new DriverManagerDataSource();
        var datasource = new SimpleDriverDataSource();
        datasource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        datasource.setUrl("jdbc:mysql://localhost:3306/po_2211");
        datasource.setUsername("root");
        datasource.setPassword("");

        var jdbcTemplate = new JdbcTemplate(datasource);

        var users =jdbcTemplate.query("SELECT * FROM user", new UserRowMapping());
        users.forEach(System.out::println);

        System.out.println("================");
        jdbcTemplate.query("SELECT * FROM user WHERE id > ?", new UserRowMapping(),new Object[]{3} )
                .forEach(System.out::println);

        System.out.println("================");
        jdbcTemplate.update("UPDATE user SET name = ? WHERE id = ?", "Vasy", 3);
        jdbcTemplate.query("SELECT * FROM user", new UserRowMapping() )
                .forEach(System.out::println);
    }
}
