package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class MarketMenu {


   private WebDriver chromeDriver;
   private WebElement comp;

    /*  Конструктор - создание новой страницы
     * @param chromeDriver - браузер
     */
    public MarketMenu(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;

    }
    public void goToPageComp(String element){
        this.comp = chromeDriver.findElement(By.xpath("//span[contains(text(),'"+element+"')]/../."));
    comp.click();
    }
}




