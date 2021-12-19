

public class DefensiveBehaviour implements Behavior{
    @Override
    public int moveCommand(GameBoard board, Point2D Point2D) {
        System.out.println("it is defensive");
        return 0;
    }
}
