package com.example.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.actions.UpSkillPracticeActions;
import com.utilities.SetupDrivers;


public class UpSkillPracticeTest {
    UpSkillPracticeActions actions;

    @BeforeMethod
    public void setup() {
        System.out.println("Initializing driver...");
        SetupDrivers.setupDriver(); // Initialize the driver
        actions = new UpSkillPracticeActions(); // Create the Actions object
        actions.loadUpSkillPracticePage(); // Navigate to the practice page
    }

    @AfterMethod
    public void tearDown() {
        SetupDrivers.tearDownDriver(); // Quit the browser
        System.out.println("Test completed and browser closed.");
    }

    @Test
    public void testMouseHoverAndClickLink() throws Exception {
        actions.switchIframe();
        actions.mouseHover();
        actions.clickLink();
    }

    @Test
    public void testTextboxFunctionality() throws Exception {
        actions.switchIframe();
        actions.textBox("Tesla");
    }

    @Test
    public void testDropdownSelection() throws Exception {
        actions.switchIframe();
        actions.selectDropDown("Option 2");
        //actions.verifyDropDown();
    }

    @Test
    public void testClickAlertAndConfirm() throws Exception {
        actions.clickAlert();
        actions.clickOK();
    }

    @Test
    public void testCancelPractice() throws Exception {
        actions.clickAlert();
        actions.cancelAlert(); // Click cancel on the alert
    }

    @Test
    public void testRadioButtonAndCheckbox() throws Exception {
        actions.clickRadioBtn();
        actions.clickCheckbox();
    }

    @Test
    public void testCheckboxPractice() throws Exception {
        actions.clickCheckbox(); // Ensure checkbox interaction works
    }

    @Test
    public void testWindowHandling() throws Exception {
        actions.clickOpenWindow();
        actions.switchNewWindow();
        actions.clickCourses();
    }

    @Test
    public void testIframeCoursesPractice() throws Exception {
        actions.switchIframeHome(); // Switch to the iFrame for Courses
        actions.clickCourses(); // Interact with Courses button in iFrame
    }

    @Test
    public void testConfirmButtonHandling() throws Exception {
        actions.clickConfirm();
        actions.verifyAlertText("Great!");
    }
}