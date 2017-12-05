package Assignment.As2;

import java.io.IOException;
import java.net.URL;
import java.util.Formatter;
import java.util.Scanner;

public class Calculate_result {
    private void getWinLost() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/openfootball/eng-england/master/2017-18/1-premierleague-i.txt");
            Scanner input = new Scanner(url.openStream()).useDelimiter("");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
