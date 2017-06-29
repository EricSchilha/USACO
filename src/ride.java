/*
ID: eschilh1
LANG: JAVA
PROG: ride
 */
import java.io.*;

class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String sGroup = f.readLine();
        String sComet = f.readLine();
        int nGroupScore = 1, nCometScore = 1;
        for(int i = 0; i < sGroup.length(); i++){
            nGroupScore *= sGroup.charAt(i) - 'A' + 1;
        }
        for(int i = 0; i < sComet.length(); i++){
            nCometScore *= sComet.charAt(i) - 'A' + 1;
        }
        if(nGroupScore % 47 == nCometScore % 47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();
    }
}