import org.example.ReverseString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseStringTest {


    private final ReverseString stringUtils = new ReverseString();

    @Test
    void reverseLetters() {
        Assertions.assertEquals("tseT", stringUtils.reverseLetters("Test"));
        Assertions.assertEquals("", stringUtils.reverseLetters(""));
    }

}