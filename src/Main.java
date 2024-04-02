import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Assignment a1 = new AssignmentImpl("Comp 301 A05 Driver", 20);
        Assignment a2 = new AssignmentImpl("Linear Algebra Worksheet", 6);
        Assignment a3 = new AssignmentImpl("Comp 211 Malloc Lab", 3);
        Assignment a4 = new AssignmentImpl("Stor 485 Mastering", 15);
        ArrayList<Assignment> assignments = new ArrayList<>();
        assignments.add(a1);
        assignments.add(a2);
        assignments.add(a3);
        assignments.add(a4);

        DueDateIterator dueDateIterator = new DueDateIterator(assignments);
        System.out.println("Assignments returned by dueDateIterator:");
        while (dueDateIterator.hasNext()) {
            Assignment temp = dueDateIterator.next();
            System.out.println("Name of next assignment due: " + temp.getAssignmentName());
            System.out.println("Days till next assignment due: " + temp.getDaysTillDue());
            System.out.println("More assignments? " + dueDateIterator.hasNext());
            System.out.println("");
        }
        System.out.println("");

        ExpandingDueDateIterator expandingIterator = new ExpandingDueDateIterator(assignments);
        System.out.println("Assignments returned by expandingDueDateIterator:");
        while (expandingIterator.hasNext()) {
            Assignment temp = expandingIterator.next();
            System.out.println("Name of next assignment due: " + temp.getAssignmentName());
            System.out.println("Days till next assignment due: " + temp.getDaysTillDue());
            System.out.println("More assignments? " + expandingIterator.hasNext());
            System.out.println("");
        }

    }
}
