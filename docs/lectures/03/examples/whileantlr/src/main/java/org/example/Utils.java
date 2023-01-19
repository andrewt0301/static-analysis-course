package org.example;

public class Utils {
    public static String encodeHtml(final String str) {
        final StringBuilder result = new StringBuilder();
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            final char charVal = str.charAt(i);
            switch (charVal) {
                case '<':
                    result.append("&lt;");
                    break;
                case '>':
                    result.append("&gt;");
                    break;
                case '\'':
                    result.append("&apos;");
                    break;
                case '\"':
                    result.append("&quot;");
                    break;
                case '&':
                    result.append("&amp;");
                    break;
                default:
                    result.append(charVal);
                    break;
            }
        }
        return result.toString();
    }
}
