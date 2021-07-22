package pl.sunymonkey.mojadelegacja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.sunymonkey.mojadelegacja.service.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/application/**").hasAnyRole( "FINANCE", "MANAGER", "EMPLOYEE","ADMIN")
                .antMatchers("/delegation/**").hasAnyRole( "FINANCE", "MANAGER", "EMPLOYEE","ADMIN")
                .antMatchers("/diet/**").hasAnyRole( "FINANCE", "MANAGER", "EMPLOYEE","ADMIN")
                .antMatchers("/manager/profile").hasAnyRole( "EMPLOYEE", "FINANCE", "MANAGER","ADMIN")
                .antMatchers("/manager/**").hasAnyRole( "FINANCE", "MANAGER","ADMIN")
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/").permitAll();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    } //bean ktory wstrzykiwany jest do znalezienia usera w NASZEJ bazie danych

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //bean do szyfrowania hasla usera rejestrujacego sie

}
