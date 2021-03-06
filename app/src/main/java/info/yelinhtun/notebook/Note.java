package info.yelinhtun.notebook;

public class Note {
    private String title, message;
    private long noteId, dateCreatedMilli;
    private Category category;

    public enum Category {
        PERSONAL, TECHNICAL, QUOTE, FINANCE
    }

    public Note(String title, String message, Category category) {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;
    }

    public Note(String title, String message, Category category, long noteId, long dateCreatedMilli) {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public long getDateCreatedMilli() {
        return dateCreatedMilli;
    }

    public long getNoteId() {
        return noteId;
    }

    public String toString() {
        return "ID: " + noteId + " Title: " + title + " Message: " + message
                + " NoteId: " + noteId + " Category: " + category.name();
    }

    public static int categoryToDrawable(Category noteCategory) {
        switch (noteCategory) {
            case PERSONAL:
                return R.drawable.a;
            case TECHNICAL:
                return R.drawable.b;
            case FINANCE:
                return R.drawable.c;
            case QUOTE:
                return R.drawable.d;
        }

        return R.drawable.a;
    }

    public int getAssociatedDrawable() {
        return categoryToDrawable(category);
    }
}
