package jikan.ui;

import jikan.activity.ActivityList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ui {
    public static final String GREETING = "Jikan";

    public static final String DIVIDER = "-------------------------------------------";

    /** Prints the logo and greeting so users know the app is working. */
    public void printGreeting() {
        System.out.println(GREETING);
        System.out.println(DIVIDER);
    }

    /** Prints exit message and exits the app. */
    public void exitFromApp() {
        System.out.println(DIVIDER);
        System.out.println(" Bye! See you again.");
        System.out.println(DIVIDER);
        System.exit(0);
    }

    /** Prints divider between user input and app feedback. */
    public void printDivider(String line) {
        System.out.println(DIVIDER);
        System.out.println(line);
        System.out.println(DIVIDER);
    }

    /** Prints all the activities in the list. */
    public void printList(ActivityList activityList) {
        System.out.println(DIVIDER);
        System.out.println("Your completed activities:");
        for (int i = 0; i < activityList.getSize(); i++) {
            long durationInNanos = (activityList.get(i).getDuration()).toNanos();
            String duration = String.format("%02d:%02d:%02d",
                    TimeUnit.NANOSECONDS.toHours(durationInNanos),
                    TimeUnit.NANOSECONDS.toMinutes(durationInNanos)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.NANOSECONDS.toHours(durationInNanos)),
                    TimeUnit.NANOSECONDS.toSeconds(durationInNanos)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(durationInNanos)));
            System.out.print(i + 1 + ". " + activityList.get(i).getName() + " " + duration);
            if (activityList.get(i).getTags() != null) {
                if (!activityList.get(i).getTags()[0].equals("null")) {
                    System.out.println(" " + Arrays.toString(activityList.get(i).getTags()));
                } else {
                    System.out.println();
                }
            } else {
                System.out.print("\n");
            }
        }
        System.out.println(DIVIDER);
    }
}
