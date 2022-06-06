import java.util.Scanner;

public class Service {
    private Table table;

    Service(Table table) {
        this.table = table;
        table.populate();
    }

    public void startGame() {
        boolean win = false;
        while(!win) {
            this.toPrint();
            this.player1Move();
            this.toPrint();
            this.player2Move();
            if(table.getLastDead().getLetter().equals("R")) {
                if (table.getLastDead().getWhite())
                    System.out.println("Jucatorul \u001b[48;5;57m  \u001b[0m a castigat!");
                else
                    System.out.println("Jucatorul \u001b[48;5;88" +
                            "" +
                            "m  \u001b[0m a castigat!");
                win = true;
            }
        }
    }

    private void player1Move() {
        boolean retry = true;
        Validator validator = new Validator(this.table);
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Jucatorul \u001b[48;5;57m  \u001b[0m muta!");
        while(retry) {
            System.out.println("Coordonate piesa (rand coloana): ");
            int row = input.nextInt();
            int col = input.nextInt();

            System.out.println("Coordonate mutare (rand coloana): ");
            int row2 = input.nextInt();
            int col2 = input.nextInt();
            if(validator.validateMove(table.getPiece(row, col), row2, col2) && !table.getPiece(row, col).getWhite()) {
                table.movePiecePlayer(table.getPiece(row, col), row2, col2);
                retry = false;
            }
            else {
                this.toPrint();
                System.out.println();
                System.out.println("\u001b[31;1mCoordonate eronate, retry!\u001b[0m");
            }
        }
    }

    private void player2Move() {
        boolean retry = true;
        Validator validator = new Validator(this.table);
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Jucatorul \u001b[48;5;88m  \u001b[0m muta!");
        while(retry) {
            System.out.println("Coordonate piesa (rand coloana): ");
            int row = input.nextInt();
            int col = input.nextInt();

            System.out.println("Coordonate mutare (rand coloana): ");
            int row2 = input.nextInt();
            int col2 = input.nextInt();
            if(validator.validateMove(table.getPiece(row, col), row2, col2) && table.getPiece(row, col).getWhite()) {
                table.movePieceEnemy(table.getPiece(row, col), row2, col2);
                retry = false;
            }
            else {
                this.toPrint();
                System.out.println();
                System.out.println("\u001b[31;1mCoordonate eronate, retry!\u001b[0m");
            }
        }
    }


    public void toPrint() {
        for (int i = 0; i < table.getRows(); i++) {
            for (int j = 0; j < table.getCols(); j++)
                System.out.print(table.getPiece(i, j).getName());
            System.out.println();
        }
    }
}
