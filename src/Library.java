import java.util.ArrayList;

public class Library {
    private ArrayList<Publication> publications;

    public Library() {
        publications = new ArrayList<>();
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }

    public void add(Publication publication) {
        publications.add(publication);
    }

    public boolean remove(Publication publication) {
        return publications.remove(publication);
    }

    @Override
    public String toString() {
        return "Library{" +
                "publications=" + publications +
                '}';
    }
}