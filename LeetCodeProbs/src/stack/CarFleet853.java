package stack;

import java.util.*;

public class CarFleet853 {
    public static void main(String[] args) {
        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};
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
        // push to stack (to create a fleet) if:
        // 1. speed[i] > speed[stk.peek()] &&
        // 2. deltaT < time[stk.peek()]
        int size = position.length;
        Car[] cars = new Car[size];
        for (int i = 0; i < size; ++i) {
            cars[i] = new Car(position[i], speed[i], target);
        }
        Arrays.sort(cars, Comparator.comparingInt(a -> a.position));

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = size - 1; i >= 0; i--) {
            stack.push(i);
            if (stack.size() > 1) {
                int stackPeek = stack.pop();
                int stackPeekMinus1 = stack.peek();
                if (cars[stackPeek].getTime() > cars[stackPeekMinus1].getTime()) {
                    stack.push(stackPeek);
                }
            }
        }
        return stack.size();
    }
}
