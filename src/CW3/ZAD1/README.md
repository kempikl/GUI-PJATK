# GUI - CW 03 - Zad 1

Napisz klasę-komparator MyComp, obiektów której można użyć do, na przykład, posortowania tablicy Integer’ów według różnych kryteriów. Odpowiednie kryterium powinno być zadane wartością pola typu int inicjowanego w konstruktorze: możliwe wartości tego pola odpowiadają czterem wartościom finalnych stałych statycznych typu int zdefiniowanych w klasie: <br />
BY_VAL: według wartości liczbowej rosnąco; <br />
BY_VAL_REV: według wartości liczbowej malejąco; <br />
BY_NUM_OF_DIVS: według ilości dzielników; <br />
BY_SUM_OF_DIGS: według sumy cyfr. <br />
Jeśli dwa elementy są równe według zadanego kryterium, to decyduje wartość liczbową (wzrastająco).

Przykładowo załączony program Compars.java powinien wypisać coś w rodzaju:

Oryginal [ 1 5 33 12 98 15 ] <br />
ByVal [ 1 5 12 15 33 98 ] <br />
ByValRev [ 98 33 15 12 5 1 ] <br />
ByNumOfDivs [ 1 5 15 33 12 98 ] <br />
BySumOfDigs [ 1 12 5 15 33 98 ] <br />

Uwaga: zamiast finalnych statycznych pól, których wartości określają kryteria porównywania, możesz użyć enumeratorów