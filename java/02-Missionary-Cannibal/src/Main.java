import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main bfs = new Main();
        bfs.bfs();
    }

    private void bfs() {
        boolean solutionFound = false;

        Set<State> closedSet = new HashSet<>();
        Queue<Node> fringe = new LinkedList<>();

        State.initializeProblem(3, 3);

        fringe.add(new Node(new State(State.totalNumOfMissionaries, 0, State.totalNumOfCannibals, 0, 0), 0, null));

        Node currentNode = null;
        State currentState;
        int numberOfNodesExpanded = 0;

        while (!fringe.isEmpty()) {
            currentNode = fringe.poll();
            currentState = currentNode.state;

            if (currentState.goalTest()) {
                solutionFound = true;
                break;
            }

            closedSet.add(currentState);

            if (currentState.oneM() != null && !closedSet.contains(currentState.oneM())) {
                fringe.add(new Node(currentState.oneM(), currentNode.cost + 1, currentNode));
            }

            if (currentState.twoM() != null && !closedSet.contains(currentState.twoM())) {
                fringe.add(new Node(currentState.twoM(), currentNode.cost + 2, currentNode));
            }

            if (currentState.oneC() != null && !closedSet.contains(currentState.oneC())) {
                fringe.add(new Node(currentState.oneC(), currentNode.cost + 1, currentNode));
            }

            if (currentState.twoC() != null && !closedSet.contains(currentState.twoC())) {
                fringe.add(new Node(currentState.twoC(), currentNode.cost + 2, currentNode));
            }

            if (currentState.mC() != null && !closedSet.contains(currentState.mC())) {
                fringe.add(new Node(currentState.mC(), currentNode.cost + 2, currentNode));
            }
        }

        if (solutionFound) {
            System.out.println(currentNode.cost);
            System.out.println();
            System.out.println(numberOfNodesExpanded);
            System.out.println();
            printPath(currentNode);
        }
    }

    private void printPath(Node solutionNode) {

        if (solutionNode.parent != null) {
            printPath(solutionNode.parent);
        }
        System.out.println(solutionNode.state);
    }
}
