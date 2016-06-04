package org;

import org.components.ComparativeLayer;
import org.components.Net;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int[] q = {0, 1, 1, 0, 0};
        Net net = new Net();
        net.start(q);
    }
}
