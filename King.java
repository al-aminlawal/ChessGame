public class King extends ChessPiece {


    public King(String newColor, Board theBoard) {
        super("King", newColor, theBoard);
    }

    public King(String name, String newColor, Board theBoard) {
        super(name, newColor, theBoard);
    }


    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol ){
        boolean valid = false;

        int rowDiff = Math.abs(futureRow-currentRow);
        int colDiff = Math.abs(futureCol-currentCol);

        if ((futureRow >= 0 && futureRow < this.getBoard().BOARD_SIZE) && (futureCol >= 0 && futureCol < this.getBoard().BOARD_SIZE)) {
            if (rowDiff <= 1 && colDiff <= 1 && (rowDiff != colDiff)) {
                if (this.getBoard().hasPiece(futureRow,futureCol)) {
                    if (!this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = true;
                    }
                } else {
                    valid = true;
                }
            }
        }
        return valid;
    }

}
