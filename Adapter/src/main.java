public class main {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue("cat");
        queue.enqueue("cup");
        queue.enqueue("book");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
