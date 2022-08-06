package com.simbirsoft.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    private SelenideElement searchField = $("a11y-search-input");
    private SelenideElement searchButton = $(byText("Найти")).parent();
    private SelenideElement advancedSearchButton = $x("//*[@data-qa='advanced-search']");
    private SelenideElement vacanciesTab = $x("//*[@data-hh-tab-id='searchVacancy']");
    private SelenideElement resumesTab = $x("//*[@data-hh-tab-id='resumeSearch']");
    private SelenideElement employersTab = $x("//*[@data-hh-tab-id='employersList']");
    private SelenideElement mainBoldHeader = $x("//*[@data-qa='vacancies-catalog-header']");
    private ElementsCollection jobNamesCollection = $$("h3.bloko-header-section-3");
    private ElementsCollection tagsCollection = $$("a.cluster-tag");
    private ElementsCollection salariesCollection = $$("a.cluster-tag");

    public SearchResultPage checkPresenceOfVitalElements() {
        searchField.shouldBe(Condition.visible);
        searchButton.shouldBe(Condition.visible);
        advancedSearchButton.shouldBe(Condition.visible);
        vacanciesTab.shouldBe(Condition.visible);
        resumesTab.shouldBe(Condition.visible);
        employersTab.shouldBe(Condition.visible);
        mainBoldHeader.shouldBe(Condition.visible);
        jobNamesCollection.shouldHave(CollectionCondition.sizeGreaterThan(0));
        tagsCollection.shouldHave(CollectionCondition.sizeGreaterThan(0));
        salariesCollection.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public SearchResultPage checkFirstJobInResults(String searchRequest) {
        jobNamesCollection.get(0).shouldHave(Condition.text(searchRequest));
        return this;
    }

    public SearchResultPage checkCertainJobInResults(int number, String searchRequest) {
        jobNamesCollection.get(number).shouldHave(Condition.text(searchRequest));
        return this;
    }
}
