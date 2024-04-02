import java.util.Iterator;

public class DueDateIterator implements Iterator<Assignment> {

    private Iterable<Assignment> assignments;
    private Iterator<Assignment> assignmentIterator;
    private Assignment nextAssignment;
    private int daysAway;
    private int numAssignments;
    private int assignmentsReturned;

    public DueDateIterator(Iterable<Assignment> assignments) {
        if (assignments == null) {
            throw new IllegalArgumentException("Invalid iterable of assignments.");
        }

        this.assignments = assignments;
        this.assignmentIterator = this.assignments.iterator();
        this.numAssignments = 0;
        while(this.assignmentIterator.hasNext()) {
            if(this.assignmentIterator.next() == null) {
                throw new IllegalArgumentException("Null assignments are not allowed.");
            }
            this.numAssignments++;
        }

        this.assignmentIterator = this.assignments.iterator();
        this.daysAway = 0;
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
                  if (tempAssignment.getDaysTillDue() == daysAway) {
                      nextAssignment = tempAssignment;
                      assignmentsReturned++;
                  }
              } else {
                  daysAway++;
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
        if (!hasNext()) {
            throw new IllegalArgumentException("No more assignments to return.");
        }
        Assignment tempAssignment = nextAssignment;
        nextAssignment = null;
        return tempAssignment;
    }
}
