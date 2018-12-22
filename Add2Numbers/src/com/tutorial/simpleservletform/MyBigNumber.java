

/**
 *
 * @author Hao Nguyen
 * A function that add 2 very big number
 */

package com.tutorial.simpleservletform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
	

public class MyBigNumber {
	

	private IReceiver ireceiver;
    
    //Ham de goi tung buoc
	public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }
     
    public String sum(final String s1, final String s2){
        
        Pattern p = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher m1 = p.matcher(s1);
        final Matcher m2 = p.matcher(s2);
       
        //Kiem tra so am
        if (s1.contains("-")) {
            this.ireceiver.sendMessage("First nubmer must be positive integer");
            throw new NumberFormatException("First nubmer must be positive integer");
        }
        if (s2.contains("-")) {
            this.ireceiver.sendMessage("Second number must be positive integer");
            throw new NumberFormatException("Second number must be positive integer");
        }
        
        // Kiểm tra kí tự đặc biệt hoặc chữ
        if (m1.find()) {
            this.ireceiver.sendMessage("Please does not contain any character in first number : " + s1);
            throw new NumberFormatException(m1.start() + 1 + "");   
        }
        
        if (m2.find()) {
            this.ireceiver.sendMessage("Please does not contain any character in second number : " + s2);
            throw new NumberFormatException(m2.start() + 1 + "");
        }
        
        
        // Buoc 1: lay do dai 2 chuo
        String result = "";
        int length1 = s1.length();// do dai chuoi thu 1
        int length2 = s2.length();// do dai chuoi thu 2
        
        // lay do dau lon nhat giua a va b
        int maxLength = (length1 > length2) ? length1 : length2;
        
        //Tạo biến nhớ mặc định = 0 
        //Khi kết quả + số ở vị trí i lớn hơn 9 thì sẽ là 1
        int temp = 0;
        
        int position1 = 0;// Vị trí chuỗi s1
        int position2 = 0;// Vị trí chuỗi s2
        
        //Ký tự tại vị trí đang xét
        char c1;
        char c2;
        
        //Biến tổng 2 ký tự
        int sum = 0;
        
        //chuỗi trả về các bước tính 
        String direction = "";
        
        // Lặp từ 0 đến max lần
        for (int i = 0; i < maxLength; i++) {
            
            // cập nhật lại vị trí chuỗi 
            position1 = length1 - i - 1;
            position2 = length2 - i - 1;
                
            direction += "Step " + (i + 1) + ":\n";
            
            // Xét vị trí của 2 chuỗi xem có >= 0 hay không
            // nếu >=0 thì lấy kí tự tại vị trí đang xét
            c1 = (position1 >=0) ? s1.charAt(position1) : '0';
            c2 = (position2 >=0) ? s2.charAt(position2) : '0';
            
            //Chuyển ký tự thành số
            sum = (c1 - '0') + (c2 - '0');
            
            //Vì khi chạy lần đầu, temp mặc định = 0
            //Nên sẽ không thêm "+ nhớ"
            if (i == 0){
                direction += c1 + " + " + c2 + " = " + sum + 
                        ". Write " + (sum%10) + " remember " + sum/10;
                       
            }
            else{
                direction += c1 + " + " + c2 + " = " + sum + " + " + temp + " = " + (sum + temp) +
                        ". Write " + (sum%10 + temp) + " remember " + sum/10;
                       
            }
            
            sum+= temp;
            result = (sum % 10) + result;
            temp = sum / 10;
            
            direction += ". current result: " + (result) + ".\n"; //(sum+=temp) + result = kq hien tai
           
    }

        if (temp >= 1) {
            result = 1 + result;// Nếu số nhớ còn dư thì ghép vào chuỗi kết quả
        }
        
        this.ireceiver.sendMessage(direction);
        
        return "Final result: " + result;// Trả về kết quả thu được
    }
	
}
