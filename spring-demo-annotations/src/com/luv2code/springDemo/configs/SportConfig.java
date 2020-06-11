package com.luv2code.springDemo.configs;

import com.luv2code.springDemo.coaches.Coach;
import com.luv2code.springDemo.coaches.SwimCoach;
import com.luv2code.springDemo.services.FortuneService;
import com.luv2code.springDemo.services.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springDemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for our swim coach AND inject dependencies
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
