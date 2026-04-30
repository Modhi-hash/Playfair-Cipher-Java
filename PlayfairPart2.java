 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playfairmaingui;

/**
 *
 * @author vip_1
 */
public class PlayfairPart2 {
    

    // Find row and column of a character in the matrix
    public static int[] findPosition(char[][] matrix, char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) return new int[]{i, j};
            }
        } 
        return null;
    }
    // Encryption: Shift characters +1
    public static String encrypt(java.util.List<String> pairs, char[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (String pair : pairs) {
            result.append(processPair(pair.charAt(0), pair.charAt(1), matrix, 1));
        }
        return result.toString();
    }
     // Decryption: Shift characters +4
    public static String decrypt(String text, char[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            result.append(processPair(text.charAt(i), text.charAt(i + 1), matrix, 4));
        }
        return result.toString();
    }

   
    private static String processPair(char a, char b, char[][] matrix, int shift) {
        int[] p1 = findPosition(matrix, a);
        int[] p2 = findPosition(matrix, b);

        if (p1[0] == p2[0]) // Rule 1: Same row
        { 
            return "" + matrix[p1[0]][(p1[1] + shift) % 5] + matrix[p2[0]][(p2[1] + shift) % 5];
            
        } else if (p1[1] == p2[1]) // Rule 2: Same column
        { 
            return "" + matrix[(p1[0] + shift) % 5][p1[1]] + matrix[(p2[0] + shift) % 5][p2[1]];
            
        } else // Rule 3: Rectangle swap
        { 
            return "" + matrix[p1[0]][p2[1]] + matrix[p2[0]][p1[1]];
        }
    }
}

    

