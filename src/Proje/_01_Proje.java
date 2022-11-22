package Proje;

import Utils.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Proje extends BaseDriver {

    @Test
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

        elements.email.sendKeys("mehmet.52@gmail.com");
        elements.company.sendKeys("Apple");
        elements.password.sendKeys("ahmet.49");
        elements.confirmPassword.sendKeys("ahmet.49");
        elements.registerButton.click();
        Assert.assertTrue(elements.dogrulama.getText().contains("completed"), "yazi gozukmedi");
    }

  @Test()
  void LoginTest() {
      Proje4_Elements elements = new Proje4_Elements();

      elements.logIn.click();
      elements.email.sendKeys("mehmet.50@gmail.com");
      elements.password.sendKeys("ahmet.49");
      elements.logInButton.click();
      Assert.assertTrue(elements.basariliMi.getText().contains("Log out"), "log in islemi basarisiz");
  }

 // @Test(dataProvider = "getData")
 // void DataProviderLoginTest(String email, String password) {
 //     _01_Proje_Elements elements = new _01_Proje_Elements();
 //     elements.logIn.click();
 //     elements.email.sendKeys(email);
 //     elements.password.sendKeys(password);
 //     elements.logInButton.click();
 // }

 // @DataProvider
 // public Object[][] getData() {

 //     Object[][] data = {
 //             {"peynir@gmail.com", "shdfvgjsfs"},
 //             {"kirmizi1@gmail.com", "123asd123"}
 //     };
 //     return data;
 // }

 // @Test
 // void TabMenuTest(){

 //     _01_Proje_Elements elements = new _01_Proje_Elements();

 //     List<WebElement> tabMenuElemanlari = driver.findElements(By.cssSelector("[class='top-menu notmobile']>li"));
 //     List<String> dogrulama = new ArrayList<>();
 //     dogrulama.add("Computers");
 //     dogrulama.add("Electronics");
 //     dogrulama.add("Apparel");
 //     dogrulama.add("Digital downloads");
 //     dogrulama.add("Books");
 //     dogrulama.add("Jewelry");
 //     dogrulama.add("Gift Cards");

 //     for (int i = 0; i < dogrulama.size(); i++) {

 //         Assert.assertEquals(dogrulama.get(i),tabMenuElemanlari.get(i).getText());
 //     }
 // }

 // @Test(dependsOnMethods = "LoginTest")
 // void  OrderGiftsTest(){
 //     _01_Proje_Elements elements = new _01_Proje_Elements();

 //     elements.giftCart.click();
 //     List<WebElement> gifts = driver.findElements(By.cssSelector("[class='button-2 product-box-add-to-cart-button']"));

 //     Random random = new Random();
 //     int randomSayi=random.nextInt(3);
 //     gifts.get(randomSayi).click();

 //     wait.until(ExpectedConditions.urlContains("gift-card"));
 //     elements.recipientsName.sendKeys("Sedat");
 //     elements.message.sendKeys("gule gule kullan:)");
 //     elements.addToCart.click();
 // }



}
