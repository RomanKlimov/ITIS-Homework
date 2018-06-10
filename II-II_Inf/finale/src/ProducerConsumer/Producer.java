package ProducerConsumer;

public class Producer extends Thread {

    private Product product;
    public Producer(Product p) {
        this.product = p;
    }

    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isUsed()) {
                    try {
                        //wait временно снимает блокировку
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                product.produce();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.notify();

            }
        }
    }

}
