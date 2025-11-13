# Podstawy programowania obiektowego

## Wprowadzenie

Witaj w pierwszej lekcji kursu Java! Zanim zaczniemy pisać kod, musimy zrozumieć podstawowe koncepcje programowania obiektowego (OOP - Object-Oriented Programming).

## Czym jest programowanie obiektowe?

**Programowanie obiektowe** to sposób pisania programów, w którym organizujemy kod wokół "obiektów" - rzeczy, które mają swoje cechy i zachowania.

### Analogia ze świata rzeczywistego

Wyobraź sobie samochód:
- **Cechy** (właściwości): kolor, marka, prędkość maksymalna
- **Zachowania** (akcje): jedź, zatrzymaj się, przyspiesz

W programowaniu obiektowym samochód byłby **obiektem**, który ma swoje dane (cechy) i funkcje (zachowania).

## Podstawowe pojęcia OOP

### 1. Klasa (Class)

**Klasa** to szablon, wzorzec, przepis na tworzenie obiektów.

Analogia: Klasa to jak przepis na ciasto. Sam przepis nie jest ciastem - to tylko instrukcja jak je zrobić.

```
Klasa "Samochód":
- właściwości: kolor, marka, prędkość
- metody: jedź(), zatrzymaj(), przyspiesz()
```

### 2. Obiekt (Object)

**Obiekt** to konkretna instancja klasy - coś co zostało stworzone na podstawie klasy.

Analogia: Jeśli klasa to przepis, to obiekt to konkretne ciasto upieczone według tego przepisu.

```
Obiekt 1: czerwony Ford o prędkości max 200 km/h
Obiekt 2: niebieski Toyota o prędkości max 180 km/h
```

Oba samochody zostały stworzone z tej samej klasy "Samochód", ale mają różne wartości właściwości.

### 3. Właściwości (Fields/Attributes)

**Właściwości** to dane przechowywane w obiekcie. Opisują "kim" lub "czym" jest obiekt.

Przykłady:
- Samochód: kolor, marka, rocznik
- Osoba: imię, nazwisko, wiek
- Konto bankowe: numer rachunku, saldo, właściciel

### 4. Metody (Methods)

**Metody** to funkcje/akcje, które obiekt może wykonywać. Opisują "co" obiekt może robić.

Przykłady:
- Samochód: jedź(), zatrzymaj(), zaparkuj()
- Osoba: mów(), jedz(), śpij()
- Konto bankowe: wpłać(), wypłać(), sprawdźSaldo()

## Dlaczego OOP?

Programowanie obiektowe pomaga nam:
1. **Organizować kod** - grupujemy powiązane dane i funkcje razem
2. **Ponownie używać kodu** - możemy tworzyć wiele obiektów z jednej klasy
3. **Modelować rzeczywistość** - łatwiej myśleć o programie jak o rzeczach ze świata rzeczywistego
4. **Utrzymywać kod** - zmiany w jednej klasie nie psują reszty programu

## Podsumowanie

- **Klasa** = szablon/przepis
- **Obiekt** = konkretna rzecz stworzona z klasy
- **Właściwości** = dane obiektu (cechy)
- **Metody** = funkcje obiektu (zachowania)

---

## Quiz - Sprawdź swoją wiedzę!

Odpowiedz na poniższe pytania zaznaczając checkboxy `[x]` lub wpisując odpowiedzi tekstowe.
Po wypełnieniu zapisz ten plik i uruchom: `mvn test`

---

### Pytanie 1
Co to jest **klasa** w programowaniu obiektowym?

- [ ] A) Konkretny obiekt z danymi
- [ ] B) Szablon/wzorzec do tworzenia obiektów
- [ ] C) Funkcja która wykonuje obliczenia
- [ ] D) Zmienna przechowująca wartość

---

### Pytanie 2
Co to jest **obiekt**?

- [ ] A) Kod źródłowy programu
- [ ] B) Funkcja w programie
- [ ] C) Konkretna instancja stworzona na podstawie klasy
- [ ] D) Nazwa zmiennej

---

### Pytanie 3
Które z poniższych są elementami obiektu? *(zaznacz wszystkie poprawne)*

- [ ] A) Właściwości (dane)
- [ ] B) Pliki na dysku
- [ ] C) Metody (funkcje)
- [ ] D) Komentarze w kodzie

---

### Pytanie 4
Używając analogii: jeśli klasa to "przepis na ciasto", to czym jest obiekt?

Odpowiedź:

---

### Pytanie 5
Samochód ma kolor, markę i prędkość maksymalną. Jak nazywamy te elementy w OOP?

Odpowiedź:

---

### Pytanie 6
Samochód może jechać, zatrzymać się i przyspieszyć. Jak nazywamy te elementy w OOP?

Odpowiedź:

---

### Pytanie 7
Która analogia najlepiej opisuje relację klasa-obiekt?

- [ ] A) Książka - strona
- [ ] B) Przepis - upieczone ciasto
- [ ] C) Komputer - klawiatura
- [ ] D) Nauczyciel - uczeń

---

### Pytanie 8
Czy możemy stworzyć wiele obiektów z jednej klasy?

- [ ] A) Tak
- [ ] B) Nie

---

**Powodzenia!** 🚀

Po wypełnieniu odpowiedzi zapisz ten plik i uruchom testy: `mvn test`
