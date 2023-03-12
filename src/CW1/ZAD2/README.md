# GUI - CW 01 - Zad 2

Zdefiniuj abstrakcyjną klasę Singer opisującą piosenkarzy, z których każdy ma imie i numer (np. w konsursie talentów) który jest przypisywany automatycznie gdy obiekt jest tworzony. Klasa będzie zawierać tylko jeden konstruktor przyjmujący ciąg znaków jako imie pososenkarza. oraz następujące metody:

-   abstract: abstract String sing(), zwracającą tekst piosenki śpiewanej przez wykonawcę podczas konkursu;
-   public String toString() zwracającą informacje o wykonawcy;
-   static: ... loudest(...) przyjmującej jako argument tablicę obiektów Singer i zwracającą ten tekst piosenki, który zawiera najwięcej wielkich liter.

I metodzie main testowej klasy Main_:

1.  utwórz przynajmniej 3 obiekty/piosenkarzy wykorzystując klasę anonimową reprezentującą piosenkarza. Zaimplementuj zbiór tekstów wykonywanych podczas konkursu;
2.  utwórz tablicę wykonawców zawierającą elementy z punktu 1
3.  przetestuj metodę loudest klasy Singer.

Metoda main załączonej klasy Main powinna wyświetlić:

(1) Martin: Arrivederci, Roma...<br />
(2) Joplin: ...for me and my Bobby MacGee<br />
(3) Houston: I will always love youuuu<br /><br />
(2) Joplin: ...for me and my Bobby MacG

	public  class Main {
		public  static  void main(String[] args) {
			Singer s1 = new Singer("Martin"){
				/*<- ... */
			};

			Singer s2 = new Singer("Joplin"){
				/*<- ... */
			};

			Singer s3 = new Singer("Houston"){
				/*<- ... */
			};

			Singer sng[] = {s1, s2, s3};
			for (Singer s : sng) System.out.println(s);
			System.out.println("\n" + Singer.loudest(sng));
		}
	}