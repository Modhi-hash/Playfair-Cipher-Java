/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playfairmaingui;

import java.util.*;

/**
 *
 * @author vip_1
 */
public class PlayfairPart1 {
    
     public static List<String> prepareText(String text) {
        text = text.toUpperCase().replaceAll("\\s+", "");
        text = text.replace('J', 'I');

        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            char b;

            if (i + 1 < text.length()) {
                b = text.charAt(i + 1);
                if (a == b) {
                    b = 'X';
                } else {
                    i++;
                }
            } else {
                b = 'X';
            }

            pairs.add("" + a + b);
        }

        return pairs;
    }

    public static char[][] generateMatrix(String key) {
        key = key.toUpperCase().replaceAll("\\s+", "");
        key = key.replace('J', 'I');

        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char c : key.toCharArray()) {
            set.add(c);
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J') {
                set.add(c);
            }
        }

        char[][] matrix = new char[5][5];
        Iterator<Character> it = set.iterator();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = it.next();
            }
        }

        return matrix;
    }
}



