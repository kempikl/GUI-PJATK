# GUI - Projekt 3

## Zasady gry

Snake, to prosta, ale wciągająca gra, w której celem jest kierowanie wężem, aby zebrać
jak najwięcej pożywienia i uniknąć zderzenia z samym sobą lub ścianami planszy. Oto
szczegółowy opis zasad gry w węża:
1. Plansza: Gra odbywa się na prostokątnej planszy podzielonej na siatkę. Plansza
   może mieć różne rozmiary, ale najczęściej ma kształt kwadratu. Wężowi można
   poruszać się po polach tej siatki.
2. Wąż: Gracz kontroluje węża, który składa się z kolejnych segmentów. Wąż jest
   początkowo krótki i składa się z jednego segmentu, ale w miarę zbierania pożywienia
   rośnie, dodając kolejne segmenty. Głowa węża jest reprezentowana przez segment
   odróżniający się wyglądem lub kolorem.
3. Pożywienie: Na planszy rozmieszczone są kawałki pożywienia, najczęściej przedstawione jako wypełnione koła. Celem gracza jest zjedzenie jak największej liczby tych
   kawałków pożywienia.
4. Poruszanie się: Wąż porusza się po planszy, przemieszczając swoją głowę w jednym
   z czterech podstawowych kierunków: góra, dół, lewo i prawo. Wąż nie może poruszać
   się na skos.
5. Zasady dotyczące poruszania się węża:
   * Gdy gracz wybierze kierunek, wąż porusza się o jeden segment w danym kierunku.
   * Każdy segment węża porusza się za głową, co powoduje, że cały wąż porusza
   się jako jedno ciągłe ciało.
   * Wąż nie może poruszać się do tyłu, czyli nie może zawrócić i poruszać się w
   przeciwnym kierunku niż dotychczasowy ruch.
   * Gracz może zmienić kierunek poruszania się węża w dowolnym momencie, ale
   nie może zatrzymać go całkowicie.
6. Kolizje:
   * Jeśli głowa węża zderzy się z jednym ze swoich segmentów lub z krawędzią
   planszy, gra się kończy.
   * Gdy wąż zje kawałek pożywienia, jego długość się zwiększa, dodając nowy
   segment na końcu węża.
7. Punktacja: Gracz zdobywa punkty za zbieranie pożywienia. Najczęściej liczba punktów jest równa liczbie zjedzonych kawałków pożywienia. Można również używać innych mechanizmów punktacji, takich jak zwiększenie punktów wraz ze wzrostem
   długości węża.
8. Cele gry: Głównym celem gry w węża jest zdobycie jak największej liczby punktów
   poprzez zbieranie pożywienia i unikanie kolizji z samym sobą i ścianami planszy.

## Opis Projektu

Zaimplementuj autorską wersję gry Snake, przyjmując następujące założenia:
* plansza gry będzie przechowywana w dwu wymiarowej tablicy zmiennych typu int
o rozmiarze 25 × 16;
* właściwa część gry będzie się odbywała w wątku niezależnym od wątku związanego
z interfejsem użytkownika;
* wybór kierunku poruszania się węża zostanie zrealizowany w oparciu o strzałki na
klawiaturze;
* wszystkie elementy gry tj. tick gry, zjedzenie pożywienia, uderzenie w ściąnę czy
własny segment, będzie generowało zdarzenie (NameOfEvent) które będzie odbierane przez adekwatne nasłuchiwacze;
* komponent JTable - jako główny panel wizualizujący;
* JPanel - wykorzystujący metodę paintComponent(...) do wyrysowywania ilości zdobytych punktów;

Dodatkowo po zakończeniu rozgrywki, wyświetl na ekranie listę 10 najlepszych graczy
wraz z ilością punktów jaką uzyskali. Informacja ta będzie zapisywana i przechowywana
w pliku binarnym zgodnie ze schematem:
* pole LEN o wielkości 1 bajt - zawierającą informację o ilości znaków opisujących
nazwę gracza;
* sekwencja LEN bajtów zawierających znaki składające się na nazwę gracza;
* 4 bajty opisujące ilość zdobytych punktów.

Operację zapisu i odczytu należy zrealizować na podstawie strumienia FileInputStream lub FileOutputStream nie enkapsulując go żadną inną klasą