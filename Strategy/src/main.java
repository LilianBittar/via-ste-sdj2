public class main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        Robot robot = new Robot("robot",gameBoard);
        robot.setBehaviourStrategy(new AggressiveBehaviour());
        robot.move();
        robot.setBehaviourStrategy(new NeutralBehaviour());
        robot.move();
        robot.setBehaviourStrategy(new DefensiveBehaviour());
        robot.move();
    }
}
