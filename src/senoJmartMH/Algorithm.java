package senoJmartMH;

import java.util.*;
import java.util.Iterator;

public class Algorithm {

    private Algorithm() {}

    public static <T> int count(T[] array, T value)
    {
        int counter = 0;
        for(T arrayValue : array)
        {
            if (arrayValue.equals(value))
            {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterable<T> iterable, T value)
    {
        int counter = 0;
        for(T t : iterable)
        {
            if(t.equals(value))
            {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterator<T> iterator, T value)
    {
        int counter = 0;
        while(iterator.hasNext())
        {
            if(iterator.next().equals(value))
            {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(T[] array, Predicate<T> pred)
    {
        int counter = 0;
        for(T arrayValue : array)
        {
            if (arrayValue.equals(pred))
            {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred)
    {
        int counter = 0;
        for(T t : iterable)
        {
            if(t.equals(pred))
            {
                counter++;
            }
        }
        return counter;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred)
    {
        int counter = 0;
        while(iterator.hasNext())
        {
            if(iterator.next().equals(pred))
            {
                counter++;
            }
        }
        return counter;
    }

    public static <T> boolean exist(T[] array, T value)
    {
        for(T arrayValue : array)
        {
            if (arrayValue.equals(value))
            {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exist(Iterable<T> iterable, T value)
    {
        for(T t : iterable)
        {
            if(t.equals(value))
            {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exist(Iterator<T> iterator, T value)
    {
        while(iterator.hasNext())
        {
            if(iterator.next().equals(value))
            {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exist(T[] array, Predicate<T> pred)
    {
        for(T arrayValue : array)
        {
            if (arrayValue.equals(pred))
            {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exist(Iterable<T> iterable, Predicate<T> pred)
    {
        for(T t : iterable)
        {
            if(t.equals(pred))
            {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exist(Iterator<T> iterator, Predicate<T> pred)
    {
        while(iterator.hasNext())
        {
            if(iterator.next().equals(pred))
            {
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, T value)
    {
        return null;
    }

    public static <T> T find(Iterable<T> iterable, T value)
    {
        return null;
    }

    public static <T> T find(Iterator<T> iterator, T value)
    {
        return null;
    }

    public static <T> T find(T[] array, Predicate<T> pred)
    {
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred)
    {
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred)
    {
        return null;
    }

    public static<T extends Comparable<? super T>> T max(T first, T second)
    {
        if(first.compareTo(second) > 0) return first;
        return second;
    }

    public static<T extends Comparable<? super T>> T min(T first, T second)
    {
        if(first.compareTo(second) < 0) return first;
        return second;
    }
}