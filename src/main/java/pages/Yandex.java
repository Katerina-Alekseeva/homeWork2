package pages;

    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    import java.util.ArrayList;
    import java.util.List;

public class Yandex {
    /*Поле  браузера */
        private WebDriver chromeDriver;
    /*    Поле сервисов яндекса  */
    private List<WebElement> servisesYandex = new ArrayList<>();

        /*  Конструктор - создание новой страницы
        * @param chromeDriver - браузер
       */
        public Yandex(WebDriver chromeDriver) {
            this.chromeDriver = chromeDriver;
            this.servisesYandex = chromeDriver.findElements(By.className("services-new__item-title"));
        }
        /* Процесс перехода на Сервис Яндекса
        * @param nameServis - Имя сервиса */
        public void GoTo(String nameServis){
            for (WebElement servis : servisesYandex){
                if (servis.getText().contains(nameServis)){
                    servis.click();
                }
            }
            List<String> tabs = new ArrayList<>(chromeDriver.getWindowHandles());
            for (String tab : tabs){
                chromeDriver.switchTo().window(tab);

            }
        }

    }

