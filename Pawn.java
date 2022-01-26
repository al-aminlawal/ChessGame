public class Pawn extends ChessPiece{

    public Pawn(String newColor, Board theBoard) {
        super("Pawn", newColor, theBoard);

    }

    public Pawn(String name, String newColor, Board theBoard) {
        super(name, newColor, theBoard);
    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol) {
        boolean valid = false;


        if ((futureRow >= 0 && futureRow < this.getBoard().BOARD_SIZE) && (futureCol >= 0 && futureCol < this.getBoard().BOARD_SIZE)) {
            // check if it is the pawns first move
            if (currentRow == 1 && futureCol==currentCol){
                if (futureRow == currentRow+1 || futureRow == currentRow+2) {
                    valid = true;
                }

                // check if pawn can move forward
            } else if ((futureRow == currentRow+1) && (futureCol == currentCol)) {
                if (!this.getBoard().hasPiece(futureRow, futureCol)){
                    valid = true;
                }

                // check if pawn can move diagonally
            } else if ((futureRow == currentRow+1) && (futureCol == currentCol+1 || futureCol == currentCol-1)){
                if (this.getBoard().hasPiece(futureRow, futureCol)) {
                    // if the piece is a piece on the opposing team, the move is valid
                    if (!this.getBoard().getPieceColor(futureRow, futureCol).equals(this.getColor())) {
                        valid = true;
                    }
                }
            }

        }
        return valid;
    }
}
