import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */


    @Test
    public void testFlik() {

        int i=0;
        int j=0;
        while(i<500){
            System.out.print(i);
            System.out.print(j);
            assertTrue(Flik.isSameNumber(i,j));
            i++;
            j++;
        }


    }
}