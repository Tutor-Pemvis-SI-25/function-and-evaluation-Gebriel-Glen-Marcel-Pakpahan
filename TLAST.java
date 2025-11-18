//Gebriel -12S25019
import java.util.*;
import java.lang.Math;

public class JavaApplication {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] descriptions = new String[10], codes = new String[10], courses = new String[10], lecturers = new String[10], deadlines = new String[10], notes = new String[10], statuses = new String[10];
        int[] difficulties = new int[10], days = new int[10];
        int[] priorities = new int[10];
        String command, tempCode, tempStatus, recommendation;
        int i, j, count;

        count = 0;
        command = input.nextLine();
        while (!command.equals("---")) {
            if (command.equals("---")) {
            } else {
                if (command.equals("Add task")) {
                    descriptions[count] = input.nextLine();
                    codes[count] = input.nextLine();
                    courses[count] = input.nextLine();
                    lecturers[count] = input.nextLine();
                    deadlines[count] = input.nextLine();
                    notes[count] = input.nextLine();
                    difficulties[count] = Integer.parseInt(input.nextLine());
                    days[count] = Integer.parseInt(input.nextLine());
                    statuses[count] = input.nextLine();
                    priorities[count] = difficulties[count] * 1.0 / days[count];
                    count = count + 1;
                }
                if (command.equals("Update task status")) {
                    tempCode = input.nextLine();
                    tempStatus = input.nextLine();
                    for (i = 0; i <= count - 1; i++) {
                        if (codes[i].equals(tempCode)) {
                            statuses[i] = tempStatus;
                        }
                        if (command.equals("Show assigment")) {
                        }
                    }
                }
            }
        }
    }
    
    public static void display() {
        for (i = 0; i <= n - 1; i++) {
            System.out.println("Prioritas: " + toFixed(priorities[i],2));
            if (statuses[i] == "Selesai") {
                System.out.println( + codes[i] + "|" + courses[i] + "|" + lecturers[i] + "|" + notes[i] + "|" + statuses[i]);
            } else {
                if (riorities[i] > 3) {
                    recommendation = "Penting! Anda harus mengerjakan tugas ini segera";
                } else {
                    if (priorities[i] >= 1.5) {
                        recommendation = "Tugas ini memiliki prioritas menengah";
                    } else {
                        recommendation = "Tugas ini relatif ringan, namun jangan tunda terlalu lama";
                        System.out.println( + codes[i] + "|" + courses[i] + "|" + lecturers[i] + "|" + deadlines[i] + "|" + notes[i] + "|" + statuses[i] + "|" + recommendation);
                    }
                }
            }
        }
    }
    
    public static void sorting() {
        String[] descriptions = new String[10], codes = new String[10], courses = new String[10], lecturers = new String[10], deadlines = new String[10], notes = new String[10], statuses = new String[10];
        int[] difficulties = new int[10], days = new int[10];
        int[] priorities = new int[10];
        int i, j, count;

        for (i = 0; i <= n - 2; i++) {
            for (i = 0; i <= n - 2 - i; i++) {
                if (priorities[j] < priorities[j + 1]) {
                    priorities[j + 1] = priorities[j];
                    descriptions[j + 1] = descriptions[j];
                    codes[j + 1] = codes[j];
                    courses[j + 1] = courses[j];
                    lecturers[j + 1] = lecturers[j];
                    deadlines[j + 1] = deadlines[j];
                    notes[j + 1] = notes[j];
                    statuses[j + 1] = statuses[j];
                    difficulties[j + 1] = difficulties[j];
                    days[j + 1] = days[j];
                }
            }
        }
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
