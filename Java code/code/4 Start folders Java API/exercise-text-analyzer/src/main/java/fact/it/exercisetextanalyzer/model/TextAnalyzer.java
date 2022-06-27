package fact.it.exercisetextanalyzer.model;

import java.lang.reflect.Array;

public class TextAnalyzer {
    private String text;

    public TextAnalyzer() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String pigLatin(){
        String[] words= text.split(" ");
        String result = "";
        result +=words[0].substring(1) + words[0].charAt(0) + "ay";
        for (int pos = 1;words.length>pos;pos++){
            result += " " + words[pos].substring(1) + words[pos].charAt(0) + "ay";
        }
        return result;
    }
    public int countLetters(){
        int amountLetters = 0;
        for(int pos = 0;text.length()>pos;pos++){
            char character = text.charAt(pos);
            if (Character.isLetter(character) == true){
                amountLetters++;
            }
        }
        return amountLetters;
    }
    public int countDigits(){
        int amountDigits = 0;
        for(int pos = 0;text.length()>pos;pos++){
            char character = text.charAt(pos);
            if (Character.isDigit(character) == true){
               amountDigits++;
            }
        }
        return amountDigits;
    }
}
