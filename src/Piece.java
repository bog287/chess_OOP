public class Piece {
    private String name;
    private String letter;
    private boolean white;
    private Integer row;
    private Integer col;

    private boolean dead;

    Piece(String name, String letter, boolean white, Integer row, Integer col) {
        this.name = name;
        this.letter = letter;
        this.white = white;
        this.row = row;
        this.col = col;
    }

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }

    public String getName() {
        return name;
    }

    public boolean getWhite() {
        return this.white;
    }

    public boolean getDead() {
        return this.dead;
    }

    public String getLetter() {
        return letter;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", letter=" + letter+
                ", white=" + white +
                ", row=" + row +
                ", col=" + col +
                ", dead=" + dead +
                '}';
    }
}
