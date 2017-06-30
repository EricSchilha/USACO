/*
ID: eschilh1
LANG: JAVA
PROG: gift1
 */

import java.io.*;
import java.util.Scanner;

public class gift1 {
    private static int nPeeps;
    private static String[] arsNames;
    private static int[] arnMoney;

    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner(new FileReader("gift1.in"));//RENAME TO files/gift1.in
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));//RENAME TO files/gift1.out
        String sGiver, sReceiver;
        nPeeps = sin.nextInt();
        arsNames = new String[nPeeps];
        arnMoney = new int[nPeeps];
        int nLoc, nMoney, nNumOfReceivers;

        for (int i = 0; i < nPeeps; i++) {
            arsNames[i] = sin.next();
        }

        while (sin.hasNext()) {
            sGiver = sin.next();
            nLoc = findLoc(sGiver);
            nMoney = sin.nextInt();
            nNumOfReceivers = sin.nextInt();
            for (int i = 0; i < nNumOfReceivers; i++) {
                sReceiver = sin.next();
                if (nNumOfReceivers > 0) {
                    arnMoney[findLoc(sReceiver)] += Math.floor(nMoney / nNumOfReceivers);
                }
            }
            if (nNumOfReceivers > 0)
                arnMoney[nLoc] -= (nMoney - nMoney % nNumOfReceivers);

        }

        for (int i = 0; i < nPeeps; i++) {
            out.println(arsNames[i] + " " + arnMoney[i]);
        }
        out.close();
        sin.close();
    }

    private static int findLoc(String name) {
        for (int i = 0; i < nPeeps; i++) {
            if (arsNames[i].equals(name)) {
                return i;
            }
        }
        return 42;
    }
}
