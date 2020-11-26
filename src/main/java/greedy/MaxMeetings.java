package greedy;


import java.util.*;

class Time{
    int start;
    int end;
    int pos;

    public Time(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

}
public class MaxMeetings {

    static void maxMeetings(int start[], int end[], int n) {

        List<Time> times = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {

            Time t = new Time(start[i], end[i], i);
            times.add(t);
        }

        times.sort(((o1, o2) -> {

            if (o1.end == o2.end) {
                return Integer.compare(o1.start, o2.start);
            } else return Integer.compare(o1.end, o2.end);
        }));

        List<Integer> positions = new ArrayList<>();

        //pick first
        positions.add(times.get(0).pos);
        int nextStart = times.get(0).end;

        for (int i = 1; i < times.size(); i++) {
            if (times.get(i).start > nextStart) {
                positions.add(times.get(i).pos);
                nextStart = times.get(i).end;
            }
        }

        positions.forEach(o -> System.out.print((o+1) + " ") );
    }

}
