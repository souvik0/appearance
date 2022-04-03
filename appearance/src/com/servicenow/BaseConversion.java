package com.servicenow;

import java.util.*;

public class BaseConversion {

    public static void main(String[] args) {
        BaseConversion n1 = new BaseConversion(16, "10AF");
        System.out.println("Decimal : " + n1.toDecimal());
        System.out.println("Octal : " + n1.toTargetBase(8));
        System.out.println("Binary : " + n1.toTargetBase(2));
    }

    private int base; // 2, 8, 10, 16
    private String value; // can be of any base
    private Map<Character, Integer> hextoDecimal; // for hexadecimal to decimal conversion
    private Map<Integer, Character> decimaltoHex; // for decimal to hexadecimal

    public BaseConversion(String value) {
        this.value = value;
        this.base = 10;
        hextoDecimal = new HashMap<>();
        decimaltoHex = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            decimaltoHex.put(10 + i, (char)('A' + i));
            hextoDecimal.put((char)('A' + i), 10 + i);
        }
    }

    public BaseConversion(int base, String value) {
        this.value = value;
        this.base = base;
        hextoDecimal = new HashMap<>();
        decimaltoHex = new HashMap<>();

        for (int i = 0; i < 6; i++) {
             decimaltoHex.put(10 + i, (char)('A' + i));
             hextoDecimal.put((char)('A' + i), 10 + i);
        }
    }

    public String toDecimal() {
        int sum = 0;
        int power = 0;
        String tempVal = this.value;

        for (int i = tempVal.length() - 1; i >= 0; i--) {
            int val = tempVal.charAt(i) - '0';
            if (this.base == 16 && hextoDecimal.containsKey(tempVal.charAt(i))) {
                val = hextoDecimal.get(tempVal.charAt(i));
            }
            sum += (val) * (Math.pow(this.base, power++));
        }

        return String.valueOf(sum);
    }

    public String toTargetBase(int targetBase) {
        // take the given number convert it into decimal divide the decimal with the target base
        String val = this.value;

        // Current base number must be converted to decimal as intermediate base
        if (this.base != 10) {
            val = toDecimal();
        }

        int temp = Integer.parseInt(val);
        StringBuilder sb = new StringBuilder();

        // Here converting from decimal to any base
        while (temp != 0) {
            int tempValue = temp % targetBase;
            if (targetBase == 16 && decimaltoHex.containsKey(tempValue)) {
                sb.insert(0, decimaltoHex.get(tempValue));
            } else {
                sb.insert(0, tempValue);
            }
            temp = temp / targetBase;
        }

        return sb.toString();
    }
}
