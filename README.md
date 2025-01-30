# Selenium TestNG Parallel Execution


This repository showcases a Selenium project configured with TestNG to perform parallel execution of UI tests. It emphasizes efficient test execution across multiple browsers without the use of BDD frameworks or additional reporting tools.

## Features
- **Selenium WebDriver**: Automates browsers for UI testing.
- **TestNG Framework**: Manages test configurations and supports parallel execution.
- **Page Object Model (POM)**: Ensures maintainable and reusable code.
- **Cross-browser Compatibility**: Test on Chrome, Firefox, and other supported browsers.
- **Parallel Execution**: Execute tests faster across multiple threads or browsers.
---

## Prerequisites
Make sure you have the following installed on your machine:
- **Java Development Kit (JDK)**: Version 8 or later.
- **Apache Maven**: For dependency management and build tasks.
- **Integrated Development Environment (IDE)**: Recommended - IntelliJ IDEA or Eclipse.
- **Browser Drivers**: Required for browser interactions (e.g., ChromeDriver for Chrome, GeckoDriver for Firefox). The project utilizes WebDriverManager to handle browser driver management automatically.

---

## Project Setup

Follow these steps to set up and run the project on your local machine:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/shuffle007/selenium-testng-parallel.git
  
2. **Navigate to the project directory**:
   ```bash
   cd selenium-testng-parallel
   ```
3. **Install project dependencies:** Run Maven to clean any previous builds and install dependencies:
   ```bash
   mvn clean install
    
## Set up Browser Driver
This project uses **WebDriverManager** to automatically download and manage the correct version of the WebDriver (e.g., ChromeDriver) for your system. No manual setup of WebDrivers is required.

When the tests are run, WebDriverManager will:
- Detect the version of your installed browser.
- Download the compatible WebDriver version.
- Configure the WebDriver for use.

## Configuring Parallel Execution
TestNG allows for parallel test execution through the testng.xml configuration file. You can specify the parallelism strategy and the number of threads to use.
Example testng.xml configuration:
```xml
  <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="ParallelTestSuite" parallel="tests" thread-count="2">
    <test name="ChromeTests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.tests.YourTestClass"/>
        </classes>
    </test>
    <test name="FirefoxTests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="com.tests.YourTestClass"/>
        </classes>
    </test>
</suite>
```
In this configuration:

- `parallel="tests"` → Executes all `<test>` tags in parallel.
- `thread-count="2"` → Sets the number of threads to 2.
- `<parameter name="browser" value="chrome"/>` → Passes the browser parameter to the test class.

For more details on TestNG's parallel execution, refer to the [TestNG Parallel Execution Guide](https://www.browserstack.com/guide/run-parallel-test-cases-in-testng).

## Running Tests
- To execute tests, use: 
  ```bash
  mvn test -DsuiteXmlFile=testng.xml
  ```
- This command runs the tests defined in the testng.xml file.

## Folder Structure
- selenium-testng-parallel/
  - src/
    - test/
      - java/
        - com.utilities/: Contains utility classes such as SetupDrivers.
        - com.pages/: Contains Page Object Model classes.
        - com.tests/: Contains actual TestNG test cases.
  - testng.xml: TestNG configuration file for test execution.
  - target/: Stores test reports and build artifacts.
  - pom.xml: The Maven configuration file.

## Technologies Used
- Selenium WebDriver
- TestNG
- Maven
- Java

## Contributing
Feel free to fork this project and submit pull requests for any improvements or features!

## License
This project is licensed under the MIT License.
