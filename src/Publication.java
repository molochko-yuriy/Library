public abstract class Publication {
    private String title;
    private int circulation;
    private int countPage;

    public Publication() {}

    public Publication(String title, int circulation, int countPage) {
        this.title = title;
        this.circulation = circulation;
        this.countPage = countPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }
}