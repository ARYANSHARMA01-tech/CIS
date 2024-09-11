package com.example.cryptoking;

import java.util.Base64;

public class decode {
    public static String dec(String encodedString, String encodingType) {
        String initializer = "11111111";

        // Ensure the string starts with the initializer
        if (!encodedString.startsWith(initializer)) {
            return "Invalid encoded string";
        }

        // Remove the initializer
        encodedString = encodedString.substring(initializer.length());

        switch (encodingType.toLowerCase()) {
            case "binary":
                return binaryDecoding(encodedString);
            case "hex":
                return hexDecoding(encodedString);
            case "base64":
                return base64Decoding(encodedString);
            default:
                return "Unsupported encoding type";
        }
    }

    private static String binaryDecoding(String binaryString) {
        StringBuilder decodedString = new StringBuilder();

        try {
            for (int i = 0; i < binaryString.length(); i += 7) {
                String binaryChar = binaryString.substring(i, i + 7);  // Each character is represented by 7 bits
                int asciiValue = Integer.parseInt(binaryChar, 2);  // Convert binary to decimal
                decodedString.append((char) asciiValue);  // Convert ASCII to character
            }
        } catch (Exception e) {
            return "Invalid binary encoding";
        }

        return decodedString.toString();
    }

    private static String hexDecoding(String hexString) {
        StringBuilder decodedString = new StringBuilder();

        try {
            for (int i = 0; i < hexString.length(); i += 2) {
                String hexChar = hexString.substring(i, i + 2);  // Each character is represented by 2 hex digits
                int asciiValue = Integer.parseInt(hexChar, 16);  // Convert hex to decimal
                decodedString.append((char) asciiValue);  // Convert ASCII to character
            }
        } catch (Exception e) {
            return "Invalid hex encoding";
        }

        return decodedString.toString();
    }

    private static String base64Decoding(String base64String) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            return new String(decodedBytes);  // Convert bytes to String
        } catch (Exception e) {
            return "Invalid Base64 encoding";
        }
    }
}
