import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoListApp extends Application {

    private ObservableList<String> tasks;

    @Override
    public void start(Stage stage) {
        tasks = FXCollections.observableArrayList();

        // Text field to enter new tasks
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter a new task");
        taskInput.setPrefWidth(300);

        // Button to add tasks
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskInput.clear();
            }
        });

        // HBox for input and button
        HBox inputBox = new HBox(10, taskInput, addButton);
        inputBox.setPadding(new Insets(10));

        // ListView to show tasks
        ListView<String> taskListView = new ListView<>(tasks);
        taskListView.setPrefHeight(200);

        // Button to remove selected task
        Button removeButton = new Button("Remove Selected");
        removeButton.setOnAction(e -> {
            String selected = taskListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                tasks.remove(selected);
            }
        });

        VBox root = new VBox(10, inputBox, taskListView, removeButton);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Simple To-Do List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
