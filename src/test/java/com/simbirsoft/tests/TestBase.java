package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.config.CredentialsConfig;
import com.simbirsoft.tests.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        String browserSize = System.getProperty("browserSize", "1920x1080");
        String browser = System.getProperty("browser", "chrome");
        String baseUrl = System.getProperty("baseUrl", "https://hh.ru");
        String browserVersion = System.getProperty("browserVersion", "99");

        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;

        String email = credentials.email();
        String password = credentials.password();
        String remoteBrowserUser = credentials.remoteBrowserUser();
        String remoteBrowserPassword = credentials.remoteBrowserPassword();
        String browserURL = System.getProperty("url", credentials.remoteBrowserURL());
        Configuration.remote = format("https://%s:%s@%s", remoteBrowserUser, remoteBrowserPassword, browserURL);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Последний скриншот");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
