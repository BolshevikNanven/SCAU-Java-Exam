package org.ex303.shape;

import java.util.Objects;

public class RegularPolygon {
    private int numberOfSides;
    private double lengthOfSide ;
    private double x;
    private double y;

    public double getArea(){
        return (numberOfSides* lengthOfSide*lengthOfSide)/(4*Math.tan(Math.PI/numberOfSides));
    }

    public double getOffset(){
        return Math.sqrt(x*x+y*y);
    }

    @Override
    public String toString() {
        return "["+numberOfSides +","+String.format("%.2f",lengthOfSide)+"]@("+String.format("%.2f",x)+","+String.format("%.2f",y)+")";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof RegularPolygon))return false;
        RegularPolygon polygonObj=(RegularPolygon) obj;
        return x==polygonObj.getX()&&y== polygonObj.getY()&&lengthOfSide== polygonObj.getLengthOfSide()&&numberOfSides== polygonObj.getNumberOfSides();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfSides,lengthOfSide,x,y);
    }

    public RegularPolygon() {
        this.numberOfSides=3;
        this.lengthOfSide=1.0;
        this.x=0.0;
        this.y=0.0;
    }

    public RegularPolygon(int numberOfSides, double lengthOfSide, double x, double y) {
        this.numberOfSides = numberOfSides;
        this.lengthOfSide = lengthOfSide;
        this.x = x;
        this.y = y;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public double getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
