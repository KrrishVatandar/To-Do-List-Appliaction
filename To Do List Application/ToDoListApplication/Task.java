import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void markCompleted() {
        completed = true;
    }

    public void displayTask() {
        String status = completed ? "Completed" : "Pending";
        System.out.println(id + ". " + description + " [" + status + "]");
    }
}
