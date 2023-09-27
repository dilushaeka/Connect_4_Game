package lk.ijse.dep.service;

public class HumanPlayer extends Player {
    protected Board board;
    public HumanPlayer(Board board) {
        this.board=board;
    }

    @Override
    public void movePiece(int col) {

        if (board.isLegalMove(col)) {
            board.updateMove(col, Piece.BLUE);
            board.getBoardUI().update(col, true);

            Winner winner = board.findWinner();

            Piece winningPiece = winner.getWinningPiece();

            if (winningPiece == Piece.BLUE) {
                board.getBoardUI().notifyWinner(winner);
            } else if (!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        }

    }
}
