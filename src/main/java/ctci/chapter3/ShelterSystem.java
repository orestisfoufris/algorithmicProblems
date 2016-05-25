package ctci.chapter3;


import java.util.LinkedList;

/**
 * Chapter 3 exercise 3.7
 *
 * We can even use two LinkedLists and based on the timestamp determine
 * which one to return. On that solution timestamp is only useful for testing.
 */
class ShelterSystem {

    private LinkedList<Animal> allAnimals = new LinkedList<>();

    void enqueue(Animal animal) {
        allAnimals.add(animal);
    }

    Animal dequeueAny() {
        return allAnimals.poll();
    }

    Animal dequeueDog() {
        return findAnimal(Dog.class);
    }

    Animal dequeueCat() {
        return findAnimal(Cat.class);

    }

    private Animal findAnimal(Class<? extends Animal> animal) {
        int i = 0;

        while (i < allAnimals.size() && !(allAnimals.get(i).getClass() == animal)) {
            i++;
        }

        if (i == allAnimals.size()) {
            return null;
        }

        Animal a = allAnimals.get(i);
        allAnimals.remove(i);

        return a;
    }

    public boolean isEmpty() {
        return allAnimals.isEmpty();
    }

    public int size() {
        return allAnimals.size();
    }

    interface Animal extends Comparable<Animal> {
        int getTimestamp();
    }

    static class Dog implements Animal {
        private int timestamp;

        Dog(int timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Animal o) {
            return compare(this, o);
        }

        public int getTimestamp() {
            return timestamp;
        }
    }

    static class Cat implements Animal {
        private int timestamp;

        Cat(int timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Animal o) {
            return compare(this, o);
        }

        public int getTimestamp() {
            return timestamp;
        }
    }

    public static int compare(Animal x, Animal y) {
        if (x.getTimestamp() == y.getTimestamp()) {
            return 0;
        } else if (x.getTimestamp() > y.getTimestamp()) {
            return 1;
        } else {
            return -1;
        }
    }
}
