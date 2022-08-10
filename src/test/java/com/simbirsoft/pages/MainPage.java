package com.simbirsoft.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement regionHeader = $x("//*[@data-qa='mainmenu_areaSwitcher']");
    private SelenideElement forCandidatesHeader = $(byText("Соискателям"));
    private SelenideElement forEmployersHeader = $(byText("Соискателям"));
    private SelenideElement regionSearchInput = $("#area-search-input");
    private ElementsCollection regionSearchResults = $$("li.suggest__item");
    private SelenideElement hhSymbol = $(".supernova-logo-wrapper");
    private SelenideElement searchField = $("#a11y-search-input");
    private SelenideElement searchButton = $(byText("Найти работу")).parent();
    private SelenideElement advancedSearch = $x("//*[@data-qa='advanced-search']");
    private SelenideElement helpLink = $x("//*[@data-qa='mainmenu_help']");
    private SelenideElement createResumeButton = $x("//*[@data-qa='signup']");
    private SelenideElement signInButton = $x("//*[@data-qa='login']");
    private SelenideElement appStoreDownload = $("a.supernova-app-button_ios");
    private SelenideElement playMarketDownload = $("a.supernova-app-button_android");
    private SelenideElement huaweiAppGalleryDownload = $("a.supernova-app-button_huawei");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        hhSymbol.shouldBe(Condition.visible);
        return this;
    }

    @Step("Переключиться на регион {desiredRegion}, начинающийся на букву {firstLetterOfRegion}")
    public MainPage switchToDesiredRegion(String desiredRegion, String firstLetterOfRegion) {
        if ($(".supernova-navi-item_area-switcher-button").text().equals(desiredRegion)) {
            return this;
        }
        regionHeader.click();
        $(withText("городов")).click();
        $(byText(firstLetterOfRegion)).click();
        $$(".area-switcher-city").findBy(Condition.text(desiredRegion)).click();
        return this;
    }

    @Step("Проверить присутствие самых важных элементов: логотип, вкладка \"Соискателям\", вкладка \"Работодателям\", поле поиска, кнопка поиска, " +
            "кнопка расширенного поиска, ссылка \"Помощь\", кнопка регистрации, кнопка авторизации, кнопки загрузки мобильного приложения")
    public MainPage checkPresenceOfVitalElements() {
        hhSymbol.shouldBe(Condition.visible);
        forCandidatesHeader.shouldBe(Condition.visible);
        forEmployersHeader.shouldBe(Condition.visible);
        searchField.shouldBe(Condition.visible);
        searchButton.shouldBe(Condition.visible);
        advancedSearch.shouldBe(Condition.visible);
        helpLink.shouldBe(Condition.visible);
        createResumeButton.shouldBe(Condition.visible);
        signInButton.shouldBe(Condition.visible);
        appStoreDownload.shouldBe(Condition.visible);
        playMarketDownload.shouldBe(Condition.visible);
        huaweiAppGalleryDownload.shouldBe(Condition.visible);
        return this;
    }

    @Step("Сделать поиск вакансии \"{searchRequest}\"")
    public SearchResultPage searchJob(String searchRequest) {
        searchField.setValue(searchRequest);
        searchButton.click();
        return new SearchResultPage();
    }

    @Step("Открыть страницу расширенного поиска")
    public AdvancedSearchPage openAdvancedSearch() {
        advancedSearch.click();
        return new AdvancedSearchPage();
    }
}
