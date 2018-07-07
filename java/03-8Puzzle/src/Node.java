class Node {

    int cost;
    State state;
    Node parent;

    Node(State state, int cost, Node parent) {
        this.state = state;
        this.cost = cost;
        this.parent = parent;
    }
}