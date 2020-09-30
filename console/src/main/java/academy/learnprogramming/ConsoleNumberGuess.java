package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess /*implements ApplicationListener<ContextRefreshedEvent>*/ {
    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(ConsoleNumberGuess.class);
    }
    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    @EventListener
    public void onRefresh(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("Annotation - Container ready for use");
        Scanner scanner = new Scanner (System.in);
        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();
            if (game.isGameLost() || game.isGameWon()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play Again? (Y/N)?");
                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }

        }
    }
    @EventListener(ContextRefreshedEvent.class)
    public void onRefresh2() {
        logger.info("Annotation2 - Container ready for use");
    }
}
