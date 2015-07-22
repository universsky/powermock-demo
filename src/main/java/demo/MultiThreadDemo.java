/**
 * 
 */
package demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenguangjian
 *
 */
public class MultiThreadDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        java.util.concurrent.locks.ReentrantLock reentrantLock = new ReentrantLock();
        /**
         * Acquires the lock.
         *
         * <p>
         * Acquires the lock if it is not held by another thread and returns
         * immediately, setting the lock hold count to one.
         *
         * <p>
         * If the current thread already holds the lock then the hold count is
         * incremented by one and the method returns immediately.
         *
         * <p>
         * If the lock is held by another thread then the current thread becomes
         * disabled for thread scheduling purposes and lies dormant until the
         * lock has been acquired, at which time the lock hold count is set to
         * one.
         */
        reentrantLock.lock();
        {
            /**
             * 位于这两个方法之间的代码在被执行时，效果等同于被放在synchronized同步块中。一般用法是将需要在lock()和unlock
             * ()方法之间执行的代码放在try{}块中，并且在finally{}块中调用unlock()方法，
             * 这样就可以保证即使在执行代码抛出异常的情况下，对象的锁也总是会被释放，否则的话就会为死锁的产生增加可能。
             * 和synchronized关键字不同，lock只把当前方法锁定，其他的方法(不论是同步还是非同步的)并没有被锁定。
             */

        }
        /**
         * Attempts to release this lock.
         *
         * <p>
         * If the current thread is the holder of this lock then the hold count
         * is decremented. If the hold count is now zero then the lock is
         * released. If the current thread is not the holder of this lock then
         * {@link IllegalMonitorStateException} is thrown.
         *
         * @throws IllegalMonitorStateException
         *             if the current thread does not hold this lock
         */
        reentrantLock.unlock();

        /**
         * Causes the currently executing thread to sleep (temporarily cease
         * execution) for the specified number of milliseconds, subject to the
         * precision and accuracy of system timers and schedulers. The thread
         * does not lose ownership of any monitors.
         *
         * @param millis
         *            the length of time to sleep in milliseconds
         *
         * @throws IllegalArgumentException
         *             if the value of {@code millis} is negative
         *
         * @throws InterruptedException
         *             if any thread has interrupted the current thread. The
         *             <i>interrupted status</i> of the current thread is
         *             cleared when this exception is thrown.
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
