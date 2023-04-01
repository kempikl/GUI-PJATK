# GUI - CW 02 - Zad 2

Dany jest interfejs funkcyjny FunDD, który deklaruje metodę fun, oraz statyczną metodę xminim.

Metoda xminim przyjmuje odniesienie (f) do obiektu klasy implementującej interfejs FunDD i dziedzinę określoną zmiennymi a i b. Celem tej metody będzie znalezienie takiej wartości argumentu x z przedziału [a,b] dla której metoda fun obiektu f wyliczy minimalną wartość. Aby znaleźć minimalną wartość przyjmij metodę numeryczną, sprawdzającą wszystkie wartości z przedziału od a do b z przyjętym krokiem 1e-5.



Utwórz klasę Parabola implementującą interfejs FunDD z polami a, b, c typu double, w której metoda fun będzie wyliczać wartość funkcji kwadratowej (ax^2+bx+c) dla dostarczonego x.



W klasie Task0402, metoda main wykorzysta statyczną metodę xminim aby znaleźć minima następujących funkcji, dostarczając następujące argumenty:

- obiekt klasy Parabola wraz z limitami a i b (np. dla funkcji x^2-x=5/4 w której x należy do [0, 1]);

- obiekt klasy anonimowej implementującej interfejs FunDD i granice dziedziny a i b (np. dla funkcji sqrt((x-0.75)^2 + 1) w której x należy do [0, 2])

- lambdę z granicami dziedziny a i b (np. dla funkcji x^2(x-2) w której x należy do [0, 2]).



Dla powyżej zamieszczonych przykładów, rezultatem powinno być: 1/2, 3/4, 4/3 (z dużą dokładnością).