package com.danieldai.testdome.java;

// https://www.testdome.com/questions/java/game-platform/117604

public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        if (initialSpeed == 0) {
            return 0.0;
        }

        for (int inclination : inclinations) {
            if (inclination > 0 ) {
                initialSpeed -= inclination;
                if (initialSpeed <= 0.0) {
                    return 0;
                }
            }
            if (inclination < 0) {
                initialSpeed -= inclination;
            }
        }
        return initialSpeed;
    }

    public static void main(String[] args){
        System.out.println(calculateFinalSpeed(60.0, new int[] { 0, 30, 0, -45, 0 }));
    }
}
