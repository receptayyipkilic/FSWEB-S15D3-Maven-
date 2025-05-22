package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static Map<String, Integer> calculatedWord(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();

        // Kelimeleri boşluklara göre ayırıyoruz
        String[] words = text.split(" ");

        for (String word : words) {
            word = word.toLowerCase();

            // Noktalama işaretlerini kaldırıyoruz ama Türkçe karakterler kalacak
            word = word.replaceAll("[^a-zçğıöşü0-9]", "");

            if (word.isEmpty()) continue;

            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        return wordCounts;
    }
}
