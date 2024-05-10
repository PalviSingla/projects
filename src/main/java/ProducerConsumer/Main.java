package ProducerConsumer;

public class Main {
    public static void main(String[] args){

        PCData producer = new PCData(true);
        PCData consumer = new PCData(false);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();

    }
}

