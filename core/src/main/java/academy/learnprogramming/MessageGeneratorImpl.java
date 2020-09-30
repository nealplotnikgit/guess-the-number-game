package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator{

    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    @Autowired
    private Game game;

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()){
            return "You guessed it the number was " + game.getNumber();
        } else if (game.isGameLost()){
            return "You lost. Number was " + game.getNumber();
        } else if (!game.isValidNumberRange()){
            return "Your guess is outside the number range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()){
            return "what is your first guess?";
        } else{
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " left. Guess again";
        }
    }

    @PostConstruct
    private void checkGame(){
        logger.info("the game is null = {}", String.valueOf(game == null));
    }
}
