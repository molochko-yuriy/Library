public class LogicLibrary {
    private Library library;

    public LogicLibrary(Library library) {
        this.library = library;
    }

    public void countSpecialSectionBook(String section) {
        int count = 0;
        for (Publication publication : library.getPublications()) {
            if (publication instanceof Book) {
                if (section.equals(((Book) publication).getGenre())) {
                    count++;
                }
            }
        }
        System.out.println("Количество книг из раздела " + section + ": " + count);
    }

    public void commonCountPage() {
        int countPage = 0;
        for (Publication publication : library.getPublications()) {
            countPage += publication.getCountPage();
        }
        System.out.println("Общее количество страниц: " + countPage);
    }
}