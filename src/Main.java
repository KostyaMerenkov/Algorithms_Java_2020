public class Main {

    public static void main(String[] args) {
        System.out.println(recPowNum(5,5));

        Backpack bp = new Backpack(19);
        Item []items = new Item[] {
                new Item("Ручка", 8, 800),
                new Item("Телефон", 6, 200),
                new Item("Арбуз", 4, 300),
                new Item("Камера", 8, 200),
                new Item("Повербанк", 21, 27)
        };

        System.out.println(bp.getBestItems(items.length-1, bp.getCapacity(), items));
    }

    public static int recPowNum(int a, int b) {
        if (b == 1) {
            return a;
        }
        return recPowNum(a, b - 1) * a;
    }
}
