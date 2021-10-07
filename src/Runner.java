import java.util.Locale;

public class Runner {
    public static void main(String[] args) throws Exception {
        DOMxmlParser parser = new DOMxmlParser();
        Library library = parser.parse("library.xml");
        System.out.println(library);
        LogicLibrary logic = new LogicLibrary(library);
        logic.commonCountPage();
        logic.countSpecialSectionBook("Art");
    }

    public static void fill() {

//
//        System.out.println(library);
////        PeriodicalEdition publication5 = new Newspaper("Room", "Romanov R. D.", 32, 100);
////        PeriodicalEdition publication6 = new Magazine("Room", "Romanov R. D.", 32, 100);
////        parser.addNewPeriodicalEdition(publication5);
////        parser.addNewPeriodicalEdition(publication6);

        Publication publication1 = new Book("War", "Petriv V. A.", "Art",177,145);
        Publication publication2 = new Book("Peace", "Molochko U. I.", "Novels",89,1345);
        Publication publication3 = new Book("Sun", "Rubanov V. S.", "Detective",21,2456);
        Publication publication4 = new Book("Water", "Petrov G. P.", "Fantasy",222,198);
        Publication publication5 = new Newspaper("Room", "Romanov R. D.", 32, 100);
        Publication publication6 = new Magazine("Room", "Romanov R. D.", 32, 100);
        Library library = new Library();
        library.add(publication1);
        library.add(publication2);
        library.add(publication3);
        library.add(publication4);
        library.add(publication5);
        library.add(publication6);

        System.out.println(library);
    }
}