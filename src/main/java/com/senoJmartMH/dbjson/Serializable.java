package com.senoJmartMH.dbjson;

import java.util.HashMap;

public class Serializable implements Comparable <Serializable>
{
    public final int id;
    protected Serializable(int id)
    {
        this.id = id;
    }

    @Override
    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }

    public boolean equals(Object object)
    {
        if (object instanceof Serializable){
            Serializable serializable = (Serializable) object;
            if(serializable.id == this.id){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean equals(Serializable serializable)
    {
        if(serializable.id == this.id){
            return true;
        }else{
            return false;
        }
    }

    public static <T extends Serializable> int getClosingId(Class<T> clazz)
    {
        return mapCounter.get(clazz);
    }

    public static <T extends Serializable> int setClosingId(Class<T> clazz, int id)
    {
        return mapCounter.getOrDefault(clazz, id);
    }

    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    protected Serializable()
    {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }



}