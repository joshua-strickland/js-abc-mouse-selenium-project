package pageobjects

import org.openqa.selenium.By

object YahooFinanceStockPage {
    val stockName = By.xpath("//*[@id=\"quote-header-info\"]/div[2]/div[1]/div[1]/h1")
    val stockPrice = By.xpath("//*[@id=\"quote-header-info\"]/div[3]/div[1]/div[1]/fin-streamer[1]")
    val stockChange = By.xpath("//*[@id=\"quote-header-info\"]/div[3]/div[1]/div/fin-streamer[2]/span")


}