package Assignment.As2;

import java.util.Formatter;
public class Laucher {
    public static void main(String[] args) {

        Calculate_result Arsenal = new Calculate_result();
        Calculate_result Tottenham = new Calculate_result();
        Calculate_result WHam = new Calculate_result();
        Calculate_result CPalace = new Calculate_result();
        Calculate_result MU = new Calculate_result();
        Calculate_result MC = new Calculate_result();
        Calculate_result Everton = new Calculate_result();
        Calculate_result Liv = new Calculate_result();
        Calculate_result WBAlbion = new Calculate_result();
        Calculate_result NU = new Calculate_result();
        Calculate_result Stoke_City = new Calculate_result();
        Calculate_result Southampton = new Calculate_result();
        Calculate_result Leicester_City = new Calculate_result();
        Calculate_result Bournemouth = new Calculate_result();
        Calculate_result Watford = new Calculate_result();
        Calculate_result Brighton = new Calculate_result();
        Calculate_result Burnley = new Calculate_result();
        Calculate_result Huddersfield = new Calculate_result();
        Calculate_result Swansea = new Calculate_result();
        try {
            Formatter f = new Formatter("C:\\Users\\neX-\\Desktop\\Standings.txt");

            f.format(Arsenal.getResult("Arsenal FC")+"\n");
            f.format(Tottenham.getResult("Tottenham Hotspur")+"\n");
            f.format(WHam.getResult("West Ham United")+"\n");
            f.format(CPalace.getResult("Crystal Palace")+"\n");
            f.format(MU.getResult("Manchester United")+"\n");
            f.format(MC.getResult("Manchester City")+"\n");
            f.format(Everton.getResult("Everton FC")+"\n");
            f.format(Liv.getResult("Liverpool FC")+"\n");
            f.format(WBAlbion.getResult("West Bromwich Albion")+"\n");
            f.format(NU.getResult("Newcastle United")+"\n");
            f.format(Stoke_City.getResult("Stoke City")+"\n");
            f.format(Southampton.getResult("Southampton FC")+"\n");
            f.format(Leicester_City.getResult("Leicester City")+"\n");
            f.format(Bournemouth.getResult("AFC Bournemouth")+"\n");
            f.format(Watford.getResult("Watford FC")+"\n");
            f.format(Brighton.getResult("Brighton & Hove Albion")+"\n");
            f.format(Burnley.getResult("Burnley FC")+"\n");
            f.format(Huddersfield.getResult("Huddersfield Town")+"\n");
            f.format(Swansea.getResult("Swansea City")+"\n");
            f.close();
        } catch (Exception e) {
        System.out.println("Error");
        }
    }


}
