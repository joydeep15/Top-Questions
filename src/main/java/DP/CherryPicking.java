package DP;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cherry-pickup/solution/
 */
public class CherryPicking {

    class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    enum Direction{
        LEFT(0, -1),
        RIGHT(0, 1),
        UP(-1, 0),
        DOWN(1, 0),
        NA(0, 0);

        public int x;
        public int y;

        Direction(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    @Test
    public void test(){
        CherryPicking cherryPicking = new CherryPicking();
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        System.out.println(cherryPickup(grid));
    }

    Direction[] forwardDirs = {Direction.LEFT, Direction.UP};
    Direction[] reverseDirs = {Direction.RIGHT, Direction.DOWN};

    public int cherryPickup(int[][] grid) {

        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        Map<Integer, Map<Integer, Direction>> path = new HashMap<>();
        int forward = getMaxCherries(grid, memo, path, forwardDirs, reverseDirs);
        if(forward == 0){
            return forward;
        }
        int backward = getMaxCherries(grid, memo, path, reverseDirs, forwardDirs);
        return forward + backward;


    }


    public int getMaxCherries(int[][] grid, Map<Integer, Map<Integer, Integer>> memo,
                              Map<Integer, Map<Integer, Direction>> path,
                              Direction[] fetch, Direction[] push){

        memo.clear();
        path.clear();
        Queue<Pair> bfs = new LinkedList<>();
        bfs.add(new Pair(0, 0));

        while (!bfs.isEmpty()) {
            Pair current = bfs.poll();
            int value = grid[current.first][current.second];
            //update Directions
            for (Direction dir : push){
                int x = dir.x + current.first;
                int y = dir.y + current.second;
                if(isValidIdx(grid, x, y)){
                    bfs.add(new Pair(x, y));
                }
            }

            if(value == -1){
                continue;
            }

            Direction maxDir = Direction.NA;

            for (Direction dir : fetch) {
                int x = dir.x + current.first;
                int y = dir.y + current.second;
                if(isValidIdx(grid, x, y)){
                    int newValueForDir = value + getFromMemo(memo, x, y, 0);
                    if(newValueForDir > value){
                        maxDir = dir;
                        value = newValueForDir;
                    }
                }
            }
            updateMemo(memo, current.first, current.second, value);
            updateMemo(path, current.first, current.second, maxDir);

        }
        Pair terminating = getTerminating(grid, push);
        if(getFromMemo(memo, terminating.first, terminating.second, 0) ==0 ){
            return 0;
        }
        sweep(grid, path, terminating, fetch);

        return getFromMemo(memo, terminating.first, terminating.second, 0);
    }

    private void sweep(int[][] grid, Map<Integer, Map<Integer, Direction>> path,
                       Pair terminating, Direction[] fetch) {

        int x = terminating.first;
        int y = terminating.second;
        Direction next = getFromMemo(path, x, y, Direction.NA);

        while (next != Direction.NA){

            grid[x][y] = 0;
            next = getFromMemo(path, x, y, Direction.NA);
            x = x + next.x;
            y = y + next.y;

        }
        grid[x][y] = 0;
    }

    private Pair getTerminating(int[][] grid, Direction[] push) {
        if(push[0] == Direction.DOWN && push[1] == Direction.RIGHT){
            return new Pair(grid.length - 1, grid.length - 1);
        } else return new Pair(0, 0);
    }

    private <T> void updateMemo(Map<Integer, Map<Integer, T>> memo, int x, int y, T value) {

        if(!memo.containsKey(x)){
            memo.put(x, new HashMap<>());
        }

        memo.get(x).put(y, value);

    }

    private <T> T getFromMemo(Map<Integer, Map<Integer, T>> memo, int x, int y, T defaultValue) {
        if(memo.containsKey(x)){
            if(memo.get(x).containsKey(y)){
                return memo.get(x).get(y);
            }
        }
        return defaultValue;
    }

    private boolean isValidIdx(int[][] grid, int x, int y) {
        return x>=0 && x < grid.length && y >=0 && y < grid.length;
    }



}
