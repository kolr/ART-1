package org.util;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class Combinations {
    public static String[] getAllLists(String[] elements, int lengthOfList) {
        //initialize our returned list with the number of elements calculated above
        String[] allLists = new String[MathNetwork.countCombination(lengthOfList, elements.length)];

        //lists of length 1 are just the original elements
        if (lengthOfList == 1) return elements;
        else {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            String[] allSublists = getAllLists(elements, lengthOfList - 1);

            //append the sublists to each element
            int arrayIndex = 0;

            for (int i = 0; i < elements.length; i++) {
                for (int j = i + 1; j < allSublists.length; j++) {
                    //add the newly appended combination to the list
                    allLists[arrayIndex] = elements[i] + allSublists[j];
                    arrayIndex++;
                }
            }
            return allLists;
        }
    }

    public static void main(String[] args) {
        String[] database = {"1", "2", "3", "4"};
        String[] result = getAllLists(database, 2);
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
    }
}
