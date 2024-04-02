# Iterator_Workshop_Example

## Example 1: Due Date Iterator
This iterator returns the assignment with the closest due date. After an assignment has been returned, the assignment 
with the next closest due date will be returned. This process will continue until all assignments have returned, at 
which point the iterator will throw an IllegalArgumentException() if next() is called again.


## Example 2: Expanding Due Date Iterator
This iterator will return assignments that are due within a week (0 to 6 days). Once all of the assignments due in the 
given week are returned, the iterator will start returning assignments due the following week (7 to 13 days), then the
following week (14 to 20 days), etc., in a manner similar to the Expanding Proximity Iterator from A05. Once all of the 
assignments have been returned, the iterator will throw an IllegalArgumentException() if next() is called again.