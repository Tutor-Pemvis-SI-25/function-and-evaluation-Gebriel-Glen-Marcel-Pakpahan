//Gebriel Glen Marcel Pakpahan - 12S25019//
//Maria Octavia Simorangkir - 12S25033//


import java.util.*;
import java.lang.Math;

public class TLAST {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] descriptions = new String[10], codes = new String[10], courses = new String[10], lecturers = new String[10], deadlines = new String[10], filenames = new String[10], statuses = new String[10];
        int[] difficulties = new int[10], days = new int[10];
        double[] priorities = new double[10];
        int taskCount;

        taskCount = 0;
        String command;

        command = "";
        while (!command.equals("---")) {
            command = input.nextLine();
            if (command.equals("Add task")) {
                if (taskCount < 10) {
                    addTask(descriptions, codes, courses, lecturers, deadlines, filenames, difficulties, days, statuses, priorities, taskCount);
                }
            }
            if (command.equals("Update task status")) {
                updateTask(codes, statuses, taskCount);
            }
            if (command.equals("Show assigment")) {
                showAssignments(descriptions, codes, courses, lecturers, deadlines, filenames, difficulties, days, statuses, priorities, taskCount);
            }
        }
    }
    
    public static void addTask(String[] descriptions, String[] codes, String[] courses, String[] lecturers, String[] deadline, String[] filenames, int[] difficulties, int[] days, String[] statuses, double[] priorities, int count) {
        descriptions[count] = input.nextLine();
        codes[count] = input.nextLine();
        courses[count] = input.nextLine();
        lecturers[count] = input.nextLine();
        deadlines[count] = input.nextLine();
        filenames[count] = input.nextLine();
        difficulties[count] = Integer.parseInt(input.nextLine());
        days[count] = Integer.parseInt(input.nextLine());
        statuses[count] = input.nextLine();
        priorities[count] = calculatePriority(difficulties[count], days[count]);
        count = count + 1;
    }
    
    public static double calculatePriority(int difficulty, int days) {
        double priority;

        priority = difficulty * 1.0 / days;
        
        return priority;
    }
    
    public static String getRecommendation(double priority) {
        String recommendation;

        if (priority > 3) {
            recommendation = "Penting! Anda harus mengerjakan tugas ini segera";
        } else {
            if (priority >= 1.5) {
                recommendation = "Tugas ini memiliki prioritas menengah";
            } else {
                recommendation = "Tugas ini relatif ringan, namun jangan tunda terlalu lama";
            }
        }
        
        return recommendation;
    }
    
    public static void showAssignments(String[] descriptions, String[] codes, int[] courses, int[] lecturers, int[] deadlines, int[] filenames, int[] statuses, int[] difficulties, int[] days, int[] priorities, int count) {
        int i, j;
        String outputString, recText, tempString;
        int tempInt;
        double tempReal;

        for (i = 0; i <= count - 1; i++) {
            for (j = 0; j <= count - 1; j++) {
                if (priorities[j] < priorities[j + 1]) {
                    tempReal = priorities[j];
                    priorities[j] = priorities[j + 1];
                    priorities[j + 1] = tempReal;
                    tempString = descriptions[j];
                    descriptions[j] = descriptions[j + 1];
                    descriptions[j + 1] = tempString;
                    tempString = codes[j];
                    codes[j] = codes[j + 1];
                    codes[j + 1] = tempString;
                    tempString = courses[j];
                    courses[j] = courses[j + 1];
                    courses[j + 1] = tempString;
                    tempString = lecturers[j];
                    lecturers[j] = lecturers[j + 1];
                    lecturers[j + 1] = tempString;
                    tempString = deadlines[j];
                    deadlines[j] = deadlines[j + 1];
                    deadlines[j + 1] = tempString;
                    tempString = filenames[j];
                    filenames[j] = filenames[j + 1];
                    filenames[j + 1] = tempString;
                    tempString = statuses[j];
                    statuses[j] = statuses[j + 1];
                    statuses[j + 1] = tempString;
                    tempInt = difficulties[j];
                    difficulties[j] = difficulties[j + 1];
                    difficulties[j + 1] = tempInt;
                    tempInt = days[j];
                    days[j] = days[j + 1];
                    days[j + 1] = tempInt;
                }
            }
        }
        for (i = 0; i <= count - 1; i++) {
            System.out.println("Prioritas: " + toFixed(priorities[i],2));
            if (statuses[i] == "Selesai") {
                outputString = descriptions[i] + "|" + codes[i] + "|" + courses[i] + "|" + lecturers[i] + "|" + filenames[i] + "|" + statuses[i];
            } else {
                recText = getRecommendation(priorities[i]);
                outputString = descriptions[i] + "|" + codes[i] + "|" + courses[i] + "|" + lecturers[i] + "|" + deadlines[i] + "|" + filenames[i] + "|" + statuses[i] + "|" + recText;
            }
            System.out.println(outputString);
        }
    }
    
    public static void updateTask(String[] codes, String[] statuses, int count) {
        int targetCode, newStatus;
        int i;

        targetCode = Integer.parseInt(input.nextLine());
        newStatus = Integer.parseInt(input.nextLine());
        for (i = 0; i <= count - 1; i++) {
            if (codes[i] == targetCode) {
                statuses[i] = newStatus;
            }
        }
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
