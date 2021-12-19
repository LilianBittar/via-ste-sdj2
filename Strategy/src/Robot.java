
public class Robot  {
    private String name;
    private GameBoard board;
    private Behavior behavior;

    public Robot(String name, GameBoard board){
        this.name = name;
        this.board = board;
    }

    public Behavior getBehaviourStrategy(){
        return behavior;
    }

    public void setBehaviourStrategy(Behavior behaviourStrategy){
        behavior = behaviourStrategy;
    }

    public void move(){
       behavior.moveCommand(board, new Point2D(2,3));
    }

}
