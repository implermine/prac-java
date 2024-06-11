package org.example._volatile_and_Atomic;

import org.junit.jupiter.api.Test;

public class VolatileAndAtomicTest {
    private boolean stopRequested = false;

    /**
     * <PRE>
     *     https://nesoy.github.io/articles/2018-06/Java-volatile
     *
     *     volatile이나 Atomic 없이, Shared Object를 Multi-Thread에서 사용할 시. 에 대한 예시
     *
     *     쓰기와 읽기 모두 CPU_Cache와 소통한다. 따라서 writerThread는 실 데이터에 영향을 미치지 않았다.
     *
     *     장점) Blocking이 아니다. (writer thread는
     *     단점) 제대로 된 행위를 보장할 수 없다.
     * </PRE>
     */
    @Test
    void test(){
        Thread writerThread = new Thread(() -> {
            // Simulate some work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.stopRequested = true; // Set the flag to stop the reader thread
        });

        Thread readerThread = new Thread(() -> {
            while (!this.stopRequested) {
                // Keep running as long as the flag is not set
                System.out.println("say something");
            }
            System.out.println("Reader thread stopped."); // Reader thread could not stop. it will always read value from CPU-cache
        });

        writerThread.start();
        readerThread.start();
    }
}
