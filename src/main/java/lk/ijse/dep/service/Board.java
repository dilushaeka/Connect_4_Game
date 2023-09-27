package lk.ijse.dep.service;

public abstract class Board {
    public int NUM_OF_ROWS=5;
    public int NUM_OF_COLS=6;

    public abstract BoardUI getBoardUI();

    public abstract int findNextAvailableSpot(int col);

    public abstract boolean isLegalMove(int col);

    public abstract boolean existLegalMoves();

    public abstract void updateMove(int col,Piece move);

    //public abstract void updateMove(int col,int row,Piece move);

    public abstract Winner findWinner();
}
