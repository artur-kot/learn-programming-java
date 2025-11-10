
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringTransformationTest {

    private StringTransformation transformer;

    @BeforeEach
    void setUp() {
        transformer = new StringTransformation();
    }

    // Part 1: Reversing Strings Tests

    @Test
    void testReverseStringSimple() {
        assertEquals("olleh", transformer.reverseString("hello"));
    }

    @Test
    void testReverseStringCapital() {
        assertEquals("avaJ", transformer.reverseString("Java"));
    }

    @Test
    void testReverseStringSingleChar() {
        assertEquals("a", transformer.reverseString("a"));
    }

    @Test
    void testReverseStringEmpty() {
        assertEquals("", transformer.reverseString(""));
    }

    @Test
    void testReverseStringPalindrome() {
        assertEquals("racecar", transformer.reverseString("racecar"));
    }

    // Part 2: Palindrome Detection Tests

    @Test
    void testIsPalindromeTrue() {
        assertTrue(transformer.isPalindrome("racecar"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(transformer.isPalindrome("hello"));
    }

    @Test
    void testIsPalindromeCaseInsensitive() {
        assertTrue(transformer.isPalindrome("Madam"));
        assertTrue(transformer.isPalindrome("RaceCar"));
    }

    @Test
    void testIsPalindromeSingleChar() {
        assertTrue(transformer.isPalindrome("a"));
    }

    @Test
    void testIsPalindromeEmpty() {
        assertTrue(transformer.isPalindrome(""));
    }

    @Test
    void testIsPalindromeLevel() {
        assertTrue(transformer.isPalindrome("level"));
    }

    // Part 3: Acronym Creation Tests

    @Test
    void testCreateAcronymSimple() {
        assertEquals("HW", transformer.createAcronym("Hello World"));
    }

    @Test
    void testCreateAcronymLowercase() {
        assertEquals("ASAP", transformer.createAcronym("as soon as possible"));
    }

    @Test
    void testCreateAcronymMultipleWords() {
        assertEquals("JPL", transformer.createAcronym("Java Programming Language"));
    }

    @Test
    void testCreateAcronymSingleWord() {
        assertEquals("H", transformer.createAcronym("Hello"));
    }

    @Test
    void testCreateAcronymMixedCase() {
        assertEquals("LOL", transformer.createAcronym("Laugh Out Loud"));
    }

    // Part 4: Title Case Conversion Tests

    @Test
    void testToTitleCaseSimple() {
        assertEquals("Hello World", transformer.toTitleCase("hello world"));
    }

    @Test
    void testToTitleCaseAllUppercase() {
        assertEquals("Java Programming", transformer.toTitleCase("JAVA PROGRAMMING"));
    }

    @Test
    void testToTitleCaseMixedCase() {
        assertEquals("Learn To Code", transformer.toTitleCase("lEaRn tO cOdE"));
    }

    @Test
    void testToTitleCaseSingleWord() {
        assertEquals("Hello", transformer.toTitleCase("hello"));
    }

    @Test
    void testToTitleCaseAlreadyTitleCase() {
        assertEquals("Hello World", transformer.toTitleCase("Hello World"));
    }

    // Part 5: Vowel Counting Tests

    @Test
    void testCountVowelsSimple() {
        assertEquals(2, transformer.countVowels("hello"));
    }

    @Test
    void testCountVowelsProgramming() {
        assertEquals(3, transformer.countVowels("programming"));
    }

    @Test
    void testCountVowelsAllVowels() {
        assertEquals(5, transformer.countVowels("aeiou"));
    }

    @Test
    void testCountVowelsUppercase() {
        assertEquals(5, transformer.countVowels("AEIOU"));
    }

    @Test
    void testCountVowelsMixed() {
        assertEquals(3, transformer.countVowels("HeLLo WoRLd"));
    }

    @Test
    void testCountVowelsNoVowels() {
        assertEquals(0, transformer.countVowels("xyz"));
    }

    @Test
    void testCountVowelsEmpty() {
        assertEquals(0, transformer.countVowels(""));
    }

    @Test
    void testCountVowelsJava() {
        assertEquals(2, transformer.countVowels("Java"));
    }
}
