package org.thealphalab.education;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.locks.LockSupport;

public class NormalTest {

    @Test
    public void test() throws InterruptedException {
        Thread curThread = Thread.currentThread();
        Thread subThread = new MyThread(curThread);
        subThread.start();
        LockSupport.unpark(curThread);
        LockSupport.unpark(curThread);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println(i + "锁定");
            LockSupport.park();
        }
        System.out.println("运行结束");

    }

}
class MyThread extends Thread{
    Thread mainThread = null;
    public MyThread(Thread mainThread) {
        this.mainThread = mainThread;
    }
    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            LockSupport.unpark(mainThread);
            System.out.println(i + "解锁");
        }
    }
}