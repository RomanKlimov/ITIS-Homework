package ProducerConsumer;

public class Product {
    private boolean status = false;

    public boolean isReady() {
        return status;
    }

    public boolean isUsed() {
        return !status;
    }

    public void produce() {
        System.out.println("Product is producing");
        this.status = true;
    }

    public void use() {
        System.out.println("Product is using");
        this.status = false;
    }
}
