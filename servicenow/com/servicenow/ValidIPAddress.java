package com.servicenow;

import java.util.ArrayList;
import java.util.List;

/* Time Complexity: O(n)
   Space Complexity: O(1)
*/
public class ValidIPAddress {

    public static void main(String[] args) {
        String ipString = "25011255255";
        System.out.println(validIpAddress(ipString).toString());
    }

    public static List<String> validIpAddress(String ipString) {
        List<String> ipAddressFound = new ArrayList<String>();

        // It must rotate from 1 to avoid NumberFormatException
        for (int i = 1; i < Math.min(ipString.length(), 4); i++) {
            String[] currentIpAddressParts = new String[] {"", "", "", ""};
            currentIpAddressParts[0] = ipString.substring(0, i);
            if (!isValidPart(currentIpAddressParts[0])) {
                continue;
            }

            // If part before is valid
            for (int j = i + 1; j < i + Math.min(ipString.length() - i, 4); j++) {
                currentIpAddressParts[1] = ipString.substring(i, j);
                if (!isValidPart(currentIpAddressParts[1])) {
                    continue;
                }

                // If parts before is valid
                for (int k = j + 1; k < j + Math.min(ipString.length() - j, 4); k++) {
                    currentIpAddressParts[2] = ipString.substring(j, k);
                    currentIpAddressParts[3] = ipString.substring(k);
                    if (isValidPart(currentIpAddressParts[2]) && isValidPart(currentIpAddressParts[3])){
                        ipAddressFound.add(joinAllParts(currentIpAddressParts));
                    }
                }
            }
        }

        return ipAddressFound;
    }

    public static boolean isValidPart(String ipString) {
        Integer stringAsInt = Integer.parseInt(ipString);
        if (stringAsInt > 255) {
            return false;
        }

        // Dealing with leading zeroes
        return ipString.length() == stringAsInt.toString().length();
    }

    public static String joinAllParts(String[] ipAddressParts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ipAddressParts.length; i++) {
             sb.append(ipAddressParts[i]);
             if (i < ipAddressParts.length - 1) {
                 sb.append(".");
             }
        }
        return sb.toString();
    }
}
