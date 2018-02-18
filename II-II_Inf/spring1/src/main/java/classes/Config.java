package classes;

import classes.Eur;
import classes.Usd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Eur Eur(){ return new Eur();}

    @Bean
    public Usd Usd(){ return new Usd();}

}
