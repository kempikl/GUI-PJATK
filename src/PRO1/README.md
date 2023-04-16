# GUI - Projekt 1

Szachy to rodzina strategicznych gier planszowych rozgrywanych przez dwóch graczy na 64-polowej, kwadratowej szachownicy, za pomocą zestawu pionów i figur. Zrealizuj w pełni funkcjonalną grę w szachy, wykorzystując przedstawione podczas zajęć koncepcje programowania obiektowego. Dokonaj podziału programu na część logiczną i wizualną. W części logicznej zaimplementuj wszystkie zagadnienia powiązane z aktorami na planszy (piony, figury), natomiast w części wizualnej zaimplementuj tekstową reprezentację planszy z pionami i figurami.

* Rozpocznij od zaprojektowania struktury klas i interfejsów. Skoncentruj się na funkcjonalnościach gry w szachy, takich jak mechanika ruchu, mechanizmy sprawdzające, czy dany ruch jest dozwolony, mechanizmy wykrywające szach i szach mat oraz na ogólnej logice gry. Zdefiniuj również klasę reprezentującą planszę do gry oraz klasy reprezentujące poszczególne figury szachowe.
* Stwórz interfejsy, aby zdefiniować ogólne zachowania dla różnych klas.
* Stwórz klasy abstrakcyjne, aby zdefiniować ogólne właściwości dla kilku typów figur.
* Zaimplementuj logikę gry, taką jak mechanizmy sprawdzające, czy dany ruch jest dozwolony, mechanizmy wykrywające szach i szach mat oraz logikę dla graczy. Możesz również wykorzystać wyrażenia lambda do zdefiniowania funkcji anonimowych,np. do przeszukiwania planszy w poszukiwaniu figur.
* Zaimplementuj część wizualną, która pozwoli na wyświetlanie planszy z pionami i figurami.

Zadbaj, aby w dowolnym momencie gry istniała możliwość zapisania i odczytania planszy przechowywanej w postaci pliku binarnego zgodnie z ustalonym formatem. Specyfikacja formatu poczynając od najmniej znaczącego bitu (bit o indeksie 0):

* pierwsze 3 bity określają rodzaj figury lub piona ( 1 - król, 2- hetman, 3 - wieża, 4- goniec, 5 - skoczek, 0 - pion);
* kolejne 4 bity określają pozycję poziomą;
* kolejne 4 bity określają pozycję pionową;
* ostatni bit określa kolor bierki.

Wykorzystaj wszystkie przedstawione podczas wykładu i ćwiczeń techniki programistyczne (interfejsy, klasy abstrakcyjne, klasy, wyrażenia lambda, itd).

Uwagi wynikłe podczas dyskusji nad projektem:

* przyjmij że pozycja 0,0 jest zarezerwowana dla bierek nie znajdujących się na planszy;
* remis jest natomiast ogłaszany w przypadku obopólnej zgody graczy.