import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    // A list to store the booked events as pairs of start and end times.
    List<int[]> bookings;

    // Constructor to initialize the calendar object.
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    // Method to book an event if it doesn't overlap with any existing event.
    public boolean book(int start, int end) {
        // Check for each booked event if there is an overlap.
        for (int[] booking : bookings) {
            int bookedStart = booking[0];
            int bookedEnd = booking[1];
            
            // An overlap happens if the new event starts before an existing event ends
            // and ends after an existing event starts.
            if (start < bookedEnd && end > bookedStart) {
                return false; // There is an overlap, so booking fails.
            }
        }
        // If no overlap is found, add the new event.
        bookings.add(new int[]{start, end});
        return true; // Booking is successful.
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
