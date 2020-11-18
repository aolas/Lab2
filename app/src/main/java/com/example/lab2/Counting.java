package com.example.lab2;

public class Counting{
     private static int countChar(String words){

        return words.length();
    }
    private static int countWords(String words){
        return words.split("\\s+|,\\s*|\\.\\s*").length;
    }

    public static String counting(String inputText,int position,String numberOfWords, String numberOfChars){
        int count;
        String message;

            if (position ==0 ){
                count = countWords(inputText);
                message = String.format(numberOfWords, count);
            }
            else{
                count = countChar(inputText);
                message = String.format(numberOfChars, count);
            }

        return message;
    }

}