import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BoardLoader {

    private static final String file = ".//Boards//";

    public static void loadBoardState(Board theBoard, String fileName) {

        String [][] board = parseFile(fileName);

        loadPiecesFromString(theBoard, board);

    }

    private static String[][] parseFile(String fileName) {
        String[][] board = null;
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file + fileName));

            line = reader.readLine();
            Scanner scan = new Scanner(line);
            int row = Integer.parseInt(scan.next());
            int col = Integer.parseInt(scan.next());
            int rowCount = 0;
            int colCount = 0;
            board = new String[row][col];

            line = reader.readLine();
            while (line != null) {
                scan = new Scanner(line);

                while (scan.hasNext()) {
                    board[rowCount][colCount] = scan.next();
                    colCount++;
                }
                rowCount++;
                colCount = 0;
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return board;
    }

    private static void loadPiecesFromString(Board targetBoard, String[][] boardCodes) {

        for (int i = 0; i < boardCodes.length; i++) {
            for (int j = 0; j < boardCodes[i].length; j++) {
                ChessPiece piece = loadChessPiece(targetBoard, boardCodes[i][j]);
                targetBoard.setPiece(i,j,piece);
            }
        }
    }

    private static ChessPiece loadChessPiece(Board targetBoard, String code) {
        ChessPiece piece = null;
        if (code.charAt(0) == 'B') {
            if (code.contains("C")) {
                piece = new Castle("BLACK", targetBoard);
            } else if (code.contains("N")) {
                piece = new Knight("BLACK", targetBoard);
            } else if (code.contains("B")) {
                piece = new Bishop("BLACK", targetBoard);
            } else if (code.contains("K")) {
                piece = new King("BLACK", targetBoard);
            } else if (code.contains("Q")) {
                piece = new Queen("BLACK", targetBoard);
            } else if (code.charAt(1) == 'P') {
                piece = new Pawn("BLACK", targetBoard);
            }
        } else if (code.charAt(0) == 'W') {
            if (code.contains("C")) {
                piece = new Castle("WHITE", targetBoard);
            } else if (code.contains("N")) {
                piece = new Knight("WHITE", targetBoard);
            } else if (code.contains("B")) {
                piece = new Bishop("WHITE", targetBoard);
            } else if (code.contains("K")) {
                piece = new King("WHITE", targetBoard);
            } else if (code.contains("Q")) {
                piece = new Queen("WHITE", targetBoard);
            } else if (code.charAt(1) == 'P') {
                piece = new Pawn("WHITE", targetBoard);
            }
        } else {
            piece = null;
        }
        return piece;
    }

    // Used this for testing
    public static String printArray(String[][] array) {
        String arr = "";
        for (int i = 0; i <  array.length; i++)  {
            for (int j = 0; j < array[i].length; j++) {
                arr+= array[i][j] + " ";
            }
            arr += "\n";
        }
        return arr;
    }
}
