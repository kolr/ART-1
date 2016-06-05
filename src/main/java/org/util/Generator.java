package org.util;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class Generator {
    public static String generateString(int[] objects) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            result.append(objects[i]);
        }
        return new String(result);
    }
}
