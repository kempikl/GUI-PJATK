# GUI - CW 04 - Zad 4

Napisz program czytający plik zawierający nieznaną z góry liczbę linii o formacie jak poniżej

    Mary 12c 78
    Jane 12c 90
    Bill 13c 68
    Kate 12c 76
    John 13c 66

Każda linia reprezentuje studenta o danym imieniu, numerze grupy i wyniku kolokwium. Używając strumieni stwórz mapę w której kluczami są nazwy grup, a wartościami listy studentów z danej grupy, a następnie wydrukuj te listy. Zakładając odpowiednią implementację metody toString w klasie Student, powinniśmy otrzymać coś w rodzaju:

    Group 13c: [Bill(13c)-68, John(13c)-66]
    Group 12c: [Mary(12c)-78, Jane(12c)-90, Kate(12c)-76]

Uwaga: Nie używaj żadnych jawnych pętli!
