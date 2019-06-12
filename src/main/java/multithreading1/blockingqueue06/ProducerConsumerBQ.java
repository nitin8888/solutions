package multithreading1.blockingqueue06;

import common.CommonUtil;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBQ {

    // Linked list of eleements
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        ProducerConsumerBQ producerConsumerBQ = new ProducerConsumerBQ();
        producerConsumerBQ.createThreads();
    }

    private void createThreads() {
        Thread producer = new Thread(() -> {
            produce();
        }, "ProducerThread");

        Thread consumer = new Thread(() -> {
           consume();
        });
        producer.start();
        consumer.start();

    }

    private void produce() {
        Random random = new Random();
        // add all elements as quickly as possible
        while (true) {
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() {
        // Thread to consume elements. It should have sleep to process it slowly
        while (true) {
            try {
                System.out.println("value: " + queue.take() + " ; size:" + queue.size());
                CommonUtil.sleepSeconds(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
