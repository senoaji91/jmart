package senoJmartMH;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable<Recognizable>
{
    public final int id;
    
    protected Recognizable(int id)
    {
        this.id = id;
    }

    @Override
    public int compareTo(Recognizable other)
    {
        return Integer.compare(this.id, other.id);
    }

    public boolean equals(Object o)
    {
        if(o instanceof Recognizable){
            Recognizable or = (Recognizable) o;
            if (this.id == or.id){
                return true;
            }
            return false;
        }
        else {
            return true;
        }
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id)
    {
        return 0;
    }

    public static <T extends Recognizable> int getClosingId(Class<T> clazz)
    {
        return 0;
    }
    
    public boolean equals(Recognizable r)
    {
        return (this.id == r.id);
    }
}