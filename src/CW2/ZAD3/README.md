# GUI - CW 02 - Zad 3

Stwórz klasę szablonową MyQueue, która będzie reprezentować kolejkę FIFO (First-In, First-Out) elementów dowolnego typu.

Klasa powinna mieć metody enqueue(), dequeue() oraz isEmpty().



Przykładowe uruchomienie załączonej metody main in powinno wyświetlić:

1 <br />
2 <br />
Ala <br />
ma <br />
kota <br />
Exception in thread "main" java.util.NoSuchElementException<br />
at MyQueue.dequeue(MyQueue.java:19)<br />
at Main.main(Main.java:21)



1. Zdefiniuj klasę MyQueue<T> i określ jej modyfikator dostępu jako publiczny;
2. Dodaj prywatne pole elements reprezentujące kolekcję elementów kolejki. Można użyć dowolnej kolekcji np: ArrayList
3. Stwórz konstruktor bezargumentowy, który utworzy nową pustą kolejkę.
4. Dodaj metodę enqueue(T element), która będzie dodawać nowy element typu T do końca kolejki.
5. Dodaj metodę dequeue(), która będzie usuwać i zwracać pierwszy element z kolejki. Jeśli kolejka jest pusta, metoda powinna rzucić wyjątek.
6. Dodaj metodę isEmpty(), która będzie zwracać true, jeśli kolejka jest pusta, a w przeciwnym razie false.