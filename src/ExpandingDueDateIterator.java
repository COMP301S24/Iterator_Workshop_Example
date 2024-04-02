import java.util.Iterator;

public class ExpandingDueDateIterator implements Iterator<Assignment> {

    private Iterable<Assignment> assignments;
    private Iterator<Assignment> assignmentIterator;
    private Assignment nextAssignment;
    private int currWeek;
    private int prevWeek;
    private int numAssignments;
    private int assignmentsReturned;

    public ExpandingDueDateIterator(Iterable<Assignment> assignments) {
        if (assignments == null) {
            throw new IllegalArgumentException("Invalid iterable of assignments");
        }
        this.assignments = assignments;
        this.assignmentIterator = this.assignments.iterator();
        this.numAssignments = 0;
        while(this.assignmentIterator.hasNext()) {
            if (this.assignmentIterator.next() == null) {
                throw new IllegalArgumentException("Null assignments are not allowed.");
            }
            this.numAssignments++;

        }

        this.assignmentIterator = this.assignments.iterator();
        this.currWeek = 1;
        this.prevWeek = 0;
        this.assignmentsReturned = 0;
        this.nextAssignment = null;
    }

    private void loadNext() {
        if (nextAssignment != null) {
            return;
        }
        if (assignmentsReturned < numAssignments) {
            while (nextAssignment == null) {
                if (assignmentIterator.hasNext()) {
                    Assignment tempAssignment = assignmentIterator.next();
                    if (tempAssignment.getDaysTillDue() < currWeek * 7 && tempAssignment.getDaysTillDue() >= prevWeek * 7) {
                        nextAssignment = tempAssignment;
                        assignmentsReturned++;
                    }
                } else {
                    currWeek++;
                    prevWeek++;
                    assignmentIterator = assignments.iterator();
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        loadNext();
        return nextAssignment != null;
    }

    @Override
    public Assignment next() {
        if(!hasNext()) {
            throw new IllegalArgumentException("No more assignments to return.");
        }
        Assignment temp = nextAssignment;
        nextAssignment = null;
        return temp;
    }
}
