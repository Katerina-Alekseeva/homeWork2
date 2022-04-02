package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MarketComputers {
    /* Селектор  блока подраздела*/
    private String selectorSearchItems = "//h3[text()='Покупайте компьютерную технику на Маркете']/../../span/../../div/following-sibling::*//div[@data-zone-data]";
    /* Селектор  названия подраздела*/ //h3[contains(text(),'Покупайте')]/../../../div/following-sibling::*//div//div[@data-zone-data]
    private String selectorNamePage = ".//div[@class='_3Nlow _3Ct1C']";
    /* Селектор  ссылки блока подраздела*/
    private String selectorURL= ".//a[@href]";
    /* Браузер*/
    private WebDriver chromeDriver;

    /* Список всех элентов*/
    private List<WebElement> searchItems ;
    /* Лист объктов ключ-значение */
    private List<Map<String,Object>> collectResults = new ArrayList<>();

    /*  Конструктор - создание нового объекта с определенными значениями
     * @param chromeDriver - браузер
     */
    public MarketComputers(WebDriver chromeDriver) {
        this.chromeDriver=chromeDriver;
        searchItems = chromeDriver.findElements(By.xpath(selectorSearchItems));
       // this.nout =chromeDriver.findElement(By.xpath("//span[contains(text(),'Компьютеры')]"));
    }

/*Процесс наполнения списка объектов ключ-значение  содержащий блок  и имя элемента
 по каждому элементу подразделов на Яндекс Маркет
  @return наполненый лист  Мap*/
    public List<Map<String, Object>> getCollectResults() {

        for(WebElement result : searchItems){
            collectResults.add(Map.of(
                    "WEB_ELEMENT", result,
                    "NAME_PAGE", result.findElement(By.xpath(selectorNamePage)).getText()
            ));
        }
        return collectResults;
       }
       /*Переход на страницу подраздела
       * @param nameItems -  название подраздела*/
    public void goToPageNout(String nameItems){
         getCollectResults();
        WebElement pageLink = (WebElement) collectResults.stream()
                .filter(x->x.get("NAME_PAGE").toString().contains(nameItems))
                .findFirst()
                .get().get("WEB_ELEMENT");
        pageLink.findElement(By.xpath(selectorURL)).click();
    }

}
