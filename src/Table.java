import java.util.ArrayList;
import java.util.List;

public class Table {
    private Piece[][] table;
    private Integer rows;
    private Integer cols;
    private Piece lastDead = new Piece(" ", " ", false, 0, 0);

    private String index = "\u001b[32m ";
    private String black = "\u001b[47m ";
    private String white = "\u001b[40m ";
    private String clear = " \u001b[0m";
    private String enemy = "\u001b[38;5;88m";
    private String player = "\u001b[38;5;57m";

    Table(Integer rows, Integer cols) {
        this.rows = rows + 1;
        this.cols = cols + 1;
        table = new Piece[this.rows][this.cols];

        for (Integer i = 0; i < this.rows; i++)
            for (Integer j = 0; j < this.cols; j++) {
                if (i == 0 && j != 0)
                    table[i][j] = new Piece(index + j + clear, j.toString(), true, i, j);
                else if (j == 0 && i != 0)
                    table[i][j] = new Piece(index + i + clear, i.toString(), true, i, j);
                else {
                    if ((i + j) % 2 == 0)
                        table[i][j] = new Piece(black + " " + clear, " ",true, i, j);
                    else
                        table[i][j] = new Piece(white + " " + clear, " ",true, i, j);
                }
        }
        table[0][0] = new Piece("   ", " ",true, 0,0);
    }

    public Integer getCols() {
        return cols;
    }

    public Integer getRows() {
        return rows;
    }

    public Piece[][] getTable() {
        return table;
    }

    public Piece getPiece(Integer row, Integer col) {
        return table[row][col];
    }

    public void movePieceEnemy(Piece p, Integer row, Integer col) {
        if ((p.getRow() + p.getCol()) % 2 == 0)
            table[p.getRow()][p.getCol()] = new Piece(black + " " + clear, " ",p.getWhite(), p.getRow(), p.getCol());
        else
            table[p.getRow()][p.getCol()] = new Piece(white + " " + clear, " ",p.getWhite(), p.getRow(), p.getCol());

        if ((row + col) % 2 == 0)
            table[row][col] = new Piece(black + enemy + p.getLetter() + clear, p.getLetter(), p.getWhite(), row, col);
        else
            table[row][col] = new Piece(white + enemy + p.getLetter() + clear, p.getLetter(), p.getWhite(), row, col);
    }

    public void movePiecePlayer(Piece p, Integer row, Integer col) {
        if ((p.getRow() + p.getCol()) % 2 == 0)
            table[p.getRow()][p.getCol()] = new Piece(black + " " + clear, " ",p.getWhite(), p.getRow(), p.getCol());
        else
            table[p.getRow()][p.getCol()] = new Piece(white + " " + clear, " ",p.getWhite(), p.getRow(), p.getCol());

        if ((row + col) % 2 == 0)
            table[row][col] = new Piece(black + player + p.getLetter() + clear, p.getLetter(), p.getWhite(), row, col);
        else
            table[row][col] = new Piece(white + player + p.getLetter() + clear, p.getLetter(), p.getWhite(), row, col);
    }

    public void populate() {
        Piece p;
        String[] list = {"null", "T", "C", "N", "R", "r", "N", "C", "T"};

        for(int j = 1; j < this.cols; j++) {
            if((2 + j) % 2 == 0)
                p = new Piece(black + enemy + "P" + clear, "P",true, 2, j);
            else
                p = new Piece(white + enemy + "P" + clear, "P", true, 2, j);
            table[2][j] = p;
        }

        for(int i = 1; i < list.length; i++) {
            if (i % 2 == 1)
                p = new Piece(black + enemy + list[i] + clear, list[i],true, 1, i);
            else
                p = new Piece(white + enemy + list[i] + clear, list[i],true, 1, i);
            table[1][i] = p;
        }

        for(int j = 1; j < this.cols; j++) {
            if((2 + j) % 2 == 0)
                p = new Piece(white + player + "P" + clear, "P",false, 7, j);
            else
                p = new Piece(black + player + "P" + clear, "P", false, 7, j);
            table[7][j] = p;
        }

        for(int i = 1; i < list.length; i++) {
            if (i % 2 == 1)
                p = new Piece(white + player + list[i] + clear, list[i],false, 8, i);
            else
                p = new Piece(black + player + list[i] + clear, list[i],false, 8, i);
            table[8][i] = p;
        }
    }

    public void deadPiece(Piece p) {
        lastDead = p;
        if((p.getCol() + p.getRow()) % 2 == 0)
            table[p.getRow()][p.getCol()] = new Piece(black + " " + clear, " ",false, p.getRow(), p.getCol());
        else
            table[p.getRow()][p.getCol()] = new Piece(white + " " + clear, " ",false, p.getRow(), p.getCol());

    }

    public Piece getLastDead() {
        return lastDead;
    }
}
