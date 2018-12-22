/**
 *
 * @author Hao Nguyen
 * A class to test the program
 */


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBigNumberTesting implements IReceiver {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	
	/**
     * Test of sum method, of class MyBigNumber.
     */
    @Test
    public void testSumCase1() {
    	MyBigNumber mb = new MyBigNumber(this);
        mb.sum("5", "4");
    }

    @Test
    public void testSumCase2() {
        MyBigNumber mbn = new MyBigNumber(this);
        mbn.sum("123", "9");
    }

    @Test
    public void testSumCase3() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("111111111111111111111111111111", "222222222222222222222222222222");
    }
    
    @Test()
    public void testSumCase4() {
    	Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("klrfa", "asdqa");
    	});
    }
    
    @Test()
    public void testSumCase5() {
    	Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-456", "481");
    	});
    }
    
    @Test()
    public void testSumCase6() {
    	Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("5s488a", "12347");
    	});
    }
    
    @Test()
    public void testSumCase7() {
    	Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("4478+", "-89468");
    	});
    }
    
    @Test()
    public void testSumCase10() {
    	Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-554d8a", "134897846544a");
    	});
    }
    
    @Test
    public void testSumCase11() {
        MyBigNumber mb = new MyBigNumber(this);
        mb.sum("999990", "999999");
    }
    
    @Test()
    public void testSumCase12() {
    	Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-48658965168498", "123486518798798");
    	});
    }
    
    @Test()
    public void testSumCase13() {
    	Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("89631479865189465", "s98a654986498646534");
    	});
    }


	@Override
	public void sendMessage(String message) {
		
	}
	

}
