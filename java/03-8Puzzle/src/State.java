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
                if(this.board[i][j]==0){
                    System.out.println("Current Coordinate of 0 is : "+i+","+j);
                    System.out.println("Which is the actual Coordinate of : "+getActualValueForCoordinate(i,j));
                    System.out.println("And misplaced at : "+
                            getCurrentCoordinateForValue(getActualValueForCoordinate(i,j))[0]
                            +","+getCurrentCoordinateForValue(getActualValueForCoordinate(i,j))[1]);
                }
                k++;
            }
        }
        return missCount;
    }

    int getActualValueForCoordinate(int px, int py){
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==px&&j==py){
                    return k;
                }
                k++;
            }
        }
        return -1;
    }

    int[] getCurrentCoordinateForValue(int target){
        int coord[] = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(target==this.board[i][j]){
                    coord[0]=i;
                    coord[1]=j;
                    return coord;
                }
            }
        }
        return coord;
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
