package Assignment.As2;

import java.util.Formatter;
import java.util.Scanner;


public class Launcher {
    private static CalculateStandings input = new CalculateStandings();
    private static int rank = 1;
    private static int[][] points = new int[2][20];
    private static String pathDir;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the desired location for the output file: ");
        pathDir = input.nextLine();
        System.out.println("Please wait for the program to process the data...");
        getData();
        sortData();
        writeStandingsToFile();
        System.out.println("Done! The text file for teams' standings is now available in your chosen directory");
    }

    private static void getData() {
        input.getResult("Arsenal FC", 0);
        input.getResult("Tottenham Hotspur", 1);
        input.getResult("West Ham United", 2);
        input.getResult("Crystal Palace", 3);
        input.getResult("Manchester United", 4);
        input.getResult("Manchester City", 5);
        input.getResult("Everton FC", 6);
        input.getResult("Liverpool FC", 7);
        input.getResult("West Bromwich Albion", 8);
        input.getResult("Newcastle United", 9);
        input.getResult("Stoke City", 10);
        input.getResult("Southampton FC", 11);
        input.getResult("Leicester City", 12);
        input.getResult("AFC Bournemouth", 13);
        input.getResult("Watford FC", 14);
        input.getResult("Brighton & Hove Albion", 15);
        input.getResult("Burnley FC", 16);
        input.getResult("Huddersfield Town", 17);
        input.getResult("Swansea City", 18);
        input.getResult("Chelsea", 19);
    }

    private static void sortData() {

        int[][] temp = new int[2][1];
        for (int i = 0; i < 20; i++) {
            points[0][i] = i;
            points[1][i] = CalculateStandings.getPoint(i);
        }
        for (int a = 0; a < 20; a++) {
            for (int x = 1; x < (20 - a); x++) {

                if (points[1][x - 1] < points[1][x] || (points[1][x - 1] == points[1][x] && CalculateStandings.getGoalDifferences(points[0][x]) < CalculateStandings.getGoalDifferences(points[0][x]))) {
                    temp[0][0] = points[0][x - 1];
                    temp[1][0] = points[1][x - 1];

                    points[0][x - 1] = points[0][x];
                    points[1][x - 1] = points[1][x];

                    points[0][x] = temp[0][0];
                    points[1][x] = temp[1][0];
                }

            }
        }
        //for (int y =0; y < 20; y++){
        // System.out.printf(rank++ + ". " + points[0][y] + " with " + points[1][y] + " points\n");
        //}
        /*HashMap<Integer, Integer> points = new HashMap<>();
        for (int i = 0; i < 20; i++) {

            points.put(i, CalculateStandings.getPoint(i));

        }
        points.entrySet().stream()
                .sorted((x,y) -> y.getValue().compareTo(x.getValue()))
                .forEach(n -> System.out.println(rank++ + ". " + n.getKey() + " with " + n.getValue() + " points."
                ));*/

    }

    private static void writeStandingsToFile() {
        try {
            Formatter f = new Formatter(pathDir + "Standings.txt");
            f.format("%60s %28s %22s\r\n", "- Total -", "- Home -", "- Away -");
            f.format("%42s %3s %3s %3s %5s %5s %5s %6s %3s %3s %5s %7s %3s %3s %5s\r\n", "Pld",   "W",   "D",   "L",   "F:A",    "+/-",  "Pts",     "W",   "D",   "L",   "F:A",     "W",   "D",   "L",   "F:A"  );
            for (int i = 0; i < 20; i++) {
                f.format("%2d. %-30s %7d %3d %3d %3d %3d:%-3d %+3d %4d %7d %3d %3d %3d:%-3d %5d %3d %3d %3d:%-5d\r\n", rank++, CalculateStandings.getTeamName(points[0][i]),
                        CalculateStandings.getMatches(points[0][i]),
                        CalculateStandings.getTotalWin(points[0][i]),
                        CalculateStandings.getTotalDraw(points[0][i]),
                        CalculateStandings.getTotalLost(points[0][i]),
                        CalculateStandings.getTotalForGoal(points[0][i]),
                        CalculateStandings.getTotalAgainstGoal(points[0][i]),
                        CalculateStandings.getGoalDifferences(points[0][i]),
                        CalculateStandings.getPoint(points[0][i]),
                        CalculateStandings.getHomeWin(points[0][i]),
                        CalculateStandings.getHomeDraw(points[0][i]),
                        CalculateStandings.getHomeLost(points[0][i]),
                        CalculateStandings.getHomeForGoal(points[0][i]),
                        CalculateStandings.getHomeAgainstGoal(points[0][i]),
                        CalculateStandings.getAwayWin(points[0][i]),
                        CalculateStandings.getAwayDraw(points[0][i]),
                        CalculateStandings.getAwayLost(points[0][i]),
                        CalculateStandings.getAwayForGoal(points[0][i]),
                        CalculateStandings.getAwayAgainstGoal(points[0][i]));
            }
            f.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

