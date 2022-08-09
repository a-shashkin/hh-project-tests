package com.simbirsoft.tests;

import com.simbirsoft.pages.MainPage;
import com.simbirsoft.pages.SearchResultPage;
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

    @ValueSource(strings = {
        "Разработчик"
    })
    @ParameterizedTest
    @Tag("job_search_tests")
    @Story("Поиск вакансии")
    @DisplayName("Проверка возврата запрашиваемой вакансии в первом результате")
    void checkThatFirstResultContainsQuery(String searchRequest) {
        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob(searchRequest);
        searchResultPage.checkFirstJobInResults(searchRequest);
    }

    @CsvSource(value = {
            "3, Разработчик"
    })
    @ParameterizedTest
    @Tag("job_search_tests")
    @Story("Поиск вакансии")
    @DisplayName("Проверка возврата запрашиваемой вакансии в заданном результате")
    void checkThatSpecificResultContainsQuery(int number, String searchRequest) {
        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob(searchRequest);
        searchResultPage.checkCertainJobInResults(number, searchRequest);
    }

    @CsvSource(value = {
            "Ульяновск, У, Разработчик, Ульяновск, Димитровград"
    })
    @ParameterizedTest
    @Tag("job_search_tests")
    @Story("Поиск вакансии")
    @DisplayName("Проверка возврата запрашиваемой вакансии после смены города")
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
