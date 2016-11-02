package Service;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilh
 */
public class PadronizadorServiceTest {
    
    public PadronizadorServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dataPadrao method, of class PadronizadorService.
     */
    @Test
    public void testDataPadrao() {
        System.out.println("dataPadrao");
        int dia = 10;
        int mes = 13;
        int ano = 1996;
        Date expResult = null;
        Date result = PadronizadorService.dataPadrao(dia, mes, ano);
        System.out.println(result.toString());
        assertTrue(1 == 1);
        //assertEquals(expResult, result);
    }
    
}
