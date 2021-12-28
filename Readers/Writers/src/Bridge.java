import java.util.ArrayDeque;
import java.util.Queue;
//Readers/Writers problem implemented with the fair solution
// for this particular exercise bridge class acts as our monitor class
public class Bridge implements Lane{
    private Queue<Thread> queue;
    private int redCarsOnBridge;
    private int blueCarsOnBridge;
    public Bridge(){
        queue = new ArrayDeque<>();
        redCarsOnBridge = 0;
        blueCarsOnBridge = 0;
    }
    //Method for the red cars to enter to the monitor
    @Override
    public synchronized void enterFromTheLeft() {
        //puts the current thread in the queue of the bridge
        queue.offer(Thread.currentThread());
        //check if the red car is the first in the queue
        while (queue.peek() != Thread.currentThread()) try {
            System.out.println(Thread.currentThread().getName() + " is now waiting in the queue.");
            wait();
        } catch (Exception e) {
            // Do nothing.
        }
        System.out.println(Thread.currentThread().getName() + " is now first in the queue.");
        //checks if there are any blue cars on the bridge and makes the red cars waits if it's true
        while (blueCarsOnBridge > 0) try {
            System.out.println(Thread.currentThread().getName() + " is waiting for all the blue cars left on bridge: " + blueCarsOnBridge);
            wait();
        } catch (Exception e) {
            // Do nothing.
        }
        //allows the red car to pass
        redCarsOnBridge++;
        queue.remove();
        System.out.println(Thread.currentThread().getName() + " is now passing the bridge.");
        //notifying all the waiting threads that a new red car is on the bridge
        notifyAll();
    }

    //method for the red cars to exit the bridge
    @Override
    public synchronized void exitToTheRight() {
        redCarsOnBridge--;
        System.out.println(Thread.currentThread().getName() + " has passed the bridge. Red cars on bridge: " + redCarsOnBridge);
        //if it's the last red car on the bridge that exit then we notify all and any blue cars that are waiting to pass
        if (redCarsOnBridge == 0) notifyAll();
    }

    //Method for the blue cars to enter to the monitor
    @Override
    public synchronized void enterFromTheRight() {
        //puts the current thread in the queue of the bridge
        queue.offer(Thread.currentThread());
        //check if the blue car is the first in the queue
        while (queue.peek() != Thread.currentThread()) try {
            System.out.println(Thread.currentThread().getName() + " is now waiting in the queue.");
            wait();
        } catch (Exception e) {
            // Do nothing.
        }
        System.out.println(Thread.currentThread().getName() + " is now first in the queue.");
        //checks if there are any red cars on the bridge and makes the blue cars waits if it's true
        while (redCarsOnBridge > 0) try {
            System.out.println(Thread.currentThread().getName() + " is waiting for all the red cars left on bridge: " + redCarsOnBridge);
            wait();
        } catch (Exception e) {
            // Do nothing.
        }
        //allows the blue car to pass
        blueCarsOnBridge++;
        queue.remove();
        System.out.println(Thread.currentThread().getName() + " is now passing the bridge.");
        //notifying all the waiting threads that a new blue car is on the bridge
        notifyAll();
    }

    @Override
    public synchronized void exitToTheLeft() {
        blueCarsOnBridge--;
        System.out.println(Thread.currentThread().getName() + " has passed the bridge. Blue cars on bridge: " + blueCarsOnBridge);
        //if it's the last blue car on the bridge that exit then we notify all and any red cars that are waiting to pass
        if (blueCarsOnBridge == 0) notifyAll();
    }
}
