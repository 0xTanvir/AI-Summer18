import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main bfs = new Main();
        bfs.bfs();
    }

    private void bfs(){
        boolean solutionFound = false;
        Set<State> closedSet = new HashSet<>();
        Queue<Node> fringe = new LinkedList<>();

        int[][] initialBoard = new int[][]{{1, 8, 2}, {0, 4, 3}, {7, 6, 5}};

        fringe.add(new Node(new State(initialBoard, 1, 0), 0, null));

        Node currentNode = null;
        State currentState;

        while (!fringe.isEmpty()) {
            currentNode = fringe.poll();
            currentState = currentNode.state;

            if (currentState.goalTest()) {
                solutionFound = true;
                break;
            }

            System.out.println("Current State:");
            currentState.printBoard();
            System.out.println(currentState.misPlaced()+" Tiles Misplaced");

            closedSet.add(currentState);

            if (currentState.goUp() != null &&  !closedSet.contains(currentState.goUp())) {
                fringe.add(new Node(currentState.goUp(), currentNode.cost + 1, currentNode));

            }

            if (currentState.goDown() != null &&  !closedSet.contains(currentState.goUp())) {
                fringe.add(new Node(currentState.goDown(), currentNode.cost + 1, currentNode));
            }

            if (currentState.goLeft() != null &&  !closedSet.contains(currentState.goUp())) {
                fringe.add(new Node(currentState.goLeft(), currentNode.cost + 1, currentNode));
            }

            if (currentState.goRight() != null &&  !closedSet.contains(currentState.goUp())) {
                fringe.add(new Node(currentState.goRight(), currentNode.cost + 1, currentNode));
            }

        }

        if (solutionFound) {
            System.out.println("----------------"+currentNode.cost+" Steps---------------");
            printPath(currentNode);
        } else {
            System.out.println("Solution not found");
        }
    }

    private void printPath(Node solutionNode) {

        if (solutionNode.parent != null) {
            printPath(solutionNode.parent);
        }
        solutionNode.state.printBoard();
        System.out.println(" ||");
    }
}
