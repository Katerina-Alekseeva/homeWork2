package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Market {
    /*Поле  браузера */
    private WebDriver chromeDriver;

    /* Кнопка меню на Яндекс Марткет*/
  private WebElement marketMenuButton;

    /*  Конструктор - создание новой страницы
     * @param chromeDriver - браузер

     */
        public Market(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        this.marketMenuButton= chromeDriver.findElement(By.id("catalogPopupButton"));
    }
    /*Процесс открытия меню Яндекс Маркет*/
    public  void openMenu(){
        marketMenuButton.click();
    }
}
