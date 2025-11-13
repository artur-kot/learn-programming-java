# Trzy filary OOP

## Wprowadzenie

Programowanie obiektowe opiera się na trzech fundamentalnych zasadach, które nazywamy **trzema filarami OOP**. Te zasady to: **Enkapsulacja**, **Dziedziczenie** i **Polimorfizm**.

Brzmi skomplikowanie? Nie martw się! Za chwilę wszystko stanie się jasne dzięki prostym analogiom.

## Filar 1: Enkapsulacja (Encapsulation)

### Czym jest enkapsulacja?

**Enkapsulacja** to grupowanie danych i metod w jednym miejscu (klasie) oraz **kontrolowanie dostępu** do nich.

Innymi słowy: "ukrywamy dane" i udostępniamy tylko to, co naprawdę potrzebne.

### Analogia: Kapsułka leku

**Kapsułka** to doskonały przykład enkapsulacji:
- **Wewnątrz**: lek (dane prywatne)
- **Zewnątrz**: otoczka, którą połykasz (publiczny interfejs)

Nie możesz bezpośrednio dotknąć leku - kapsułka go chroni. Lek działa dokładnie tak, jak powinien, bez Twojej ingerencji w szczegóły.

### Analogia: Sejf w banku

W sejfie:
- **Prywatne**: Twoje pieniądze i dokumenty (nikt inny nie ma dostępu)
- **Publiczne**: Klucz lub kod PIN (kontrolowany dostęp)

Nie każdy może zajrzeć do środka. Tylko właściciel z odpowiednimi uprawnieniami.

### Jak to działa w kodzie?

```
Klasa: KontoBankowe

Dane prywatne (ukryte):
- saldo (nikt nie może go zmieniać bezpośrednio)
- numerKonta

Metody publiczne (dostępne):
- wpłać(kwota) - kontrolowana zmiana salda
- wypłać(kwota) - kontrolowana zmiana salda
- sprawdźSaldo() - odczyt salda
```

Dzięki enkapsulacji nikt nie może napisać `saldo = -1000`. Musi użyć metody `wypłać()`, która sprawdzi, czy masz wystarczająco pieniędzy!

### Zalety enkapsulacji

1. **Ochrona danych** - Nikt nie może przypadkowo zepsuć ważnych danych
2. **Kontrola** - Możesz sprawdzić, czy wartość jest poprawna przed zapisem
3. **Elastyczność** - Możesz zmienić wewnętrzną implementację bez zmiany interfejsu
4. **Łatwiejsze debugowanie** - Wiesz, gdzie dane się zmieniają

## Filar 2: Dziedziczenie (Inheritance)

### Czym jest dziedziczenie?

**Dziedziczenie** to mechanizm, w którym nowa klasa "dziedziczy" właściwości i metody z istniejącej klasy.

To jak dzieci dziedziczą cechy po rodzicach!

### Analogia: Rodzina

- **Rodzic (klasa bazowa)**: Człowiek
  - właściwości: imię, wiek
  - metody: oddychaj(), jedz(), śpij()

- **Dziecko (klasa pochodna)**: Student
  - **dziedziczy**: wszystko od Człowieka
  - **dodaje**: numerIndeksu, kierunek
  - **dodaje metody**: uczSię(), zdajEgzamin()

Student **jest** Człowiekiem (ma wszystko co Człowiek), ale **dodatkowo** ma coś więcej!

### Analogia: Pojazdy

```
Klasa bazowa: Pojazd
- właściwości: prędkość, kolor
- metody: jedź(), zatrzymaj()

↓ dziedziczy

Klasa pochodna: Samochód
- dziedziczy: prędkość, kolor, jedź(), zatrzymaj()
- dodaje: liczbaKół, marka
- dodaje: otwórzBagażnik()

↓ dziedziczy

Klasa pochodna: SamochodSportowy
- dziedziczy: wszystko od Samochód
- dodaje: turbodoładowanie
- dodaje: trybWyścigowy()
```

### Zalety dziedziczenia

1. **Ponowne użycie kodu** - Nie piszesz tego samego wielokrotnie
2. **Hierarchia** - Logiczna organizacja klas
3. **Łatwiejsze zarządzanie** - Zmiana w klasie bazowej wpływa na wszystkie pochodne
4. **Naturalne modelowanie** - Łatwo modelować rzeczywistość

## Filar 3: Polimorfizm (Polymorphism)

### Czym jest polimorfizm?

**Polimorfizm** (z greckiego: "wiele form") to zdolność obiektów różnych klas do reagowania na tę samą metodę **w różny sposób**.

Ta sama komenda, różne efekty!

### Analogia: Komenda "Mów!"

Wyobraź sobie, że mówisz "Mów!" do różnych zwierząt:

- **Pies**: Hau hau!
- **Kot**: Miau!
- **Krowa**: Muuu!
- **Kaczka**: Kwa kwa!

Ta sama komenda (`mów()`), ale **każde zwierzę reaguje inaczej** (polimorficznie)!

### Analogia: Pilot uniwersalny

Pilot uniwersalny ma przycisk "PLAY":
- Dla **odtwarzacza DVD**: odtwarza film
- Dla **radia**: włącza muzykę
- Dla **konsoli**: uruchamia grę

Ten sam przycisk, różne działania w zależności od urządzenia!

### Jak to działa w kodzie?

```
Klasa bazowa: Zwierzę
- metoda: wydajDźwięk()

Klasa: Pies (dziedziczy z Zwierzę)
- wydajDźwięk() → "Hau hau!"

Klasa: Kot (dziedziczy z Zwierzę)
- wydajDźwięk() → "Miau!"

Klasa: Krowa (dziedziczy z Zwierzę)
- wydajDźwięk() → "Muuu!"

---

Użycie:
Zwierzę zwierzak = new Pies();
zwierzak.wydajDźwięk(); // "Hau hau!"

zwierzak = new Kot();
zwierzak.wydajDźwięk(); // "Miau!"
```

### Zalety polimorfizmu

1. **Elastyczność** - Ten sam kod działa z wieloma typami obiektów
2. **Rozszerzalność** - Łatwo dodać nowe klasy bez zmiany istniejącego kodu
3. **Przejrzystość** - Prosta i spójna składnia
4. **Uniwersalność** - Piszesz raz, działa dla wielu typów

## Podsumowanie trzech filarów

| Filar | Definicja | Analogia | Korzyść |
|-------|-----------|----------|---------|
| **Enkapsulacja** | Ukrywanie danych, kontrola dostępu | Kapsułka leku, sejf | Ochrona danych |
| **Dziedziczenie** | Klasy dziedziczą od innych klas | Rodzina, pojazdy | Ponowne użycie kodu |
| **Polimorfizm** | Ta sama metoda, różne zachowania | Zwierzęta "mówią" | Elastyczność |

## Dlaczego te trzy filary są ważne?

Razem tworzą potężne narzędzie do budowania:
- **Bezpiecznego** kodu (enkapsulacja)
- **Efektywnego** kodu (dziedziczenie)
- **Elastycznego** kodu (polimorfizm)

Bez tych filarów OOP byłoby po prostu "grupowaniem kodu w klasy" - z filarami to **potężna metodologia**!

---

## Quiz - Sprawdź swoją wiedzę!

Odpowiedz na poniższe pytania zaznaczając checkboxy `[x]` lub wpisując odpowiedzi tekstowe.
Po wypełnieniu zapisz ten plik i uruchom: `mvn test`

---

### Pytanie 1
Które z poniższych są trzema filarami OOP? *(zaznacz wszystkie poprawne)*

- [x] A) Enkapsulacja
- [ ] B) Kompilacja
- [x] C) Dziedziczenie
- [x] D) Polimorfizm

---

### Pytanie 2
Co to jest **enkapsulacja**?

- [ ] A) Dziedziczenie klas po sobie
- [x] B) Ukrywanie danych i kontrolowanie dostępu do nich
- [ ] C) Ta sama metoda dla różnych klas
- [ ] D) Tworzenie wielu obiektów

---

### Pytanie 3
Kapsułka leku to analogia do której zasady OOP?

Odpowiedź: enkapsulacja

---

### Pytanie 4
Co to jest **dziedziczenie**?

- [ ] A) Kopiowanie kodu między plikami
- [x] B) Klasa dziedziczy właściwości i metody z innej klasy
- [ ] C) Ukrywanie danych prywatnych
- [ ] D) Tworzenie zmiennych globalnych

---

### Pytanie 5
Student **dziedziczy** po klasie Człowiek. Co to oznacza? *(zaznacz wszystkie poprawne)*

- [x] A) Student ma wszystkie właściwości Człowieka
- [x] B) Student może dodać własne właściwości
- [ ] C) Student nie może mieć własnych metod
- [x] D) Student ma wszystkie metody Człowieka

---

### Pytanie 6
Co to jest **polimorfizm**?

- [ ] A) Tworzenie wielu zmiennych
- [ ] B) Ukrywanie metod prywatnych
- [x] C) Ta sama metoda wywołana na różnych obiektach daje różne efekty
- [ ] D) Dziedziczenie wielu klas naraz

---

### Pytanie 7
Podaj nazwę filaru OOP, który ilustruje przykład: Pies mówi "Hau", Kot mówi "Miau".

Odpowiedź: polimorfizm

---

### Pytanie 8
Jaką zaletę daje **enkapsulacja**?

- [x] A) Ochrona danych przed nieautoryzowanym dostępem
- [ ] B) Możliwość dziedziczenia
- [ ] C) Szybsze działanie programu
- [ ] D) Automatyczne testowanie

---

### Pytanie 9
Jaką zaletę daje **dziedziczenie**?

- [ ] A) Ukrywanie danych
- [x] B) Ponowne użycie kodu (nie piszemy tego samego wielokrotnie)
- [ ] C) Różne zachowania dla tej samej metody
- [ ] D) Bezpieczeństwo danych

---

### Pytanie 10
W klasie KontoBankowe, pole `saldo` jest prywatne, a metody `wpłać()` i `wypłać()` są publiczne. To przykład:

- [x] A) Enkapsulacji
- [ ] B) Dziedziczenia
- [ ] C) Polimorfizmu
- [ ] D) Abstrakcji

---

**Powodzenia!** 🚀

Po wypełnieniu odpowiedzi zapisz ten plik i uruchom testy: `mvn test`
