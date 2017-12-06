/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 2
  Purpose: Get and process the data and finally put it into corresponding field
  Author: Long H. Tran
  ID: s3635165
  Created date: 5/12/2017
  Acknowledgement:  https://stackoverflow.com/questions/2275004/in-java-how-do-i-check-if-a-string-contains-a-substring-ignoring-case
                    https://www.mkyong.com/java/java-convert-string-to-int/
                    https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

*/

package Assignment.As2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataFetching {
    //Create fields of array that store data of all team, which is assigned to an index number of the arrays
    private static String[] teamName = new String[20];
    private static int[] matches = new int[20];
    private static int[] homeWin = new int[20];
    private static int[] homeDraw = new int[20];
    private static int[] homeLost = new int[20];
    private static int[] homeForGoal = new int[20];
    private static int[] homeAgainstGoal = new int[20];
    private static int[] awayWin = new int[20];
    private static int[] awayDraw = new int[20];
    private static int[] awayLost = new int[20];
    private static int[] awayForGoal = new int[20];
    private static int[] awayAgainstGoal = new int[20];
    private static int[] point = new int[20];
    private static int[] totalWin = new int[20];
    private static int[] totalLost = new int[20];
    private static int[] totalDraw = new int[20];
    private static int[] totalAgainstGoal = new int[20];
    private static int[] totalForGoal = new int[20];
    private static int[] goalDifferences = new int[20];

    //Make Getter for the fields to be able to accessed from outside of the class
    static String getTeamName(int index) {
        return teamName[index];
    }

    static int getMatches(int index) {
        return matches[index];
    }

    static int getHomeWin(int index) {
        return homeWin[index];
    }

    static int getHomeDraw(int index) {
        return homeDraw[index];
    }

    static int getHomeLost(int index) {
        return homeLost[index];
    }

    static int getHomeForGoal(int index) {
        return homeForGoal[index];
    }

    static int getHomeAgainstGoal(int index) {
        return homeAgainstGoal[index];
    }

    static int getAwayWin(int index) {
        return awayWin[index];
    }

    static int getAwayDraw(int index) {
        return awayDraw[index];
    }

    static int getAwayLost(int index) {
        return awayLost[index];
    }

    static int getAwayForGoal(int index) {
        return awayForGoal[index];
    }

    static int getAwayAgainstGoal(int index) {
        return awayAgainstGoal[index];
    }

    static int getPoint(int index) {
        return point[index];
    }

    static int getTotalWin(int index) {
        return totalWin[index];
    }

    static int getTotalLost(int index) {
        return totalLost[index];
    }

    static int getTotalDraw(int index) {
        return totalDraw[index];
    }

    static int getTotalAgainstGoal(int index) {
        return totalAgainstGoal[index];
    }

    static int getTotalForGoal(int index) {
        return totalForGoal[index];
    }

    static int getGoalDifferences(int index) {
        return goalDifferences[index];
    }

    void getResult(String teamName, int index) {
        DataFetching.teamName[index] = teamName; //store the team name
        try {
            URL url = new URL("www.google.com");
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) { //Read until the end of the text file
                String currentLine = input.nextLine();
                currentLine = currentLine.trim(); //Since in the file there are extra trailing space behind some of the lines, which will mess up the program when searching with endsWith(), therefore, all leading space and trailing space will be removed

                if (currentLine.contains(teamName)) {   //Check if the line contain the team
                    Pattern pattern = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}");  //Create a Pattern in order to find and extract the result from the line of text, the partern is x-y
                    Matcher matcher = pattern.matcher(currentLine);
                    String result;
                    if (matcher.find()) {
                        matches[index] += 1;
                        result = matcher.group(); //Store the string that matches the pattern
                        if (currentLine.startsWith(teamName)) { //If the line starts with the team's name, the team is Home team, if the line ends with the team's name, the team is Away team
                            homeForGoal[index] += Integer.parseInt(Character.toString(result.charAt(0)));
                            homeAgainstGoal[index] += Integer.parseInt(Character.toString(result.charAt(2)));
                        } else if (currentLine.endsWith(teamName)) {
                            awayForGoal[index] += Integer.parseInt(Character.toString(result.charAt(2)));
                            awayAgainstGoal[index] += Integer.parseInt(Character.toString(result.charAt(0)));
                        }
                        //Get and convert the first and the third character of the result string into integers, then compare and store them in the corresponding fields based on whether the searched team is home or away, win or lose
                        if (Integer.parseInt(Character.toString(result.charAt(0))) > Integer.parseInt(Character.toString(result.charAt(2)))) {
                            if (currentLine.startsWith(teamName)) {
                                point[index] += 3;
                                homeWin[index] += 1;
                            } else if (currentLine.endsWith(teamName)) {
                                awayLost[index] += 1;
                            }
                        } else if (Integer.parseInt(Character.toString(result.charAt(0))) < Integer.parseInt(Character.toString(result.charAt(2)))) {
                            if (currentLine.startsWith(teamName)) {
                                homeLost[index] += 1;
                            } else if (currentLine.endsWith(teamName)) {
                                point[index] += 3;
                                awayWin[index] += 1;
                            }

                        } else {
                            if (currentLine.startsWith(teamName)) {
                                point[index] += 1;
                                homeDraw[index] += 1;
                            } else if (currentLine.endsWith(teamName)) {
                                point[index] += 1;
                                awayDraw[index] += 1;
                            }
                        }
                    }
                }
            }
            //Get the total result
            totalWin[index] = homeWin[index] + awayWin[index];
            totalLost[index] = homeLost[index] + awayLost[index];
            totalDraw[index] = homeDraw[index] + awayDraw[index];
            totalAgainstGoal[index] = homeAgainstGoal[index] + awayAgainstGoal[index];
            totalForGoal[index] = homeForGoal[index] + awayForGoal[index];
            goalDifferences[index] = totalForGoal[index] - totalAgainstGoal[index];

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MalformedURLException a){

        }
    }


}
