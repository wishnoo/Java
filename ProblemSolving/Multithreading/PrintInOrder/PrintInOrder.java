package ProblemSolving.Multithreading.PrintInOrder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// This program is based on the working of how LeetCode tests threads.
class Foo {

    public Foo() {
        
    }

    private final Lock accessLock = new ReentrantLock();
    private final Condition printConditionOne = accessLock.newCondition();
    private final Condition printConditionTwo = accessLock.newCondition();
    private final Condition printConditionThree = accessLock.newCondition();
    
    private String value = "none";
    
    public void first(Runnable printFirst) throws InterruptedException {
        accessLock.lock();
        try{
            while(value != "none"){
                printConditionOne.await();
            }
            
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            value = "first";
            printConditionTwo.signal();
        }
        finally{
            accessLock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        accessLock.lock();
        try{
            while(value != "first"){
                printConditionTwo.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            value = "second";
            printConditionThree.signal();
        }
        finally{
            accessLock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        accessLock.lock();
        try{
            while(value != "second"){
                printConditionThree.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            value = "third";
        }
        finally{
            accessLock.unlock();
        }
    }
}
