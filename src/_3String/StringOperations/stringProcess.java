package LabPrac._3String.StringOperations;

import java.util.Objects;

public class stringProcess implements StringManipulator{
    public String revString(String str){
        char [] chars = str.toCharArray();
        int left=0,right = chars.length-1;
        while (left < right){
            char temp = chars[left];
            chars [left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        String res = new String(chars);
        return res;
    }
    public String upperString(String str){
        return str.toUpperCase();
    }
    public String lowerString(String str){
        return str.toLowerCase();
    }
    public String concatString(String str1, String str2) {
        return str1.concat(str2);
    }
    public int countVowels(String str){
        int count = 0;
        String Vowels = "aeiouAEIOU";
        for (char ch : str.toCharArray()){
            if(Vowels.indexOf(ch)!=-1){
                count++;
            }
        }
        return count;
    }
    public boolean isPali(String str){
        String rev = revString(str);
        return Objects.equals(rev, str);
    }
    public int countWords(String str){
        if(str.trim().isEmpty()){
            return 0;
        }
        return str.trim().split("\\s+").length;
    }
}
