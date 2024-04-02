public class AssignmentImpl implements Assignment {

    private String assignmentName;

    private int daysTillDue;

    public AssignmentImpl(String assignmentName, int daysTillDue) {
        if (assignmentName == null || daysTillDue < 0) {
            throw new IllegalArgumentException("Invalid parameters for assignment.");
        }
        this.assignmentName = assignmentName;
        this.daysTillDue = daysTillDue;

    }

    @Override
    public String getAssignmentName() {
        return assignmentName;
    }

    @Override
    public int getDaysTillDue() {
        return daysTillDue;
    }

    @Override
    public void setAssignmentName(String newAssignmentName) {
        if (newAssignmentName == null) {
            throw new IllegalArgumentException("Invalid assignment name.");
        }
        this.assignmentName = newAssignmentName;
    }

    @Override
    public void setDaysTillDue(int newDaysTillDue) {
        if (newDaysTillDue < 0) {
            throw new IllegalArgumentException("invalid days till due date value.");
        }
        this.daysTillDue = newDaysTillDue;
    }
}
