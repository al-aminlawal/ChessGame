public class Bishop extends ChessPiece {
    public Bishop(String newColor, Board theBoard) {
        super("Bishop", newColor, theBoard);
    }

    public Bishop(String name, String newColor, Board theBoard) {
        super(name, newColor, theBoard);
    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean valid = false;

        if ((futureRow >= 0 && futureRow < this.getBoard().BOARD_SIZE) && (futureCol >= 0 && futureCol < this.getBoard().BOARD_SIZE)) {


            if (Math.abs(futureRow - currentRow) == Math.abs(futureCol - currentCol)) {

                valid = checkDiagonalValidity(currentRow, currentCol, futureRow, futureCol);
            }
        }

        return valid;
    }

    private boolean checkDiagonalValidity(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean valid = true;
        int row;
        int col;

        if (futureRow < currentRow && futureCol < currentCol) {
            row = currentRow - 1;
            col = currentCol - 1;

            while (row > futureRow && col > futureCol && valid) {
                if (this.getBoard().hasPiece(row,col)) {
                    valid = false;
                }
                row--;
                col--;
            }

            if (valid) {
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    if (this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = false;
                    }
                }
            }

        } else if (futureRow > currentRow && futureCol > currentCol) {
            row = currentRow + 1;
            col = currentCol + 1;
            while (row < futureRow && col < futureCol && valid) {
                if (this.getBoard().hasPiece(row,col)) {
                    valid = false;
                }
                row++;
                col++;
            }

            if (valid) {
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    if (this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = false;
                    }
                }
            }

        } else if (futureRow < currentRow && futureCol > currentCol) {
            row = currentRow - 1;
            col = currentCol + 1;
            while (row > futureRow && col < futureCol && valid) {
                if (this.getBoard().hasPiece(row,col)) {
                    valid = false;
                }
                row--;
                col++;
            }

            if (valid) {
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    if (this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = false;
                    }
                }
            }

        } else if (futureRow > currentRow && futureCol < currentCol) {
            row = currentRow + 1;
            col = currentCol - 1;

            while (row < futureRow && col > futureCol && valid) {
                if (this.getBoard().hasPiece(row,col)) {
                    valid = false;
                }
                row++;
                col--;
            }

            if (valid) {
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    if (this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = false;
                    }
                }
            }
        }
        return valid;
    }
}
