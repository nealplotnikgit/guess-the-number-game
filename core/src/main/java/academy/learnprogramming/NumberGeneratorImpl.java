package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class NumberGeneratorImpl implements NumberGenerator{

    private final Random random = new Random();
// removed field injection    @Autowired
//    @MaxNumber
    private final int maxNumber;  //added final when going to constructor injection

// removed field injection    @Autowired
//    @MinNumber
    private final int minNumber; //added final when going to constructor injection
@Autowired // constructor injection
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) { // added constructor injection
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt((getMaxNumber()-getMinNumber()))+getMinNumber();
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
