package LabPrac._4Palindrome;

import java.util.Scanner;

class InvalidInputException extends Exception{
    public InvalidInputException(String message){
        super(message);
    }
}
class ShortStringException extends Exception{
    public ShortStringException(String message){
        super(message);
    }

}
public class palindromeChecker {
    public  boolean isPalindrome(String str){
        String lowerInput = str.toLowerCase();
        String reversedInput = new StringBuffer(lowerInput).reverse().toString();
        return lowerInput.equals(reversedInput);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        palindromeChecker obj = new palindromeChecker();
        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        try{
            if(!str.matches("[a-zA-Z]+")){
                throw new InvalidInputException("Input contains non alpha char");
            }
            if(str.length()<3){
                throw new ShortStringException("Input string is too short");
            }
            if(obj.isPalindrome(str)){
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Not a palindrome");
            }
        }catch(InvalidInputException | ShortStringException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
