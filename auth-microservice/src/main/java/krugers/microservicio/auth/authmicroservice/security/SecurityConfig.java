package krugers.microservicio.auth.authmicroservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        String[] pathArray = new String[]
        {
                "/api/users/**",
                "/api/carts/**",
                "/api/users/update/**",
                "/api/address/**",
                "/api/mails/**",
                "/swagger-ui/index.html#/**"
        };

        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(pathArray).permitAll()
                .and()
                .httpBasic();

        return http.build();

    };

}
