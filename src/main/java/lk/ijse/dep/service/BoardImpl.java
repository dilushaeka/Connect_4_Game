package lk.ijse.dep.service;

//import lk.ijse.dep.controller.BoardController;

public class BoardImpl extends Board {
    private BoardUI boardUI;
    private Piece[][] piece;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        piece = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                piece[i][j] = Piece.EMPTY;
            }
        }
    }


    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
       // System.out.println(col + "kkk");
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (piece[col][i] == Piece.EMPTY) {
                // System.out.println(i);
                return i;
            }
        }
       return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        System.out.println(col + "islegal");
        if (findNextAvailableSpot(col) != -1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if (piece[i][j] == Piece.EMPTY) {
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        if (isLegalMove(col)) {
            int row = findNextAvailableSpot(col);
            piece[col][row] = move;
        }

    }





    @Override
    public Winner findWinner() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            int greencount = 0;
            int bluecount = 0;
            int emptycount = 0;
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if (piece[i][j] == Piece.GREEN) {
                    greencount += 1;
                    bluecount = 0;
                    emptycount = 0;
                }

                if (piece[i][j] == Piece.BLUE) {
                    greencount = 0;
                    bluecount += 1;
                    emptycount = 0;
                }

                if (piece[i][j] == Piece.EMPTY) {
                    greencount = 0;
                    bluecount = 0;
                    emptycount += 1;
                }

                if (greencount == 4 || bluecount == 4) {
                    Piece winningPiece = greencount == 4 ? Piece.GREEN : Piece.BLUE;
                    return new Winner(winningPiece, i, j-3,i,j);
                }
            }
        }


        for (int i = 0; i < NUM_OF_ROWS; i++) {
            int greencount = 0;
            int bluecount = 0;
            int emptycount = 0;
            for (int j = 0; j < NUM_OF_COLS; j++) {
                if (piece[j][i] == Piece.GREEN) {
                    greencount += 1;
                    bluecount = 0;
                    emptycount = 0;
                }

                if (piece[j][i] == Piece.BLUE) {
                    greencount = 0;
                    bluecount += 1;
                    emptycount = 0;
                }

                if (piece[j][i] == Piece.EMPTY) {
                    greencount = 0;
                    bluecount = 0;
                    emptycount += 1;
                }

                if (greencount == 4 || bluecount == 4) {
                    Piece winningPiece = greencount == 4 ? Piece.GREEN : Piece.BLUE;
                    return new Winner(winningPiece, j-3,i,j , i);
                }
            }
        }
        return new Winner(Piece.EMPTY);
    }

}
