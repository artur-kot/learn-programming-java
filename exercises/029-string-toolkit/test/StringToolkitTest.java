
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringToolkitTest {

    private StringToolkit toolkit;

    @BeforeEach
    void setUp() {
        toolkit = new StringToolkit();
    }

    // Part 1: Character and Word Counting Tests

    @Test
    void testCountCharactersSimple() {
        assertEquals(5, toolkit.countCharacters("Hello"));
    }

    @Test
    void testCountCharactersLonger() {
        assertEquals(11, toolkit.countCharacters("Programming"));
    }

    @Test
    void testCountCharactersEmpty() {
        assertEquals(0, toolkit.countCharacters(""));
    }

    @Test
    void testCountCharactersWithSpaces() {
        assertEquals(11, toolkit.countCharacters("Hello World"));
    }

    @Test
    void testCountWordsSimple() {
        String[] words = {"cat", "dog", "bird"};
        assertEquals(3, toolkit.countWords(words));
    }

    @Test
    void testCountWordsSingle() {
        String[] words = {"only"};
        assertEquals(1, toolkit.countWords(words));
    }

    @Test
    void testCountWordsMany() {
        String[] words = {"one", "two", "three", "four", "five"};
        assertEquals(5, toolkit.countWords(words));
    }

    // Part 2: Finding Longest and Shortest Tests

    @Test
    void testFindLongestSimple() {
        String[] words = {"cat", "elephant", "dog"};
        assertEquals("elephant", toolkit.findLongest(words));
    }

    @Test
    void testFindLongestFirst() {
        String[] words = {"butterfly", "cat", "dog"};
        assertEquals("butterfly", toolkit.findLongest(words));
    }

    @Test
    void testFindLongestLast() {
        String[] words = {"cat", "dog", "butterfly"};
        assertEquals("butterfly", toolkit.findLongest(words));
    }

    @Test
    void testFindLongestSingleWord() {
        String[] words = {"single"};
        assertEquals("single", toolkit.findLongest(words));
    }

    @Test
    void testFindLongestTie() {
        // When multiple words have same length, return first one
        String[] words = {"cat", "dog", "rat"};
        assertEquals("cat", toolkit.findLongest(words));
    }

    @Test
    void testFindShortestSimple() {
        String[] words = {"cat", "elephant", "dog"};
        String result = toolkit.findShortest(words);
        assertTrue(result.equals("cat") || result.equals("dog"),
                "Should return either 'cat' or 'dog' (both length 3)");
    }

    @Test
    void testFindShortestFirst() {
        String[] words = {"a", "elephant", "dog"};
        assertEquals("a", toolkit.findShortest(words));
    }

    @Test
    void testFindShortestLast() {
        String[] words = {"elephant", "dog", "to"};
        assertEquals("to", toolkit.findShortest(words));
    }

    @Test
    void testFindShortestSingleWord() {
        String[] words = {"single"};
        assertEquals("single", toolkit.findShortest(words));
    }

    @Test
    void testFindShortestTie() {
        // When multiple words have same length, return first one
        String[] words = {"cat", "dog", "elephant"};
        assertEquals("cat", toolkit.findShortest(words));
    }

    // Part 3: String Joining Tests

    @Test
    void testConcatenateWordsWithSpace() {
        String[] words = {"Java", "is", "fun"};
        assertEquals("Java is fun", toolkit.concatenateWords(words, " "));
    }

    @Test
    void testConcatenateWordsWithComma() {
        String[] words = {"red", "green", "blue"};
        assertEquals("red, green, blue", toolkit.concatenateWords(words, ", "));
    }

    @Test
    void testConcatenateWordsWithDash() {
        String[] words = {"one", "two", "three"};
        assertEquals("one-two-three", toolkit.concatenateWords(words, "-"));
    }

    @Test
    void testConcatenateWordsSingle() {
        String[] words = {"alone"};
        assertEquals("alone", toolkit.concatenateWords(words, ", "));
    }

    @Test
    void testConcatenateWordsTwo() {
        String[] words = {"hello", "world"};
        assertEquals("hello world", toolkit.concatenateWords(words, " "));
    }

    @Test
    void testConcatenateWordsEmptySeparator() {
        String[] words = {"a", "b", "c"};
        assertEquals("abc", toolkit.concatenateWords(words, ""));
    }
}
