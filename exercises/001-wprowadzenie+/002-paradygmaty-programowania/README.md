# Paradygmaty programowania

## Wprowadzenie

W poprzedniej lekcji poznaliśmy podstawy programowania obiektowego. Teraz przyjrzyjmy się szerszemu obrazowi - różnym **paradygmatom programowania**, czyli sposobom myślenia o tym, jak pisać programy.

## Czym jest paradygmat programowania?

**Paradygmat programowania** to fundamentalny styl czy podejście do pisania kodu. To sposób myślenia o rozwiązywaniu problemów programistycznych.

### Analogia ze świata rzeczywistego

Wyobraź sobie, że chcesz dotrzeć z punktu A do punktu B:
- Możesz iść pieszo (jeden sposób)
- Możesz jechać samochodem (inny sposób)
- Możesz lecieć samolotem (jeszcze inny sposób)

Każdy sposób ma swoje zalety i wady, i lepiej sprawdza się w różnych sytuacjach. Podobnie jest z paradygmatami programowania!

## Główne paradygmaty programowania

### 1. Programowanie proceduralne (Procedural Programming)

**Definicja**: Program to seria instrukcji wykonywanych krok po kroku, jak przepis kulinarny.

**Jak to działa**:
- Piszemy funkcje/procedury, które wykonują konkretne zadania
- Program wywołuje te funkcje w określonej kolejności
- Dane często są oddzielone od funkcji

**Analogia**: Gotowanie według przepisu - krok 1, krok 2, krok 3...

**Przykład myślenia**:
```
Zrób kawę:
1. Zagotuj wodę
2. Wsyp kawę do filiżanki
3. Zalej gorącą wodą
4. Dodaj mleko
5. Zamieszaj
```

**Kiedy stosować**: Proste skrypty, automatyzacja zadań, szybkie rozwiązania.

### 2. Programowanie obiektowe (Object-Oriented Programming - OOP)

**Definicja**: Program to zbiór obiektów, które współpracują ze sobą. Każdy obiekt ma swoje dane i zachowania.

**Jak to działa**:
- Tworzymy klasy jako szablony
- Tworzymy obiekty z tych klas
- Obiekty komunikują się między sobą
- Dane i funkcje są razem w obiektach

**Analogia**: Firma - różne działy (obiekty) mają swoje zadania i współpracują.

**Przykład myślenia**:
```
Obiekt: Ekspres do kawy
- Właściwości: ilość wody, typ kawy, temperatura
- Metody: zróbKawę(), dodajMleko(), wyczyść()
```

**Kiedy stosować**: Duże aplikacje, systemy biznesowe, gry komputerowe.

### 3. Programowanie funkcyjne (Functional Programming)

**Definicja**: Program to kompozycja czystych funkcji, które przekształcają dane bez zmieniania ich.

**Jak to działa**:
- Funkcje są traktowane jak matematyczne funkcje
- Unikamy zmieniania danych (immutability)
- Funkcje można przekazywać jako argumenty
- Brak efektów ubocznych

**Analogia**: Matematyka - funkcja f(x) = 2x zawsze zwraca ten sam wynik dla tego samego x.

**Przykład myślenia**:
```
Lista liczb [1, 2, 3, 4, 5]
→ pomnóż każdą przez 2
→ [2, 4, 6, 8, 10]
→ wybierz tylko parzyste
→ [2, 4, 6, 8, 10]
→ zsumuj
→ 30
```

**Kiedy stosować**: Przetwarzanie danych, analiza, systemy wymagające przewidywalności.

### 4. Programowanie deklaratywne (Declarative Programming)

**Definicja**: Opisujemy **co** chcemy osiągnąć, nie **jak** to zrobić.

**Jak to działa**:
- Określamy pożądany wynik
- System sam decyduje, jak to osiągnąć
- Skupiamy się na logice, nie na kontroli przepływu

**Analogia**: Restauracja - mówisz "chcę pizzę Margherita" (co chcesz), nie "weź mąkę, zrób ciasto, dodaj sos..." (jak to zrobić).

**Przykład myślenia**:
```
SQL (język zapytań do baz danych):
"Pokaż wszystkich użytkowników starszych niż 18 lat"

SELECT * FROM users WHERE age > 18;

(Nie mówimy JAK to znaleźć, tylko CO chcemy)
```

**Kiedy stosować**: Zapytania do baz danych, konfiguracje, szablony HTML/CSS.

## Porównanie paradygmatów

| Paradygmat | Główna idea | Struktura kodu |
|------------|-------------|----------------|
| Proceduralny | Krok po kroku | Funkcje + dane osobno |
| Obiektowy | Obiekty współpracują | Klasy i obiekty |
| Funkcyjny | Przekształcenia danych | Czyste funkcje |
| Deklaratywny | Opisz wynik | Reguły i definicje |

## Java i paradygmaty

**Java** jest przede wszystkim językiem **obiektowym**, ale:
- Wspiera elementy programowania **proceduralnego** (metody statyczne)
- Od Java 8 wspiera elementy **funkcyjne** (streams, lambdy)
- W pewnych aspektach jest **deklaratywna** (adnotacje, konfiguracje)

Java jest **wieloparadygmatowa** - możesz używać różnych stylów w zależności od potrzeb!

## Podsumowanie

- **Paradygmat** = sposób myślenia o programowaniu
- **Proceduralny** = krok po kroku, jak przepis
- **Obiektowy** = obiekty ze świata rzeczywistego
- **Funkcyjny** = matematyczne funkcje, niezmienność danych
- **Deklaratywny** = opisz CO chcesz, nie JAK to zrobić
- Większość nowoczesnych języków (w tym Java) wspiera **wiele paradygmatów**

---

## Quiz - Sprawdź swoją wiedzę!

Odpowiedz na poniższe pytania zaznaczając checkboxy `[x]` lub wpisując odpowiedzi tekstowe.
Po wypełnieniu zapisz ten plik i uruchom: `mvn test`

---

### Pytanie 1
Co to jest **paradygmat programowania**?

- [ ] A) Konkretny język programowania
- [ ] B) Błąd w kodzie
- [x] C) Fundamentalny styl/sposób myślenia o pisaniu programów
- [ ] D) Biblioteka funkcji

---

### Pytanie 2
W programowaniu **proceduralnym**, jak organizujemy kod?

- [ ] A) W obiekty z klasami
- [x] B) W funkcje/procedury wykonywane krok po kroku
- [ ] C) W zapytania SQL
- [ ] D) W pliki konfiguracyjne

---

### Pytanie 3
Które stwierdzenia są prawdziwe dla programowania **obiektowego**? *(zaznacz wszystkie poprawne)*

- [x] A) Dane i funkcje są razem w obiektach
- [ ] B) Unikamy tworzenia klas
- [x] C) Obiekty komunikują się między sobą
- [ ] D) Nie można używać zmiennych

---

### Pytanie 4
W programowaniu **funkcyjnym**, do czego są porównywane funkcje?

Odpowiedź: matematyka

---

### Pytanie 5
Co jest kluczową cechą programowania **deklaratywnego**?

- [ ] A) Opisujemy każdy krok wykonania
- [x] B) Opisujemy CO chcemy osiągnąć, nie JAK to zrobić
- [ ] C) Nie używamy żadnych funkcji
- [ ] D) Piszemy tylko komentarze

---

### Pytanie 6
Podaj nazwę paradygmatu, w którym program to seria kroków jak w przepisie kulinarnym.

Odpowiedź: proceduralny

---

### Pytanie 7
Który paradygmat najlepiej opisuje poniższy przykład?
"SELECT * FROM users WHERE age > 18"

- [ ] A) Proceduralny
- [ ] B) Obiektowy
- [ ] C) Funkcyjny
- [x] D) Deklaratywny

---

### Pytanie 8
Czy Java wspiera tylko jeden paradygmat programowania?

- [ ] A) Tak, tylko obiektowy
- [x] B) Nie, jest wieloparadygmatowa

---

### Pytanie 9
Do którego paradygmatu należy koncepcja "obiekty współpracują ze sobą"?

Odpowiedź: obiektowy

---

### Pytanie 10
Które paradygmaty wspiera Java? *(zaznacz wszystkie poprawne)*

- [x] A) Obiektowy
- [x] B) Proceduralny
- [x] C) Funkcyjny
- [ ] D) Żaden z powyższych

---

**Powodzenia!** 🚀

Po wypełnieniu odpowiedzi zapisz ten plik i uruchom testy: `mvn test`
