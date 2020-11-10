package graph;

import java.util.*;

enum CITY{
    DELHI,
    MUM,
    KOL,
    CHEN,
    BANG,
    HYD,
    AMRIST,
    NAG,
    DARJ,
    BHOP,
    COMB,
    LUCKNOW,
    VIZAG
}
class Flights{

    private HashMap<CITY,Set<CITY>> routes;

    Flights() {
        routes = new HashMap<>();
        for (CITY city : CITY.values()) {
            routes.put(city, new HashSet<>());
        }
    }

    public void addRoute(CITY origin, CITY... destinations){
        routes.get(origin).addAll(Arrays.asList(destinations));
    }

    public HashMap<CITY, Set<CITY>> getRoutes() {
        return routes;
    }
}

class FlightRoutesUtil{
    private Flights flights;

    public Flights getFlights() {
        return flights;
    }

    private void linkMetros(Flights flights, CITY... cities) {
        for (CITY city : cities) {
            flights.addRoute(city, cities);
        }
    }

    private void addReverseRoutes(Flights flights) {
        flights.getRoutes().forEach((origin, destinations) ->{

            destinations.forEach(destination -> {
                flights.addRoute(destination, origin);
            });

        });
    }

    private void addDefaultRoutes(Flights flights) {
        flights.addRoute(CITY.DELHI, CITY.AMRIST, CITY.BHOP, CITY.LUCKNOW);
        flights.addRoute(CITY.MUM, CITY.NAG, CITY.BHOP);
        flights.addRoute(CITY.HYD, CITY.VIZAG, CITY.NAG);
        flights.addRoute(CITY.KOL, CITY.DARJ);
        flights.addRoute(CITY.CHEN, CITY.COMB);
        flights.addRoute(CITY.BANG, CITY.VIZAG);
    }

    public void buildFlights() {
        flights = new Flights();
        addDefaultRoutes(flights);
        addReverseRoutes(flights);
        linkMetros(flights, CITY.DELHI, CITY.MUM, CITY.KOL, CITY.CHEN, CITY.BANG, CITY.HYD);
    }

}

public class FlightRoutes {


    public static void main(String[] args) {
        FlightRoutesUtil flightRoutes = new FlightRoutesUtil();
        flightRoutes.buildFlights();
//        System.out.println(flightRoutes.getFlights().getRoutes());
        List<List<CITY>> paths = getPaths(flightRoutes.getFlights(), CITY.DELHI, CITY.BHOP);
        paths.forEach( p ->{
            p.forEach(q -> System.out.print(q+" , "));
            System.out.println();
        });

    }

    private static List<List<CITY>> getPaths(Flights flights, CITY start, CITY end) {

        List<List<CITY>> paths = new ArrayList<>();
        List<CITY> currentPath = new LinkedList<>();
        Set<CITY> visited = new HashSet<>();

        dfs(flights, start, end, paths, currentPath, visited);
        return paths;
    }

    private static void dfs(Flights flights, CITY start, CITY end,
                            List<List<CITY>> paths, List<CITY> currentPath, Set<CITY> visited) {

        if (visited.contains(start) && start!=end) {
            return;
        }

        currentPath.add(start);
        visited.add(start);

        if (start == end) {
            paths.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        for (CITY c : flights.getRoutes().get(start)) {
            dfs(flights, c, end, paths, currentPath, visited);
        }
        currentPath.remove(currentPath.size() - 1);
        visited.clear();
        visited.addAll(currentPath);
    }


}
