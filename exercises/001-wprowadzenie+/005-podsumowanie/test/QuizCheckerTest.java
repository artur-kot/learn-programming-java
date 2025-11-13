import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class QuizCheckerTest {

    @Test
    void testAllAnswersCorrect() throws IOException {
        Map<Integer, Boolean> results = QuizChecker.checkAnswers("README.md");

        int totalQuestions = results.size();
        long correctCount = results.values().stream().filter(correct -> correct).count();

        StringBuilder message = new StringBuilder();
        message.append(String.format("\n\n========================================\n"));
        message.append(String.format("📝 WYNIK QUIZU: %d/%d poprawnych odpowiedzi\n", correctCount, totalQuestions));
        message.append(String.format("========================================\n\n"));

        // Sortuj wyniki po numerze pytania
        results.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                String typeDesc = QuizChecker.getQuestionTypeDescription(entry.getKey());
                if (!entry.getValue()) {
                    message.append(String.format("❌ Pytanie %d %s: Niepoprawna odpowiedź\n",
                        entry.getKey(), typeDesc));
                } else {
                    message.append(String.format("✅ Pytanie %d %s: Poprawna odpowiedź\n",
                        entry.getKey(), typeDesc));
                }
            });

        message.append("\n");

        if (correctCount < totalQuestions) {
            message.append("💡 Wskazówka: Przeczytaj ponownie teorię i popraw\n");
            message.append("   odpowiedzi w pliku README.md\n");
        } else {
            message.append("🎉 Gratulacje! Wszystkie odpowiedzi są poprawne!\n");
            message.append("   Możesz przejść do następnego rozdziału.\n");
        }

        assertTrue(correctCount == totalQuestions, message.toString());
    }
}
