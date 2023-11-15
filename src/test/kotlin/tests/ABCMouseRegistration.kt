package tests

import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.Test
import pageobjects.ABCMouseHomePage


class ABCMouseRegistration : BaseTest() {

    @Test
    fun test(){
        with(driver){
            get(properties.getProperty("abcMouseURL"))

            //I am encountering an automation detection mechanism upon trying to load ABCmouse.com through selenium.
            //I, as a robot hoping to elude detection to get an education, intentionally fail the test upon my robot identity being uncovered.
            val iAmARobot =
                findElement(ABCMouseHomePage.automationToolDetectedField).text.contains("Please verify you are a human")
            if (iAmARobot) {
                print("I am a robot and cannot learn with human children using abc mouse :(.")
            }
            Assert.assertFalse(iAmARobot)

        }

    }

}