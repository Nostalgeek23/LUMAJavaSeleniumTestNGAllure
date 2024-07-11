<h1>Test Automation Framework with Java, Selenium, TestNG, Maven and Allure</h1>

[![Build Java with Maven](https://github.com/Nostalgeek23/LUMAJavaSeleniumTestNGAllure/actions/workflows/build.yml/badge.svg)](https://github.com/Nostalgeek23/LUMAJavaSeleniumTestNGAllure/actions/workflows/build.yml)
<a href="https://nostalgeek23.github.io/LUMAJavaSeleniumTestNGAllure"><img alt="GitHub Contributors" src="https://img.shields.io/badge/Latest_Allure_Report-blue" /></a>


<h2>Overview</h2>

This project provides a comprehensive framework for automated testing of the demo e-commerce website Luma Magento (https://magento.softwaretestingboard.com).

Built using Java, Selenium WebDriver, TestNG, Maven and Allure for reporting. The tests are designed to automate various functionalities of a web application, ensuring robust and reliable test execution.

Open the latest Allure report by clicking on the badge at the top.


<i>This project serves as an example of my capabilities and skills. It demonstrates my ability to handle various tasks and showcases different approaches to problem-solving. The project may look inconsistent and intentionally includes a mix of methods to illustrate my versatility and proficiency in multiple techniques.   </i>
<h2>Features</h2>

<h3>Testing Framework</h3>
<ul>
<li>Utilizes the <code>Page Object Model</code> (POM) pattern for structured and reusable test code.</li>
<li>Supports <code>cross-browser testing</code> and <strong>multiple operating systems</strong>.</li>
<li>Data-driven tests with <code>DataProvider</code> for comprehensive test coverage.</li>
<li><code>ThreadLocalDriver</code> for thread-safe WebDriver instances.</li>
<li>Extensive <code>logging</code> for debugging and tests execution tracking.</li>
</ul>

<h3>Tools</h3>

| Tool                                                                                                                | Purpose                |
| ------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| ![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white) | For browser automation. |
| ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) | For writing code. |
| ![TestNG Logo](https://github.com/Nostalgeek23/Mysite/blob/master/testng.svg) | For testing framework. |
| ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) | For build automation. |
| ![Allure Logo](https://github.com/Nostalgeek23/Mysite/blob/master/Allure.svg) | For generating detailed test reports. |

<h3>Cross-testing</h3>

| Platform                                                          | Info                                | Browsers                                                                                                     |
| ----------------------------------------------------------------- | ----------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| ![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white) | For checks on CI |
| ![Ubuntu](https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white) | Ubuntu-latest | ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white) ![Firefox](https://img.shields.io/badge/Firefox-FF7139?style=for-the-badge&logo=Firefox-Browser&logoColor=white)|
| ![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white) | Windows-latest | ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white) ![Firefox](https://img.shields.io/badge/Firefox-FF7139?style=for-the-badge&logo=Firefox-Browser&logoColor=white) ![Edge](https://img.shields.io/badge/Edge-0078D7?style=for-the-badge&logo=Microsoft-edge&logoColor=white) |
| ![macOS](https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=macos&logoColor=F0F0F0) | MacOs 13, Safari limited support | ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white) 	![Safari](https://img.shields.io/badge/Safari-000000?style=for-the-badge&logo=Safari&logoColor=white)|

<h3>Project Structure</h3>
<div class="project-structure">
<pre>
📁 LUMAJavaSeleniumTestngAllure/
├──📁 .github/
│   └──📁 workflows/
│       └── build.yml
├──📁 src/
│   └── 📁test/
│        └── 📁 java/
│              └── 📁 com/
│                    └── 📁 lumatest/
│                    |    ├── 📁 base/
│                    |    │     └── BaseTest.java
│                    |    ├── 📁 data/
│                    |    │     ├── TestData.java
│                    |    │     └── DrivenBackpackDescription.txt  
│                    |    ├── 📁 model/
│                    |    │     └── *POM classes*
│                    |    ├── 📁 test/
│                    |    │     ├── CartTest.java  
│                    |    │     ├── LoginTest.java  
│                    |    │     ├── NavigationTest.java
│                    |    │     ├── ProductPageTest.java
│                    |    │     └── SearchTest.java  
│                    |    ├── 📁 utils/
│                    |    │     ├── DriverUtils.java
│                    |    │     ├── ProjectUtils.java  
│                    |    │     └── ReportUtils.java
│                    |    └── FrameworkTest.java
│                    └── 📁 resources/
│                         ├── 📁 xmlSuites/
│                         │     ├── smoke.xml
│                         │     ├── regression.xml
│                         │     ├── testngubu.xml
│                         │     ├── testngwin.xml
│                         │     └── testngmac.xml
│                         ├── allure.properties
│                         └── logback.xml
├── 📁 target/
│    └── allure-results/
├── pom.xml
└── README.md
</pre>
</div>

<h2>Running Tests</h2>
<h4>Running Tests is performed on different browsers via Maven profiles for each OS, and profiles for run smoke and regression tests on Google Chrome</h4>
<p>For instance:</p>
<h4>Smoke Testing</h4>
  <pre><code>
    mvn test -PSmokeTest
  </code></pre>

<h4>Regression testing</h4>
  <pre><code>
    mvn test -PRegressTest
  </code></pre>

<h4>Ubuntu Cross-Browser Testing</h4>
  <pre><code>
    mvn test -PUbuntuTest
  </code></pre>

  <h4>Windows Cross-Browser Testing</h4>
  <pre><code>
    mvn test -PWindowsTest
  </code></pre>

  <h4>MacOs Cross-Browser Testing</h4>
  <pre><code>
    mvn test -PMacosTest
  </code></pre>

<h2>GitHub Actions CI</h2>
  <p>This project uses GitHub Actions for Continuous Integration. </p>

<h2>Test Reporting</h2>
  <p>Test results are generated with Test Reporter for all operating systems, Allure Reports are generated for Ubuntu. Locally you can view the Allure report by running:</p>
  <pre><code>
    mvn allure:serve
  </code></pre>

<h2>Running the Tests Locally</h2>
<ol>
<li><strong>Clone the repository</strong>:
<pre><code>git clone https://github.com/Nostalgeek23/LUMAJavaSeleniumTestNGAllure.git
cd LUMAJavaSeleniumTestNGAllure
</code></pre>
</li>
<li><strong>Install dependencies</strong>:
<pre><code>mvn clean install
</code></pre>
</li>
<li><strong>Run the tests</strong>:
<pre><code>mvn test
</code></pre>
</li>
</ol>

