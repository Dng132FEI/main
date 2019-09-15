package Model_Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Model_Class.Deadline object inherits Model_Class.Task.
 * Is a type of task available for use.
 */
public class Deadline extends Task{
    /**
     * Contains the date & time in a String.
     */
	protected Date dateObj;
    protected String date;
    protected int format;

    /**
     * Creates deadline
     * @param description Description of task.
     * @param date Model_Class.Deadline date & time.
     */
    public Deadline(String description, String date){
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
     * Creates deadline with boolean attached, so as to read from file correctly.
     * @param description Description of task.
     * @param date Model_Class.Deadline date & time.
     * @param isDone Boolean defining if the task is completed or not.
     */
    public Deadline(String description, String date, boolean isDone) {
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
     * Converts deadline type task to string format for printing.
     * @return Formatted string representing the deadline and its date.
     */
    @Override
	public String toString(){
    	if (format == 1) {
    		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
    	 	String out = outputFormat.format(dateObj);
    	 	return "[D]" + super.toString() + "(by: " + out + ")";
    	} else if (format == 2) {
    		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
    	 	String out = outputFormat.format(dateObj);
    	 	return "[D]" + super.toString() + "(by: " + out + ")";
    	} else {
    		return "[D]" + super.toString() + "(by: " + date + ")";
    	}
    }
}
