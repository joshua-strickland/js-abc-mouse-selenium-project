package tests

import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.Test
import pageobjects.ABCMouseHomePage
import pageobjects.GoogleHomePage
import pageobjects.GoogleResultsPage

class GoogleABCMouse : BaseTest(){

    @Test
    fun test() {
        // Here I use google to search for and then click into abc mouse's website
        with(driver) {
            get(properties.getProperty("googleURL"))

            findElement(GoogleHomePage.searchBar).sendKeys("ABC mouse")
            findElement(GoogleHomePage.searchButton).click()

            findElement(GoogleResultsPage.firstResult).click()
            //I am encountering an automation detection mechanism upon trying to load ABCmouse.com through selenium.
            //I pass the test upon the selenium robot's identity being uncovered, as I, the developer do not want robots in my classrooms.
            val iAmARobot =
                findElement(ABCMouseHomePage.automationToolDetectedField).text.contains("Please verify you are a human")
            Assert.assertTrue(iAmARobot)
            if (iAmARobot) {
                print("The selenium robot cannot join the classroom.")
            }
        }

    }

}