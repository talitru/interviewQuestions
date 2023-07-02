package il.co.ilrd.InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;



/*
You have to design a generic data structure for RandomObject’s,
 the DS should have ‘Set' properties (e.g. no duplications

Required support for the following methods in O(1) runtime:
put – method accepts an Object and puts it in the DS.
delete – method receives object and removes it from the DS.
getRandom – returns random object with equal probability
(lets say we have numbers: 1,2,3 then each number has 1/3 chance of being picked ).
 */

public class RandomObjectDS <E>{
    private HashMap<E, Integer> map = new HashMap<>();
    private List<E> indexesArr = new ArrayList<>();
    private Random random = new Random();
    private int arrSize = 0;

    public void put(E object){
        if(!map.containsKey(object)){
            map.put(object,arrSize);
            indexesArr.add(arrSize, object);
            arrSize++;
        }
    }

    public void delete(E object){

        if(map.containsKey(object)){
            int objectIndex = map.get(object);
            E lastObjectInArr = indexesArr.get(arrSize-1);
            indexesArr.set(objectIndex, lastObjectInArr);
            map.replace(lastObjectInArr,arrSize-1, objectIndex);
            map.remove(object);
            arrSize--;
        }
    }

    public E randObject(){
        int randedIndex = random.nextInt(arrSize);
        return indexesArr.get(randedIndex);
    }

    public static void main(String[] args) {
        RandomObjectDS randClass = new RandomObjectDS();
        randClass.put(1);
        randClass.put(2);
        randClass.put(3);
        randClass.put(4);
        randClass.put(1.5);

        System.out.println("randed object1: "+randClass.randObject());
        randClass.delete(1);
        randClass.delete(3);

        System.out.println("randed object2: "+randClass.randObject());
        System.out.println("randed object3: "+randClass.randObject());
        System.out.println("randed object4: "+randClass.randObject());
        System.out.println("randed object5: "+randClass.randObject());
        System.out.println("randed object6: "+randClass.randObject());

    }

}
