package com.simbirsoft.tests;

import com.simbirsoft.pages.MainPage;
import com.simbirsoft.pages.SearchResultPage;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Feature("Поиск вакансии на сайте")
@Owner("Alexander Shashkin")
public class JobSearchTest extends TestBase {

    MainPage mainPage = new MainPage();

    @CsvSource(value = {
        "Разработчик, Developer"
    })
    @ParameterizedTest
    @Tag("job_search_tests")
    @Story("Поиск вакансии")
    @DisplayName("Проверка возврата запрашиваемой вакансии в первом результате")
    @AllureId("11871")
    void checkThatFirstResultContainsQuery(String searchRequest, String possibleSynonym) {
        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob(searchRequest);
        searchResultPage.checkFirstJobInResults(searchRequest, possibleSynonym);
    }

    @CsvSource(value = {
            "3, Разработчик, Developer"
    })
    @ParameterizedTest
    @Tag("job_search_tests")
    @Story("Поиск вакансии")
    @DisplayName("Проверка возврата запрашиваемой вакансии в заданном результате")
    @AllureId("11872")
    void checkThatSpecificResultContainsQuery(int number, String searchRequest, String possibleSynonym) {
        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob(searchRequest);
        searchResultPage.checkCertainJobInResults(number, searchRequest, possibleSynonym);
    }

    @CsvSource(value = {
            "Ульяновск, У, Разработчик, Ульяновск, Димитровград"
    })
    @ParameterizedTest
    @Tag("job_search_tests")
    @Story("Поиск вакансии")
    @DisplayName("Проверка возврата запрашиваемой вакансии после смены населённого пункта")
    @AllureId("11873")
    void changeCityAndCheckItsPresence(String desiredRegion,
                                       String firstLetterOfRegion,
                                       String searchRequest,
                                       String preselectedCity,
                                       String targetCity
    ) {
        mainPage.openPage()
                .switchToDesiredRegion(desiredRegion, firstLetterOfRegion);
        SearchResultPage searchResultPage = mainPage.searchJob(searchRequest);
        searchResultPage.changeCityAndCheck(preselectedCity, targetCity);
    }

}
