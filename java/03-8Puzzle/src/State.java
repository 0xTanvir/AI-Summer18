import java.io.Serializable;

class State implements Serializable {
    private int[][] board;
    private int positionX, positionY;

    State(int[][] board, int positionX, int positionY) {
        this.board = board;
        this.positionX = positionX;
        this.positionY = positionY;
    }


    State goUp() {
        if (positionX == 0) {
            return null;
        }
        State newState = (State) DeepCopy.deepCopy(this);
        newState.positionX = positionX - 1;
        newState.board[positionX][positionY] = this.board[positionX - 1][positionY];
        newState.board[newState.positionX][newState.positionY] = 0;
        return newState;
    }


    State goDown() {
        if (positionX == 2) {
            return null;
        }
        State newState = (State) DeepCopy.deepCopy(this);
        newState.positionX = positionX + 1;
        newState.board[positionX][positionY] = this.board[positionX + 1][positionY];
        newState.board[newState.positionX][newState.positionY] = 0;
        return newState;
    }

    State goLeft() {
        if (positionY == 0) {
            return null;
        }
        State newState = (State) DeepCopy.deepCopy(this);
        newState.positionY = positionY - 1;
        newState.board[positionX][positionY] = this.board[positionX][positionY - 1];
        newState.board[newState.positionX][newState.positionY] = 0;
        return newState;
    }

    State goRight() {
        if (positionY == 2) {
            return null;
        }
        State newState = (State) DeepCopy.deepCopy(this);
        newState.positionY = positionY + 1;
        newState.board[positionX][positionY] = this.board[positionX][positionY + 1];
        newState.board[newState.positionX][newState.positionY] = 0;
        return newState;
    }

    int misPlaced(){
        int missCount = 0;
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] != k) {
                    missCount++;
                }
                if (this.board[2][2]==0){
                    missCount++;
                }
                k++;
            }
        }
        return missCount;
    }

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean goalTest() {
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                    if (this.board[i][j] != 0) {
                        return false;
                    }
                } else if (this.board[i][j] != k) {
                    return false;
                }
                k++;
            }
        }
        return true;
    }
}
