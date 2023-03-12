# GUI - CW 01 - Zad 1

Zdefiniuj interfejs TwoStringsOper deklarujący metodę apply przyjmującą dwa ciągi znaków i zwracającą ciąg znaków.

Następnie zdefiniuj klasę implementującą powyższy interface, tak aby wynikiem wywołania metody było:

-   połączenie argumentów metody ( klasa Concat);
-   połączenie argumentów metody w odwrotnej kolejności ( klasa ConcatRev);

-   ciąg znaków składający się z pierwszych znaków obu argumentów (klasa Initials);
-   połączenie, ale w taki sposób aby separatorem pomiędzy ciągami był argument dostarczony w konstruktorze.

Przykładowo, wywołanie metody main załączonej klasy InterS.java powinno wyświetlić:

MaryJohn<br />
JohnMary<br />
MJ<br />
Mary loves John

    public
	    class InterS{
	    
	    public  static  void main(String[] args) {
		    TwoStringsOper[] a = {
		    new Concat(), new ConcatRev(),
		    new Initials(), new Separ(" loves ")
		    };
		    for (TwoStringsOper op : a) {
		    System.out.println(op.apply("Mary", "John"));
		    }
	    }
    }
