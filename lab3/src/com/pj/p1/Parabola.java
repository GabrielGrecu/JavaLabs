package com.pj.p1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Parabola {
    private int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] calculareVarf() {
        double xVarf = -((double)b) / (2 * a);
        double yVarf = ((-Math.pow(b, 2) + 4 * a * c) / (4 * a));
        return new double[] {xVarf, yVarf};
    }

    @Override
    public String toString() {
        return String.format("f(x) = %dx^2 + %dx + %d", a, b, c);
    }

    public static double[] calculareMijlocSegment(Parabola p1, Parabola p2) {
        double[] varf1 = p1.calculareVarf();
        double[] varf2 = p2.calculareVarf();
        double xMijloc = (varf1[0] + varf2[0]) / 2;
        double yMijloc = (varf1[1] + varf2[1]) / 2;
        return new double[] {xMijloc, yMijloc};
    }

    public static double calculareLungimeSegment(Parabola p1, Parabola p2) {
        double[] varf1 = p1.calculareVarf();
        double[] varf2 = p2.calculareVarf();
        return Math.hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }

    public static void main(String[] args) {
        List<Parabola> parabole = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String[] coeficienti = scanner.nextLine().split(" ");
                int a = Integer.parseInt(coeficienti[0]);
                int b = Integer.parseInt(coeficienti[1]);
                int c = Integer.parseInt(coeficienti[2]);
                Parabola p = new Parabola(a, b, c);
                parabole.add(p);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Parabola p : parabole) {
            System.out.println(p.toString());
            double[] varf = p.calculareVarf();
            System.out.println("Varful: (" + varf[0] + ", " + varf[1] + ")");
        }

        for (int i = 0; i < parabole.size() - 1; i++) {
            Parabola p1 = parabole.get(i);
            Parabola p2 = parabole.get(i + 1);
            double[] mijlocSegment = Parabola.calculareMijlocSegment(p1, p2);
            double lungimeSegment = Parabola.calculareLungimeSegment(p1, p2);
            System.out.println("Mijlocul segmentului intre parabolele " + (i + 1) + " și " + (i + 2) + ": (" + mijlocSegment[0] + ", " + mijlocSegment[1] + ")");
            System.out.println("Lungimea segmentului intre parabolele " + (i + 1) + " și " + (i + 2) + ": " + lungimeSegment);
        }
    }
}
