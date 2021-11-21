package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyTabulek {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void rodicSeMusiPrihlasit() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement prihlasit = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[2]/a"));
        prihlasit.click();
        prihlaseniTomasMarny();
    }

    @Test
    public void neprihlasenyRodicMusiPrihlasitDiteNaKurz() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement viceInformaci = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[3]//a[text()='Více informací']"));
        viceInformaci.click();
        WebElement vytvoritPrihlasku = prohlizec.findElement(By.className("btn-primary"));
        vytvoritPrihlasku.click();
        prihlaseniTomasMarny();
        WebElement vyberteTermin = prohlizec.findElement(By.xpath
                ("/html/body/div/div/div/div/div/form/table/tbody/tr[2]/td[2]/div/button/div/div/div"));
        vyberteTermin.click();
        WebElement terminKurzu = prohlizec.findElement(By.xpath("(//span[@class = 'text'])"));
        terminKurzu.click();
        WebElement krestniJmenoZaka = prohlizec.findElement(By.id("forename"));
        krestniJmenoZaka.sendKeys("Jan");
        WebElement prijmeniZaka = prohlizec.findElement(By.id("surname"));
        prijmeniZaka.sendKeys("Marny");
        WebElement datumNarozeni = prohlizec.findElement(By.id("birthday"));
        datumNarozeni.sendKeys("05.05.2005");
        WebElement zpusobUhrady = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[8]/td[2]/span[1]/label"));
        zpusobUhrady.click();
        WebElement souhlas = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/span/label"));
        souhlas.click();
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.className("btn-primary"));
        tlacitkoVytvoritPrihlasku.click();
        prohlizec.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement zalozkaPrihlasky = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[1]/a[2]"));
        zalozkaPrihlasky.click();

        WebElement potvrzeniPrihlaseni = prohlizec.findElement(By.xpath("//td[text() = 'JavaScript']"));
        Assertions.assertNotNull(potvrzeniPrihlaseni);
    }

    @Test
    public void prihlasenyRodicMusiPrihlasitDiteNaKurz() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement prihlasit = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[2]/a"));
        prihlasit.click();
        prihlaseniTomasMarny();
        WebElement tlacitkoVytvorNovouPrihlasku = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div[1]/a"));
        tlacitkoVytvorNovouPrihlasku.click();
        WebElement viceInformaci = prohlizec.findElement(By.xpath("( //div[@class = 'card'] )[2]//a[text()='Více informací']"));
        viceInformaci.click();
        WebElement vytvoritPrihlasku = prohlizec.findElement(By.className("btn-primary"));
        vytvoritPrihlasku.click();
        WebElement vyberteTermin = prohlizec.findElement(By.xpath
                ("/html/body/div/div/div/div/div/form/table/tbody/tr[2]/td[2]/div/button/div/div/div"));
        vyberteTermin.click();
        WebElement terminKurzu = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[2]/td[2]/div/div/div[2]/ul/li[2]/a/span"));
        terminKurzu.click();
        WebElement krestniJmenoZaka = prohlizec.findElement(By.id("forename"));
        krestniJmenoZaka.sendKeys("Jan");
        WebElement prijmeniZaka = prohlizec.findElement(By.id("surname"));
        prijmeniZaka.sendKeys("Marny");
        WebElement datumNarozeni = prohlizec.findElement(By.id("birthday"));
        datumNarozeni.sendKeys("05.05.2005");
        WebElement zpusobUhrady = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[8]/td[2]/span[1]/label"));
        zpusobUhrady.click();
        WebElement souhlas = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/form/table/tbody/tr[11]/td[2]/span/label"));
        souhlas.click();
        WebElement tlacitkoVytvoritPrihlasku = prohlizec.findElement(By.className("btn-primary"));
        tlacitkoVytvoritPrihlasku.click();
        prohlizec.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement zalozkaPrihlasky = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[1]/a[2]"));
        zalozkaPrihlasky.click();

        WebElement potvrzeniPrihlaseni = prohlizec.findElement(By.xpath("//td[text() = 'HTML 1']"));
        Assertions.assertNotNull(potvrzeniPrihlaseni);
    }

    @Test
    public void proklikPresKontaktNaCzechitas() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement zalozkaKontakt = prohlizec.findElement(By.xpath("/html/body/div/header/nav/div/div[1]/a[2]"));
        zalozkaKontakt.click();
        WebElement odkaz = prohlizec.findElement(By.xpath("//div[1]/p[2]/a"));
        odkaz.click();
    }

    @AfterEach
    public void tearDown() {
        prohlizec.quit();
    }

    public void prihlaseniTomasMarny() {
        WebElement email = prohlizec.findElement(By.id("email"));
        email.sendKeys("tomas.marny@czechitas.cz");
        WebElement heslo = prohlizec.findElement(By.id("password"));
        heslo.sendKeys("masToMarny666");
        WebElement tlacitko = prohlizec.findElement(By.className("btn-primary"));
        tlacitko.click();
    }
}
