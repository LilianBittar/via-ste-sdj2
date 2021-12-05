import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClockTest {
    private Clock clock;
    @BeforeEach
    void setUp(){
        clock = new Clock(0,0,0);
    }
    private String valueOf(Clock clock){
        return clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
    }
    @Test
    void setZero(){
        clock.set(0,0,0);
        assertEquals("0:0:0",valueOf(clock));
    }

    @Test
    void setOne(){
        clock.set(0,0,1);
        assertEquals("0:0:1",valueOf(clock));
        clock.set(0,1,0);
        assertEquals("0:1:0",valueOf(clock));
        clock.set(1,0,0);
        assertEquals("1:0:0",valueOf(clock));
    }
    @Test
    void setMany() {
        clock.set(3, 2, 4);
        assertEquals("3:2:4", valueOf(clock));
        clock.set(12, 15, 20);
        assertEquals("12:15:20", valueOf(clock));
    }

    @Test
    void setBoundary(){
        assertThrows(IllegalArgumentException.class,() -> clock.set(0,0,-1));
        assertThrows(IllegalArgumentException.class,() -> clock.set(0,-1,0));
        assertThrows(IllegalArgumentException.class,() -> clock.set(-1,0,0));

        clock.set(0,0,59);
        assertEquals("0:0:59",valueOf(clock));
        clock.set(0,59,0);
        assertEquals("0:59:0",valueOf(clock));
        clock.set(23,0,0);
        assertEquals("23:0:0",valueOf(clock));

        assertThrows(IllegalArgumentException.class,() -> clock.set(0,0,60));
        assertThrows(IllegalArgumentException.class,() -> clock.set(0,60,0));
        assertThrows(IllegalArgumentException.class,() -> clock.set(60,0,0));
    }

    @Test
    void setException(){
        assertThrows(IllegalArgumentException.class,() -> clock.set(0,0,-5));
        assertThrows(IllegalArgumentException.class,() -> clock.set(0,-5,0));
        assertThrows(IllegalArgumentException.class,() -> clock.set(-5,0,0));
        assertThrows(IllegalArgumentException.class,() -> clock.set(0,0,78));
        assertThrows(IllegalArgumentException.class,() -> clock.set(0,78,0));
        assertThrows(IllegalArgumentException.class,() -> clock.set(78,0,0));
    }

}
