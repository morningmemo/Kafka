package TestDataGenerator;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class DataGeneratorSimulatorTest {

    @Test
    public void dataGeneratorSimulationTest() throws InterruptedException {

        ScheduledExecutorService execService = Executors.newScheduledThreadPool(100, Thread::new);

        ScheduledFuture<?> schedFuture = execService.scheduleAtFixedRate(
                new ScheduledTask(),
                1000,
                1,
                TimeUnit.MILLISECONDS
        );

        Thread.currentThread().join();
    }
}