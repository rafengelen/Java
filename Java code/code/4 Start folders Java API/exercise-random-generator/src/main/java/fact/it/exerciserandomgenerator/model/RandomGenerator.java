package fact.it.exerciserandomgenerator.model;

import java.util.Random;

public class RandomGenerator {

        private int smallest;
        private int number;

        public RandomGenerator() {
            this.smallest = 1;
            this.number = 5;
        }

        public RandomGenerator(int smallest, int number) {
            this.smallest = smallest;
            this.number = number;
        }

        public int getSmallest() {
            return smallest;
        }

        public void setSmallest(int smallest) {
            this.smallest = smallest;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getRandom() {
            Random randomResult = new Random();
            int finalResult = randomResult.nextInt(smallest+number);
            while (finalResult<smallest){
                finalResult = randomResult.nextInt(smallest+number);
            }

            return finalResult;
        }

    }


