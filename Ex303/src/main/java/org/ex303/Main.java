package org.ex303;

import org.ex303.shape.RegularPolygon;

public class Main {
    public static void main(String[] args) {
        RegularPolygon rp1 = new RegularPolygon();
        System.out.printf("rp1: %s, area: %.2f, offset: %.2f\n",
                rp1.toString(), rp1.getArea(), rp1.getOffset());

        RegularPolygon rp2 = new RegularPolygon(5,10.0,1.0,1.0);
        System.out.printf("rp2: %s, area: %.2f, offset: %.2f\n",
                rp2.toString(),rp2.getArea(), rp2.getOffset());
        RegularPolygon rp3 = new RegularPolygon(5,10.0,1.0,1.0);
        System.out.printf("rp3: %s, area: %.2f, offset: %.2f\n",
                rp3.toString(),rp3.getArea(), rp3.getOffset());
        System.out.println();
        System.out.println("rpl==rp2 的值: " + (rp1 == rp2));
        System.out.println("rp1.equals(rp2) 的值: "+ (rp1.equals(rp2)));
        System.out.println("rpl.hashCode() 的值: " + rp1.hashCode());
        System.out.println("rp2.hashCode() 的值: "+ rp2.hashCode());

        System.out.println();
        System.out.println("rp2==rp3 的值:" + (rp2 == rp3));
        System.out.println("rp2.equals(rp3) 的值:" + (rp2.equals(rp3)));
        System.out.println("rp2.hashCode() 的值: " + rp2.hashCode());
        System.out.println("rp3.hashCode() 的值:" + rp3.hashCode());
    }
}
