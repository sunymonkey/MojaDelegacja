package pl.sunymonkey.mojadelegacja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sunymonkey.mojadelegacja.model.Role;
import pl.sunymonkey.mojadelegacja.model.User;
import pl.sunymonkey.mojadelegacja.service.UserService;
import pl.sunymonkey.mojadelegacja.service.RoleService;

@SpringBootApplication
public class MojaDelegacjaApplication {

    public static void main(String[] args) {

        SpringApplication.run(MojaDelegacjaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserService userService, RoleService roleService) { //funkcja ktora uruchamia sie podczas startu aplikacji (za kazdym razem)
            return (args) -> {

                if(roleService.findByName("ROLE_ADMIN")==null) { //patrzymy czy mamy role admin i jesli nie to ja tworzymy
                    Role r = new Role();
                    r.setName("ROLE_ADMIN");
                    roleService.save(r);
                }
                if(roleService.findByName("ROLE_USER")==null) { //analogicznie do roli wyzej
                    Role r = new Role();
                    r.setName("ROLE_USER");
                    roleService.save(r);
                }
                if(userService.findByUsername("admin")==null){ //tworze admina

                    User user = new User();
                    user.setFirstName("Super user");
                    user.setLastName("Super user");
                    user.setUsername("admin");
                    user.setPassword("admin");
                    userService.saveAdmin(user);
                }
            };
        }



}
