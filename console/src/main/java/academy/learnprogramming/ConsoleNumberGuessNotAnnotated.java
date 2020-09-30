package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNumberGuessNotAnnotated implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(ConsoleNumberGuessNotAnnotated.class);
    }
@Autowired
    private Game game;

@Autowired
    private MessageGenerator messageGenerator;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("Container ready for use");
    }
}
