# GUI - CW 04 - Zad 3

Napisz program tworzący z danych zawartych w tablicy napisów arr mapę typu

Map<String, List<Car>>

Każde trzy kolejne elementy tablicy odpowiadają nazwie salonu samochodowego oraz marce i cenie samochodu (cena jest podana jako String). W mapie kluczami są nazwy salonów a wartościami listy samochodów (typu Car) w nich oferowanych.

Po wczytaniu danych do mapy, program nie korzysta już z tablicy arr, a operuje wyłącznie na tej mapie. Program wypisuje
w dowolnej formie zawartość mapy;
markę, cenę i salon najtańszego samochodu.
Na przykład dla następującej tablicy podanej na początku funkcji main

    String[] arr = {
        "salon A", "Mercedes", "130000",
        "salon B", "Mercedes", "120000",
        "salon C", "Ford", "110000",
        "salon B", "Opel", "90000",
        "salon C", "Honda", "95000",
        "salon A", "Ford", "105000",
        "salon A", "Renault", "75000"
    };

wynikiem powinno być coś w rodzaju

{salon A=[Mercedes 130000, Ford 105000, Renault 75000],
salon B=[Mercedes 120000, Opel 90000],
salon C=[Ford 110000, Honda 95000]}

Renault in salon A for 75000