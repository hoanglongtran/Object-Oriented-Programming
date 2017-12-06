/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Purpose: Sort the data and write it into text file
  Author: Long H. Tran
  ID: s3635165
  Created date: 5/12/2017
  Acknowledgement:  https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax

*/
package Assignment.As2;

import java.io.FileNotFoundException;
import java.util.Formatter;

class DataProcessing {
    private static DataFetching input = new DataFetching();
    private static int rank = 1;
    private static int[][] teamScore = new int[2][20];
    private static String pathDir;

    static void setPathDir(String pathDir) {
        DataProcessing.pathDir = pathDir;
    }

    static void getData() { //give the getResult() method the name of the team to begin searching and assign a element of array field to hold the data
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
        input.getResult("Chelsea FC", 19);
    }

    static void sortData() {    //This method will sort the order of the team based on their teamScore

        int[][] temp = new int[2][1];
        //Create 2D array, in which the indexes that each team is assigned to are on the top row and their teamScore in the bottom row
        for (int i = 0; i < 20; i++) {
            teamScore[0][i] = i;
            teamScore[1][i] = DataFetching.getPoint(i);
        }
        //Bubble sort
        for (int a = 0; a < 20; a++) {
            for (int x = 1; x < (20 - a); x++) {

                if (teamScore[1][x - 1] < teamScore[1][x] || (teamScore[1][x - 1] == teamScore[1][x] && DataFetching.getGoalDifferences(teamScore[0][x-1]) < DataFetching.getGoalDifferences(teamScore[0][x]))) {
                    //When swapping based on the teamScore, we also sort the order of the index numbers, aka the numbers assigned to each team
                    temp[0][0] = teamScore[0][x - 1];
                    temp[1][0] = teamScore[1][x - 1];

                    teamScore[0][x - 1] = teamScore[0][x];
                    teamScore[1][x - 1] = teamScore[1][x];

                    teamScore[0][x] = temp[0][0];
                    teamScore[1][x] = temp[1][0];
                }

            }
        }

    }

    static void writeStandingsToFile() { //Method to write the result into a text file

        Formatter output = null;
        try { //Exception handling
            output = new Formatter(pathDir + "/standings.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Format the text for better quality
        assert output != null;
        output.format("%60s %28s %22s\r\n", "- Total -", "- Home -", "- Away -");
        output.format("%42s %3s %3s %3s %5s %5s %5s %6s %3s %3s %5s %7s %3s %3s %5s\r\n", "Pld",   "W",   "D",   "L",   "F:A",    "+/-",  "Pts",     "W",   "D",   "L",   "F:A",     "W",   "D",   "L",   "F:A"  );
        for (int i = 0; i < 20; i++) {
            //Run through the teamScore array, since the numbers assigned to each team are in descending order, it will write the correspond teams in the exact order
            output.format("%2d. %-30s %7d %3d %3d %3d %3d:%-3d %+3d %4d %7d %3d %3d %3d:%-3d %5d %3d %3d %3d:%-5d\r\n", rank++, DataFetching.getTeamName(teamScore[0][i]),
                    DataFetching.getMatches(teamScore[0][i]),
                    DataFetching.getTotalWin(teamScore[0][i]),
                    DataFetching.getTotalDraw(teamScore[0][i]),
                    DataFetching.getTotalLost(teamScore[0][i]),
                    DataFetching.getTotalForGoal(teamScore[0][i]),
                    DataFetching.getTotalAgainstGoal(teamScore[0][i]),
                    DataFetching.getGoalDifferences(teamScore[0][i]),
                    DataFetching.getPoint(teamScore[0][i]),
                    DataFetching.getHomeWin(teamScore[0][i]),
                    DataFetching.getHomeDraw(teamScore[0][i]),
                    DataFetching.getHomeLost(teamScore[0][i]),
                    DataFetching.getHomeForGoal(teamScore[0][i]),
                    DataFetching.getHomeAgainstGoal(teamScore[0][i]),
                    DataFetching.getAwayWin(teamScore[0][i]),
                    DataFetching.getAwayDraw(teamScore[0][i]),
                    DataFetching.getAwayLost(teamScore[0][i]),
                    DataFetching.getAwayForGoal(teamScore[0][i]),
                    DataFetching.getAwayAgainstGoal(teamScore[0][i]));
        }
        output.close();

    }
}
