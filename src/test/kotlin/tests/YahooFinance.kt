package tests

import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.Test
import pageobjects.YahooFinanceHomePage
import pageobjects.YahooFinanceStockPage
import util.Properties

class YahooFinance : BaseTest(){
    @Test
    fun test() {
        // In this test I perform some basic web page scraping, assertions, and conditionals based upon stock market data
        with(driver) {
            get(properties.getProperty("yahooFinanceURL"))

            findElement(YahooFinanceHomePage.searchBar).sendKeys("SPY")
            findElement(YahooFinanceHomePage.searchButton).click()

            //confirm we see SPY
            Assert.assertTrue(findElement(YahooFinanceStockPage.stockName).text.contains("SPY"))

            val stockPrice = findElement(YahooFinanceStockPage.stockPrice).text
            println("Today's stock price is $stockPrice")

            val stockChange = findElement(YahooFinanceStockPage.stockChange).text
            if(stockChange.contains("+")){
                println("Today\'s stock market change was positive: $stockChange")
            } else {
                println("Today\'s stock market change was negative: $stockChange")
            }
        }

    }

}