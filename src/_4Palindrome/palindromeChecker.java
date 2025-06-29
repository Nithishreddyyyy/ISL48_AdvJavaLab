package _4Palindrome;

import java.util.Scanner;

class InvalidInputException extends Exception{
    public InvalidInputException(String message){
        super(message);
    }
}
class LongStringException extends Exception{
    public LongStringException(String message){
        super(message);
    }

}
public class palindromeChecker {
    public  boolean isPalindrome(StringBuffer str){
        String original = str.toString();
        String reversed = str.reverse().toString();
        return original.equalsIgnoreCase(reversed);
    }
    public boolean alphaChecker(StringBuffer str){
        for (int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if (!Character.isLetter(ch) || !Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        palindromeChecker obj = new palindromeChecker();
        System.out.println("Enter a string: ");
        String str1 = sc.nextLine();
        StringBuffer str = new StringBuffer(str1);

        try{
            if(!obj.alphaChecker(str)){
                throw new InvalidInputException("String is not a valid palindrome");

            }
            if(str.length()>5){
                throw new LongStringException("Input string is too long");
            }
            if(obj.isPalindrome(str)){
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Not a palindrome");
            }
        }catch(InvalidInputException | LongStringException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
