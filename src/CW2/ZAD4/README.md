# GUI - CW 02 - Zad 4

Utwórz klasę MyColor dziedziczącą po klasie java.awt.Color. Klasa MyColor będzie definiowała pojedynczy konstruktor akceptujący trzy wartości int z przedziału [0, 255] reprezentujące trzy składowe RGB koloru, odwołując się do analogicznego konstruktora w klasie bazowej. Przyjmij, że klasa ta będzie definiowała pole przechowujące sumę bajtową wszystkich składowych koloru. Klasa będzie również przeciążała metodę toString, tak aby dostarczała ona ciąg znaków z wartościami kolorów: MyColor(red, green, blue).



Ponadto, zdefiniuj klasę MyColorCompar implementującą interfejs Comparator<MyColor>, której konstruktor przyjmie wartość typu wylicznikowego (enum) ColComponent z jednej z wartości: RED, GREEN, BLUE lub NONE. W zależności od dostarczonej wartości, metoda compare uporządkuje kolory w porządku rosnącym, zależnie od wskazanej w parametrze wartości koloru lub z wykorzystaniem pola klasy w przypadku stanu NONE.



Przykładowy program ColorComparing.java powinien wyświetlić:

[(1,2,3), (255,0,0), (55,55,100), (10,255,10)] <br />
[(1,2,3), (55,55,100), (255,0,0), (10,255,10)] <br />
[(1,2,3), (10,255,10), (55,55,100), (255,0,0)] <br />
[(255,0,0), (1,2,3), (55,55,100), (10,255,10)] <br />
[(255,0,0), (1,2,3), (10,255,10), (55,55,100)] <br />
[(1,2,3), (55,55,100), (255,0,0), (10,255,10)]