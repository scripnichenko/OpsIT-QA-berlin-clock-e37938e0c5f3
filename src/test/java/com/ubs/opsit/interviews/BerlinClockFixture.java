package com.ubs.opsit.interviews;


import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You need to
 * edit this class to complete the exercise.
 */
public class BerlinClockFixture {

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }
    /*
    Scenario: 00:00:00 Time Berlin clock representation

    Given Current time is 00:00:00
    When On the top of the clock there is a yellow lamp that is On
    Then The top row of red lamps has values OOOO
    And lower row of red lamps has values OOOO
    And The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps and values OOOOOOOOOOO
    And In the last row with 4 lamps has values OOOO
        **/


    MyTimeConverter TimeConverter = new MyTimeConverter();

    protected String yellowCircle;
    protected String topHoursString;
    protected String lowerHoursString;
    protected String topMinutesString;
    protected String lowerMinutesString;


    // Parse result of MyTimeConverter to Seconds flag, Minutes, Hours...
    @Given("^Current time is '([^']+)'$")
    public void current_time_is(String time) throws IllegalArgumentException{
    if ((time.length()!= 8)) throw new IllegalArgumentException("Time is incorrect. Please, set correct time according to mask HH:mm:ss. Thank you!");
       yellowCircle = String.valueOf(time.charAt(0));
       topHoursString = new String(new char[] {time.charAt(1),time.charAt(2),time.charAt(3),time.charAt(4)});
       lowerHoursString = new String(new char[] {time.charAt(5),time.charAt(6),time.charAt(7),time.charAt(8)});
       for (int  i= 9; i<20;i++){
           topMinutesString += String.valueOf(time.charAt(i));
       }
       lowerMinutesString = new String(new char[] {time.charAt(20),time.charAt(21),time.charAt(22),time.charAt(23)});

    }

    @When("^On the top of the clock there is a yellow lamp that is '([^']+)'$")
    public void yellow_lamp_condition(String on_off) throws IllegalArgumentException {
        if ((on_off!="O")||(on_off!="Y")) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of yellow lamp (O/Y). Thank you!");
          Assert.assertTrue("The expected Flag of Yellow Lamp is  " + on_off + " , but actually was: " + yellowCircle,yellowCircle.equals(on_off));
    }

    @Then("^The top row of red lamps has values '([^']+)'$")
     public void top_row_of_Hrs (String topHrs) throws IllegalArgumentException {
        if (topHrs.length()!=4) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of top row of red lamps 4 symbols 'R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The top row of red lamps (hours) is " +topHoursString + " , but actually was: " + topHrs, topHrs.equals(topHoursString));

    }

    @Then("^lower row of red lamps has values '([^']+)'$")
    public void low_row_of_Hrs (String lowerHrs) throws IllegalArgumentException {
        if (lowerHrs.length()!=4) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of lower row of red lamps (Hrs) 4 symbols 'R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The lower row of red lamps (hours) is" + lowerHoursString +" , but actually was: " + lowerHrs, lowerHrs.equals(lowerHoursString));
    }

    @Then("^The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps and values '([^']+)'$")
    public void top_row_of_minutes (String topMinutes) throws IllegalArgumentException {
        if (topMinutes.length()!=11) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of top row of yellow/red lamps 11 symbols 'Y','R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The top row of red lamps (minutes) is "+topMinutesString + ", but actually was: " + topMinutes, topMinutes.equals(topMinutesString));
    }

    @Then("^In the last row with 4 lamps has values '([^']+)'$")
    public void low_row_of_minutes (String lowerMinutes) throws IllegalArgumentException {
        if (lowerMinutes.length()!=4) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of lower row of red lamps (Minutes) 4 symbols 'R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The lower row of red lamps (minutes) is " + lowerMinutesString + " , but actually was: " + lowerMinutes, lowerMinutes.equals(lowerHoursString));
    }


}
