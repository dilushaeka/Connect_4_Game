package lk.ijse.dep.service;
import java.util.Random;

public class AiPlayer extends Player {

    protected Board board;
    public AiPlayer(Board board) {
        this.board=board;
    }

    Random r=new Random();
    @Override
    public void movePiece(int col) {
        int num=col;
        do {
            num= r.nextInt(6);
            System.out.println(num+"move");
            if (board.isLegalMove(num))break;

        }while (!board.isLegalMove(num));
System.out.println( num+"Dilsha Madushan Ekanayaka");
//============================================================
        if (board.isLegalMove(num)) {
            board.updateMove(num, Piece.GREEN);
            board.getBoardUI().update(num, false);
        }
            Winner winner = board.findWinner();

            Piece winningPiece = winner.getWinningPiece();

            if (winningPiece == Piece.GREEN) {
                board.getBoardUI().notifyWinner(winner);
            } else if (!board.existLegalMoves()) {
                System.out.println("Empty");
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }

    }
}
