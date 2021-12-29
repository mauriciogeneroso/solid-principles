package solid.dependencyinversion.after;

public class PasswordReminder {

    private DatabaseConnection connection;

    public PasswordReminder(DatabaseConnection connection) {
        this.connection = connection;
    }

    // implementation
}
