/*
ID: eschilh1
LANG: JAVA
PROG: beads
 */

import java.io.*;
import java.util.Scanner;

public class beads {
    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        out.println(maxBeads(sin.nextInt(), sin.next()));
        sin.close();
        out.close();
        //System.out.println(maxBeads(77, "rwrwrwrwrwrwrwrwrwrwrwrwbwrwbwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwrwr"));
    }

    private static int maxBeads(int nBeads, String sNecklace) {
        int nMax = 0, nColA = 0, nColB = 0, nDif;
        char cColA = 'w', cColB = 'w';//Values for debugging
        boolean maxReachedA = false, maxReachedB = false;
        nBeads = sNecklace.length();
        for (int i = 0; i < nBeads; i++) {
            maxReachedA = false;
            maxReachedB = false;
            nColA = nColB = 0;
            cColA = cColB = 'w';

            for (int v = 0; v < nBeads; v++) {
                if (i + v < nBeads) {
                    if (sNecklace.charAt(i + v) != 'w') {
                        cColA = sNecklace.charAt(i + v);
                        v = nBeads;
                    }
                } else {
                    if (sNecklace.charAt(i + v - nBeads) != 'w') {
                        cColA = sNecklace.charAt(i + v - nBeads);
                        v = nBeads;
                    }
                }
            }
            for (int v = 0; v < nBeads; v++) {
                if (i - 1 - v >= 0) {
                    if (sNecklace.charAt(i - 1 - v) != 'w') {
                        cColB = sNecklace.charAt(i - 1 - v);
                        v = nBeads;
                    }
                } else {
                    if (sNecklace.charAt(nBeads - i - 1 - v) != 'w') {
                        cColB = sNecklace.charAt(nBeads - i - 1 - v);
                        v = nBeads;
                    }
                }
            }


            while (!maxReachedA && !maxReachedB) {  //"wwwbbrwrbrbrrbrbrwrwwrbwrwrrb"
                if (!maxReachedA) {
                    if (i + nColA < nBeads) {
                        if (sNecklace.charAt(i + nColA) == cColA || sNecklace.charAt(i + nColA) == 'w') {
                            nColA++;
                        } else {
                            maxReachedA = true;
                        }
                    } else {
                        if (sNecklace.charAt(i + nColA - (nBeads)) == cColA || sNecklace.charAt(i + nColA - (nBeads)) == 'w') {
                            nColA++;
                        } else {
                            maxReachedA = true;
                        }
                    }
                }

                if (!maxReachedB) {
                    if (i - 1 - nColB >= 0) {
                        if (sNecklace.charAt(i - 1 - nColB) == cColB || sNecklace.charAt(i - 1 - nColB) == 'w') {
                            nColB++;
                        } else {
                            maxReachedB = true;
                        }
                    } else {
                        nDif = i - 1 - nColB;//Negative
                        if (sNecklace.charAt(nBeads + nDif) == cColB || sNecklace.charAt(nBeads + nDif) == 'w') {
                            nColB++;
                        } else {
                            maxReachedB = true;
                        }

                    }
                }
                if (nColA + nColB >= nBeads) {
                    //System.out.println("Bead Count Reached");
                    return nBeads;

                }
            }


            if (nColA + nColB > nMax) {
                nMax = nColA + nColB;
                System.out.println("\t\t\t" + i + "\tA:" + cColA + "," + nColA + "\tB:" + cColB + "," + nColB + "\tMax:" + nMax);
            }

            //if (nMax > nBeads / 2) break;
        }

        return nMax;
    }
}