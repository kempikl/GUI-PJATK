# GUI - CW 03 - Zad 2

Zdefiniuj trzy typy wyliczeniowe: <br />
Sex ze stałymi F (female) i M (male); <br />
Size ze stałymi XS, S, M, L, XL; <br />
Country ze stałymi PL, NL i DE. <br />
Dla każdej stałej metoda toString powinna być osobno nadpisana, tak żeby zwracała pełną nazwę danego kraju w języku tego kraju (Polska, Nederland, Deutschland).

Zdefiniuj też klasę Person z polami name, sex, size i country i z nadpisaną metodą toString.

W klasie głównej, prócz funkcji main, zdefiniuj generyczną, statyczną funkcję printArray pobierającą napis (tytuł) i tablicę dowolnego typu do wypisania jej zawartości.

Napisz program EnumsLambdas.java tak aby, po uzupełnieniu potrzebnych definicji, wydrukować coś w rodzaju

        *** Persons by sex and then size ***
    Eva (F, XS, Nederland)
    Mila(F, S, Deutschland)
    Ola (F, M, Polska)
    Lina (F, L, Deutschland)
    Jan (M, S, Polska)
    Max (M, XL, Nederland)
        *** Persons by size and then name ***
    Eva (F, XS, Nederland)
    Jan (M, S, Polska)
    Mila(F, S, Deutschland)
    Ola (F, M, Polska)
    Lina (F, L, Deutschland)
    Max (M, XL, Nederland)
        *** Countries by name ***
    Deutschland
    Nederland
    Polska