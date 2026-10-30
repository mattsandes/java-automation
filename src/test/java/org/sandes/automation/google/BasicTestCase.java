package org.sandes.automation.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTestCase {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();

        if("true".equals(System.getenv("CI"))) {
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        }

        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void shouldOpenGooglePage() {
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());
    }
}
