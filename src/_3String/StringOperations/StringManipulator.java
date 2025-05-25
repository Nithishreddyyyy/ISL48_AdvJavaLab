package LabPrac._3String.StringOperations;

public interface StringManipulator {
    String revString(String str);
    String upperString(String str);
    String lowerString(String str);
    String concatString(String str1, String str2);
    int countVowels(String str);
    boolean isPali(String str);
    int countWords(String str);
}
