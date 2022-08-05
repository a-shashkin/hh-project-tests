package com.simbirsoft.tests;

import com.simbirsoft.pages.MainPage;
import com.simbirsoft.pages.SearchResultPage;
import org.junit.jupiter.api.Test;

public class JobSearchTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    void checkThatFirstResultContainsQuery() {
        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob("Разработчик");
        searchResultPage.checkFirstJobInResults("Разработчик");
    }

    @Test
    void checkThatSpecificResultContainsQuery() {
        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob("Разработчик");
        searchResultPage.checkCertainJobInResults(3, "Разработчик");
    }
}
