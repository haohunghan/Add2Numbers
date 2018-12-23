package mybignumber;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyBigNumberTest implements IReceiver {

	@Test
	void testSum_1() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("1", "2");
		assertEquals("3", sum);
	}
	
	@Test
	void testSum_2() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("99999999999999999999999999", "8888888888888888888888888");
		assertEquals("108888888888888888888888887", sum);
	}
	
	@Test
	void testSum_3() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("123", "9");
		assertEquals("132", sum);
	}
	
	@Test
	void testSum_4() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("", "0");
		assertEquals("0", sum);
	}
	
	@Test
	void testSum_5() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("0", "");
		assertEquals("0", sum);
	}
	
		
	@Test
	void testSum_6() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("99", "");
		assertEquals("99", sum);
	}
	
	@Test
	void testSum_7() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("", "99");
		assertEquals("99", sum);
	}
	
	@Test
	void testSum_8() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("", "");
		assertEquals("0", sum);
	}

	@Test
	void testSum_9() {	
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("0", "0");
		assertEquals("0", sum);
	}

	@Test
	void testSum_10() {	
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("45", "-99");
    	});
	}
	
	@Test
	void testSum_11() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-45", "99");
    	});
	}
	
	@Test
	void testSum_12() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-44549789745", "-465487974654699");
    	});
	}
	
	@Test
	void testSum_13() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("4s5", "99");
    	});
	}
	
	@Test
	void testSum_14() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("45", "9s9");
    	});
	}
	
	@Test
	void testSum_15() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("4s5", "9s9");
    	});
	}
	
	@Test
	void testSum_16() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("*&(&^", "DJ*(@!");
    	});
	}
	
	@Test
	void testSum_17() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-486s8434", "1486513");
    	});
	}
	
	@Test
	void testSum_18() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("487984134", "-7986454s");
    	});
	}
	
	@Test
	void testSum_19() {
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("99", "99");
		assertEquals("198", sum);
	}
	
	
	
	
	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		
	}
	
	

}
