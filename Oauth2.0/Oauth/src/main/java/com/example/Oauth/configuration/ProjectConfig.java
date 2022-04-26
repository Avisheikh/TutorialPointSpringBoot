package com.example.Oauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.oauth2Login( c ->{
//            c.clientRegistrationRepository(clientRepository());
//        });
//
//        http.authorizeRequests()
//                .anyRequest().authenticated();
//    }

//    public ClientRegistrationRepository clientRepository()
//    {
//        var c = clientRegistration();
//        return new InMemoryClientRegistrationRepository(c);
//    }

//    private ClientRegistration clientRegistration(){
//        return CommonOAuth2Provider.GITHUB
//                .getBuilder("github")
//                .clientId("762fdd42491dea363b48")
//                .clientSecret("9be92a94afcad527a4302cb3aec6ac9b0c100e36 ")
//                .build();
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.oauth2Login();
//
//        http.authorizeRequests().anyRequest().authenticated();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.oauth2Login(c ->{
            c.clientRegistrationRepository(clientRepository());
        });

        http.authorizeRequests()
                .anyRequest().authenticated();
    }

    private ClientRegistrationRepository clientRepository()
    {
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }

    private ClientRegistration clientRegistration()
    {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("762fdd42491dea363b48")
                .clientSecret("09c47272e247e7ec8a861b6b4df0e5d167e1cee1")
                .build();
    }

}
