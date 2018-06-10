package ProducerConsumer;

public class Consumer extends Thread {

    private Product product;
    public Consumer (Product p) {
        this.product = p;
    }

    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isReady()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                product.use();
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
