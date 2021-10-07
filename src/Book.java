public class Book extends Publication{
    private String author;
    private String genre;

    public Book() {}

    public Book(String title, String author, String genre, int circulation, int countPage) {
        super(title, circulation, countPage);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                "title='" + getTitle() + '\'' +
                "genre='" + getGenre() + '\'' +
                "count page='" + getCountPage() + '\'' +
                '}';
    }
}