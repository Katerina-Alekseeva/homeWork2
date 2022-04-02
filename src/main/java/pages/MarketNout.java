package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;

public class MarketNout {
    /* Селектор  найденой продукции*/
    private final String selectorSeachItem ="//div[@aria-label='Результаты поиска']//article//h3//a";
    /* Селектор  серого экрана загрузки элеменов*/
    private final String selectorGreyMonitir ="//div[contains(@aria-label,'Результаты поиска')]/child::*[@class]";
    /* Селектор  кнопки изменения колличесва продукции на странице*/
    private final String selectorCountButton ="//button[@type='button' and @aria-haspopup='true']";
    /* Браузер*/
    WebDriver chromeDriver;
    /*Ожидание */

  public   WebDriverWait wait;
    /*Поле установки минимальной цены*/
    private WebElement fromPrice;
    /* Поле установки максимальной цены*/
    private WebElement toPrice;

    /*Кнопка выбора количества товаров на странице */
    private   WebElement choose;
    /*Поле поиска */
    private  WebElement searchField;
    /*Кнопка "Искать" */
private WebElement searchButton;
    /*Список названий компьютеров на странице */
    private List<WebElement>laptops;

    /*  Конструктор - создание страницы
     * @param chromeDriver - браузер
     */
    public MarketNout(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;

        this.wait = new WebDriverWait(chromeDriver, 30);
        this.fromPrice = chromeDriver.findElement(By.xpath("//input[@type='text' and @name='Цена от']"));
        this.toPrice = chromeDriver.findElement(By.xpath("//input[@type='text' and @name='Цена до']"));
        this.searchField=chromeDriver.findElement(By.id("header-search"));
        this.searchButton=chromeDriver.findElement(By.xpath("//span[contains(text(), 'Найти')]/../../button"));

    }
    /*  Процесс утановки минимальной и максимальной цены, и желаемых моделей
     * @param minPraice -минимальная цена
     * @param maxPraice - максимальная цена
     * @param model1 - фильтр модели1
     * @param model2 - фильтр модели2
     */
     public void installPriceAndModel(String minPrice, String maxPrice, String model1, String model2 ) {

         fromPrice.click();
         fromPrice.sendKeys(minPrice);
         toPrice.click();
         toPrice.sendKeys(maxPrice);
         chromeDriver.findElement(By.xpath("//*[@name='Производитель "+ model1 +"']/../../label//div")).click();
         chromeDriver.findElement(By.xpath("//*[@name='Производитель "+model2+"']/../../label//div")).click();

     }


    /*  Процесс утановки количества товаров на странице
     * @param value -количество товаров на странице
     */
     public void installCountItems(int value){

       wait.until(invisibilityOfElementLocated(By.xpath(selectorGreyMonitir)));
     chromeDriver.findElement(By.xpath(selectorCountButton)).click();
         String selectorChooseCount ="//button[contains(text(),'Показывать по "+value+"' )]";
       chromeDriver.findElement(By.xpath(selectorChooseCount)).click();
         wait.until(invisibilityOfElementLocated(By.xpath(selectorGreyMonitir)));
     }
    /*  Метод сохнаяет значение названия первого товара и ищет через поиск этот товар
     */
         public void findFirstLaptopInSearch(){

             String laptop = getNameFirstElementSearch();
             searchField.click();
             searchField.sendKeys(laptop);
             searchButton.click();
            wait.until(visibilityOfElementLocated(By.xpath(selectorSeachItem)));

         }
    /*  Возвращает название товара
    @return String -имя товара
     */
         public String getNameFirstElementSearch(){
             this.laptops=chromeDriver.findElements(By.xpath(selectorSeachItem));
        return laptops.get(0).getText();
         }
    /*  Возвращиает список товаров на старнице
        @return список наименований товара
     */
         public List<WebElement> getLaptops(){
             this.laptops=chromeDriver.findElements(By.xpath(selectorSeachItem));
        return laptops;
         }


}


