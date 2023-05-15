# GUI - CW 04 - Zad 1

Napisz program wczytujący z pliku tekstowego dane dotyczące zakupów dokonanych przez kilka osób. Każda linia pliku odpowiada jednemu zakupowi i zawiera trzy dane oddzielone znakami odstępu: imię osoby kupującej, nazwę produktu i jego cenę; na przykład:

    Mary shoes 1000
    John beer 5
    Mary stockings 70
    John beer 6
    Mary lipstick 40
    John hammer 25
    John beer 4
    Mary shoes 1200
    James butter 9
    John beer 7
    Mary shoes 2250
    John beer 7

Program wpisuje wczytane dane do mapy typu

    Map<String, List<Purchase>>

w której kluczami są imiona osób a wartościami listy zakupów danej osoby; każdy zakup reprezentowany jest obiektem typu Purchase z (prywatnymi) polami name (nazwa produktu) i price (cena). Po wczytaniu wszystkich danych, na podstawie utworzonej mapy, program wpisuje do osobnego pliku tekstowego podsumowanie: każda linia zawiera, oddzielone znakami odstępu, <br />
1. imię klienta;
2. liczbę dokonanych zakupów;
3. liczbę różnych (o różnych nazwach) produktów, kupionych przez tego klienta;
4. całkowitą kwotę zapłacona przez niego za wszystkie swoje zakupy. <br />

Dla podanych przykładowych danych plik wynikowy powinien więc zawierać:

    James 1 1 9
    John 6 2 54
    Mary 5 3 4560