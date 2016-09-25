package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by masha on 25.09.16.
 */
public class EquationTests {

    @Test
    public void test0(){
        Equation e1 = new Equation(16, 2, 2);
        Assert.assertEquals(e1.getN(), 0);
    }

    @Test
    public void test1(){
        Equation e2 = new Equation(1, 4, 4);
        Assert.assertEquals(e2.getN(), 1);
    }

    @Test
    public void test2(){
        Equation e3 = new Equation(4, 32, 2);
        Assert.assertEquals(e3.getN(), 2);
    }
}
