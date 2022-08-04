package com.simbirsoft.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement hhSymbol = $(".supernova-logo-wrapper");
    private SelenideElement searchField = $("#a11y-search-input");
    private SelenideElement searchButton = $(byText("Найти работу")).parent();
    private SelenideElement advancedSearch = $x("//*[@data-qa='advanced-search']");

    public MainPage openPage() {
        open("");
        hhSymbol.shouldBe(Condition.visible);
        searchField.shouldBe(Condition.visible);
        return this;
    }

    public SearchResultPage searchJob(String searchRequest) {
        searchField.setValue(searchRequest);
        searchButton.click();
        return new SearchResultPage();
    }

    public AdvancedSearchPage openAdvancedSearch() {
        advancedSearch.click();
        return new AdvancedSearchPage();
    }
}
