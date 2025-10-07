# Polymer Shop Automation Framework

This project is a Selenium automation framework built to test the Polymer Shop E-commerce website (https://shop.polymer-project.org/). It is designed using the Page Object Model (POM) and TestNG to ensure a scalable, maintainable, and reliable test suite.

The framework is specifically engineered to handle web components and the Shadow DOM, which is a key feature of the Polymer Shop site, allowing for robust and accurate test execution.

**🚀 Project Overview**
----------------------------------

The primary goal of this framework is to automate end-to-end test cases covering core e-commerce functionalities, including:

Home Page: Verifying page elements, navigation, and featured products.

Product Listing: Testing product display, filtering, and sorting.

Product Details: Validating product information and "Add to Cart" functionality.

Shopping Cart: Managing product quantities, removal, and total calculations.

Checkout Process: Verifying form validation and order confirmation.

**🛠️ Framework Components**
----------------------------------

The project's architecture is built on best practices to facilitate easy development and maintenance.

Selenium WebDriver: The core library for browser automation.

TestNG: The testing framework for test execution, reporting, and parallel testing.

Page Object Model (POM): A design pattern that separates test logic from page-specific locators, improving code readability and reducing duplication.

WebDriverManager: Automatically handles browser driver binaries (e.g., ChromeDriver), eliminating manual setup.

Apache POI: A library for handling data-driven tests by reading from Excel files (.xlsx).

Log4j2: A robust logging framework for capturing test execution logs.

**📂 Project Structure**
----------------------------------

The project is organized into a clean and logical structure:

src/main/java:

com.polymershop.pages: Contains all Page Object classes (HomePage.java, CartPage.java, etc.).

com.polymershop.managers: Manages WebDriver instances (DriverManager.java).

com.polymershop.utils: Includes utility classes for configuration and data reading (ConfigReader.java, ExcelReader.java).

src/test/java:

com.polymershop.tests: Contains the TestNG test classes (HomePageTests.java, ShoppingCartTests.java, etc.).

com.polymershop.listeners: Includes custom TestNG listeners (TestListener.java).

resources:

config.properties: Stores all environment-specific configurations like browser type and URL.

testng.xml: The TestNG suite file for defining and running tests.

**⚙️ Project Setup**
----------------------------------

Follow these steps to set up the project in your local environment.

Prerequisites
Java Development Kit (JDK) 8 or higher

Maven (pre-installed in most IDEs)

An IDE (Eclipse or IntelliJ IDEA are recommended)

Step-by-Step Setup
Clone the Repository:

Bash

git clone https://github.com/your-username/PolymerShop-Automation.git
cd PolymerShop-Automation
Open in IDE:

Open your IDE and import the project as a Maven project.

Your IDE should automatically download all the dependencies listed in the pom.xml file.

Update Maven Dependencies:

If dependencies are not downloaded automatically, right-click the project in your IDE and select Maven -> Update Project.... This will ensure all libraries are correctly configured.

**▶️ How to Run Tests**
----------------------------------

The tests can be executed using the testng.xml file.

Configure testng.xml:

Open the resources/testng.xml file.

You can configure the browser (chrome or firefox), the number of threads for parallel execution, and the specific test classes you want to run.

Execute the Test Suite:

In your IDE, right-click on the testng.xml file.

Select Run As -> TestNG Suite.

The tests will start running, and the browser will be launched and automated.

**📝 Test Reports**
----------------------------------

TestNG automatically generates detailed HTML reports after each test run.

Location: The reports are saved in the test-output directory at the root of your project.

To View: Open the index.html file in your browser to view a summary of the test results, including passed, failed, and skipped tests, along with execution times.

Failure Screenshots: For every failed test, TestListener.java will automatically capture a screenshot and save it in the output/screenshots directory, which is useful for debugging.
