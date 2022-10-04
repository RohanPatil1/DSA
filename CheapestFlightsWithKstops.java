import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithKstops {

    class Flight {
        int stops;
        int node;
        int cost; // distance

        public Flight(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Flight> q = new LinkedList<>();
        q.add(new Flight(0, src, 0));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        //Dijkstra
        while (!q.isEmpty()) {
            Flight flight = q.poll();
            int flightStops = flight.stops;
            int flightNode = flight.node;
            int flightCost = flight.cost;


            if (flightStops > k) continue;

            //Go to adjacent cities
            for (Pair adjN : adj.get(flightNode)) {
                int kFlightNode = adjN.node;
                int kFlightCost = adjN.cost;

                if (flightCost + kFlightCost < distance[kFlightNode] && flightStops <= k) {
                    distance[kFlightNode] = flightCost + kFlightCost;
                    q.add(new Flight(flightStops + 1, kFlightNode, distance[kFlightNode]));
                }

            }


        }

        if (distance[dst] == Integer.MAX_VALUE) return -1;

        return distance[dst];
    }

}
