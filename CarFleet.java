import java.util.Arrays;

public class CarFleet {

    static class Car {
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    public static int carGleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        //Fill the cars arr
        for (int i = 0; i < n; i++) {
            double time = (target - position[i]) * 1d / speed[i];
            cars[i] = new Car(position[i], time);
        }

        //Sort according to position
        Arrays.sort(cars, (a, b) -> a.position - b.position);

        int fleetCount = 1;
        double bestTime = cars[n - 1].time; //time such that I can merge
        for (int i = n - 2; i >= 0; i--) {
            if (cars[i].time > bestTime) {
                fleetCount += 1;
                bestTime = cars[i].time;
            }
        }


        return fleetCount;
    }

}
