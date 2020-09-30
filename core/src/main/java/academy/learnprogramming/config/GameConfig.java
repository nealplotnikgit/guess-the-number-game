package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/config.properties")
@ComponentScan(basePackages = "academy.learnprogramming")
public class GameConfig {
    // field. Default values 100, 10 if values not found in properties file
    @Value("${game.maxNumber:100}")
    private int maxNumber;
    @Value("${game.guessCount:10}")
    private int guessCount;
    @Value("${game.minNumber:10}")
    private int minNumber;

    @Bean
    @MaxNumber
    public int maxNumber_1(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
    @Bean
    @GuessCount
    public int guessCount_1(){
        return guessCount;
    }
}
