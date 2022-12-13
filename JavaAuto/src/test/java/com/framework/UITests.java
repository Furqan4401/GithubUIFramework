package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UITests {

    @Test
    void userNameIsCorrectOnProfile() {

        System.setProperty("chromedriver_win32 (1)", "C:\\Users\\furqan.Yasin\\OneDrive - Jumar Solutions\\Documents");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String user = "Furqan4401";
        driver.get("https://github.com/Furqan4401");

        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        Assertions.assertEquals(user, actualUserName);

        driver.close();

    }


    @Test
    public void repoLinkGoesToCorrectRepo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String user = "Furqan4401";
        driver.get("https://github.com/" + user);
        String repo = "MouseMover";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        TimeUnit.SECONDS.sleep(1);
        String expectedURL = "https://github.com/Furqan4401/MouseMover";
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL);
        driver.close();
    }



    @Test
    void findNumberOfRepositories() {
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        // Navigate to the user's repository page.
        driver.get("https://github.com/Furqan4401?tab=repositories");

        // Find the repository count element on the page.
        WebElement repositoryCountElement = driver.findElement(By.className("Counter"));

        // Get the repository count from the element.
        String repositoryCountString = repositoryCountElement.getText();
        int repositoryCount = Integer.parseInt(repositoryCountString);

        // Print the repository count.
        System.out.println("Repository count: " + repositoryCount);

        // Close the current window.
        driver.close();
    }


    @Test
    void projectSectionisClickable() {
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navigate to the user's repository page.
        driver.get("https://github.com/Furqan4401");

        String projects = "Projects";
        WebElement projectElement = driver.findElement(By.linkText(projects));
        projectElement.click();

        ExpectedConditions.elementToBeClickable(By.linkText(projects));

         driver.close();
    }



    }























