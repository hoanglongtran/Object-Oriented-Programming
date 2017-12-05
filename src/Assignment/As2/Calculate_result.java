package Assignment.As2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate_result {
    private String team_Name;
    private int matches;
    private int homeWin;
    private int homeDraw;
    private int homeLost;
    private int homeForGoal;
    private int homeAgainstGoal;
    private int awayWin;
    private int awayDraw;
    private int awayLost;
    private int awayForGoal;
    private int awayAgainstGoal;
    private int point;


    String getResult(String team_Name) {

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
                        matches += 1;
                        result = matcher.group();

                        if (mydata.startsWith("  " + team_Name)) {
                            homeForGoal += Integer.parseInt(Character.toString(result.charAt(0)));
                            homeAgainstGoal += Integer.parseInt(Character.toString(result.charAt(2)));
                        } else if (mydata.endsWith("  " + team_Name)) {
                            awayForGoal += Integer.parseInt(Character.toString(result.charAt(2)));
                            awayAgainstGoal += Integer.parseInt(Character.toString(result.charAt(0)));
                        }

                        if (Integer.parseInt(Character.toString(result.charAt(0))) > Integer.parseInt(Character.toString(result.charAt(2)))) {
                            if (mydata.startsWith("  " + team_Name)) {
                                homeWin += 1;
                            } else if (mydata.endsWith("  " + team_Name)) {
                                awayLost += 1;
                            }
                        } else if (Integer.parseInt(Character.toString(result.charAt(0))) < Integer.parseInt(Character.toString(result.charAt(2)))) {
                            if (mydata.startsWith("  " + team_Name)) {
                                homeLost += 1;
                            } else if (mydata.endsWith("  " + team_Name)) {
                                awayWin += 1;
                            }

                        } else {
                            if (mydata.startsWith("  " + team_Name)) {
                                homeDraw += 1;
                            } else if (mydata.endsWith("  " + team_Name)) {
                                awayDraw += 1;
                            }
                        }


                    }
                }
            }
            int totalWin = homeWin + awayWin;
            int totalLost = homeLost + awayLost;
            int totalDraw = homeDraw + awayDraw;
            int totalAgainstGoal = homeAgainstGoal + awayAgainstGoal;
            int totalForGoal = homeForGoal + awayForGoal;
            return String.format("%s Match: %d Win: %d Draw: %d Lost: %d F/A: %d:%d ", team_Name, matches, totalWin, totalDraw, totalLost, totalForGoal, totalAgainstGoal);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
