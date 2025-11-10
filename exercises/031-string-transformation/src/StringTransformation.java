
public class StringTransformation {

    // Part 1: Reversing Strings

    /**
     * Reverse a string
     * Example: reverseString("hello") returns "olleh"
     */
    public String reverseString(String str) {
        // TODO: Loop backwards through the string and build the reversed version
        // Hint: Start from str.length() - 1 and go down to 0
        return "";
    }

    // Part 2: Palindrome Detection

    /**
     * Check if a string is a palindrome (reads same forwards and backwards)
     * Should be case-insensitive
     * Example: isPalindrome("racecar") returns true
     * Example: isPalindrome("Madam") returns true
     */
    public boolean isPalindrome(String str) {
        // TODO: Compare the string with its reverse (ignoring case)
        // Hint: Convert to lowercase first, then reverse and compare
        return false;
    }

    // Part 3: Acronym Creation

    /**
     * Create an acronym from a phrase by taking first letter of each word
     * Return uppercase letters
     * Example: createAcronym("Hello World") returns "HW"
     * Example: createAcronym("as soon as possible") returns "ASAP"
     */
    public String createAcronym(String phrase) {
        // TODO: Split the phrase by spaces, take first letter of each word
        // Hint: Use phrase.split(" ") to get array of words
        // Hint: Take charAt(0) from each word and convert to uppercase
        return "";
    }

    // Part 4: Title Case Conversion

    /**
     * Convert string to title case (capitalize first letter of each word)
     * Example: toTitleCase("hello world") returns "Hello World"
     * Example: toTitleCase("JAVA programming") returns "Java Programming"
     */
    public String toTitleCase(String str) {
        // TODO: Split by spaces, capitalize first letter of each word, lowercase the rest
        // Hint: For each word, take first character, uppercase it, then add the rest lowercase
        return "";
    }

    // Part 5: Vowel Counting

    /**
     * Count the number of vowels (a, e, i, o, u) in a string
     * Count both uppercase and lowercase
     * Example: countVowels("hello") returns 2
     * Example: countVowels("programming") returns 3
     */
    public int countVowels(String str) {
        // TODO: Loop through each character and check if it's a vowel
        // Hint: Use Character.toLowerCase(c) and check if it's 'a', 'e', 'i', 'o', or 'u'
        return 0;
    }
}
