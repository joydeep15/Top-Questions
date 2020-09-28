package DivideAndConquer;

import utilities.BReader;

import java.io.IOException;

public class KthElementSortedArray {
//    https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array/0

    public static void main(String[] args) throws IOException {
        int t = BReader.getIntLine();

        StringBuilder sb = new StringBuilder();
        while (t != 0) {
            t--;

            int[] ar = BReader.getIntLine("\\s+");
            int n = ar[0];
            int m = ar[1];
            int k = ar[2];

            int[] a = BReader.getIntLine("\\s+");
            int[] b = BReader.getIntLine("\\s+");

            sb.append(getKthElement(a, b, k)).append("\n");

        }

        System.out.println(sb);
    }

    private static int getKthElement(int[] a, int[] b, int k) {

        if (a.length == 0) {
            return b[k];
        } else if (b.length == 0) {
            return a[k];
        }

        int i = 0;
        int j = 0;
        int el = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                el = a[i];
                k--;
                i++;
            }else {
                el = b[j];
                k--;
                j++;
            }

            if (k == 0) {
                return el;
            }
        }

        //one of the arrays is over
        while (i < a.length) {
            el = a[i];
            i++;
            k--;
            if (k == 0) {
                return el;
            }
        }

        //one of the arrays is over
        while (j < b.length) {
            el = b[j];
            j++;
            k--;
            if (k == 0) {
                return el;
            }
        }

        return el;
    }


}
