package com.example.admin.w7d4testing;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CalculationTest {

    Calculation calculation;

    @Mock
    Addition addition;


    public static final int PARAM1 = 3;
    public static final int PARAM2 = 3;
    public static final int EXPECTED = 9;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); //INITIALIZE THE MOCK
        System.out.println("setUp Before");

        calculation = new Calculation(addition);

    }


    @Test
    public void add() {
        System.out.println("add");
    }

    @After
    public void tearDown() throws Exception {
        calculation = null;
        System.out.println("tearDown After");
    }

    @Before
    public void set() {
        System.out.println("Set Before");
    }

    @Test
    public void multiply() {

        System.out.println("multiply test");
        assertEquals(EXPECTED, calculation.multiply(PARAM1, PARAM2));
    }

    @After
    public void tearDown2() {
        System.out.println("tearDown2 After");
    }

    @Test
    public void addTen() {
//        mock addition method

        //whenever this method is called add return 5
        when(addition.add(PARAM1, PARAM2)).thenReturn(5);
//        Since we dont know what addition has we are mocking it
        assertEquals(15, calculation.addTen(PARAM1, PARAM2));
        System.out.println("addTEn");
    }

    @Test
    public void something() {
        calculation.something();
        verify(addition).something();
        System.out.println("something");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void divide() {
        System.out.println("divide by zero1");
        try {
            calculation.divide(PARAM1, 0);
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), containsString("/ by zero"));
        }
    }

    @Test
    public void divide_with_rule() {
        System.out.println("divide with rule by zero");
        exception.expect(ArithmeticException.class);
        exception.expectMessage(containsString("/ by zero"));
        calculation.divide(PARAM1, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void otherDivide() {
        System.out.println("other divide");
        calculation.divide(PARAM1, 0);
    }


    @Test
    public void getList() {
        List<String> expectedList = Arrays.asList("A", "B", "C");
        assertThat(calculation.getList(), is(expectedList));
        assertThat(calculation.getList(), hasItem("B"));


        System.out.println("getList");
    }
}