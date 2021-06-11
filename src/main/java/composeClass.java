import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class composeClass extends BaseClass {

    @FindBy(xpath="//div[@class='T-I T-I-KE L3']") private WebElement compose;
    @FindBy(xpath="//textarea[@name='to']") private WebElement to;
    @FindBy(xpath="//input[@name='subjectbox']") private WebElement sub;
    @FindBy(xpath="//div[@aria-label='Message Body']") private WebElement body;
    @FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[1]/div[1]/div[2]") private WebElement label;
    @FindBy(xpath="//div[@class=\"J-Ph Gi J-N\"]") private WebElement labeloption;

    @FindBy(xpath="//div[@title='Social']") private WebElement socialable;
    @FindBy(xpath="//div[contains(@data-tooltip,'Messages from social networks,')]") private WebElement social;
    @FindBy(xpath="(//span[@class='aXw T-KT'])[3]") private WebElement starred;
    @FindBy(xpath="//div[@aria-label='Send ‪(Ctrl-Enter)‬']") private WebElement send;
    @FindBy(xpath="(//span[@name='me'])[2]") private WebElement openmsg;
    @FindBy(xpath="//h2[@class='hP']") private WebElement subverify;

    //@FindBy(xpath="((//div[@dir=\"ltr\"])[4]") private WebElement msgbody;
    //@FindBy(xpath="(//div[@dir='ltr'])[4]") private WebElement msgbody;



    public composeClass(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void Login() throws InvalidFormatException, IOException, InterruptedException
    {
        compose.click();
        to.sendKeys(UtilityClass.getTD(0,0));
        Thread.sleep(4000);
        sub.sendKeys(UtilityClass.getTD(0,2));
        body.sendKeys(UtilityClass.getTD(0,3));

        label.click();
        Thread.sleep(4000);
        labeloption.click();
        Thread.sleep(4000);


        Actions act=new Actions(driver);
//
//    	act.moveToElement(labeloption).click().perform();
        act.moveToElement(socialable).click().perform();
        send.click();
        Thread.sleep(4000);

        driver.navigate().refresh();

        Thread.sleep(4000);
        social.click();
        Thread.sleep(4000);
        starred.click();
        Thread.sleep(4000);
        openmsg.click();
        Thread.sleep(4000);

    }


    public void verifysubject()
    {


        String actualsubject = subverify.getText();
        String expecsubject= "Test Mail";
        if(expecsubject.equals(actualsubject))
        {
            System.out.println("Message verified");
        }
        else
        {
            System.out.println("Mesage Failed");
        }
    }


}
