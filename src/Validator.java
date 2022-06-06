public class Validator {
    private Table table;
    private Piece piece;

    Validator(Table table) {
        this.table = table;
    }

    public boolean validateMove(Piece p, Integer row, Integer col) {
        this.piece = p;

        if(p.getLetter().equals("P") && this.checkP(p, row, col))
            return true;
        if(p.getLetter().equals("T") && this.checkT(p, row, col))
            return true;
        if(p.getLetter().equals("C") && this.checkC(p, row, col))
            return true;
        if(p.getLetter().equals("N") && this.checkN(p, row, col))
            return true;
        if(p.getLetter().equals("R") && this.checkR(p, row, col))
            return true;
        if(p.getLetter().equals("r") && this.checkRr(p, row, col))
            return true;
        return false;
    }

    private boolean checkP(Piece p, Integer row, Integer col) {
        if(p.getWhite()) {
            if (p.getRow() + 1 == row && p.getCol().equals(col) || p.getRow() + 2 == row && p.getCol().equals(col))
                return table.getPiece(row, col).getLetter().equals(" ");
            else if((p.getRow() + 1 == row && p.getCol() - 1 == col && (table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))) || (p.getRow() + 1 == row && p.getCol() + 1 == col && (table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" ")))))) {
                table.deadPiece(table.getPiece(row, col));
                return true;
            }
                return false;
        }
        else
            if (p.getRow() - 1 == row && p.getCol().equals(col) || p.getRow() - 2 == row && p.getCol().equals(col))
                return table.getPiece(row, col).getLetter().equals(" ");
            else if((p.getRow() - 1 == row && p.getCol() - 1 == col && (table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))) || (p.getRow() - 1 == row && p.getCol() + 1 == col && (table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" ")))))) {
                    table.deadPiece(table.getPiece(row, col));
                return true;
            }
            return false;
    }

    private boolean checkT(Piece p, Integer row, Integer col) {
        if (p.getCol().equals(col)) {
            if (p.getRow() < row) {
                for (int i = p.getRow() + 1; i < row; i++)
                    if (!table.getPiece(i, col).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            } else {
                for (int i = p.getRow() - 1; i > row; i--)
                    if (!table.getPiece(i, col).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            }
        } else if (p.getRow().equals(row)) {
            if (p.getCol() < col) {
                for (int i = p.getCol() + 1; i < col; i++)
                    if (!table.getPiece(row, i).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            } else {
                for (int i = p.getCol() - 1; i > col; i--)
                    if (!table.getPiece(row, i).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            }
        }
        return false;
    }

    private boolean checkC(Piece p, Integer row, Integer col) {
        Integer[] r = {-1, -2, -2, -1, 1, 2, 2, 1};
        Integer[] c = {-2, -1, 1, 2, 2, 1, -1, -2};

        for (int i = 0; i < r.length; i++)
            if (p.getRow() + r[i] == row && p.getCol() + c[i] == col) {
                if (table.getPiece(row, col).getLetter().equals(" "))
                    return true;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" ")))) {
                    table.deadPiece(table.getPiece(row, col));
                    return true;
                }
            }
                return false;
    }

    private boolean checkN(Piece p, Integer row, Integer col) {
        if (row < p.getRow() && col < p.getCol() && p.getRow() - row == p.getCol() - col) {
            for (int i = 1; i < p.getRow() - row; i++) {
                if (!table.getPiece(p.getRow() - i, p.getCol() - i).getLetter().equals(" "))
                    return false;
            }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
        } else if (row < p.getRow() && col > p.getCol() && p.getRow() + p.getCol() == row + col) {
            for (int i = 1; i < p.getRow() - row; i++) {
                if (!table.getPiece(p.getRow() - i, p.getCol() + i).getLetter().equals(" "))
                    return false;
            }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
        } else if (row > p.getRow() && col > p.getCol() && p.getCol() - p.getRow() == col - row) {
            for (int i = 1; i < row - p.getRow(); i++) {
                if (!table.getPiece(p.getRow() + i, p.getCol() + i).getLetter().equals(" "))
                    return false;
            }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
        } else if (row > p.getRow() && col < p.getCol() && p.getRow() + p.getCol() == row + col) {
        for (int i = 1; i < row - p.getRow(); i++) {
            if (!table.getPiece(p.getRow() + i, p.getCol() - i).getLetter().equals(" "))
                return false;
        }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
    }

        return false;
    }

    private boolean checkR(Piece p, Integer row, Integer col) {
        Integer[] r = {0, -1, -1, -1, 0, 1, 1, 1};
        Integer[] c = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int i = 0; i < r.length; i++)
            if (p.getRow() + r[i] == row && p.getCol() + c[i] == col) {
                if (table.getPiece(row, col).getLetter().equals(" "))
                    return true;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" ")))) {
                    table.deadPiece(table.getPiece(row, col));
                    return true;
                }
            }
        return false;
    }

    private boolean checkRr(Piece p, Integer row, Integer col) {
        if (row < p.getRow() && col < p.getCol() && p.getRow() - row == p.getCol() - col) {
            for (int i = 1; i < p.getRow() - row; i++) {
                if (!table.getPiece(p.getRow() - i, p.getCol() - i).getLetter().equals(" "))
                    return false;
            }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
        } else if (row < p.getRow() && col > p.getCol() && p.getRow() + p.getCol() == row + col) {
            for (int i = 1; i < p.getRow() - row; i++) {
                if (!table.getPiece(p.getRow() - i, p.getCol() + i).getLetter().equals(" "))
                    return false;
            }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
        } else if (row > p.getRow() && col > p.getCol() && p.getCol() - p.getRow() == col - row) {
            for (int i = 1; i < row - p.getRow(); i++) {
                if (!table.getPiece(p.getRow() + i, p.getCol() + i).getLetter().equals(" "))
                    return false;
            }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
        } else if (row > p.getRow() && col < p.getCol() && p.getRow() + p.getCol() == row + col) {
            for (int i = 1; i < row - p.getRow(); i++) {
                if (!table.getPiece(p.getRow() + i, p.getCol() - i).getLetter().equals(" "))
                    return false;
            }
            if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                table.deadPiece(table.getPiece(row, col));
            return true;
        } else if (p.getCol().equals(col)) {
            if (p.getRow() < row) {
                for (int i = p.getRow() + 1; i < row; i++)
                    if (!table.getPiece(i, col).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            } else {
                for (int i = p.getRow() - 1; i > row; i--)
                    if (!table.getPiece(i, col).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            }
        } else if (p.getRow().equals(row)) {
            if (p.getCol() < col) {
                for (int i = p.getCol() + 1; i < col; i++)
                    if (!table.getPiece(row, i).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            } else {
                for (int i = p.getCol() - 1; i > col; i--)
                    if (!table.getPiece(row, i).getLetter().equals(" "))
                        return false;
                if((table.getPiece(row, col).getWhite() || (p.getWhite() && !table.getPiece(row, col).getLetter().equals(" "))))
                    table.deadPiece(table.getPiece(row, col));
                return true;
            }
        }
        return false;
    }
}
