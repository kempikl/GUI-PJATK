# GUI - CW 02 - Zad 5

* Utwórz klasę Person z polami name typu String oraz age typu int. <br /> <br />
Zadeklaruj konstruktor, metody pobraniowe (gettery) i przeciąż metodę toString. Ponadto zdefiniuj niestatyczną metodę compareTo przyjmującą jako argument odniesienie do innego obiektu tej samej klasy i zwracającą wartość int w stanie:

* ujemnym, gdy obiekt, na rzecz którego wywołano tę metodę, odpowiada młodszej osobie;
* zero, gdy oba obiekty mają taki sam wiek;
* dodatni, gdy osoba dostarczona jako argument jest młodsza.

Rozszerz definicję klasy Person o statyczną metodę sort, która uporządkuje rosnąco (wykorzystując metodę compareTo) tablicę odniesień do obiektów klasy Person przyjmując jako kryterium ich wiek.

Przygotuj program demonstracyjny posortowanie tablicy z przynajmniej pięcioma osobami.