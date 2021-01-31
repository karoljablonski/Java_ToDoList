package javaprojects.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListPairs {

    public static void main(String[] args) {
        // add task PENDING > remove task REMOVE by list index > complete task COMPLETED >
        // incomplete task PENDING
        List<Task> tasks = new ArrayList<>();
        printTasks(tasks);
        System.out.println("Wpisz ziomeczku: ");
        Scanner console = new Scanner(System.in);


        while (console.hasNext()) {
            String read = console.nextLine();
            System.out.println("Next line is: " + read);

            if (read.startsWith("add")) {
                String content = read.replace("add", "").trim();
                tasks.add(new Task(content, false));

            }

            if (read.startsWith("remove")) {
                int index = Integer.parseInt(read.replace("remove", "").trim());
                tasks.remove(index);
            }

            if (read.startsWith("complete")) {
                int index = Integer.parseInt(read.replace("complete", "").trim());
                Task task = tasks.get(index);
                task.setCompleted();
                tasks.set(index, task);
            }

            if (read.startsWith("incomplete")) {
                int index = Integer.parseInt(read.replace("incomplete", "").trim());
                Task task = tasks.get(index);
                task.setUncompleted();
                tasks.set(index, task);



            }

            if(read.startsWith("edit")) {
                String message = read.replace("edit", "").trim(); //edit 0 new content > '0 new content'
                int index = Integer.parseInt(message.substring(0, 1).trim());
                String newContent = message.replace(String.valueOf(index), "").trim();
                Task task = tasks.get(index);
                task.setContent(newContent);
                tasks.set(index, task);
            }

            printTasks(tasks);
        }
    }

    public static void printTasks(List<Task> tasks) {

        if (tasks.isEmpty()){
            System.out.println("TODOLIST IS EMPTY!");
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Index: " + i + ", content: " + tasks.get(i).getContent() + ", status: " + tasks.get(i).isCompleted());
        }
    }
}





