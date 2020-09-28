import backtracking.NQueens;
import utilities.Graph;
import utilities.ResourceReader;
import utilities.URLDecode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Runner {

    public static void main(String[] args) throws Exception {

        NQueens nq = new NQueens();
        nq.isValidPlacement(new ArrayList<String>() {{
            add("1");
            add("3");
            add("2");
            add("0");
        }},0);

    }


}
