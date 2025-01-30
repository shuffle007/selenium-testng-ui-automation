package com.example.actions;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.example.pageElements.UpSkillPracticeLocators;
import com.utilities.SetupDrivers;

public class UpSkillPracticeActions {

    UpSkillPracticeLocators locators;

    public UpSkillPracticeActions() {
        locators = new UpSkillPracticeLocators();
        PageFactory.initElements(SetupDrivers.getDriver(), locators);
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(SetupDrivers.getDriver(), Duration.ofSeconds(10));
    }

    public void loadUpSkillPracticePage() {
        SetupDrivers.getDriver().get("https://www.upskillconsultancy.com/automation-practice");
    }

    public void switchIframe() {
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("htmlComp-iframe"));
    }

    public void mouseHover() {
        Actions actions = new Actions(SetupDrivers.getDriver());
        actions.moveToElement(locators.mouseHover).perform();
    }

    public void clickLink() {
        getWait().until(ExpectedConditions.elementToBeClickable(locators.link1)).click();
    }

    public void textBox(String inputText) {
        locators.txtBox.clear();
        locators.txtBox.sendKeys(inputText);
    }

    public void selectDropDown(String visibleText) {
        Select dropDown = new Select(locators.dropDown);
        dropDown.selectByVisibleText(visibleText);
    }

    public void verifyDropDown(String expectedOption) {
        Assert.assertEquals(
            locators.validateDDSelection.getText(),
            expectedOption,
            "Dropdown verification failed!"
        );
    }

    public void clickAlert() {
        locators.alertBx.sendKeys(Keys.RETURN);
    }

    public void clickOK() {
        Alert alert = SetupDrivers.getDriver().switchTo().alert();
        alert.accept();
    }

    public void switchIframeHome() {
        SetupDrivers.getDriver().switchTo().defaultContent();
        SetupDrivers.getDriver().switchTo().frame(0);
    }

    public void clickCourses() {
        locators.courseBtn.click();
    }

    public void clickRadioBtn() {
        locators.radioBtn.click();
    }

    public void clickCheckbox() {
        locators.checkBx.click();
    }

    public void clickOpenWindow() {
        locators.windowBtn.click();
    }

    public void switchNewWindow() {
        String mainWindow = SetupDrivers.getDriver().getWindowHandle();
        for (String winHandle : SetupDrivers.getDriver().getWindowHandles()) {
            if (!winHandle.equals(mainWindow)) {
                SetupDrivers.getDriver().switchTo().window(winHandle);
                break;
            }
        }
    }

    public void clickConfirm() {
        locators.confirmBtn.sendKeys(Keys.RETURN);
    }

    public void verifyAlertText(String expectedText) {
        Alert alert = SetupDrivers.getDriver().switchTo().alert();
        String actualText = alert.getText();
        Assert.assertTrue(
            actualText.contains(expectedText),
            "Expected alert text: " + expectedText + ", but found: " + actualText
        );
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = SetupDrivers.getDriver().switchTo().alert();
        alert.dismiss();
    }
}
