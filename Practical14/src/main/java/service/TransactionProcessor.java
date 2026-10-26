package service;
import java.util.concurrent.*;
public class TransactionProcessor {private final ExecutorService pool=Executors.newFixedThreadPool(4);public void submit(Runnable task){pool.execute(task);}public void stop()throws InterruptedException{pool.shutdown();if(!pool.awaitTermination(10,TimeUnit.SECONDS))pool.shutdownNow();}}
