package ternaryoperator;

import java.util.NoSuchElementException;
import java.util.Optional;

public class TernaryOperatorTest {

    public static void main(String[] args) {

        Logic logic = new Logic();

        Long o = null;

        try {
            Object o2 = (o == null ? 3L : logic.foo().orElseThrow(NoSuchElementException::new));
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

    }

    private static class Logic{

        public Optional<Object> foo(){

            return Optional.empty();
        }
    }
}
