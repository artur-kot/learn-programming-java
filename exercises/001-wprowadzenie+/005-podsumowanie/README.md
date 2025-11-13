# Podsumowanie - Wprowadzenie do języka Java

## Gratulacje!

Dotarłeś do końca pierwszego rozdziału! Czas podsumować wszystko, czego się nauczyłeś.

## Co już wiesz?

### 1. Podstawy programowania obiektowego (OOP)

**Klasa** to szablon/przepis, na podstawie którego tworzymy obiekty.
- Analogia: Przepis na ciasto

**Obiekt** to konkretna instancja klasy.
- Analogia: Konkretne upieczone ciasto

**Właściwości** (fields) to dane/cechy obiektu.
- Przykład: samochód ma kolor, markę, prędkość

**Metody** to funkcje/zachowania obiektu.
- Przykład: samochód może jechać(), zatrzymać się(), przyspieszyć()

### 2. Paradygmaty programowania

**Paradygmat** to sposób myślenia o programowaniu.

**Proceduralny**: Program to seria kroków wykonywanych jeden po drugim (jak przepis kulinarny).

**Obiektowy**: Program to zbiór obiektów, które współpracują ze sobą.

**Funkcyjny**: Program to kompozycja funkcji przekształcających dane.

**Deklaratywny**: Opisujemy CO chcemy osiągnąć, nie JAK to zrobić.

**Java** jest wieloparadygmatowa - wspiera wszystkie powyższe podejścia!

### 3. Abstrakcja

**Abstrakcja** to ukrywanie szczegółów i pokazywanie tylko tego, co istotne.

- Koncentrujemy się na **CO** coś robi, nie **JAK** to robi
- Przykłady z życia: samochód (kierownica zamiast szczegółów silnika), pilot (przyciski zamiast elektroniki)
- Upraszcza używanie, ukrywa złożoność, zapobiega błędom

### 4. Trzy filary OOP

**Enkapsulacja** (Encapsulation)
- Ukrywanie danych i kontrolowanie dostępu do nich
- Analogia: Kapsułka leku, sejf bankowy
- Korzyść: Ochrona danych, kontrola zmian

**Dziedziczenie** (Inheritance)
- Klasa dziedziczy właściwości i metody z innej klasy
- Analogia: Student dziedziczy cechy po Człowieku
- Korzyść: Ponowne użycie kodu, hierarchia klas

**Polimorfizm** (Polymorphism)
- Ta sama metoda wywołana na różnych obiektach daje różne efekty
- Analogia: Różne zwierzęta reagują na komendę "Mów!" inaczej
- Korzyść: Elastyczność, uniwersalność kodu

## Kluczowe różnice i powiązania

### OOP vs Paradygmaty
- **OOP** to jeden z paradygmatów programowania
- Java jest głównie obiektowa, ale wspiera także inne paradygmaty

### Abstrakcja vs Enkapsulacja
- **Abstrakcja** = pokazywanie tylko istotnych szczegółów (interfejs)
- **Enkapsulacja** = ukrywanie danych i kontrola dostępu (implementacja)
- Są powiązane, ale to nie to samo!

### Klasa vs Obiekt
- **Klasa** = szablon (jak przepis)
- **Obiekt** = konkretna instancja (jak upieczone ciasto)
- Z jednej klasy można stworzyć wiele obiektów

## Czego się nauczysz dalej?

W następnych rozdziałach dowiesz się:
- Jak pisać kod w Javie
- Jak tworzyć klasy i obiekty
- Jak stosować trzy filary OOP w praktyce
- Jak używać różnych paradygmatów
- I wiele więcej!

## Dlaczego to wszystko jest ważne?

Te fundamenty to podstawa **całego** programowania w Javie (i nie tylko!). Rozumiejąc:
- **OOP** - zrozumiesz strukturę kodu
- **Paradygmaty** - będziesz umiał wybrać najlepsze podejście do problemu
- **Abstrakcję** - będziesz pisać prostszy, czytelniejszy kod
- **Trzy filary** - będziesz budować solidne, profesjonalne aplikacje

---

## Quiz - Sprawdź swoją wiedzę!

To ostatni quiz w tym rozdziale. Obejmuje wszystkie tematy, które poznałeś.

Odpowiedz na poniższe pytania zaznaczając checkboxy `[x]` lub wpisując odpowiedzi tekstowe.
Po wypełnieniu zapisz ten plik i uruchom: `mvn test`

---

### Pytanie 1
Co to jest **klasa** w programowaniu obiektowym?

- [x] A) Szablon do tworzenia obiektów
- [ ] B) Konkretny obiekt z danymi
- [ ] C) Funkcja wykonująca zadanie
- [ ] D) Plik z kodem źródłowym

---

### Pytanie 2
Co to jest **obiekt**?

Odpowiedź: instancja

---

### Pytanie 3
Które elementy należą do obiektu? *(zaznacz wszystkie poprawne)*

- [x] A) Właściwości (dane/cechy)
- [ ] B) Pliki konfiguracyjne
- [x] C) Metody (funkcje/zachowania)
- [ ] D) Komentarze w kodzie

---

### Pytanie 4
Java jest językiem:

- [ ] A) Tylko proceduralnym
- [ ] B) Tylko obiektowym
- [x] C) Wieloparadygmatowym (wspiera wiele paradygmatów)
- [ ] D) Tylko funkcyjnym

---

### Pytanie 5
Co to jest **abstrakcja**?

- [ ] A) Pisanie długiego, skomplikowanego kodu
- [x] B) Ukrywanie szczegółów i pokazywanie tylko istoty
- [ ] C) Tworzenie wielu klas
- [ ] D) Kopiowanie kodu

---

### Pytanie 6
Wymień trzy filary OOP (po przecinku).

Odpowiedź: enkapsulacja, dziedziczenie, polimorfizm

---

### Pytanie 7
**Enkapsulacja** to:

- [x] A) Ukrywanie danych i kontrolowanie dostępu do nich
- [ ] B) Dziedziczenie właściwości z innych klas
- [ ] C) Ta sama metoda, różne efekty
- [ ] D) Grupowanie funkcji w pliku

---

### Pytanie 8
**Dziedziczenie** pozwala na:

- [ ] A) Ukrywanie metod prywatnych
- [x] B) Ponowne użycie kodu z innej klasy
- [ ] C) Wywoływanie metod polimorficznie
- [ ] D) Kompilowanie szybszego kodu

---

### Pytanie 9
Pies mówi "Hau", Kot mówi "Miau" - ta sama metoda `mów()`, różne efekty. To przykład:

Odpowiedź: polimorfizm

---

### Pytanie 10
Który paradygmat programowania opisuje: "Program to seria kroków jak w przepisie kulinarnym"?

- [x] A) Proceduralny
- [ ] B) Obiektowy
- [ ] C) Funkcyjny
- [ ] D) Deklaratywny

---

### Pytanie 11
W programowaniu **deklaratywnym** skupiamy się na:

- [x] A) CO chcemy osiągnąć (wynik)
- [ ] B) JAK dokładnie to zrobić (kroki)
- [ ] C) Tworzeniu obiektów
- [ ] D) Pisaniu funkcji

---

### Pytanie 12
Co jest prawdą o **abstrakcji** i **enkapsulacji**? *(zaznacz wszystkie poprawne)*

- [x] A) Są powiązane, ale to nie to samo
- [ ] B) To dokładnie ta sama rzecz
- [x] C) Abstrakcja pokazuje CO, enkapsulacja ukrywa JAK
- [x] D) Obie pomagają uprościć kod

---

### Pytanie 13
Z jednej klasy można stworzyć:

- [ ] A) Tylko jeden obiekt
- [x] B) Wiele obiektów
- [ ] C) Żadnego obiektu
- [ ] D) Tylko dwa obiekty

---

### Pytanie 14
Podaj przykład **właściwości** (pola) dla klasy Samochód.

Odpowiedź: kolor

---

### Pytanie 15
Podaj przykład **metody** dla klasy Samochód.

Odpowiedź: jedź

---

**Gratulacje za ukończenie rozdziału!** 🎉

Po wypełnieniu odpowiedzi zapisz ten plik i uruchom testy: `mvn test`

Jeśli wszystkie odpowiedzi będą poprawne, jesteś gotowy do następnego rozdziału!
