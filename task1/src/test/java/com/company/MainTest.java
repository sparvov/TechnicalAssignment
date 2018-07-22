package com.company;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void shouldCalculateHashCodeWithoutCollisionsWithMethod1() {
        int expectedQuantity = 0;

        Set<Integer> hashcodes1 = new HashSet<>();
        Set<Integer> hashcodes2 = new HashSet<>();

        Main main = new Main();

        for (int a = Main.A1; a <= Main.A2; a++) {
            for (int b = Main.B1; b <= Main.B2; b++) {
                for (int c = Main.C1; c <= Main.C2; c++) {
                    main.setA(a);
                    main.setB(b);
                    main.setC(c);

                    hashcodes1.add(main.hashCode1());
                    hashcodes2.add(main.hashCode2());

                    expectedQuantity++;
                    System.out.println(expectedQuantity);
                }
            }
        }

        Assert.assertEquals(expectedQuantity, hashcodes1.size());
        Assert.assertEquals(expectedQuantity, hashcodes2.size());
    }
}