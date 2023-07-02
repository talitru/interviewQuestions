package il.co.ilrd.InterviewQuestions;

public class Quiz10 {
}

abstract class Base {
    public Base() {
        System.out.println("In Base");
        foo();
    }

    public void foo(){
        System.out.println("Need to implement by " + getName());
    }

    abstract public String getName();
}

class Derived extends Base {
    String ds1;
    int x;

    public Derived() {
        this.ds1 = "Derived";
        System.out.println("In Derived ");
    }

    public void foo() {
        System.out.println("In Override 'foo' " + ds1);
    }

    public String getName(){
        return this.ds1;
    }

    public static void main(String[] args) {
        Base ab = new Derived();
    }
}

class MyWaitNotify {
    String  myMonitorObject = "";
    boolean wasSignalled = false;

    public void doWait() {
        synchronized(myMonitorObject) {
            while(!wasSignalled) {
                try {
                    myMonitorObject.wait();
                } catch(InterruptedException e) {

                }
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized(myMonitorObject) {
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
    public static void main(String[] args) {
    }
}

class A implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class B implements Runnable {
    public void run() {
        new A().run();
        new Thread(new A(), "name_thread2").run();
        new Thread(new A(), "name_thread3").start();
    }
    public static void main(String[] args) {
        new Thread(new B(), "name_thread1").start();
    }
}
