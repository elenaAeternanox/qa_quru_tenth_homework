package com.github.elenaAeternanox.tenthHomeWork.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.elenaAeternanox.tenthHomeWork.config.EnvironmentConfig;
import com.github.elenaAeternanox.tenthHomeWork.helpers.Attach;
import com.github.elenaAeternanox.tenthHomeWork.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.*;

public class TestBase {

    public static EnvironmentConfig credentials = ConfigFactory.create(EnvironmentConfig.class);
    RegistrationPage registrationPage = new RegistrationPage();

    private static String login = credentials.login();
    private static String password = credentials.password();
    private static String selenoidUrl = System.getProperty("URL");

    private static String remoteUrl = String.format("https://%s:%s@%s", login, password, selenoidUrl);

    @BeforeAll
    public static void setup() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        startMaximized = true;
        remote = remoteUrl;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
