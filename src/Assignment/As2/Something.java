package Assignment.As2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Something {
    public Map<String, Integer> getScore(String line) {
        String host = line.substring(2, 25).trim();
        String guest = line.substring(32).trim();
        String[] scores = line.substring(25, 32).trim().split("-");
        Map<String, Integer> matchScore = new LinkedHashMap<>();
        matchScore.put(host, Integer.valueOf(scores[0]));
        matchScore.put(guest, Integer.valueOf(scores[1]));
        return matchScore;
    }

    public static void main(String[] args) {

        String[] team = {"Chelsea", "Arsenal", "Tottenham Hotspur", "West Ham United", "Crystal Palace"
                , "Manchester United"
                , "Manchester City"
                , "Everton"
                , "Liverpool"
                , "West Bromwich Albion"
                , "Newcastle United"
                , "Stoke City"
                , "Southampton"
                , "Leicester City"
                , "Bournemouth"
                , "Watford"
                , "Brighton & Hove Albion"
                , "Burnley"
                , "Huddersfield Town"
                , "Swansea"
        };
        URL url = null;
        try {
            url = new URL("https://raw.githubusercontent.com/openfootball/eng-england/master/2017-18/1-premierleague-i.txt");
            Scanner input = new Scanner(url.openStream());
            String line;

            String mydata = "Arsenal FC               4-3  Leicester City";
            if (mydata.toLowerCase().contains("Arsenal FC")) {
                Pattern pattern = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}");
                Matcher matcher = pattern.matcher(mydata);
                String result;
                if (matcher.find()) {
                    result = matcher.group();
                    mydata = mydata.replace(result, "#");
                }
            }
            String[] dataSplit = mydata.split("#");

            HashMap<String, String> match = new HashMap<>();

            match.put("local", dataSplit[0].trim());
            match.put("visitor", dataSplit[1].trim());
            match.put("result", result);

            System.out.println(match.get("local"));
            System.out.println(match.get("result"));
            System.out.println(match.get("visitor"));
            //Pattern pattern = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}");
            // Matcher matcher = pattern.matcher(input.nextLine());
            //if (matcher.find())
            //{
            //     System.out.println(matcher.group());
            //}

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
