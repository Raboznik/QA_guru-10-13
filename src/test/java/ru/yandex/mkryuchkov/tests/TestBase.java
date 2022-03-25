package ru.yandex.mkryuchkov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.yandex.mkryuchkov.config.CredentialsConfig;
import ru.yandex.mkryuchkov.helper.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {

    private static CredentialsConfig cfgs = ConfigFactory.create(CredentialsConfig.class);

    protected String baseUrl = "https://ayist.games/mainru";
    protected String facebook = "https://www.facebook.com/novelsgame/";
    protected String vk = "https://vk.com/novelsgame";
    protected String instagram = "https://www.instagram.com/novelsgame/";
    protected String email = "info@ayist.games";

    @BeforeAll
    static void setUp() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String size = System.getProperty("size", "1920x1080");

        Configuration.baseUrl = "https://demoqa.com";

        Configuration.remote = cfgs.url();
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.browserSize = size;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Version: ", version);
        Attach.attachAsText("Remote Url: ", cfgs.url());

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        sleep(5000);
        closeWebDriver();
    }

}