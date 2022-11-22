package Proje;

import Utils.BaseDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Proje4 extends BaseDriver {
    @Test(enabled = false)
    void RegistrationsTest() {

        Proje4_Elements elements = new Proje4_Elements();


        elements.gender.click();
        elements.firstName.sendKeys("ahmet");
        elements.lastName.sendKeys("mehmet");

        Select gunSecenekleri = new Select(elements.dateOfBirthDay);
        gunSecenekleri.selectByValue("1");

        Select aySecenekleri = new Select(elements.dateOfBirthMonth);
        aySecenekleri.selectByValue("1");

        Select yilSecenekleri = new Select(elements.dateOfBirthYear);
        yilSecenekleri.selectByValue("2000");

        elements.email.sendKeys("mehmet.58@gmail.com");
        elements.company.sendKeys("Apple");
        elements.password.sendKeys("ahmet.49");
        elements.confirmPassword.sendKeys("ahmet.49");
        elements.registerButton.click();
        Assert.assertTrue(elements.dogrulama.getText().contains("completed"), "yazi gozukmedi");
    }

    @Test(priority = 1)
    void LoginTest() {
        Proje4_Elements elements = new Proje4_Elements();

        elements.logIn.click();
        elements.email.sendKeys("mehmet.58@gmail.com");
        elements.password.sendKeys("ahmet.49");
        elements.logInButton.click();
        Assert.assertTrue(elements.basariliMi.getText().contains("Log out"), "log in islemi basarisiz");
        elements.logout.click();
    }

    @Test(dataProvider = "getData",priority = 2)
    void DataProviderLoginTest(String email, String password) {
        Proje4_Elements elements = new Proje4_Elements();
        elements.logIn.click();
        elements.email.sendKeys(email);
        elements.password.sendKeys(password);
        elements.logInButton.click();
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = {
                {"peynir@gmail.com", "shdfvgjsfs"},
                {"mehmet.58@gmail.com", "ahmet.49"}
        };
        return data;
    }

    @Test(priority = 3)
    void TabMenuTest(){
        Proje4_Elements elements = new Proje4_Elements();
        List<WebElement> tabMenuElemanlari = driver.findElements(By.cssSelector("[class='top-menu notmobile']>li"));
        List<String> dogrulama = new ArrayList<>();
        dogrulama.add("Computers");
        dogrulama.add("Electronics");
        dogrulama.add("Apparel");
        dogrulama.add("Digital downloads");
        dogrulama.add("Books");
        dogrulama.add("Jewelry");
        dogrulama.add("Gift Cards");
        for (int i = 0; i < dogrulama.size(); i++) {
            Assert.assertEquals(tabMenuElemanlari.get(i).getText(),dogrulama.get(i));
        }
    }
    @Test(priority = 4)
    void OrderGiftsTest() {

        Proje4_Elements elements = new Proje4_Elements();

        elements.giftCart.click();

        List<WebElement> giftlerinAddToCartlari = driver.findElements(By.cssSelector("[class='button-2 product-box-add-to-cart-button']"));

        Random random = new Random();
        int sayi = random.nextInt(1);

        giftlerinAddToCartlari.get(sayi).click();
        if (!driver.getCurrentUrl().contains("25-virtual-gift-")) {
            elements.recipientsName25Icin.sendKeys("sedat");
            elements.aliciEmail.sendKeys("aaaasdassadasdsd@gmail.com");
            elements.senderName.clear();
            elements.senderName.sendKeys("omer");
            elements.senderMail.clear();
            elements.senderMail.sendKeys("sw@gmail.com");
            elements.messaage.sendKeys("gule gule kullan");
            wait.until(ExpectedConditions.elementToBeClickable(elements.add));
            elements.add.click();
            //JavascriptExecutor js=(JavascriptExecutor)driver;
            //js.executeScript("window.scrollBy(0,0);");
            wait.until(ExpectedConditions.elementToBeClickable(elements.computers));

            Assert.assertTrue(elements.goruldu.getText().contains("has been added"), "islem basarisiz");


        }
    }

    @Test(priority = 5)
    void OrderComputerTest(){
        Proje4_Elements elements = new Proje4_Elements();

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, 0);");
        elements.computers.click();

        elements.desktop.click();
        elements.dBuild.click();

        Select ddmenu=new Select(elements.ramS);
        ddmenu.selectByVisibleText("8GB [+$60.00]");
        elements.hdd.click();
        elements.adcart.click();

        Assert.assertTrue(elements.yesillendi.getText().contains("has been added"),"mesaj gorulmedi");
    }

    @Test(priority = 6)
    @Parameters("aranacakKelime")
    void ParametreliSearchTest(String aranacakKelime){
        Proje4_Elements elements = new Proje4_Elements();
        elements.search.sendKeys(aranacakKelime);
        elements.searchButton.click();
        Assert.assertTrue(elements.dogruluk.getText().contains(aranacakKelime),"eleman esit degil");
    }

}
