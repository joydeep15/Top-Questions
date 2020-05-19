package arrays;

import java.util.ArrayList;
import java.util.List;

public class MemBlast {
    public static void main(String[] args) {

        List<Integer[]> l = new ArrayList<>();
        while(true){

            l.add(new Integer[1000000]);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
