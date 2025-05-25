package LabPrac._5Pass;

import java.util.Scanner;

public class passwordSecurity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        boolean hasUpper = false , hasLower = false , hadDigit = false ;
        int specialChar = 0 ;
        String masked_password = "";

        for (char ch : password.toCharArray()){
            if(Character.isUpperCase(ch)){
                hasUpper = true;
            }
            else if(Character.isLowerCase(ch)){
                hasLower = true;
            }
            else if(Character.isDigit(ch)){
                hadDigit = true;
            }
            else{
                specialChar++;
            }
        }

        System.out.println("#####Pasword Security#####\n\n\n");
        System.out.println("Your password is: "+password);
        System.out.println("Password contains Upper Letters: "+hasUpper);
        System.out.println("Password contains Lower Letters: "+hasLower);
        System.out.println("Password contains Digits: "+hadDigit);
        System.out.println("Number of Special chars in Password: "+specialChar);

        if(password.length()<=2){
            masked_password = password;
            System.out.println("Your password is: "+masked_password);
        }else {
            StringBuffer sb = new StringBuffer();
            sb.append(password.charAt(0));
            for (int i = 1 ; i<password.length();i++){
                sb.append("*");
            }
            sb.append(password.charAt(password.length()-1));
            masked_password = sb.toString();
            System.out.println("Your password is: "+masked_password);
        }
        StringBuffer sb1 = new StringBuffer(password);
        String reversedPassword = sb1.reverse().toString();
        System.out.println("Your reveresed password is: "+reversedPassword);

        int randN = (int) (Math.random() * 1001);
        String token = String.valueOf("@"+randN);
        String securePass = password+token;
        System.out.println("Your Secure password is: "+securePass);

        StringBuffer sb2 = new StringBuffer(password);
        for (int i = 0 ; i < sb2.length() ; i++){
            char ch = Character.toLowerCase(sb2.charAt(i));
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                sb2.setCharAt(i,'#');
            }
        }
        System.out.println("Password without vowels is: "+sb2.toString());

    }
}
