# GUI - Projekt 2

## Warstwa logiczna aplikacji

Klasa Baloon jest reprezentacją pojedynczego balonu, opisanego polami:
* long number- specyfikujący kolejny i unikalny numer balonu.
* BaloonColor color- opisujący jeden z 16 różnych kolorów (których nie ma w klasieColor). Kolor balonu będzie definiowany przez typ wylicznikowy (enum) dostarczanyklasie jako parametr konstruktora.

Przygotuj klasę Factory, która będzie asynchronicznie i nieustannie produkować balony (realizowane przez obiekt klasyBaloon) z częstotliwością pomiędzy 100[ms] a3[s] sekund. Program będzie mógł utworzyć bliżej nieokreśloną ilość obiektów klasy Factory z których każdy, niezależnie będzie produkował balony. Wyprodukowane balony zostanąumieszczone w składzie realizowanym przez klasę Storage na podstawie jednej z istniejących kolekcji (dobierz kolekcję adekwatnie do realizowanego problemu). Skład będzieprzyjmował dokładnie 99 balonów, a jeżeli okaże się że skład jest pełny to fabryki niemogące składować swojego towaru nie mogą produkować kolejnych balonów.Przygotuj również klasę Transporter, która będzie asynchronicznie transportowaćbalony pobierane ze składu w kolejności od najdłużej składowanego balonu. Transportowany towar będzie pobierany w partiach po 10 sztuk i wysyłany do odbiorców nie częściej niż jeden transport co 10[s]. Załadunek towaru trwa do czasu uzyskania całej partii i niemoże zostać zakłócony przez żaden inny transporter. Dostawa towaru trwa tyle samoczasu ile trwał załadunek towaru.

## Warstwa wizualna

Wykorzystaj komponenty SWING do stworzenia okienkowej aplikacji, która:
* w pozycji początku linii, będzie miała przewijalny panel zawierający wszystkieutworzone fabryki oraz przycisk pozwalający na dodanie nowej instancji klasyFactory;
* w pozycji końca linii, będzie miała przewijalny panel zawierający wszystkie utwo-rzone transportery oraz przycisk pozwalający na dodanie nowej instancji klasy Transporter;
* w środkowej pozycji panel przedstawiający stan magazynu realizowanego przez klasę Storage;

Wizualizacja pojedynczego panelu reprezentującego fabrykę powinna zawierać:
* licznik balonów wyprodukowanych przez tą fabrykę,
* suwak pozwalający na zmianę czasu produkcji pojedynczego balonu
* przycisk usunięcia danej fabryki

Wizualizacja pojedynczego panelu reprezentującego transporter powinna zawierać:
* informację o statusie transportu (oczekiwanie→ zaadunek→ dostawa→...)
* przyciski sterujące pozwalające na zatrzymanie lub uruchomienie komponentu

Gdy w magazynie znajduje się przynajmniej 90 balonów, następuje awaryjne wypuszczenie wszystkich balonów, któremu towarzyszy animacja wzlatujących ku niebu balonóww aplikacji.