package com.example.cryptoking;

import java.util.Base64;

public class encode {
    public static String enc(String s, String encodingType) {
        String initializer = "11111111";  // The initializer remains the same for all encodings
        StringBuilder res = new StringBuilder();

        switch (encodingType.toLowerCase()) {
            case "binary":
                res.append(binaryEncoding(s));
                break;
            case "hex":
                res.append(hexEncoding(s));
                break;
            case "base64":
                res.append(base64Encoding(s));
                break;
            default:
                return "Unsupported encoding type";
        }

        // Prepend the initializer
        return initializer.concat(res.toString());
    }

    private static String binaryEncoding(String s) {
        StringBuilder binaryResult = new StringBuilder();

        for (char c : s.toCharArray()) {
            String binaryChar = String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0'); // 7-bit binary
            binaryResult.append(binaryChar);
        }
        return binaryResult.toString();
    }

    private static String hexEncoding(String s) {
        StringBuilder hexResult = new StringBuilder();

        for (char c : s.toCharArray()) {
            String hexChar = Integer.toHexString(c);  // Convert each character to hex
            hexResult.append(hexChar);
        }
        return hexResult.toString();
    }

    private static String base64Encoding(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes());  // Base64 encoding
    }
}
