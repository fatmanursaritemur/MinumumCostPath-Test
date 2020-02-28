package fatmanur.mincostpath;

import javafx.scene.control.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MinCostPathTest {
    public int[][] field;
    @BeforeEach
    void init() {
        Random rand=new Random();
    field = new int[][]{{3, rand.nextInt(10), rand.nextInt(10)}
            , {rand.nextInt(10), rand.nextInt(10), rand.nextInt(10)}};
    }

    @Test
    @DisplayName("throws Illegal Argument Exception When The Start or End Point Cells Out of Matrix")
    void throwsIllegalArgumentExceptionWhenTheCellsOutofMatrix() {
        MinCostPath minCostPath = new MinCostPath();
        assertAll("Start points must be in matrix",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> minCostPath.find(field, new Point(2, 1), new Point(0, 2)))
                , () -> assertThrows(IllegalArgumentException.class,
                        () -> minCostPath.find(field, new Point(-1, 1), new Point(0, 2))),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> minCostPath.find(field, new Point(0, 2), new Point(0, 5))));
    }

    @Test()
    @DisplayName(("If end point equals to start point, minumum cost "))
   public void returnStartPointIfStartPointEqualsToEndPoint()
    {
        MinCostPath minCostPath = new MinCostPath();
    assertEquals(3,minCostPath.find(field, new Point(0, 0), new Point(0, 0)));
    }
    
    @org.junit.Test(timeout = 100)
  public  void findmincostpathfortwodimensionalfield()
    {
        MinCostPath minCostPath = new MinCostPath();
     final int[][] matrix={{1,2,3,4},{1,3,1,2},{1,2,4,5}};
        assertEquals(4,minCostPath.find(matrix, new Point(0, 0), new Point(1, 2)));
        assertEquals(4,minCostPath.find(matrix, new Point(0, 0), new Point(2, 1)));
        assertEquals(9,minCostPath.find(matrix, new Point(0, 0), new Point(2, 3)));
    }
}