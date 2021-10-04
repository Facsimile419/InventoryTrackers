package inventory;

public class TestInventoryLog {
    public static void main(String[] args) {
        Inventory log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('c');
        log.add('c');
        log.add('c');
        log.add('a');
        System.out.println(log);    // [azccca]
        log.subtract('c');
        System.out.println(log);    // [aza]
        log.set('a', 5);
        System.out.println("As = " + log.get('a'));    // As = 5
    }
}
