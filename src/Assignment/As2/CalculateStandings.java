package Assignment.As2;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateStandings {
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

    public static String getTeamName(int index) {
        return teamName[index];
    }

    public static int getMatches(int index) {
        return matches[index];
    }

    public static int getHomeWin(int index) {
        return homeWin[index];
    }

    public static int getHomeDraw(int index) {
        return homeDraw[index];
    }

    public static int getHomeLost(int index) {
        return homeLost[index];
    }

    public static int getHomeForGoal(int index) {
        return homeForGoal[index];
    }

    public static int getHomeAgainstGoal(int index) {
        return homeAgainstGoal[index];
    }

    public static int getAwayWin(int index) {
        return awayWin[index];
    }

    public static int getAwayDraw(int index) {
        return awayDraw[index];
    }

    public static int getAwayLost(int index) {
        return awayLost[index];
    }

    public static int getAwayForGoal(int index) {
        return awayForGoal[index];
    }

    public static int getAwayAgainstGoal(int index) {
        return awayAgainstGoal[index];
    }

    public static int getPoint(int index) {
        return point[index];
    }

    public static int getTotalWin(int index) {
        return totalWin[index];
    }

    public static int getTotalLost(int index) {
        return totalLost[index];
    }

    public static int getTotalDraw(int index) {
        return totalDraw[index];
    }

    public static int getTotalAgainstGoal(int index) {
        return totalAgainstGoal[index];
    }

    public static int getTotalForGoal(int index) {
        return totalForGoal[index];
    }

    public static int getGoalDifferences(int index) {
        return goalDifferences[index];
    }

    void getResult(String team_Name, int index) {
        teamName[index] = team_Name;
        try {
            URL url = new URL("https://raw.githubusercontent.com/openfootball/eng-england/master/2017-18/1-premierleague-i.txt");
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String mydata = input.nextLine();
                if (mydata.contains(team_Name)) {
                    Pattern pattern = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}");
                    Matcher matcher = pattern.matcher(mydata);
                    String result;
                    if (matcher.find()) {
                        matches[index] += 1;
                        result = matcher.group();
                        if (mydata.startsWith("  " + team_Name)) {
                            homeForGoal[index] += Integer.parseInt(Character.toString(result.charAt(0)));
                            homeAgainstGoal[index] += Integer.parseInt(Character.toString(result.charAt(2)));
                        } else if (mydata.endsWith("  " + team_Name)) {
                            awayForGoal[index] += Integer.parseInt(Character.toString(result.charAt(2)));
                            awayAgainstGoal[index] += Integer.parseInt(Character.toString(result.charAt(0)));
                        }

                        if (Integer.parseInt(Character.toString(result.charAt(0))) > Integer.parseInt(Character.toString(result.charAt(2)))) {
                            if (mydata.startsWith("  " + team_Name)) {
                                point[index] += 3;
                                homeWin[index] += 1;
                            } else if (mydata.endsWith("  " + team_Name)) {
                                awayLost[index] += 1;
                            }
                        } else if (Integer.parseInt(Character.toString(result.charAt(0))) < Integer.parseInt(Character.toString(result.charAt(2)))) {
                            if (mydata.startsWith("  " + team_Name)) {
                                homeLost[index] += 1;
                            } else if (mydata.endsWith("  " + team_Name)) {
                                point[index] += 3;
                                awayWin[index] += 1;
                            }

                        } else {
                            if (mydata.startsWith("  " + team_Name)) {
                                point[index] += 1;
                                homeDraw[index] += 1;
                            } else if (mydata.endsWith("  " + team_Name)) {
                                point[index] += 1;
                                awayDraw[index] += 1;
                            }
                        }
                    }
                }
            }
            totalWin[index] = homeWin[index] + awayWin[index];
            totalLost[index] = homeLost[index] + awayLost[index];
            totalDraw[index] = homeDraw[index] + awayDraw[index];
            totalAgainstGoal[index] = homeAgainstGoal[index] + awayAgainstGoal[index];
            totalForGoal[index] = homeForGoal[index] + awayForGoal[index];
            goalDifferences[index] = totalForGoal[index] - totalAgainstGoal[index];

            //System.out.printf("%s Match: %d Win: %d Draw: %d Lost: %d F/A: %d:%d ", team_Name, matches[index], totalWin[index], totalDraw[index], totalLost[index], totalForGoal[index], totalAgainstGoal[index]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
