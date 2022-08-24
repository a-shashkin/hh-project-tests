package com.simbirsoft.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    private SelenideElement searchField = $("#a11y-search-input");
    private SelenideElement searchButton = $(byText("Найти")).parent();
    private SelenideElement advancedSearchButton = $x("//*[@data-qa='advanced-search']");
    private SelenideElement vacanciesTab = $x("//*[@data-hh-tab-id='searchVacancy']");
    private SelenideElement resumesTab = $x("//*[@data-hh-tab-id='resumeSearch']");
    private SelenideElement employersTab = $x("//*[@data-hh-tab-id='employersList']");
    private SelenideElement mainBoldHeader = $x("//*[@data-qa='vacancies-catalog-header']");
    private ElementsCollection vacancyCityCollection = $$x("//*[@data-qa='vacancy-serp__vacancy-address']");
    private ElementsCollection jobNamesCollection = $$("h3.bloko-header-section-3");
    private ElementsCollection tagsCollection = $$("a.bloko-chips-chip-link");
    private ElementsCollection salariesCollection = $$("span.bloko-header-section-3");

    @Step("Проверить присутствие важных элементов: поле поиска, кнопка поиска, кнопка расширенного поиска, вкладка \"Вакансии\", вкладка \"Резюме\", " +
            "вкладка \"Работодатели\", полужирный заголовок, результаты поиска (название вакансий, теги, зарплаты)")
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

    @Step("Проверить, что первая вакансия соответствует запросу {searchRequest}")
    public SearchResultPage checkFirstJobInResults(String searchRequest, String possibleSynonym) {
        if (!(jobNamesCollection.get(0).text().equals(searchRequest))) {
            jobNamesCollection.get(0).shouldHave(Condition.text(possibleSynonym));
            return this;
        }
        jobNamesCollection.get(0).shouldHave(Condition.text(searchRequest));
        return this;
    }

    @Step("Проверить, что вакансия с порядковым номером {number + 1} соответствует запросу {searchRequest}")
    public SearchResultPage checkCertainJobInResults(int number, String searchRequest) {
        jobNamesCollection.get(number).shouldHave(Condition.text(searchRequest));
        return this;
    }

    @Step("Проверить выдачу вакансии при смене места проживания с {preselectedCity} на {targetCity}")
    public SearchResultPage changeCityAndCheck(String preselectedCity, String targetCity) {
        $(byText("Регион")).scrollIntoView(true);
        $$x("//*[@data-qa='serp__novafilter-title']").findBy(Condition.text(preselectedCity)).click();
        $$x("//*[@data-qa='serp__novafilter-title']").findBy(Condition.text(targetCity)).click();
        vacancyCityCollection.filter(Condition.matchText(targetCity)).shouldBe(sizeGreaterThan(0));
        vacancyCityCollection.filter(Condition.matchText(preselectedCity)).shouldBe(empty);
        return this;
    }
}
