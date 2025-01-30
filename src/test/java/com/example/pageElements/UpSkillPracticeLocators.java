package com.example.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpSkillPracticeLocators {

	//Mouse hover button
	@FindBy (xpath="//button[contains(text(), 'Hover Over Me!')]")
	public WebElement mouseHover;
	
	//Link 1
	@FindBy (xpath="//a[contains(text(), 'Link 1')]")
	public WebElement link1;
	
	//Textbox
	@FindBy (xpath="//input[contains (@placeholder, 'Type to search')]")
	public WebElement txtBox;
	
	//Dropdown 
	@FindBy (xpath="//select[contains (@aria-label, 'Default select')]")
	public WebElement dropDown;
	
	//Validate drop down selection
	@FindBy (xpath="//option[contains (text(), 'Option 2')]")
	public WebElement validateDDSelection;
	
	//Alert button
	@FindBy (xpath="//button[contains (text(), 'Alert')]")
	public WebElement alertBx;
	//button[@onclick='displayAlert()']
	
	//Home button
	@FindBy (xpath="//p[contains(text(), 'Courses')]")
	public WebElement courseBtn;
	
	//Radio button
	@FindBy (xpath="//label[contains(text(), 'Radio 2')]")
	public WebElement radioBtn;
	
	//Checkbox 
	@FindBy (xpath="//input[contains(@id, \"flexCheckCheckedOne\")]")
	public WebElement checkBx;
	
	
	//Window button
	@FindBy (xpath="//button[contains(text(), 'Open Window')]")
	public WebElement windowBtn;
	
	//Confirm button
	@FindBy (xpath="//button[contains(text(), 'Confirm')]")
	public WebElement confirmBtn;
	
	//iFrame
	@FindBy (xpath= "//iframe[@name='htmlComp-iframe']")
	public WebElement iFrame;
}
