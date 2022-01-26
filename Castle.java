public class Castle extends ChessPiece{


    public Castle(String newColor, Board theBoard) {
        super("Castle", newColor, theBoard);
    }

    public Castle(String name, String newColor, Board theBoard) {
        super(name, newColor, theBoard);
    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean valid = false;

        if ((futureRow >= 0 && futureRow < this.getBoard().BOARD_SIZE) && (futureCol >= 0 && futureCol < this.getBoard().BOARD_SIZE)) {

            if (currentRow == futureRow || currentCol == futureCol) {
                // look thru horizontally for pieces
                if (currentRow == futureRow) {
                    valid = checkHorizontalValidity(currentRow, currentCol, futureRow, futureCol);
                    // look through vertically for pieces
                } else {
                    valid = checkVerticalValidity(currentRow, currentCol, futureRow, futureCol);
                }
            }
        }


        return valid;
    }

    private boolean checkVerticalValidity(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean valid = true;
        int row;

        if (futureRow < currentRow) {
            row = currentRow - 1;
            while (row > futureRow && valid) {
                if (this.getBoard().hasPiece(row,futureCol)) {
                    valid = false;
                }
                row--;
            }

            if (valid) {
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    if (this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = false;
                    }
                }
            }

        } else if (futureRow > currentRow) {
            row = currentRow + 1;
            while (row < futureRow && valid) {
                if (this.getBoard().hasPiece(row,futureCol)) {
                    valid = false;
                }
                row++;
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

    private boolean checkHorizontalValidity(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean valid = true;
        int col;

        if (futureCol < currentCol) {
            col = currentCol-1;
            while (col > futureCol && valid) {
                if (this.getBoard().hasPiece(futureRow, col)){
                    valid = false;
                }
                col--;
            }

            if (valid) {
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    if (this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = false;
                    }
                }
            }

        } else if (futureCol > currentCol) {
            col = currentCol+1;
            while (col < futureCol && valid) {
                if (this.getBoard().hasPiece(futureRow, col)){
                    valid = false;
                }
                col++;
            }
            if (valid) {
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    if (this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = false;
                    }
                }
            }
        } else {
            valid = false;
        }
        return valid;
    }
}
