/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utils;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class NumberSystems {   
    public static String decToBaseN(long dec, int base)
    {
        String strEquiv = "";
        long rem;
        
        int mask = 10 * ((base > 10)?base / 10:1);
        
        if(dec == 0){
            return "" + 0;
        }
        
        for(;dec != 0; dec /= base)
        {
            rem = dec % base;            
            
            if(rem > 9){
                rem -= 10;
                strEquiv = (char)((rem % mask) + 'A') + strEquiv;
            }else{
                strEquiv = rem + strEquiv;
            }
        }
        
        return strEquiv;
    }
    
    public static long baseNToDec(String num, int base)
    {
        num = num.toUpperCase();
        long equiv = 0L;      
        
        Matcher matcher1 = (Pattern.compile("[^0-9A-Za-z]")).matcher(num);
        Matcher matcher2 = (Pattern.compile("[a-zA-Z]")).matcher(num);
        
        boolean isInvalidNum = matcher1.matches();
        boolean hasAlphaChars = matcher2.matches();
        
        if((base < 11 && hasAlphaChars) || (base > 10 && isInvalidNum)){
            System.out.println("hasAplpha: " + hasAlphaChars);
            System.out.println("isInvalid: " + isInvalidNum + ": " + matcher1.group());
            throw new NumberFormatException();
        }
        
        Scanner get = new Scanner(num);
        
        for(int i = 0; i < num.length(); i++)
        {
            int place = num.length() - i - 1;
            char temp = num.charAt(i);
            boolean isNumeric = Pattern.matches("[0-9]", "" + temp);
            
            long placeValue = (long)(Math.pow(base, place));
            long value;
            
            if(isNumeric){
                value = Long.parseLong("" + temp);
            }else{
                value = 10 + (temp % 'A');
            }
            
            if(value > base - 1){
                throw new NumberFormatException();
            }
            
            equiv += value * placeValue;
        }
        
        return equiv;
    }
}
