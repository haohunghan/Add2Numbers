package com.tutorial.simpleservletform;

/**
 *
 * @author Hao Nguyen
 * A function that add 2 number
 */

import java.util.Scanner;

interface IReceiver{
	
}

public class MyBigNumber implements Require {                                                                        
    
    public  String sum(final String s1, final String s2){
	    
	//Check exception    
	try {
            
            // check string s1
            for (char c: s1.toCharArray()) {
                if (c - '0' < 0 || c - '0' > 9) {
                    throw new ParameterFormatException(s1);
                }
            }

            // Check string s2
            for (char c: s2.toCharArray()) {
                if (c - '0' < 0 || c - '0' > 9) {
                    throw new ParameterFormatException(s2);
                }
            }
        } catch (ParameterFormatException ex) {
            System.out.println(ex);
            return "ParameterFormatException";
        }    
	    
	//Check number > 0
	if (s1.contains("-")) {
            throw new NumberFormatException("So thu nhat phai la so nguyen duong");
        }

        if (s2.contains("-")) {
            throw new NumberFormatException("So thu nhi phai la so nguyen duong");
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

        return direction + "result: " + result;// Trả về kết quả thu được
    }
    
}
