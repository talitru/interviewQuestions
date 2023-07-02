package il.co.ilrd.InterviewQuestions;

import il.co.ilrd.hashMap.HashMap;

public class KeyManipulator {
    private String justData;
    private Integer key;
    private static HashMap<KeyManipulator, Integer> map = new HashMap<>();

    public KeyManipulator(String justData) {
        this.justData = justData;
    }
    //increment key by 1
    public void keyInc() {
        if(!map.containsKey(this)){
            key = 0;
            map.put(this, key);
        }
        ++key;
        map.put(this, key);
    }
    //returns key value
    public int getKeyValue() {
        if(!map.containsKey(this)){
            return 0;
        }
        return map.get(this);
    }
    //reset all key to 0
    public void resetAll() {
        map = new HashMap<>();
    }

    public void keyIncN(int n) {
        for(int i = 0;i<n;++i) {
            keyInc();
        }
    }
    public static void main(String[] args) {

        KeyManipulator l []= {new KeyManipulator("leave"),
                new KeyManipulator("before"),
                new KeyManipulator("you"),
                new KeyManipulator("die")};
        l[0].keyIncN(10);
        l[1].keyIncN(5);
        l[2].keyIncN(3);
        l[3].keyIncN(1);
        for(int i=0;i<l.length;++i) {
            System.out.print("l["+i+"] = "+l[i].getKeyValue() +", ");
        }
        l[0].resetAll();
        System.out.println();
        System.out.println(" after reset ");
        for(int i=0;i<l.length;++i) {
            System.out.print("l["+i+"] = "+l[i].getKeyValue() +", ");
        }

        System.out.println();
        l[0].keyIncN(10);
        l[1].keyIncN(5);
        l[2].keyIncN(3);
        l[3].keyIncN(1);

        for(int i=0;i<l.length;++i) {
            System.out.print("l["+i+"] = "+l[i].getKeyValue() +", ");
        }
    }

}

/* Output will be :
    l[0] = 10, l[1] = 5, l[2] = 3, l[3] = 1,
    after reset:
    l[0] = 0, l[1] = 0, l[2] = 0, l[3] = 0,

    Implement the class  KeyManipulator such that time complexity of functions:
     keyInc, getKeyValue, resetAll  should be O(1);

*/

