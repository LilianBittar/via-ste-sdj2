

public class AggressiveBehaviour implements Behavior{
    @Override
    public int moveCommand(GameBoard board, Point2D Point2D) {
      System.out.println("it is aggressive");
      return 1;
    }
}
