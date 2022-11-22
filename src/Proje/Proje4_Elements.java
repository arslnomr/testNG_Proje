package Proje;

import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Proje4_Elements {

    public Proje4_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }


    @FindBy(id = "gender-female")
    public WebElement gender;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement dateOfBirthYear;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Company")
    public WebElement company;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    @FindBy(className = "result")
    public WebElement dogrulama;


    @FindBy(className = "ico-login")
    public WebElement logIn;

    @FindBy(className = "login-button")
    public WebElement logInButton;

    @FindBy(className = "ico-logout")
    public WebElement basariliMi;

    @FindBy(linkText = "Gift Cards")
    public WebElement giftCart;

    @FindBy(id = "giftcard_43_RecipientName")
    public WebElement recipientsName25Icin;

    @FindBy(id = "giftcard_43_RecipientEmail")
    public WebElement aliciEmail;

    @FindBy(className = "sender-name")
    public WebElement senderName;

    @FindBy(className = "sender-email")
    public WebElement senderMail;

    @FindBy(css = "[class='message']")
    public WebElement messaage;

    @FindBy(id = "add-to-cart-button-43")
    public WebElement add;

    @FindBy(className = "content")
    public WebElement goruldu;

    @FindBy(linkText = "Computers")
    public WebElement computers;

    @FindBy(css = "[alt='Picture for category Desktops']")
    public WebElement desktop;

    @FindBy(linkText = "Build your own computer")
    public WebElement dBuild;

    @FindBy(id = "product_attribute_2")
    public WebElement ramS;

    @FindBy(id = "product_attribute_3_7")
    public WebElement hdd;

    @FindBy(id = "add-to-cart-button-1")
    public WebElement adcart;

    @FindBy(className = "content")
    public WebElement yesillendi;

    @FindBy(id = "small-searchterms")
    public WebElement search;

    @FindBy(css = "[class='button-1 search-box-button']")
    public WebElement searchButton;

    @FindBy(css = "[class='product-title']>a")
    public WebElement dogruluk;

    @FindBy(className = "ico-logout")
    public WebElement logout;
}
