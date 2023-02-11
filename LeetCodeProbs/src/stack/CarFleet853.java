package stack;

import java.util.Objects;

public class CarFleet853 {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(new CarFleet853().carFleet(target, position, speed));
    }

    class Car {
        int position;
        int target;
        int speed;
        float time;

        Car(int position, int speed, int target) {
            this.position = position;
            this.target = target;
            this.speed = speed;
            //          distance
            // speed = ----------
            //            time
            time = (float) (target - position) / speed;
        }

        public float getTime() {
            return this.time;
        }

        public int getPosition() {
            return this.position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return position == car.position && speed == car.speed && Float.compare(car.time, time) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, speed, time);
        }

        @Override
        public String toString() {
            return "Car: "
                    + (this.target - this.position)
                    + " [speed: " + this.speed
                    + ", time to target: "
                    + this.time + "]\n";
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

//        int size = position.length;
//        Car[] cars = new Car[size];
//        for (int i = 0; i < size; ++i) {
//            cars[i] = new Car(position[i], speed[i], target);
//        }
//        Arrays.sort(cars, Comparator.comparingInt(a -> a.position));
//
//        Deque<Integer> stack = new ArrayDeque<>();
//
//        for (int i = size - 1; i >= 0; i--) {
//            stack.push(i);
//            if (stack.size() > 1) {
//                int stackPeek = stack.pop();
//                int stackPeekMinus1 = stack.peek();
//                if (cars[stackPeek].getTime() > cars[stackPeekMinus1].getTime()) {
//                    stack.push(stackPeek);
//                }
//            }
//        }
//        return stack.size();

        int size = position.length;
        // array with the total number of cars
        int[] cars = new int[target + 1];

        // assign to each car(if exist) the respective speed
        for (int i = 0; i < size; ++i) {
            cars[position[i]] = speed[i];
        }
        // keep the faster car time for all the cars,
        // fasterCarTime is the time for the slower car closer to finish
        float fasterCarTime = -1;
        int carFleets = 0;
        for (int i = target; i >= 0; --i) {
            if (cars[i] != 0) { // if car exists
                float tempTime = (float) (target - i) / cars[i];
                if (tempTime > fasterCarTime) { // if time to finish is greater than existing, ++carFleets
                    ++carFleets;
                    fasterCarTime = tempTime;
                }
            }
        }
        return carFleets;
    }
}
