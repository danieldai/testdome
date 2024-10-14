package com.danieldai.testdome.java;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> uniqNames = new HashSet<>();

        uniqNames.addAll(Arrays.asList(names1));
        uniqNames.addAll(Arrays.asList(names2));

        return uniqNames.toArray(new String[]{});
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}