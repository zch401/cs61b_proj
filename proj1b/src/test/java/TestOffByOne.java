

import org.junit.Test;


import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this src.main.java.CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars() {
        assertFalse(offByOne.equalChars('a', 'c'));
        assertTrue(offByOne.equalChars('f', 'g'));
        assertFalse(offByOne.equalChars('B', 'c'));
    }

} /*Uncomment this class once you've created your src.main.java.CharacterComparator interface and src.main.java.OffByOne class. **/