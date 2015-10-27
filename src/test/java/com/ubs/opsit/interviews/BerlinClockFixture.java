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

    @Test
    @Given("^Current time is '([^']+)'$")
    public void current_time_is(String time) throws IllegalArgumentException{
    if ((time.length()!= 8)) throw new IllegalArgumentException("Time is incorrect. Please, set correct time according to mask HH:mm:ss. Thank you!");
    TimeConverter.convertTime(time);
    }


    @When("^On the top of the clock there is a yellow lamp that is '([^']+)'$")
    public void yellow_lamp_condition(String on_off) throws IllegalArgumentException {
        if ((on_off!="On")||(on_off!="Off")) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of yellow lamp (On/Off). Thank you!");
        Assert.assertTrue("The expected Flag of Yellow Lamp is \"On\", but actually was: " + TimeConverter.getYellowLampflag(),"On"==TimeConverter.getYellowLampflag());
    }

    @Then("^The top row of red lamps has values '([^']+)'$")
     public void top_row_of_Hrs (String topHrs) throws IllegalArgumentException {
        if (topHrs.length()!=4) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of top row of red lamps 4 symbols 'R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The top row of red lamps is \"OOOO\", but actually was: " + TimeConverter.getTopRowOfHrs(),"OOOO"==TimeConverter.getTopRowOfHrs());

    }


    @Then("^lower row of red lamps has values '([^']+)'$")
    public void low_row_of_Hrs (String lowerHrs) throws IllegalArgumentException {
        if (lowerHrs.length()!=4) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of lower row of red lamps (Hrs) 4 symbols 'R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The lower row of red lamps is \"OOOO\", but actually was: " + TimeConverter.getLowerRowOfHrs(),"OOOO"==TimeConverter.getLowerRowOfHrs());
    }

    @Then("^The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps and values '([^']+)'$")
    public void top_row_of_minutes (String topMinutes) throws IllegalArgumentException {
        if (topMinutes.length()!=11) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of top row of yellow/red lamps 11 symbols 'Y','R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The lower row of red lamps is \"OOOO\", but actually was: " + TimeConverter.getTopRowOfMinutes(),"OOOOOOOOOOO"==TimeConverter.getTopRowOfMinutes());
    }

    @Then("^In the last row with 4 lamps has values '([^']+)'$")
    public void low_row_of_minutes (String lowerMinutes) throws IllegalArgumentException {
        if (lowerMinutes.length()!=4) throw new IllegalArgumentException("Condition is incorrect. Please, set correct condition of lower row of red lamps (Minutes) 4 symbols 'R' or 'O'. Thank you!");
        Assert.assertTrue("The expected Value of The lower row of red lamps is \"OOOO\", but actually was: " + TimeConverter.getLowerRowOfMinutes(),"OOOO"==TimeConverter.getLowerRowOfMinutes());
    }

    /*public class DepositStepDefinitions {
        private Account account;

        @Given("^a User has no money in their account$")
        public void a_User_has_no_money_in_their_current_account() throws CucumberException @Given("^a User has no money in their account$")
        public void a_User_has_no_money_in_their_current_account() throws CucumberException
        {
            User user = new User();
            account = new Account();
            user.setAccount(account);
            assertTrue("The balance is not zero.", account.getBalance() == 0L);
            //throw new CucumberException("Cucumber failed...");
        }

        @When("^£(\\d+) is deposited in to the account$")
        public void £_is_deposited_in_to_the_account(int amount) {
            account.deposit(amount);
        }
        */

    //TODO
}
