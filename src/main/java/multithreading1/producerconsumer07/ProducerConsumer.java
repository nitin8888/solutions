package multithreading1.producerconsumer07;

import common.CommonUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {

    // List of elements
    // Max elements
    private static final int MAX_ELEMENTS = 10;
    private List<Integer> queue = new LinkedList<>();

    private final Object lock = new Object();

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.startThreads();
    }

    private void startThreads() {
        Thread producer = new Thread(this::produce);
        Thread consumer = new Thread(this::consume);
        producer.start();
        consumer.start();
    }

    private void produce() {
        Random random = new Random();
        while (true) {
            // add elements if max not reached & wait till elements reduced
            synchronized (lock) {
                while (queue.size()>= MAX_ELEMENTS) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(random.nextInt(100));
                lock.notify();
            }
        }

    }




    // producer to produce & wait until elements free


    // consumer to take elements & wait for 1 sec.
    // Notify when consumed

    private void consume() {
        while (true) {
            // remove element & wait
            synchronized (lock) {
                while (queue.size()<=0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("element:" + queue.remove(0) + " ; size:" + queue.size());
                lock.notify();
            }
            CommonUtil.sleepSeconds(1);
        }
    }
}
