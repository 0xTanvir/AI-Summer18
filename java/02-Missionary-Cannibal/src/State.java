public class State {

    private int ml, mr, cl, cr, boat;
    static int totalNumOfMissionaries, totalNumOfCannibals;

    static void initializeProblem(int totalNumOfMissionaries, int totalNumOfCannibals) {
        State.totalNumOfMissionaries = totalNumOfMissionaries;
        State.totalNumOfCannibals = totalNumOfCannibals;
    }

    State(int ml, int mr, int cl, int cr, int boat) {
        this.ml = ml;
        this.mr = mr;
        this.cl = cl;
        this.cr = cr;
        this.boat = boat;
    }

    private boolean isValidState(State obj) {
        return ((obj.ml == 0 || obj.ml >= obj.cl) && (obj.mr == 0 || obj.mr >= obj.cr));
    }

    State oneM() {

        State newState = new State(ml, mr, cl, cr, boat);

        if (boat == 0) {
            if (ml == 0) {
                return null;
            }
            newState = new State(ml - 1, mr + 1, cl, cr, 1);
        } else if (boat == 1) {
            if (mr == 0) {
                return null;
            }
            newState = new State(ml + 1, mr - 1, cl, cr, 0);
        }

        if (isValidState(newState)) {
            return newState;
        }
        return null;

    }

    State twoM() {

        State newState = new State(ml, mr, cl, cr, boat);

        if (boat == 0) {
            if (ml < 2) {
                return null;
            }
            newState = new State(ml - 2, mr + 2, cl, cr, 1);
        } else if (boat == 1) {
            if (mr < 2) {
                return null;
            }
            newState = new State(ml + 2, mr - 2, cl, cr, 0);
        }

        if (isValidState(newState)) {
            return newState;
        }
        return null;

    }

    State oneC() {

        State newState = new State(ml, mr, cl, cr, boat);

        if (boat == 0) {
            if (ml == 0) {
                return null;
            }
            newState = new State(ml, mr, cl - 1, cr + 1, 1);
        } else if (boat == 1) {
            if (mr == 0) {
                return null;
            }
            newState = new State(ml, mr, cl + 1, cr - 1, 0);
        }

        if (isValidState(newState)) {
            return newState;
        }
        return null;

    }

    State twoC() {

        State newState = new State(ml, mr, cl, cr, boat);

        if (boat == 0) {
            if (cl < 2) {
                return null;
            }
            newState = new State(ml, mr, cl - 2, cr + 2, 1);
        } else if (boat == 1) {
            if (cr < 2) {
                return null;
            }
            newState = new State(ml, mr, cl + 2, cr - 2, 0);
        }

        if (isValidState(newState)) {
            return newState;
        }
        return null;

    }

    State mC() {

        State newState = new State(ml, mr, cl, cr, boat);

        if (boat == 0) {
            if (ml == 0) {
                return null;
            }
            else if (cl == 0) {
                return null;
            }
            newState = new State(ml - 1, mr + 1, cl - 1 , cr + 1, 1);
        } else if (boat == 1) {
            if (mr == 0) {
                return null;
            }
            else if (cr == 0) {
                return null;
            }
            newState = new State(ml + 1, mr - 1, cl + 1, cr - 1, 0);
        }

        if (isValidState(newState)) {
            return newState;
        }
        return null;

    }

    boolean goalTest() {
        if (ml == 0 && cl == 0 && mr == totalNumOfMissionaries && cr == totalNumOfCannibals) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.ml;
        hash = 29 * hash + this.mr;
        hash = 29 * hash + this.cl;
        hash = 29 * hash + this.cr;
        hash = 29 * hash + this.boat;
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
        if (this.ml != other.ml) {
            return false;
        }
        if (this.mr != other.mr) {
            return false;
        }
        if (this.cl != other.cl) {
            return false;
        }
        if (this.cr != other.cr) {
            return false;
        }
        if (this.boat != other.boat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "State{" + "ml=" + ml + ", cl=" + cl + ", mr=" + mr + ", cr=" + cr + ", boat=" + boat + '}';
    }

}
