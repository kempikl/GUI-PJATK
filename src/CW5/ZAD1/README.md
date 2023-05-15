# GUI - CW 05 - Zad 1

Utwórz klasę "Letters", która będzie używana do uruchamiania wielu wątków równolegle. Konstruktor klasy Letters przyjmuje łańcuch znaków, kolejne litery których będą drukowane przez osobne wątki (tyle wątków, ile liter jest w łańcuchu; każdy wątek drukuje "swoje" litery co sekundę).

Główna funkcja (z osobnej klasy) tworzy jeden obiekt klasy Letters, następnie uruchamia wszystkie wątki, czeka przez 5 sekund, a następnie kończy wszystkie wątki, jak pokazano poniżej w pliku SLettersThread.java.

Program powinien wypisać coś w stylu:

    Thread A starting
    Thread B starting
    Thread C starting
    Thread D starting
    ACDBDBACACDBCBDA
    Program completed.

Ważne: Metody stop, resume, suspend i destroy z klasy Thread są z natury niebezpieczne i nie wolno ich używać!