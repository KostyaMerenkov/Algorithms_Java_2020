public class Backpack {
    private int capacity;

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBestItems(int i, int capacity, Item []items) {
        if (i < 0) {
            return 0;
        }
        if (items[i].getWeight() > capacity) {
            return getBestItems(i-1, capacity,items);
        } else {

            return Math.max(getBestItems(i-1, capacity,items), getBestItems(i-1, capacity - items[i].getWeight(),items) + items[i].getPrice());
        }
    }
}
