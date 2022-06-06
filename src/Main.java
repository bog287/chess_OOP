public class Main {
    public static void main(String[] args) {

        Table t1 = new Table(8,8);
        Piece p2 = new Piece("\u001b[31mX", "X", false,1,2);
        Service service = new Service(t1);
        service.startGame();


        Collection<Piece> list = new Collection<Piece>();
        Piece p1 = new Piece("P", "P", false,0,0);
        list.add(p1);
        System.out.println(list.get(0));
        list.remove(p1);

        HashTable<Integer, Piece> table = new HashTable<Integer, Piece>();
        table.put(1, p1);
        System.out.println(table.containsKey(1));
        System.out.println(table.size());
        System.out.println(table.get(1));
        table.remove(1);

    }
}
