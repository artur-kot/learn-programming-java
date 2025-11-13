
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QuizChecker {

    // Typ pytania
    enum QuestionType {
        SINGLE_CHOICE, // Jedno zaznaczenie
        MULTIPLE_CHOICE, // Wiele zaznaczeń
        TEXT              // Odpowiedź tekstowa
    }

    // Definicja pytania
    static class Question {

        int number;
        QuestionType type;
        Set<String> correctAnswers; // Dla checkbox: {"A", "C"}, dla text: {"obiekt", "instancja"}

        Question(int number, QuestionType type, String... correctAnswers) {
            this.number = number;
            this.type = type;
            this.correctAnswers = new HashSet<>(Arrays.asList(correctAnswers));
        }
    }

    // Poprawne odpowiedzi
    private static final List<Question> QUESTIONS = Arrays.asList(
            new Question(1, QuestionType.SINGLE_CHOICE, "B"),
            new Question(2, QuestionType.SINGLE_CHOICE, "A"),
            new Question(3, QuestionType.MULTIPLE_CHOICE, "A", "B", "D"),
            new Question(4, QuestionType.TEXT, "co", "co robi", "interfejs"),
            new Question(5, QuestionType.SINGLE_CHOICE, "B"),
            new Question(6, QuestionType.TEXT, "samochód", "samochod", "pilot", "telefon", "bankomat", "komputer"),
            new Question(7, QuestionType.SINGLE_CHOICE, "B"),
            new Question(8, QuestionType.SINGLE_CHOICE, "A"),
            new Question(9, QuestionType.SINGLE_CHOICE, "A"),
            new Question(10, QuestionType.MULTIPLE_CHOICE, "A", "C")
    );

    /**
     * Normalizuje tekst: lowercase, trim, usuwa znaki interpunkcyjne
     */
    public static String normalizeText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }
        return text.toLowerCase()
                .trim()
                .replaceAll("[^a-ząćęłńóśźż0-9\\s]", "")
                .replaceAll("\\s+", " ")
                .trim();
    }

    /**
     * Parsuje README.md i wyciąga odpowiedzi użytkownika
     */
    public static Map<Integer, Set<String>> parseAnswersFile(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));
        Map<Integer, Set<String>> userAnswers = new HashMap<>();

        // Regex dla pytań i checkboxów
        Pattern questionPattern = Pattern.compile("##\\s*Pytanie\\s+(\\d+)");
        Pattern checkboxPattern = Pattern.compile("-\\s*\\[([xX ])]\\s*([A-D])");
        Pattern textAnswerPattern = Pattern.compile("Odpowiedź:\\s*(.*)");

        String[] sections = content.split("(?=##\\s*Pytanie)");

        for (String section : sections) {
            Matcher qMatcher = questionPattern.matcher(section);
            if (!qMatcher.find()) {
                continue;
            }

            int questionNum = Integer.parseInt(qMatcher.group(1));
            Set<String> answers = new HashSet<>();

            // Sprawdź checkboxy
            Matcher cbMatcher = checkboxPattern.matcher(section);
            boolean hasCheckboxes = false;
            while (cbMatcher.find()) {
                hasCheckboxes = true;
                String checked = cbMatcher.group(1);
                String option = cbMatcher.group(2);
                if ("x".equalsIgnoreCase(checked.trim())) {
                    answers.add(option);
                }
            }

            // Jeśli nie ma checkboxów, szukaj odpowiedzi tekstowej
            if (!hasCheckboxes) {
                Matcher textMatcher = textAnswerPattern.matcher(section);
                if (textMatcher.find()) {
                    String textAnswer = normalizeText(textMatcher.group(1));
                    if (!textAnswer.isEmpty()) {
                        answers.add(textAnswer);
                    }
                }
            }

            userAnswers.put(questionNum, answers);
        }

        return userAnswers;
    }

    /**
     * Sprawdza odpowiedzi użytkownika
     */
    public static Map<Integer, Boolean> checkAnswers(String answersFilePath) throws IOException {
        Map<Integer, Set<String>> userAnswers = parseAnswersFile(answersFilePath);
        Map<Integer, Boolean> results = new HashMap<>();

        for (Question question : QUESTIONS) {
            Set<String> userAnswer = userAnswers.getOrDefault(question.number, new HashSet<>());

            boolean isCorrect = false;

            if (question.type == QuestionType.TEXT) {
                // Dla pytań tekstowych - sprawdź czy którykolwiek wariant pasuje
                String normalizedUserAnswer = userAnswer.isEmpty() ? "" : userAnswer.iterator().next();
                isCorrect = question.correctAnswers.stream()
                        .map(QuizChecker::normalizeText)
                        .anyMatch(correct -> correct.equals(normalizedUserAnswer));
            } else {
                // Dla checkboxów - muszą się zgadzać dokładnie
                isCorrect = userAnswer.equals(question.correctAnswers);
            }

            results.put(question.number, isCorrect);
        }

        return results;
    }

    public static String getQuestionTypeDescription(int questionNum) {
        Question q = QUESTIONS.stream()
                .filter(question -> question.number == questionNum)
                .findFirst()
                .orElse(null);
        if (q == null) {
            return "";
        }

        switch (q.type) {
            case SINGLE_CHOICE:
                return "(jedno zaznaczenie)";
            case MULTIPLE_CHOICE:
                return "(wielokrotny wybór)";
            case TEXT:
                return "(odpowiedź tekstowa)";
            default:
                return "";
        }
    }
}
