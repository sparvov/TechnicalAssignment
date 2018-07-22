package com.company;

public class Main {

    final static int A1 = 1;
    final static int A2 = 10;
    final static int B1 = 2;
    final static int B2 = 20;
    final static int C1 = 3;
    final static int C2 = 30;

    private int a; // may change from a1 to a2
    private int b; // may change from b1 to b2
    private int c; // may change from c1 to c2

    public static void main(String[] args) {
    }

    public int hashCode1() {
        int hashCode = 0;

        for (int a = A1; a <= A2; a++) {
            for (int b = B1; b <= B2; b++) {
                for (int c = C1; c <= C2; c++) {
                    if (a == this.a && b == this.b && c == this.c) {
                        return hashCode;
                    }
                    hashCode++;
                }
            }
        }
        return hashCode;
    }

    public int hashCode2() {
        return (A2 - A1 + 1) * (B2 - B1 + 1) * (c - C1) + (A2 - A1 + 1) * (b - B1) + (a - A1 + 1);
    }

    public void setA(final int a) {
        this.a = a;
    }

    public void setB(final int b) {
        this.b = b;
    }

    public void setC(final int c) {
        this.c = c;
    }
}
