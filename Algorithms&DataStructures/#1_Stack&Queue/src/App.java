
public class App {
    public static void main(String[] args){
        Stack stack = new Stack();
        Queue queue = new Queue();


        queue.add("HelloQUEUE");
        queue.add("HellQUEUE");

        stack.add("HelloSTACK");
        stack.add("HellSTACK");

        System.out.println(queue.size());

        System.out.println((String)(queue.pop()).toString());

        System.out.println(queue.size());

        System.out.println(stack.size());

        System.out.println((String)(stack.pop()).toString());

        System.out.println(stack.size());
    }
}
