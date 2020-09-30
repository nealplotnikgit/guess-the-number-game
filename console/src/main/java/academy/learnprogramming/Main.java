package academy.learnprogramming;

import academy.learnprogramming.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    private static final String CONFIG_LOCATION = "beans.xml_bkp";

    public static void main(String[] args){
        log.info("Number Game");
        //defines ioc container
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
        //get the bean from container
//testcode        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//testcode        int number = numberGenerator.next();
//testcode        log.info("number: {}",number);

        //get game bean from context
//testcode        Game game = context.getBean(Game.class);
 //       game.reset();

//testcode        MessageGenerator msg = context.getBean(MessageGenerator.class);
//testcode        log.info("get main message: " + msg.getMainMessage());
//testcode        log.info("get result message: " + msg.getResultMessage());
        context.close(); //prevent resource leak
    }

}
