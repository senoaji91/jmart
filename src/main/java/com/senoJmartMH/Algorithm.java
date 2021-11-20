package com.senoJmartMH;

import java.util.*;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Algorithm
{

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


    public static <T> T find(T[] array, T value){
        Predicate<T> pNilai = nilai1 -> (nilai1 == value);
        for (T t : array) {
            if (pNilai.predicate(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, T value)
    {
        Predicate<T> pNilai = nilai1 -> (nilai1 == value);
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T element = iterator.next();
            if(pNilai.predicate(element))
            {
                return element;
            }
        }
        return null;
    }

    public static <T> T find(Iterator<T> iterator, T value)
    {
        Predicate<T> pNilai = nilai1 -> (nilai1 == value);
        while(iterator.hasNext())
        {
            T element = iterator.next();
            if(pNilai.predicate(element))
            {
                return element;
            }
        }
        return null;
    }

    public static <T> T find(T[] array, Predicate<T> pred)
    {
        for (T t : array) {
            if (pred.predicate(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred)
    {
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext())
        {
            T element = iterator.next();
            if(pred.predicate(element))
            {
                return element;
            }
        }
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred)
    {
        while(iterator.hasNext())
        {
            T element = iterator.next();
            if(pred.predicate(element))
            {
                return element;
            }
        }
        return null;
    }

    public static<T extends Comparable<? super T>> T max(T first, T second)
    {
        if(first.compareTo(second) > 0) return first;
        return second;
    }

    public static<T extends Comparable<? super T>> T max(T[] array)
    {
        List<T> list = Arrays.asList(array);
        return Collections.max(list);
    }

    public static<T extends Comparable<? super T>> T max(Iterable<T> iterable)
    {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.max(list);
    }

    public static<T extends Comparable<? super T>> T max(Iterator<T> iterator)
    {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.max(list);
    }

    public static<T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator)
    {
        List<T> list = new ArrayList<T>();
        list.add(first);
        list.add(second);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator)
    {
        List<T> list = Arrays.asList(array);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator)
    {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator)
    {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.max(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(T first, T second)
    {
        if(first.compareTo(second) < 0) return first;
        return second;
    }

    public static<T extends Comparable<? super T>> T min(T[] array)
    {
        List<T> list = Arrays.asList(array);
        return Collections.min(list);
    }

    public static<T extends Comparable<? super T>> T min(Iterable<T> iterable)
    {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.min(list);
    }

    public static<T extends Comparable<? super T>> T min(Iterator<T> iterator)
    {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.min(list);
    }

    public static<T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator)
    {
        List<T> list = new ArrayList<T>();
        list.add(first);
        list.add(second);
        return Collections.min(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator)
    {
        List<T> list = Arrays.asList(array);
        return Collections.min(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator)
    {
        List<T> list = new ArrayList<T>();
        iterable.forEach(list::add);
        return Collections.min(list, comparator);
    }

    public static<T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator)
    {
        List<T> list = new ArrayList<T>();
        iterator.forEachRemaining(list::add);
        return Collections.min(list, comparator);
    }

    public static<T> List<T> collect(T[] array, T value)
    {
        List<T> list = new ArrayList<T>();
        for (T t: array) {
            if(t.equals(value))
            {
                list.add(t);
            }
        }
        return list;
    }

    public static<T> List<T> collect(Iterable<T> iterable, T value)
    {
        List<T> list = new ArrayList<T>();
        for (T t: iterable)
        {
            if(t.equals(value))
            {
                list.add(t);
            }
        }
        return list;
    }

    public static<T> List<T> collect(Iterator<T> iterator, T value)
    {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext())
        {
            T t = iterator.next();
            if(t.equals(value))
            {
                list.add(t);
            }
        }
        return list;
    }

    public static<T> List<T> collect(T[] array, Predicate<T> pred)
    {
        List<T> list = new ArrayList<T>();
        for (T t: array)
        {
            if(pred.predicate(t))
            {
                list.add(t);
            }
        }
        return list;
    }

    public static<T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
        List<T> list = new ArrayList<T>();
        for (T t: iterable)
        {
            if(pred.predicate(t))
            {
                list.add(t);
            }
        }
        return list;
    }


    public static<T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
    {
        List<T> list = new ArrayList<T>();
        while(iterator.hasNext())
        {
            T t = iterator.next();
            if(pred.predicate(t))
            {
                list.add(t);
            }
        }
        return list;
    }

    public static<T extends Comparable<? super T>> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred)
    {
        List<T> list = Arrays.asList(array);
        if(page < 0) page = 0;
        if(pageSize < 0) pageSize = 0;
        return list.stream().filter(pred::predicate).skip((long) page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static<T extends Comparable<? super T>> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred)
    {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        if(page < 0) page = 0;
        if(pageSize < 0) pageSize = 0;
        return list.stream().filter(pred::predicate).skip((long) page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static<T extends Comparable<? super T>> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred)
    {
        List<T> list = new ArrayList<>();
        iterator.forEachRemaining(list::add);
        if(page < 0) page = 0;
        if(pageSize < 0) pageSize = 0;
        return list.stream().filter(pred::predicate).skip((long) page * pageSize).limit(pageSize).collect(Collectors.toList());
    }
}