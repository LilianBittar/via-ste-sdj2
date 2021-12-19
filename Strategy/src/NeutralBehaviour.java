


public class NeutralBehaviour implements Behavior{
    @Override
    public int moveCommand(GameBoard board, Point2D Point2D) {
        System.out.println("it is neutral");
        return -1;
    }
}
