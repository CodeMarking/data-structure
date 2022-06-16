package concurrentProgrammer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author make
 * @desc  ²¢·¢±à³Ì
 */
public class Concurrent {
    public static void main(String[] args) {
        ReentrantLock reentrantLock =   new ReentrantLock();
        reentrantLock.tryLock();
    }

}
