package org.util;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class Combinations {
    public static String[] getAllLists(String[] elements, int lengthOfList) {
        String[] allLists = new String[MathNetwork.countCombination(lengthOfList, elements.length)];
        if (lengthOfList == 1) return elements;
        else {
            String[] allSublists = getAllLists(elements, lengthOfList - 1);
            int arrayIndex = 0;
            for (int i = 0; i < elements.length; i++) {
                for (int j = i + 1; j < allSublists.length; j++) {
                    allLists[arrayIndex] = elements[i] + allSublists[j];
                    arrayIndex++;
                }
            }
            return allLists;
        }
    }

    public static String[] generateStringArray(int q) {
        String[] result = new String[q];
        for (int i = 0; i < q; i++) {
            result[i] = String.valueOf(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] database = {"1", "2", "3", "4"};
        String[] result = getAllLists(database, 3);
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
    }
}
