package stack;

import utilities.BReader;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class RottenOranges {

    public static void main(String[] args) throws IOException {
        int t = BReader.getIntLine();
        StringBuilder sb = new StringBuilder();
        while (t != 0) {
            t--;
            int[] dims = BReader.getIntLine("\\s+");

            int[][] grid = new int[dims[0]][dims[1]];

            int[] elements = BReader.getIntLine("\\s+");

            for (int i = 0; i < dims[0]; i++) {
                for (int j = 0; j < dims[1]; j++) {
                    grid[i][j] = elements[i * dims[1] + j];
                }
            }
            sb.append(orangesRotting(grid)).append("\n");
        }

        System.out.println(sb);
    }
    public static int orangesRotting(int[][] grid) {


        Queue<Point> q1 = new LinkedList<>();
        Queue<Point> q2 = new LinkedList<>();

        int l = grid.length;
        int b = grid[0].length;


        for(int i=0; i<l; i++){
            for(int j=0; j<b; j++){
                if(grid[i][j] == 2){
                    q1.add(new Point(i,j));
                }
            }
        }

        int interval = 0;
        while(q1.size() > 0){

            while(q1.size() > 0){
                Point p = q1.poll();
                q2.addAll(rotOranges(p, grid));
            }

            if (q2.size() == 0) {
                break;
            }else {
                interval++;
                q1.addAll(q2);
                q2.clear();
            }
        }

        for (int[] ints : grid) {
            for (int j = 0; j < b; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return interval;




    }

    private static List<Point> rotOranges(Point p, int[][] grid) {

        List<Point> lis = new LinkedList<>();
        int l = grid.length;
        int b = grid[0].length;

        if (p.x - 1 >= 0) {
            if (grid[p.x - 1][p.y] == 1) {
                lis.add(new Point(p.x - 1, p.y));
                grid[p.x - 1][p.y] = 2;
            }
        }

        if (p.x + 1 < l) {
            if (grid[p.x + 1][p.y] == 1) {
                lis.add(new Point(p.x + 1, p.y));
                grid[p.x + 1][p.y] = 2;
            }
        }

        if (p.y - 1 >= 0) {
            if (grid[p.x][p.y - 1] == 1) {
                lis.add(new Point(p.x, p.y - 1));
                grid[p.x][p.y - 1] =2;
            }
        }

        if (p.y + 1 < b) {
            if (grid[p.x][p.y + 1] == 1) {
                lis.add(new Point(p.x, p.y + 1));
                grid[p.x][p.y+1] = 2;
            }
        }

        return lis;
    }


}