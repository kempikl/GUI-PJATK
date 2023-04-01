# GUI - CW 02 - Zad 1

Dany jest interfejs Func jak podano w pliku Func.java.

Obiekty klas implementujących ten interfejs będą reprezentowały funkcję R -> R.



Interfejs składa się z:

- metody apply przyjmującej argument typu double i zwracającej wartość typu double;

- statycznej metody compose, która przyjmuje odniesienie do dwóch obiektów klas implementujących interfejs Func a następnie zwraca obiekt klasy implementującej interfejs Func, realizujący złożenie funkcji dostarczonych jako argumenty

Należy zauważyć że złożenie dwóch funkcji f o g, jest definiowane jako

(f o g)(x) = (f(g(x)).

Metoda main zawarta w pliku InterF.java zawiera implementację

przykładu, gdzie:

- f - jest reprezentowane jako odniesienie do obiektu klasy implementującej Func i reprezentującej funkcję x -> x^2;

- g - jest reprezentowane jako odniesienie do obiektu klasy anonimowej implementującej interfejs Func i reprezentującej funkcję x -> x + 1.

Wykonanie metody powinno wyświetlić następujący wynik:

Res1: 16.0 <br />
Res2: 10.0<br />
Res3: 101.0<br />
Res4: 83.0