package mybignumber;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyBigNumberTest implements IReceiver {
	
	public static final ArrayList<String> listCase = new ArrayList<>();
	public static int i =0;
	@Test
	void testSum_1() {
		listCase.add("Number + number: 1 + 2");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("1", "2");
		assertEquals("3", sum);
	}
	
	@Test
	void testSum_2() {
		listCase.add("Very big number: 99999999999999999999999999 + 8888888888888888888888888");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("99999999999999999999999999", "8888888888888888888888888");
		assertEquals("108888888888888888888888887", sum);
	}
	
	@Test
	void testSum_3() {
		listCase.add("Special sum: 99 + 99");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("99", "99");
		assertEquals("198", sum);
	}
	
	@Test
	void testSum_4() {
		listCase.add("Blank + zero");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("", "0");
		assertEquals("0", sum);
	}
	
	@Test
	void testSum_5() {
		listCase.add("Zero + blank");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("0", "");
		assertEquals("0", sum);
	}
	
		
	@Test
	void testSum_6() {
		listCase.add("Number + blank");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("99", "");
		assertEquals("99", sum);
	}
	
	@Test
	void testSum_7() {
		listCase.add("Blank + number");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("", "99");
		assertEquals("99", sum);
	}
	
	@Test
	void testSum_8() {
		listCase.add("Blank + blank");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("", "");
		assertEquals("0", sum);
	}

	@Test
	void testSum_9() {
		listCase.add("Zero + zero");
		MyBigNumber mbn = new MyBigNumber(this);
		String sum = mbn.sum("0", "0");
		assertEquals("0", sum);
	}

	@Test
	void testSum_10() {
		listCase.add("Positive number + negative number");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("45", "-99");
    	});
	}
	
	@Test
	void testSum_11() {
		listCase.add("Negative number + positive number");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-45", "99");
    	});
	}
	
	
	
	@Test
	void testSum_12() {
		listCase.add("Negative number + negative number");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-44549789745", "-465487974654699");
    	});
	}
	
	@Test
	void testSum_13() {
		listCase.add("Unlegal string + legal string");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("4s5", "99");
    	});
	}
	
	@Test
	void testSum_14() {
		listCase.add("Legal string + unlegal string");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("45", "9s9");
    	});
	}
	
	@Test
	void testSum_15() {
		listCase.add("Unlegal string + unlegal string");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("4s5", "9s9");
    	});
	}
	
	@Test
	void testSum_16() {
		listCase.add("Unlegal string + unlegal string");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("*&(&^", "DJ*(@!");
    	});
	}
	
	@Test
	void testSum_17() {
		listCase.add("Negative number and unlegal string + positive number");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("-486s8434", "1486513");
    	});
	}
	
	@Test
	void testSum_18() {
		listCase.add("Positive number + negative number and unlegal string");
		Assertions.assertThrows(NumberFormatException.class, () -> {
    		MyBigNumber mb = new MyBigNumber(this);
            mb.sum("487984134", "-7986454s");
    	});
	}
	
	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		System.out.print("Case " + i + ": " + listCase.get(i) + "\n" );
		System.out.println(message);
		i++;
		
	}
	
	

}
