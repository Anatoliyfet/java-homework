package ru.edu.module13.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.edu.module13.service.CustomUserDetailedService;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/api/user/**").hasRole("USER")
//                        .anyRequest().authenticated()
//                );
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                                .requestMatchers(HttpMethod.GET, "/user").permitAll()
//                    .requestMatchers(HttpMethod.GET,"/admin/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.POST, "/api/v1/users/**").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.PUT, "/api/v1/users/**").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasRole("ADMIN")
//                                .anyRequest()
//                                .authenticated()

                ).formLogin(withDefaults());
//                .anyRequest().authenticated());
//                .and()
//                .formLogin();

        return http.build();
    }

    //
    @Resource
    private CustomUserDetailedService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    //    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //
//    @Autowired
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(bCryptPasswordEncoder());
//    }
    //
//    @Bean
//    public PasswordEncoder passwordEncoder() {
////        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
////        return encoder;
//        return NoOpPasswordEncoder.getInstance();
//    }

}
