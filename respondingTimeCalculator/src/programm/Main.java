package programm;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("file.txt")));
        int numberOfLines = Integer.parseInt(sc.nextLine());

        String[][] splited = new String[numberOfLines][];
        int numOfQueries = 0;
        for (int i = 0; i < numberOfLines; i++) {
            splited[i] = sc.nextLine().split(" ");
            if (splited[i][0].equalsIgnoreCase("D")) {
                numOfQueries++;
            }
        }
        Query[] arrQueries = new Query[numOfQueries];
        TimelineInfo[] arrTimeLines = new TimelineInfo[numberOfLines - numOfQueries];
        int queriesCounter = 0;
        int timeLineCounter = 0;
        for (int i = 0; i < numberOfLines; i++) {
            if (splited[i][0].equalsIgnoreCase("D")) {
                arrQueries[queriesCounter] = new Query(splited[i]);
                queriesCounter++;
            } else {
                arrTimeLines[timeLineCounter] = new TimelineInfo(splited[i]);
                timeLineCounter++;
            }
        }

        int sum = 0;
        int counter = 0;
        double avgsum;
        for (int i = 0; i < queriesCounter; i++) {
            for (int j = 0; j < timeLineCounter; j++) {
                if (arrQueries[i].matchToTimeLine(arrTimeLines[j])) {
                    sum += arrTimeLines[j].getTime().getTimeInMinutes();

                    counter++;
                }
            }
            if (counter != 0) {
                avgsum = sum / counter;
                System.out.println(avgsum);
                sum = 0;
                counter = 0;
            } else {
                sum = 0;
                counter = 0;
                System.out.println("-");
            }

        }
    }
}
