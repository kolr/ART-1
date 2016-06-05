package org;

import org.components.ComparativeLayer;
import org.components.Net;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "art.xml");
        int[] q = {1, 1, 0, 0, 0};
        int[] q1 = {0, 0, 1, 1, 0};
        int[] q2 = {1, 0, 0, 0, 0};
        int[] q3 = {0, 0, 0, 1, 1};
        int[] q4 = {1, 1, 0, 0, 0};
        int[] q5 = {1, 1, 0, 0, 0};
        int[] q6 = {0, 0, 1, 1, 0};

        int[][] group = {{1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 0}};
//        Net net = new Net();
        Net net = (Net) applicationContext.getBean("net");
        net.start(q);
        net.start(q1);
        net.start(q2);
        net.start(q3);

        System.out.println("\n\n\n group \n\n");

        net.startGroup(group);
//        net.start(q4);
//        net.start(q5);
//        net.start(q6);
    }
}
