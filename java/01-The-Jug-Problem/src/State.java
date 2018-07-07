public class State {

    private static int capacityOne, capacityTwo, goalForOne;
    private int currentOne, currentTwo;

    static void initializeProblem(int capacityOne, int capacityTwo, int goalForOne) {
        State.capacityOne = capacityOne;
        State.capacityTwo = capacityTwo;
        State.goalForOne = goalForOne;
    }

    State(int currentOne, int currentTwo) {
        this.currentOne = currentOne;
        this.currentTwo = currentTwo;
    }

    private int remainingOne() {
        return State.capacityOne - this.currentOne;
    }

    private int remainingTwo() {
        return State.capacityTwo - this.currentTwo;
    }

    State fromOneToTwo() {
        int newOne;
        int newTwo;

        if (this.currentOne > remainingTwo()) {
            newOne = currentOne - remainingTwo();
            newTwo = State.capacityTwo;
        } else {
            newOne = 0;
            newTwo = currentTwo + currentOne;
        }

        return new State(newOne, newTwo);
    }

    State fromTwoToOne() {
        int newOne;
        int newTwo;

        if (this.currentTwo > remainingOne()) {
            newTwo = currentTwo - remainingOne();
            newOne = State.capacityOne;
        } else {
            newTwo = 0;
            newOne = currentOne + currentTwo;
        }

        return new State(newOne, newTwo);
    }

    State emptyOne() {
        return new State(0, currentTwo);
    }

    State emptyTwo() {
        return new State(currentOne, 0);
    }

    State fillOne() {
        return new State(State.capacityOne, currentTwo);
    }

    State fillTwo() {
        return new State(currentOne, State.capacityTwo);
    }

    State emptyBoth(){
        return new State(0,0);
    }

    State fillBoth(){
        return new State(State.capacityOne, State.capacityTwo);
    }

    boolean goalTest() {
        return this.currentOne == goalForOne;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.currentOne;
        hash = 37 * hash + this.currentTwo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (this.currentOne != other.currentOne) {
            return false;
        }
        if (this.currentTwo != other.currentTwo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "State{" + "currentOne=" + currentOne + ", currentTwo=" + currentTwo + '}';
    }

}
