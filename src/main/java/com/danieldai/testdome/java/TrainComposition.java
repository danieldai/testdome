package com.danieldai.testdome.java;

import java.util.Deque;
import java.util.LinkedList;

public class TrainComposition {
    private Deque<Integer> deque = new LinkedList();

    public void attachWagonFromLeft(int wagonId) {
        deque.offerFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        deque.offerLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return deque.pollFirst();
    }

    public int detachWagonFromRight() {
        return deque.pollLast();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}