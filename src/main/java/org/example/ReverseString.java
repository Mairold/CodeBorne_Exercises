package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString stringUtils = new ReverseString();
        System.out.println("Sisesta oma stringid");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("Kas soovid s6nad tagurpidi keerata? True / False");
        boolean reverseWords = scanner.nextBoolean();
        System.out.println("Kas soovid t2hed tagurpidi keerata? True / False");
        boolean reverseLetters = scanner.nextBoolean();
        System.out.println(stringUtils.chgangeString(string, reverseWords, reverseLetters));

    }

    public String chgangeString(String sentence, boolean isReverseWords, boolean isReverseLetters) {
        List<String> words = Arrays.asList(sentence.split("\\s+"));
        if (isReverseWords) {
            Collections.reverse(words);
        }
        if (isReverseLetters) {
            words = words.stream().map(this::reverseLetters).toList();
        }
        return String.join(" ", words);
    }

    public String reverseLetters(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}