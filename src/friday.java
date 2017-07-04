/*
ID: eschilh1
LANG: JAVA
PROG: friday
 */

import java.io.*;
import java.util.Scanner;

public class friday {
    public static void main(String[] args) throws IOException {
        Scanner sin = new Scanner(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        Date dCurrentDate = new Date(1900, 1, 1, 3);
        int nYears = sin.nextInt();
        for (int i = 0; i < nYears; i++) {
            while (!dCurrentDate.endOfYear) {
                dCurrentDate.nextDay();
            }
            dCurrentDate.endOfYear = false;
        }
        for (int i = 0; i < 7; i++) {
            if (i != 6)
                out.print(dCurrentDate.arnThirteenthCount[i] + " ");
            else
                out.print(dCurrentDate.arnThirteenthCount[i]);
        }
        out.println();//Not sure why, problem requirement
        sin.close();
        out.close();
    }
}

class Date {
    private int nYear, nMonth, nDay, nWeekday;
    boolean endOfYear = false;
    int[] arnThirteenthCount = new int[7];

    Date(int nStartYear, int nStartMonth, int nStartDay, int nStartWeekday) {
        nYear = nStartYear;
        nMonth = nStartMonth;//30 is Sept, April, June, Nov
        nDay = nStartDay;
        nWeekday = nStartWeekday;//1 is Saturday, 7 is Friday, as instructed in specifications
    }

    void nextDay() {
        int nMonthDayCount;
        nWeekday = (nWeekday == 7) ? 1 : nWeekday + 1;
        switch (nMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                nMonthDayCount = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                nMonthDayCount = 30;
                break;
            default:
                nMonthDayCount = isItLeapYear();
                break;
        }
        if (nDay == nMonthDayCount) {
            nMonth = (nMonth == 12) ? 1 : nMonth + 1;
            if (nMonth == 1) {
                endOfYear = true;
                nYear++;
            }
            nDay = 1;
        } else {
            nDay++;
        }

        if (nDay == 13) {
            arnThirteenthCount[nWeekday - 1]++;
        }


    }

    private int isItLeapYear() {
        if (nYear % 4 == 0) {
            if (nYear % 100 != 0) {
                return 29;
            } else {
                if (nYear % 400 == 0) {
                    return 29;
                }
            }
        }
        return 28;
    }
}