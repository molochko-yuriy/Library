public abstract class PeriodicalEdition extends Publication{
    private String editor;

    public PeriodicalEdition() {}

    public PeriodicalEdition(String title, String editor, int circulation, int countPage) {
        super(title, circulation, countPage);
        this.editor = editor;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String toString() {
        return "PeriodicalEdition{" +
                "editor='" + editor + '\'' +
                "title='" + getTitle() + '\'' +
                "count page='" + getCountPage() + '\'' +
                '}';
    }
}
