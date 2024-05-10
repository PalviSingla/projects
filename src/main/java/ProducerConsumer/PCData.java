package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;


public class PCData implements Runnable{
    private static final List<Integer> list = new ArrayList<>();
    private final boolean isProducer;

    public PCData(boolean isProducer){
        this.isProducer = isProducer;
    }

    @Override
    public void run() {
        try {
            if (isProducer) {
                produce();
            } else {
                consume();
            }
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    private void consume() throws InterruptedException {
        while (true) {
            synchronized (list) {
                while (list.isEmpty()) {
                    list.wait();
                }
                Integer data = list.remove(0);
                System.out.println("Consumer thread " + data);
                list.notifyAll();
            }
        }
    }


    private void produce() throws InterruptedException {
        for(int i=0;i<10;i++){
            synchronized (list) {
                int list_size = 5;
                while (list.size() == list_size) {
                    list.wait();
                }
                list.add(i);
                System.out.println("Producer thread " + i);
                list.notifyAll();
            }
        }
    }

}



