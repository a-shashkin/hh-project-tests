package com.simbirsoft.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    private SelenideElement searchField = $("a11y-search-input");
    private SelenideElement searchButton = $(byText("Найти")).parent();
    private SelenideElement advancedSearchButton = $x("//*[@data-qa='advanced-search']");
    private ElementsCollection jobNamesCollection = $$("h3.bloko-header-section-3");

    public SearchResultPage checkFirstJobInResults(String searchRequest) {
        jobNamesCollection.get(0).shouldHave(Condition.text(searchRequest));
        return this;
    }

    public SearchResultPage checkCertainJobInResults(int number, String searchRequest) {
        jobNamesCollection.get(number).shouldHave(Condition.text(searchRequest));
        return this;
    }
}
