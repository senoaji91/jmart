package senoJmartMH;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;

    public Complaint(int id, String desc)
    {
        super(id);
        this.date = new Date();
        this.desc = desc;
    }
    
    @Override
    public boolean read(String content)
    {
        return false;
    }
    
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String formattedDate = formatter.format(this.date);  
        return
        "Complaint{date=" + formattedDate + ", desc='" +this.desc+ "'}";
    }
}