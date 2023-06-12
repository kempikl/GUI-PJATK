# GUI - CW 06 - Zad 2

Twoim zadaniem jest stworzenie aplikacji, która umożliwi zarządzanie planem lekcji w szkole za pomocą interfejsu graficznego opartego na JTable. Aplikacja powinna umożliwiać dodawanie, usuwanie i edycję lekcji, a także wyświetlanie ich w formie tabeli.

Wymagania:
- Interfejs graficzny: Stwórz interfejs graficzny, w którym głównym elementem będzie JTable. Na górze okna umieść przyciski umożliwiające dodawanie, usuwanie i edycję lekcji.
- Model danych: Stwórz model danych dla JTable, który będzie przechowywał informacje o lekcjach. Możesz utworzyć klasę reprezentującą lekcję, która zawiera pola takie jak nazwa przedmiotu, dzień tygodnia i numer bloku (godzin w jakich będzie się odbywać zajęcia) itp.
- Wyświetlanie lekcji: Po uruchomieniu aplikacji, tabela powinna wyświetlać aktualny plan lekcji. Każda lekcja powinna być reprezentowana przez pole w tabeli, wiersze będą odpowieadać kolejnym blokom, a kolumny powinny odpowiadać różnym dniom tygodnia.
- Dodawanie lekcji: Po kliknięciu przycisku "Dodaj" powinno pojawić się okno dialogowe, w którym użytkownik może wprowadzić informacje o nowej lekcji, takie jak nazwa przedmiotu, sala lekcyjna, nauczyciel itp. Po zatwierdzeniu, nowa lekcja powinna zostać dodana do tabeli.
- Usuwanie lekcji: Użytkownik powinien mieć możliwość zaznaczenia jednej lub wielu lekcji w tabeli i kliknięcia przycisku "Usuń", aby usunąć je z planu lekcji.
- Edycja lekcji: Użytkownik powinien móc edytować wybrane lekcje w tabeli. Po kliknięciu przycisku "Edytuj" powinno pojawić się okno dialogowe, w którym można zmienić informacje o lekcji. Po zatwierdzeniu zmian, lekcja powinna zostać zaktualizowana w tabeli.
- Walidacja danych: Przy dodawaniu i edycji lekcji, wykonaj walidację wprowadzonych danych. Sprawdź, czy wszystkie wymagane pola są wypełnione i czy są poprawne (np. poprawny format daty)