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

        State.initializeProblem(5, 7, 4);

        fringe.add(new Node(new State(0, 0), 0, null));

        Node currentNode = null;
        State currentState;

        while (!fringe.isEmpty()) {
            currentNode = fringe.poll();
            currentState = currentNode.state;

            if (currentState.goalTest()) {
                solutionFound = true;
                break;
            }

            closedSet.add(currentState);

            if (!closedSet.contains(currentState.emptyOne())) {
                fringe.add(new Node(currentState.emptyOne(), currentNode.cost + 1, currentNode));
            }

            if (!closedSet.contains(currentState.emptyTwo())) {
                fringe.add(new Node(currentState.emptyTwo(), currentNode.cost + 1, currentNode));
            }

            if (!closedSet.contains(currentState.fillOne())) {
                fringe.add(new Node(currentState.fillOne(), currentNode.cost + 1, currentNode));
            }

            if (!closedSet.contains(currentState.fillTwo())) {
                fringe.add(new Node(currentState.fillTwo(), currentNode.cost + 1, currentNode));
            }

            if (!closedSet.contains(currentState.fromOneToTwo())) {
                fringe.add(new Node(currentState.fromOneToTwo(), currentNode.cost + 1, currentNode));
            }

            if (!closedSet.contains(currentState.fromTwoToOne())) {
                fringe.add(new Node(currentState.fromTwoToOne(), currentNode.cost + 1, currentNode));
            }

            if (!closedSet.contains(currentState.emptyBoth())) {
                fringe.add(new Node(currentState.emptyBoth(), currentNode.cost + 1, currentNode));
            }

            if (!closedSet.contains(currentState.fillBoth())) {
                fringe.add(new Node(currentState.fillBoth(), currentNode.cost + 1, currentNode));
            }


        }

        if (solutionFound) {
            System.out.println(currentNode.cost);
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
