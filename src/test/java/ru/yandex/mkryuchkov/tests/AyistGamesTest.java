package ru.yandex.mkryuchkov.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class AyistGamesTest extends TestBase {


    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://ayist.games/mainru'", () ->
                open(baseUrl));

        step("Page title should have text 'AYIST GAMES: Главная страница'", () -> {
            String expectedTitle = "AYIST GAMES: Главная страница";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

//    @Test
//    @DisplayName("Page console log should not have errors")
//    void consoleShouldNotHaveErrorsTest() {
//        step("Open url 'https://ayist.games/mainru'", () ->
//                open(baseUrl));
//
//        step("Console logs should not contain text 'SEVERE'", () -> {
//            String consoleLogs = DriverUtils.getConsoleLogs();
//            String errorText = "SEVERE";
//
//            assertThat(consoleLogs).doesNotContain(errorText);
//        });
//    }

    @Test
    @DisplayName("Test for Privacy Policy")
    void privacyPolicyTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on privacy policy", () ->
                $$(".t389__typo").findBy(href("/privacypolicy")).scrollTo().click());

        step("Assert that privacy policy is opened", () ->
                $(".t-text_md").shouldBe(visible).shouldHave(text("Our Privacy Pledge")));
    }

    @Test
    @DisplayName("Test for terms of service")
    void termOfServiceTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on terms of service", () ->
                $$(".t389__typo").findBy(href("/termsofservice")).scrollTo().click());

        step("Assert that terms of service is opened", () ->
                $(".t-text_md").shouldBe(visible).shouldHave(text("1. About Us")));
    }


    @Test
    @DisplayName("Test for support")
    void supportTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on support button", () ->
                $$(".t389__typo").findBy(href("/support")).scrollTo().click());

        step("Assert that support page is opened", () ->
                $(".t-btn").shouldBe(visible).shouldHave(href("mailto:" + email)));
    }

    @Test
    @DisplayName("Test for link to VK group")
    void vkLinkTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on VK button", () ->
                $x("//*[@id=\"rec254263356\"]/div/div/div/div/div[2]/a")
                        .shouldHave(href(vk)).scrollTo().click());
        switchTo().window(1);

        step("Open VK group", () -> {
            String expectedTitle = "Novels - любовные истории | VK";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });

        step("Assert that VK group is opened", () ->
                $("#page_info_wrap")
                        .shouldHave(text("https://bit.ly/35FGbrg"))
                        .shouldHave(text("https://apps.apple.com/ru/app/id1484653933"))
                        .shouldHave(text("www.ayist.games")));
    }

    @Disabled
    @Test
    @DisplayName("Test for link to facebook group")
    void facebookLinkTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on facebook button", () ->
                $x("//*[@id=\"rec254263356\"]/div/div/div/div/div[1]/a")
                        .shouldHave(href(facebook)).scrollTo().click());
        switchTo().window(1);

        //TODO just waiting for facebook to be unblocked. Then add locators and assertions

        step("Open facebook group", () -> {
            String expectedTitle = "Novels - любовные истории | VK";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });

        step("Assert that facebook group is opened", () ->
                $("#page_info_wrap")
                        .shouldHave(text("https://bit.ly/35FGbrg"))
                        .shouldHave(text("https://apps.apple.com/ru/app/id1484653933"))
                        .shouldHave(text("www.ayist.games")));
    }

    @Disabled
    @Test
    @DisplayName("Test for link to instagram group")
    void instagramLinkTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on instagram button", () ->
                $x("//*[@id=\"rec254263356\"]/div/div/div/div/div[3]/a")
                        .shouldHave(href(instagram)).scrollTo().click());
        switchTo().window(1);

        //TODO just waiting for instagram to be unblocked. Then add locators and assertions

        step("Open instagram group", () -> {
            String expectedTitle = "Novels - любовные истории | VK";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });

        step("Assert that instagram group is opened", () ->
                $("#page_info_wrap")
                        .shouldHave(text("https://bit.ly/35FGbrg"))
                        .shouldHave(text("https://apps.apple.com/ru/app/id1484653933"))
                        .shouldHave(text("www.ayist.games")));
    }

    @Test
    @DisplayName("Test for onelink button")
    void oneLinkTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Assert App Store and Google play refs", () ->
                $(".t392__btn").shouldBe(visible));
        $x("//*[@id=\"rec198332295\"]/div/div/div[2]/div[1]").scrollTo().click();

        step("Assert that page is opened", () -> {
            String expectedTitle = "Novels: Choices Do Matter on the App Store";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Test for scroll to top button")
    void scrollToTopTest() {

        step("Open main page", () ->
                open(baseUrl));

        step("Assert that button not visible", () -> {
            $(".t389__typo t-name t-name_xs t389_scrolltop").shouldNotBe(visible);
        });

        step("Click on button", () -> {
            $(".t389_scrolltop").scrollTo().click();
            $(".t478__blockimg").shouldBe(visible);
        });

    }

    @Test
    @DisplayName("Test for careers page")
    void careersPageTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on support button", () ->
                $$(".t-menu__link-item").findBy(href("/careersru")).click());

        step("Assert that vacancies exist", () ->
                $$(".t-col_8").should(sizeGreaterThan(0)));

        step("Assert that send resume button is exist", () ->
                $(".t580__btn").scrollTo().shouldBe(visible)).shouldHave(href("mailto:" + email));
    }

    @Test
    @DisplayName("Test for contacts page")
    void contactsPageTest() {
        step("Open main page", () ->
                open(baseUrl));

        step("Click on contacts button", () ->
                $$(".t-menu__link-item").findBy(href("/contactsru")).click());

        step("Check email", () ->
                $x("//*[@id=\"rec254241807\"]/div/div/div/div[2]/div/a")
                        .shouldBe(visible)
                        .shouldHave(href("mailto:mailto:" + email)));

        step("Check socials link", () ->
                $(".t-sociallinks__wrapper").shouldBe(visible));

        step("Check facebook link", () ->

                $x("//*[@id=\"rec254241807\"]/div/div/div/div[1]/div/div[1]/a")
                        .shouldHave(href(facebook)));

        step("Check VK link", () ->
                $x("//*[@id=\"rec254241807\"]/div/div/div/div[1]/div/div[2]/a")
                        .shouldHave(href(vk)));

        step("Check instagram link", () ->
                $x("//*[@id=\"rec254241807\"]/div/div/div/div[1]/div/div[3]/a")
                        .shouldHave(href(instagram)));


    }

}



