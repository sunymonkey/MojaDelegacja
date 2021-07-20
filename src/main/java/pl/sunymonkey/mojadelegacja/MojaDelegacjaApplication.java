package pl.sunymonkey.mojadelegacja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sunymonkey.mojadelegacja.model.*;
import pl.sunymonkey.mojadelegacja.service.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MojaDelegacjaApplication {

    public static void main(String[] args) {

        SpringApplication.run(MojaDelegacjaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserService userService,
                           RoleService roleService,
                           TypoOfExpensesService typoOfExpensesService,
                           StatusService statusService,
                           PaymentMethodService paymentMethodService,
                           CurrencyService currencyService) { //funkcja ktora uruchamia sie podczas startu aplikacji (za kazdym razem)
            return (args) -> {

                if(roleService.findByName("ROLE_ADMIN")==null) { //patrzymy czy mamy role admin i jesli nie to ja tworzymy
                    Role r = new Role();
                    r.setName("ROLE_ADMIN");
                    roleService.save(r);
                }
                if(roleService.findByName("ROLE_EMPLOYEE")==null) { //analogicznie do roli wyzej
                    Role r = new Role();
                    r.setName("ROLE_EMPLOYEE");
                    roleService.save(r);
                }
                if(roleService.findByName("ROLE_MANAGER")==null) { //analogicznie do roli wyzej
                    Role r = new Role();
                    r.setName("ROLE_MANAGER");
                    roleService.save(r);
                }
                if(roleService.findByName("ROLE_FINANCE")==null) { //analogicznie do roli wyzej
                    Role r = new Role();
                    r.setName("ROLE_FINANCE");
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

                List<String> typeOfExpensesList = new ArrayList<>();
                typeOfExpensesList.add("Hotel");
                typeOfExpensesList.add("Kolej");
                typeOfExpensesList.add("Nocleg(ryczałt)");
                typeOfExpensesList.add("Nocleg(ryczałt) zagraniczny");
                typeOfExpensesList.add("Samochód pryw.(do 900cm3)");
                typeOfExpensesList.add("Samochód pryw.(pow 900cm3)");
                typeOfExpensesList.add("Samochód służbowy");
                typeOfExpensesList.add("Samolot");
                typeOfExpensesList.add("Taxi");
                typeOfExpensesList.add("Zaliczka");
                typeOfExpensesList.add("Inne");

                for (int i = 0; i < typeOfExpensesList.size(); i++) {
                    if(typoOfExpensesService.findByName(typeOfExpensesList.get(i))==null) {
                        TypeOfExpenses t = new TypeOfExpenses();
                        t.setType(typeOfExpensesList.get(i));
                        typoOfExpensesService.save(t);
                    }
                }

                List<String> statusList = new ArrayList<>();
                statusList.add("Nowy");
                statusList.add("Wysłany");
                statusList.add("Zaakceptowany");
                statusList.add("Anulowany");
                statusList.add("Odmowa");

                for (int i = 0; i < statusList.size(); i++) {
                    if(statusService.findByStatus(statusList.get(i))==null) {
                        Status s = new Status();
                        s.setStatus(statusList.get(i));
                        statusService.save(s);
                    }
                }

                List<String> paymentMethodList = new ArrayList<>();
                paymentMethodList.add("Karta firmowa");
                paymentMethodList.add("Przelew");
                paymentMethodList.add("Pracownik");

                for (int i = 0; i < paymentMethodList.size(); i++) {
                    if(paymentMethodService.findByMethod(paymentMethodList.get(i))==null) {
                        PaymentMethod paymentMethod = new PaymentMethod();
                        paymentMethod.setMethod(paymentMethodList.get(i));
                        paymentMethodService.save(paymentMethod);
                    }
                }

                List<String> currencyList = new ArrayList<>();
                currencyList.add("AUD");
                currencyList.add("CAD");
                currencyList.add("CHF");
                currencyList.add("DKK");
                currencyList.add("EUR");
                currencyList.add("GBP");
                currencyList.add("JPY");
                currencyList.add("NOK");
                currencyList.add("SEK");
                currencyList.add("USD");

                for (int i = 0; i < currencyList.size(); i++) {
                    if(currencyService.findByCurrency(currencyList.get(i))==null) {
                        Currency currency = new Currency();
                        currency.setCurrency(currencyList.get(i));
                        currencyService.save(currency);
                    }
                }



            };
        }



}
