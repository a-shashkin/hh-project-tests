package com.simbirsoft.tests;

import com.simbirsoft.pages.MainPage;
import com.simbirsoft.pages.SearchResultPage;
import org.junit.jupiter.api.Test;

public class ElementPresenceTest {

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
}
