package com.ubs.opsit.interviews;

/**
 * Created with IntelliJ IDEA.
 * User: Андрей
 * Date: 27.10.15
 * Time: 4:12
 * To change this template use File | Settings | File Templates.
 */

import org.junit.*;
import static org.junit.Assert.*;


public class UnitTests {

    @Test
    public void assertYellowLamp() {
    MyTimeConverter TestTimeConverter = new MyTimeConverter();
    String ExpectedResultO = "O";
    String ExpectedResultY = "Y";
    Assert.assertTrue(" 01 sec Case. There is should be O, but was "+ TestTimeConverter.getYellowLampflag(1),ExpectedResultO.equals(TestTimeConverter.getYellowLampflag(1)));
    Assert.assertTrue(" 33 sec Case. There is should be O, but was "+ TestTimeConverter.getYellowLampflag(33),ExpectedResultO.equals(TestTimeConverter.getYellowLampflag(33)));
    Assert.assertTrue(" 59 sec Case. There is should be O, but was "+ TestTimeConverter.getYellowLampflag(59),ExpectedResultO.equals(TestTimeConverter.getYellowLampflag(59)));
    Assert.assertTrue(" 00 sec Case. There is should be Y, but was "+ TestTimeConverter.getYellowLampflag(0),ExpectedResultY.equals(TestTimeConverter.getYellowLampflag(0)));
    }

    @Test
    public void assertTopRowHrsMethod() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        String ExpectedResult00 = "OOOO";
        String ExpectedResult13 = "RROO";
        String ExpectedResult23 = "RRRR";
        String ExpectedResult24 = "RRRR";
        Assert.assertTrue(" 00 Hrs Case. There is should be "+ ExpectedResult00 + ", but was "+ TestTimeConverter.getTopRowOfHrs(0),ExpectedResult00.equals(TestTimeConverter.getTopRowOfHrs(0)));
        Assert.assertTrue(" 13 Hrs Case. There is should be "+ ExpectedResult13 + ", but was "+ TestTimeConverter.getTopRowOfHrs(13),ExpectedResult13.equals(TestTimeConverter.getTopRowOfHrs(13)));
        Assert.assertTrue(" 23 Hrs Case. There is should be "+ ExpectedResult23 + ", but was "+ TestTimeConverter.getTopRowOfHrs(23),ExpectedResult23.equals(TestTimeConverter.getTopRowOfHrs(23)));
        Assert.assertTrue(" 24 Hrs Case. There is should be "+ ExpectedResult23 + ", but was "+ TestTimeConverter.getTopRowOfHrs(24),ExpectedResult24.equals(TestTimeConverter.getTopRowOfHrs(24)));
    }

    @Test
    public void assertLowerRowHrsMethod() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        String ExpectedResult00 = "OOOO";
        String ExpectedResult13 = "RRRO";
        String ExpectedResult23 = "RRRO";
        String ExpectedResult24 = "RRRR";
        Assert.assertTrue(" 00 Hrs Case. There is should be "+ ExpectedResult00 + ", but was "+ TestTimeConverter.getLowerRowOfHrs(0),ExpectedResult00.equals(TestTimeConverter.getLowerRowOfHrs(0)));
        Assert.assertTrue(" 13 Hrs Case. There is should be "+ ExpectedResult13 + ", but was "+ TestTimeConverter.getLowerRowOfHrs(13),ExpectedResult13.equals(TestTimeConverter.getLowerRowOfHrs(13)));
        Assert.assertTrue(" 23 Hrs Case. There is should be "+ ExpectedResult23 + ", but was "+ TestTimeConverter.getLowerRowOfHrs(23),ExpectedResult23.equals(TestTimeConverter.getLowerRowOfHrs(23)));
        Assert.assertTrue(" 24 Hrs Case. There is should be "+ ExpectedResult23 + ", but was "+ TestTimeConverter.getLowerRowOfHrs(24),ExpectedResult24.equals(TestTimeConverter.getLowerRowOfHrs(24)));
    }

    @Test
    public void assertTopRowMtsMethod() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        String ExpectedResult00 = "OOOOOOOOOOO";
        String ExpectedResult17 = "YYROOOOOOOO";
        String ExpectedResult59 = "YYRYYRYYRYY";

        Assert.assertTrue(" 00 Mts Case. There is should be "+ ExpectedResult00 + ", but was "+ TestTimeConverter.getTopRowOfMinutes(0),ExpectedResult00.equals(TestTimeConverter.getTopRowOfMinutes(0)));
        Assert.assertTrue(" 17 Mts Case. There is should be "+ ExpectedResult17 + ", but was "+ TestTimeConverter.getTopRowOfMinutes(17),ExpectedResult17.equals(TestTimeConverter.getTopRowOfMinutes(17)));
        Assert.assertTrue(" 59 Mts Case. There is should be "+ ExpectedResult59 + ", but was "+ TestTimeConverter.getTopRowOfMinutes(59),ExpectedResult59.equals(TestTimeConverter.getTopRowOfMinutes(59)));
        }

    @Test
    public void assertLowerRowMtsMethod() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        String ExpectedResult00 = "OOOO";
        String ExpectedResult17 = "YYOO";
        String ExpectedResult59 = "YYYY";

        Assert.assertTrue(" 00 Mts Case. There is should be "+ ExpectedResult00 + ", but was "+ TestTimeConverter.getLowerRowOfMinutes(0),ExpectedResult00.equals(TestTimeConverter.getLowerRowOfMinutes(0)));
        Assert.assertTrue(" 17 Mts Case. There is should be "+ ExpectedResult17 + ", but was "+ TestTimeConverter.getLowerRowOfMinutes(17),ExpectedResult17.equals(TestTimeConverter.getLowerRowOfMinutes(17)));
        Assert.assertTrue(" 59 Mts Case. There is should be "+ ExpectedResult59 + ", but was "+ TestTimeConverter.getLowerRowOfMinutes(59),ExpectedResult59.equals(TestTimeConverter.getLowerRowOfMinutes(59)));
    }

    @Test
    public void assertConvertTypeMethodPositive() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        String ActualResult = TestTimeConverter.convertTime("13:17:01");
        String ExpectedResultPositive = "ORROORRROYYROOOOOOOOYYOO";

        Assert.assertTrue(" For \"13:17:01\" Case. There is should be "+ ExpectedResultPositive + ", but was "+ ActualResult,ExpectedResultPositive.equals(ActualResult));
     }

    @Test
    public void assertConvertTimeMethodNegative1() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        try {
            TestTimeConverter.convertTime("13:17:01:04");
            fail("On convert incorrect Time(>8 symbols) exception expected");
        }
        catch (RuntimeException e) {
            System.out.println("Negative Unit Test (Time String > 8 ) for ConvertTimeMethod is passed");
             }


    }

    @Test
    public void assertConvertTimeMethodNegative2() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        try {
            TestTimeConverter.convertTime("13:17:-1");
            fail("On convert incorrect Time(has negative value) exception expected");
        }
        catch (RuntimeException e) {
            System.out.println("Negative Unit Test(Time String has negative value) for ConvertTimeMethod is passed");
        }
    }

    @Test
    public void assertConvertTimeMethodNegative3() {
        MyTimeConverter TestTimeConverter = new MyTimeConverter();
        try {
            TestTimeConverter.convertTime("13:17:ab");
            fail("On convert incorrect Time(has letters) exception expected");
        }
        catch (RuntimeException e) {
            System.out.println("Negative Unit Test(Time String has letters) for ConvertTimeMethod is passed");
        }
    }
}

