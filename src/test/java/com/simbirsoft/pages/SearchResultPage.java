package com.simbirsoft.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {

    private SelenideElement searchField = $("a11y-search-input");
    private SelenideElement searchButton = $(byText("Найти")).parent();
    private SelenideElement advancedSearchButton = $x("//*[@data-qa='advanced-search']");
}
