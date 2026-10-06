import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private static final String FILE_NAME = "tasks.dat";
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        loadTasks();

        int choice;

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskCompleted();
                case 4 -> editTask();
                case 5 -> deleteTask();
                case 6 -> searchTasks();
                case 7 -> {
                    saveTasks();
                    System.out.println("\nThank you for using To-Do List Application!");
                }
                default -> System.out.println("\nInvalid choice. Please enter a number from 1 to 7.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n==============================================");
        System.out.println("           TO-DO LIST APPLICATION");
        System.out.println("==============================================");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Edit Task");
        System.out.println("5. Delete Task");
        System.out.println("6. Search Task");
        System.out.println("7. Exit");
        System.out.println("==============================================");
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();

        if (description.isEmpty()) {
            System.out.println("Task description cannot be empty.");
            return;
        }

        tasks.add(new Task(nextId++, description));
        saveTasks();
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks available.");
            return;
        }

        System.out.println("\n================ YOUR TASKS ================");
        for (Task task : tasks) {
            task.displayTask();
        }
        System.out.println("=============================================");
    }

    private static void markTaskCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks available.");
            return;
        }

        int id = readInt("Enter task ID to mark as completed: ");
        Task task = findTaskById(id);

        if (task != null) {
            if (task.isCompleted()) {
                System.out.println("This task is already completed.");
            } else {
                task.markCompleted();
                saveTasks();
                System.out.println("Task marked as completed!");
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void editTask() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks available.");
            return;
        }

        int id = readInt("Enter task ID to edit: ");
        Task task = findTaskById(id);

        if (task != null) {
            System.out.print("Enter new task description: ");
            String description = scanner.nextLine().trim();

            if (description.isEmpty()) {
                System.out.println("Task description cannot be empty.");
                return;
            }

            task.setDescription(description);
            saveTasks();
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks available.");
            return;
        }

        int id = readInt("Enter task ID to delete: ");
        Task task = findTaskById(id);

        if (task != null) {
            tasks.remove(task);
            saveTasks();
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void searchTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks available.");
            return;
        }

        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        System.out.println("\n=============== SEARCH RESULTS ===============");

        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword)) {
                task.displayTask();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching tasks found.");
        }

        System.out.println("===============================================");
    }

    private static Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void saveTasks() {
        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            output.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Warning: Could not save tasks.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadTasks() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(new FileInputStream(file))) {

            ArrayList<Task> loadedTasks = (ArrayList<Task>) input.readObject();
            tasks.clear();
            tasks.addAll(loadedTasks);

            for (Task task : tasks) {
                if (task.getId() >= nextId) {
                    nextId = task.getId() + 1;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Warning: Could not load saved tasks. Starting with an empty list.");
        }
    }
}
