package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BReader {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    public static int getIntLine() throws IOException {
        return Integer.parseInt(bfr.readLine().trim());
    }

    public static String[] getStringLine(String delimiter) throws IOException {
        return bfr.readLine().trim().split(delimiter);
    }

    public static int[] getIntLine(String delimiter) throws IOException {
        String[] temp = getStringLine(delimiter);
        int[] elems = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            elems[i] = Integer.parseInt(temp[i]);
        }
        return elems;
    }

}
