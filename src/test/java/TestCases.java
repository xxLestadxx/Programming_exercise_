import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestCases {

    private Main test;

    @BeforeEach
    public void setUp() {
        // Initialize your object here
        test = new Main();
    }
    @AfterEach
    public void separator(){
        System.out.println("-".repeat(30));
    }

    @Test
    public void testCalculateWords1() {
        test = new Main();
        System.out.println("Test calculate unique words 1");
        String input = "hello world hello";
        System.out.println(input);
        int result = test.calculateWords(input);
        System.out.println(result);
        assertEquals(2, result);

    }
    @Test
    public void testCalculateWords2() {
        System.out.println("Test calculate unique words 2");

        String input = "hello world 32342 hell3o 231321";
        System.out.println(input);
        int result = test.calculateWords(input);
        System.out.println(result);
        assertEquals(2, result);

    }

    @Test
    public void testCalculateWords3() {
        System.out.println("Test calculate unique words 3");

        String input = "hello world Hello";
        System.out.println(input);
        int result = test.calculateWords(input);
        System.out.println(result);
        assertEquals(2, result);

    }

    @Test
    public void testReverseString1() {
        System.out.println("test reverse String");
        String input = "hello";
        System.out.println("input: "+ input);
        String result = test.reverseString(input);
        System.out.println("result: " + result);
        assertEquals("olleh", result);
    }

    @Test
    public void testReverseString2() {
        System.out.println("test reverse String");
        String input = "   hello   ";
        System.out.println("input: "+ input);
        String result = test.reverseString(input);
        System.out.println("result: " + result);
        assertEquals("olleh", result);
    }


    @Test
    public void testTraverseArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        test.traverseArrayList(list);

        assertEquals(3, list.size());
    }

    @Test
    public void testDuplicateCharacters1() {
        System.out.println("Test Duplicate Characters 1");
        String input = "hello world hello";
        Map<Character, Integer> result = test.findDuplicateCharacters(input);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('l', 5);
        assertEquals(expected.get('l'), result.get('l'));

    }
    @Test
    public void testDuplicateCharacters2() {
        System.out.println("Test Duplicate Characters 2");

        String input = "hello world 32342 hell3o 231321";
        Map<Character, Integer> result = test.findDuplicateCharacters(input);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('l', 5);
        assertEquals(expected.get('l'), result.get('l'));

    }

    @Test
    public void testReadExcel() {
        // Test the behavior of your readExcel method
        // For now, just ensure it doesn't throw exceptions
        // You might want to add more meaningful assertions depending on what the method does
        test.readExcel();
        assertTrue(true);
    }
}
