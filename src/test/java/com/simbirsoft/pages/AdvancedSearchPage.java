package com.simbirsoft.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdvancedSearchPage {

    private SelenideElement boldHeader = $(".bloko-header-1");
    private SelenideElement keywordField = $x("//*[@data-qa='vacancysearch__keywords-input']");
    private SelenideElement vacancyNameCheckbox = $(byText("в названии вакансии")).parent();
    private SelenideElement companyNameCheckbox = $(byText("в названии вакансии")).parent();
    private SelenideElement vacancyDescriptionCheckbox = $(byText("в названии вакансии")).parent();
    private SelenideElement searchLanguageDescriptionLink = $(byText("Описание языка поисковых запросов")).parent();
    private SelenideElement specializations = $(byText("Указать специализации")).preceding(0);
    private SelenideElement selectSpecializationsLink = $x("//*[@data-qa='resumesearch__profroles-switcher']");
    private SelenideElement industry = $(byText("Указать отрасль компании")).preceding(0).$("HH-Employer-Industries-ShowIfZeroFields");
    private SelenideElement selectIndustryLink = $x("//*[@data-qa='industry-addFromList']");
    private SelenideElement regionSearchField = $x("//*[@data-qa='resumes-search-region-add']");
    private SelenideElement salaryNumberField = $x("//*[@data-qa='vacancysearch__compensation-input']");
    private SelenideElement salaryCurrencyField = $x("//*[@data-qa='vacancysearch__compensation-currency']");
    private SelenideElement searchOnlySetSalaryCheckbox = $x("//*[@data-qa='vacancysearch__only-with-compensation']");
    private SelenideElement experienceDoesNotMatterRadiobutton = $x("//*[@data-qa='vacancysearch__experience-item_doesNotMatter']");
    private SelenideElement noExperienceRadiobutton = $x("//*[@data-qa='vacancysearch__experience-item_doesNotMatter']");
    private SelenideElement oneToThreeYearsExperienceRadiobutton = $x("//*[@data-qa='vacancysearch__experience-item_doesNotMatter']");
    private SelenideElement threeToSixYearsExperienceRadiobutton = $x("//*[@data-qa='vacancysearch__experience-item_doesNotMatter']");
    private SelenideElement moreThanSixYearsExperienceRadiobutton = $x("//*[@data-qa='vacancysearch__experience-item_doesNotMatter']");
    private SelenideElement fullTimeEmploymentCheckbox = $x("//*[@data-qa='vacancysearch__employment-item_full']");
    private SelenideElement partTimeEmploymentCheckbox = $x("//*[@data-qa='vacancysearch__employment-item_part']");
    private SelenideElement projectEmploymentCheckbox = $x("//*[@data-qa='vacancysearch__employment-item_project']");
    private SelenideElement volunteerEmploymentCheckbox = $x("//*[@data-qa='vacancysearch__employment-item_volunteer']");
    private SelenideElement internshipEmploymentCheckbox = $x("//*[@data-qa='vacancysearch__employment-item_probation']");
}
