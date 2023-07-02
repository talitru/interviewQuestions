package il.co.ilrd.InterviewQuestions;

import java.util.HashMap;
import java.util.function.Function;

public class SingletonFactory<K,D,T> {
    private HashMap<K, Function<D,T>> map = new HashMap<>();

    private SingletonFactory(){}

    private static  class Holder{
        private static  final SingletonFactory instance = new SingletonFactory();
    }
    public static <K,D,T>SingletonFactory <K,D,T> getInstance(){
        return Holder.instance;
    }
    public void add (K key, Function<D,T> recipe ){
        map.put(key, recipe);
    }
    public T create(K key, D data){
        return map.get(key).apply(data);
    }

}
