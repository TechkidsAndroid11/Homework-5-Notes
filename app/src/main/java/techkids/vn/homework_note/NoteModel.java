package techkids.vn.homework_note;

/**
 * Created by Admins on 10/11/2017.
 */

public class NoteModel {
    private String title;
    private String description;

    public NoteModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
