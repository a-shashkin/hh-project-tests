package com.simbirsoft.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;

public class AdvancedSearchPage {

    private SelenideElement boldHeader = $(".bloko-header-1");
    private SelenideElement keywordField = $x("//*[@data-qa='vacancysearch__keywords-input']");
    private SelenideElement vacancyNameCheckbox = $(byText("в названии вакансии")).parent();
    private SelenideElement companyNameCheckbox = $(byText("в названии вакансии")).parent();
    private SelenideElement vacancyDescriptionCheckbox = $(byText("в названии вакансии")).parent();
    private SelenideElement searchLanguageDescriptionLink = $(byText("Описание языка поисковых запросов")).parent();
    private SelenideElement specializations = $(byText("Указать специализации")).preceding(0);
    private SelenideElement selectSpecializationsLink = $x("//*[@data-qa='resumesearch__profroles-switcher']");
    private SelenideElement industry = $(byText("Указать отрасль компании")).preceding(0).$(byText("Любая"));
    private SelenideElement selectIndustryLink = $x("//*[@data-qa='industry-addFromList']");
    private SelenideElement regionSearchField = $x("//*[@data-qa='resumes-search-region-add']");
    private SelenideElement regionSelectButton = $x("//*[@data-qa='resumes-search-region-selectFromList']");
    private SelenideElement salaryNumberField = $x("//*[@data-qa='vacancysearch__compensation-input']");
    private SelenideElement salaryCurrencyField = $x("//*[@data-qa='vacancysearch__compensation-currency']");
    private SelenideElement searchOnlySetSalaryCheckbox = $x("//*[@name='only_with_salary']");

    private SelenideElement submitButton = $("#submit-bottom");
    private SelenideElement modalWindow = $("div.bloko-modal");
    private SelenideElement closeModalWindowButton = $("div.bloko-modal-close-button");
    private SelenideElement searchInModalWindow = $("div.bloko-modal").$(".bloko-input");
    private SelenideElement cancelButtonModalWindow = $("div.bloko-modal").$(byText("Отменить"));
    private SelenideElement chooseButtonModalWindow = $("div.bloko-modal").$(byText("Выбрать"));
    private ElementsCollection expandChevronsModalWindow = $("div.bloko-modal").$$(".bloko-icon");
    private ElementsCollection checkboxesModalWindow = $("div.bloko-modal").$$(".bloko-checkbox__text");
    private ElementsCollection offeredRegions = $$("li.suggest__item.Bloko-Suggest-Item");

    @Step("Проверить присутствие элементов на странице")
    public AdvancedSearchPage checkPresenceOfVitalElements() {
        boldHeader.should(Condition.exist);
        keywordField.should(Condition.exist);
        vacancyNameCheckbox.should(Condition.exist);
        companyNameCheckbox.should(Condition.exist);
        vacancyDescriptionCheckbox.should(Condition.exist);
        searchLanguageDescriptionLink.should(Condition.exist);
        specializations.should(Condition.exist);
        selectSpecializationsLink.should(Condition.exist);
        industry.should(Condition.exist);
        selectIndustryLink.should(Condition.exist);
        regionSearchField.should(Condition.exist);
        regionSelectButton.should(Condition.exist);
        salaryNumberField.should(Condition.exist);
        salaryCurrencyField.should(Condition.exist);
        searchOnlySetSalaryCheckbox.should(Condition.exist);
        submitButton.should(Condition.exist);
        return this;
    }

    @Step("Проверить присутствие элементов в модальном окне выбора специализации")
    public AdvancedSearchPage checkSpecializationsModalWindowElements() {
        selectSpecializationsLink.click();
        modalWindow.shouldBe(Condition.visible);
        closeModalWindowButton.shouldBe(Condition.visible);
        searchInModalWindow.shouldBe(Condition.visible);
        cancelButtonModalWindow.shouldBe(Condition.visible);
        chooseButtonModalWindow.shouldBe(Condition.visible);
        expandChevronsModalWindow.shouldBe(CollectionCondition.sizeGreaterThan(0));
        expandChevronsModalWindow.get(0).shouldBe(Condition.visible);
        checkboxesModalWindow.shouldBe(CollectionCondition.sizeGreaterThan(0));
        checkboxesModalWindow.get(0).shouldBe(Condition.visible);
        closeModalWindowButton.click();
        return this;
    }

    @Step("Проверить присутствие элементов в модальном окне выбора отрасли")
    public AdvancedSearchPage checkIndustriesModalWindowElements() {
        selectIndustryLink.click();
        modalWindow.shouldBe(Condition.visible);
        closeModalWindowButton.shouldBe(Condition.visible);
        searchInModalWindow.shouldBe(Condition.visible);
        cancelButtonModalWindow.shouldBe(Condition.visible);
        chooseButtonModalWindow.shouldBe(Condition.visible);
        expandChevronsModalWindow.shouldBe(CollectionCondition.sizeGreaterThan(0));
        expandChevronsModalWindow.get(0).shouldBe(Condition.visible);
        checkboxesModalWindow.shouldBe(CollectionCondition.sizeGreaterThan(0));
        checkboxesModalWindow.get(0).shouldBe(Condition.visible);
        closeModalWindowButton.click();
        return this;
    }

    @Step("Проверить присутствие элементов в модальном окне выбора региона")
    public AdvancedSearchPage checkRegionsModalWindowElements() {
        regionSelectButton.click();
        modalWindow.shouldBe(Condition.visible);
        closeModalWindowButton.shouldBe(Condition.visible);
        searchInModalWindow.shouldBe(Condition.visible);
        cancelButtonModalWindow.shouldBe(Condition.visible);
        chooseButtonModalWindow.shouldBe(Condition.visible);
        expandChevronsModalWindow.shouldBe(CollectionCondition.sizeGreaterThan(0));
        expandChevronsModalWindow.get(0).shouldBe(Condition.visible);
        checkboxesModalWindow.shouldBe(CollectionCondition.sizeGreaterThan(0));
        checkboxesModalWindow.get(0).shouldBe(Condition.visible);
        closeModalWindowButton.click();
        return this;
    }

    @Step("Проверить присутствие элементов после их выбора в модальном окне выбора специализации")
    public AdvancedSearchPage checkChosenSpecializations(String category, List<String> chosenSpecializations) {
        selectSpecializationsLink.click();
        $(byText(category)).parent().preceding(0).scrollIntoView(true).click();
        Iterator<String> iterator = chosenSpecializations.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            $(byText(next)).parent().scrollIntoView(true).click();
        }
        chooseButtonModalWindow.click();
        modalWindow.shouldBe(Condition.hidden);
        while (iterator.hasNext()) {
            String next = iterator.next();
            $(byText(next)).shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Проверить присутствие элементов после их выбора в модальном окне выбора отрасли")
    public AdvancedSearchPage checkChosenIndustries(String category, List<String> chosenIndustries) {
        selectIndustryLink.click();
        $(byText(category)).parent().preceding(0).scrollIntoView(true).click();
        Iterator<String> iterator = chosenIndustries.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            $(byText(next)).parent().scrollIntoView(true).click();
        }
        chooseButtonModalWindow.click();
        modalWindow.shouldBe(Condition.hidden);
        while (iterator.hasNext()) {
            String next = iterator.next();
            $(byText(next)).shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Проверить присутствие элементов после их выбора в модальном окне выбора региона")
    public AdvancedSearchPage checkChosenRegions(String country, String region, List<String> chosenRegions) {
        if ($x("//*[@data-qa='searchform__selected-regions']").$(byTitle("Ульяновск")).is(Condition.visible)) {
            $x("//*[@data-qa='searchform__selected-regions']").$(byTitle("Ульяновск")).sibling(0).click();
        }
        regionSelectButton.click();
        $(byText(country)).parent().preceding(0).scrollIntoView(true).click();
        $(byText(region)).parent().preceding(0).scrollIntoView(true).click();
        Iterator<String> iterator = chosenRegions.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            modalWindow.$(byText(next)).parent().scrollIntoView(true).click();
        }
        chooseButtonModalWindow.click();
        modalWindow.shouldBe(Condition.hidden);
        while (iterator.hasNext()) {
            String next = iterator.next();
            $(byText(next)).shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Проверить присутствие элементов после их выбора через строку поиска")
    public AdvancedSearchPage typeRegionsAndCheck(List<String> chosenRegions) {
        if ($x("//*[@data-qa='searchform__selected-regions']").$(byTitle("Ульяновск")).is(Condition.visible)) {
            $x("//*[@data-qa='searchform__selected-regions']").$(byTitle("Ульяновск")).sibling(0).click();
        }
        Iterator<String> iterator = chosenRegions.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            regionSearchField.sendKeys(next.substring(0, next.length() - 3));
            offeredRegions.findBy(Condition.text(next)).click();
        }
        while (iterator.hasNext()) {
            String next = iterator.next();
            $(byText(next)).shouldBe(Condition.visible);
        }
        return this;
    }
}
