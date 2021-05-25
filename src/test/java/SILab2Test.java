import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Time> createList(Time... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    private List<Integer> rez(Integer... elem){
        return new ArrayList<>(Arrays.asList(elem));
    }
    @Test
    void everyBranch(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-1,34,70))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(28,17,32))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12,90,11))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        assertEquals(rez(73812), SILab2.function(createList(new Time(20,30,12))));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(17,17,68))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        assertEquals(rez(86400), SILab2.function(createList(new Time(24,0,0))));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24,50,43))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

    }
    @Test
    void multipleChoice(){
        //if (hr < 0 || hr > 24)
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(26,7,0))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(-4,7,0))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(21,-2,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        //if (min < 0 || min > 59)

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(18,80,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(21,-2,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(21,30,-3))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        // if (sec >= 0 && sec <= 59)
        assertEquals(rez(73812), SILab2.function(createList(new Time(20,30,12))));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(19,30,-1))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(21,31,67))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //if (hr == 24 && min == 0 && sec == 0)
        assertEquals(rez(86400), SILab2.function(createList(new Time(24,0,0))));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(24,12,0))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(24,12,10))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(12,60,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

    }
}