package com.simbirsoft.tests;

import com.simbirsoft.pages.AdvancedSearchPage;
import com.simbirsoft.pages.MainPage;
import com.simbirsoft.pages.SearchResultPage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementPresenceTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    void checkElementsOnMainPage() {

        mainPage.openPage()
                .checkPresenceOfVitalElements();
    }

    @Test
    void checkElementsOnSearchResultPage() {

        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob("Разработчик");
        searchResultPage.checkPresenceOfVitalElements();
    }

    @Test
    void checkElementsOnAdvancedSearchPage() {

        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkPresenceOfVitalElements();
    }

    @Test
    void checkElementsInModalsOnAdvancedSearch() {

        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkSpecializationsModalWindowElements()
                          .checkIndustriesModalWindowElements()
                          .checkRegionsModalWindowElements();
    }

    @Test
    void selectSpecializationsAndCheckPresence() {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        List<String> specializations = Arrays.asList("Программист, разработчик", "Тестировщик");
        advancedSearchPage.checkChosenSpecializations("Информационные технологии", specializations);
    }

    @Test
    void selectIndustriesAndCheckPresence() {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        List<String> industries = Arrays.asList("Интернет-провайдер", "Разработка программного обеспечения");
        advancedSearchPage.checkChosenIndustries("Информационные технологии, системная интеграция, интернет", industries);
    }
}
