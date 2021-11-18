public class main {
    public static void main(String[] args) {
        SeaBear seaBear = new SeaBear();
        SeaBearGuard seaBearGuard = new SeaBearGuard(seaBear);
        ZooVisitor zooVisitor = new ZooVisitor(seaBearGuard,"zooKeeper");
        ZooVisitor zooVisitor1 = new ZooVisitor(seaBearGuard,"child");
        ZooVisitor zooVisitor2 = new ZooVisitor(seaBearGuard,"adult");

        zooVisitor.view();
        zooVisitor1.view();
        zooVisitor2.view();

        zooVisitor.pet();
        zooVisitor1.pet();
        zooVisitor2.pet();

        zooVisitor.feed();
        zooVisitor1.feed();
        zooVisitor2.feed();
    }
}