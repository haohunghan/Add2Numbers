
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMethod implements IReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		MainMethod mainMethod = new MainMethod();
		
		MyBigNumber mbn = new MyBigNumber(mainMethod);
		System.out.println(mbn.sum(sc.nextLine(), sc.nextLine() ) );
		
		
	}

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	

}
