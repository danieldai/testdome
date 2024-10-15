package com.danieldai.testdome.java;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }


    //The deposit and withdraw methods will not accept negativenumbers.
    @Test
    public void depositWillNotAcceptNegativeNumbers() {
        Account account = new Account(100);
        Assert.assertFalse(account.deposit(-10));
    }

    @Test
    public void withdrawWillNotAcceptNegativeNumbers() {
        Account account = new Account(100);
        Assert.assertFalse(account.withdraw(-10));
    }

    //Account cannot overstep its overdraft limit.

    @Test
    public void canNotOverstepOverdraftLimit() {
        Account account = new Account(100);
        Assert.assertFalse(account.withdraw(101));
    }

    //The deposit and withdraw methods will deposit or withdraw the correct amount, respectively.
    @Test
    public void depositRightAmount() {
        Account account = new Account(100);
        account.deposit(20);
        Assert.assertEquals(20, account.getBalance(), epsilon);
    }

    @Test
    public void withdrawRightAmount() {
        Account account = new Account(100);
        account.deposit(20);
        account.withdraw(10);
        Assert.assertEquals(10, account.getBalance(), epsilon);
    }

    //The withdraw and deposit methods return the correct results.
    @Test
    public void depositRightResult() {
        Account account = new Account(100);
        Assert.assertTrue(account.deposit(20));
    }

    @Test
    public void withdrawRightResult() {
        Account account = new Account(100);
        Assert.assertTrue(account.withdraw(20));
    }
}