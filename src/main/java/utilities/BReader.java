package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        return Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
    }

}
