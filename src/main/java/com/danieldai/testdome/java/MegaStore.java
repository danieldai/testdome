package com.danieldai.testdome.java;

public class MegaStore {

    public enum DiscountType {
        Standard,
        Seasonal,
        Weight;
    }

    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
        switch (discountType) {
            case Standard:
                return totalPrice * (1 - 0.06);
            case Seasonal:
                return totalPrice * (1 - 0.12);
            case Weight:
                if (cartWeight <= 10) {
                    return totalPrice * (1 - 0.06);
                } else {
                    return totalPrice * (1 - 0.18);
                }
            default:
                System.out.println("Unknown discount");
                return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}