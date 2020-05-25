package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloodFill {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while (t!=0){
            t--;
            String[] ele = bfr.readLine().split("\\s+");
            int n = Integer.parseInt(ele[0]);
            int m = Integer.parseInt(ele[1]);

            int[][] maze = new int[n][m];
            ele = bfr.readLine().split("\\s+");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = Integer.parseInt(ele[i * m + j]);
                }
            }

            ele = bfr.readLine().split("\\s+");
            n = Integer.parseInt(ele[0]);
            m = Integer.parseInt(ele[1]);
            int target = Integer.parseInt(ele[2]);

            floodFill(maze, n, m, maze[n][m], target);
            n = maze.length;
            m = maze[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(maze[i][j]).append(" ");
                }
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    private static void floodFill(int[][] maze, int x, int y, int src, int target) {

        int rows = maze.length - 1;
        int cols = maze[0].length - 1;

        if(x > rows || x < 0 || y > cols || y < 0){
            return;
        }

        if(maze[x][y] == src){
            maze[x][y] = target;
            floodFill(maze, x, y + 1, src, target);
            floodFill(maze, x, y - 1, src, target);
            floodFill(maze, x+1, y , src, target);
            floodFill(maze, x-1, y , src, target);
        }
    }
}
