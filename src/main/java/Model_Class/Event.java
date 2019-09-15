package Model_Class;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;;

/**
 * Model_Class.Event object inherits Model_Class.Task.
 * Is a type of task available for use.
 */
public class Event extends Task {
    /**
    * Contains the date & time in a String.
    */
    protected Date dateObj;
    protected String date;
    protected int format;

    /**
     * Creates event
     * @param description Description of task.
     * @param date Model_Class.Event date & time.
     */
    public Event(String description, String date){
        super(description);
		try {
			SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
			inputFormat.setLenient(false);
			Date dateObj = inputFormat.parse(date);
			this.dateObj = dateObj;
			format = 1; // date and time
		} catch (ParseException pe) {
			try {
				SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
				inputFormat.setLenient(false);
				Date dateObj = inputFormat.parse(date);
				this.dateObj = dateObj;
				format = 2; // only date
			} catch (ParseException pe2) {
				format = 3; // other types; store as string
			}
		}
	}

    /**
     * Creates event with boolean attached, so as to read from file correctly.
     * @param description Description of task.
     * @param date Model_Class.Event date & time.
     * @param isDone Boolean defining if the task is completed.
     */
    public Event(String description, String date, boolean isDone){
    	super(description, isDone);
    	try {
    	    SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
    	    inputFormat.setLenient(false);
    	    Date dateObj = inputFormat.parse(date);
    	    this.dateObj = dateObj;
    	    format = 1; // date and time
    	} catch (ParseException pe) {
    		try {
	    		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	    inputFormat.setLenient(false);
	    	    Date dateObj = inputFormat.parse(date);
	    	    this.dateObj = dateObj;
	    	    format = 2; // only date
    		} catch (ParseException pe2) {
        	    format = 3; // other types; store as string
    		}
    	} 
    }

    /**
     * Converts event type task to string format for printing.
     * @return Formatted string representing the event, whether or not it is completed and its date.
     */
    @Override
    public String toString(){
    	if (format == 1) {
    		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
    	 	String out = outputFormat.format(dateObj);
    	 	return "[E]" + super.toString() + "(at: " + out + ")";
    	} else if (format == 2) {
    		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
    	 	String out = outputFormat.format(dateObj);
    	 	return "[E]" + super.toString() + "(at: " + out + ")";
    	} else {
    		return "[E]" + super.toString() + "(at: " + date + ")";
    	}
    }
}
