package senoJmartMH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable
{
    public final int id;
    
    protected Recognizable(int id)
    {
        this.id = id;
    }
    
    public boolean equals(Object object)
    {
        if (object instanceof Recognizable)
        {
            Recognizable r = (Recognizable)object;
            return (this.id == r.id);
        }
        return false;
    }
    
    public boolean equals(Recognizable r)
    {
        return (this.id == r.id);
    }
}