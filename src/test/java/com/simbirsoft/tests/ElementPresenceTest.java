package com.simbirsoft.tests;

import com.simbirsoft.pages.AdvancedSearchPage;
import com.simbirsoft.pages.MainPage;
import com.simbirsoft.pages.SearchResultPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

@Feature("Проверка наличия элементов на страницах")
@Owner("Alexander Shashkin")
public class ElementPresenceTest extends TestBase {

    MainPage mainPage = new MainPage();

    static Stream<Arguments> selectSpecializationsAndCheckPresence() {
        return Stream.of(
                Arguments.of(
                    "Информационные технологии", List.of("Программист, разработчик", "Тестировщик")
                )
        );
    }

    static Stream<Arguments> selectIndustriesAndCheckPresence() {
        return Stream.of(
                Arguments.of(
                        "Информационные технологии, системная интеграция, интернет", List.of("Интернет-провайдер", "Разработка программного обеспечения")
                )
        );
    }

    static Stream<Arguments> selectRegionsAndCheckPresence() {
        return Stream.of(
                Arguments.of(
                        "Россия",
                        "Ульяновская область",
                        List.of("Ульяновск", "Димитровград", "Новоульяновск")
                )
        );
    }

    static Stream<Arguments> typeRegionsAndCheckPresence() {
        return Stream.of(
                Arguments.of(
                        List.of("Ульяновск", "Димитровград", "Новоульяновск")
                )
        );
    }

    @Test
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на главной странице")
    @DisplayName("Проверка наличия самых важных элементов")
    void checkElementsOnMainPage() {

        mainPage.openPage()
                .checkPresenceOfVitalElements();
    }

    @ValueSource(strings = {
            "Разработчик"
    })
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице результатов поиска")
    @DisplayName("Проверка наличия самых важных элементов (без учёта фильтров)")
    void checkElementsOnSearchResultPage(String searchRequest) {

        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob(searchRequest);
        searchResultPage.checkPresenceOfVitalElements();
    }

    @Test
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия самых важных элементов")
    void checkElementsOnAdvancedSearchPage() {

        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkPresenceOfVitalElements();
    }

    @Test
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия элементов в модальных окнах")
    void checkElementsInModalsOnAdvancedSearch() {

        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkSpecializationsModalWindowElements()
                          .checkIndustriesModalWindowElements()
                          .checkRegionsModalWindowElements();
    }

    @MethodSource("selectSpecializationsAndCheckPresence")
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия блоков специализаций после их выбора в модальных окнах")
    void selectSpecializationsAndCheckPresence(String category, List<String> chosenSpecializations) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkChosenSpecializations(category, chosenSpecializations);
    }

    @MethodSource("selectIndustriesAndCheckPresence")
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия блоков отраслей после их выбора в модальных окнах")
    void selectIndustriesAndCheckPresence(String category, List<String> chosenIndustries) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkChosenIndustries(category, chosenIndustries);
    }

    @MethodSource("selectRegionsAndCheckPresence")
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия блоков регионов после их выбора в модальных окнах")
    void selectRegionsAndCheckPresence(String country, String region, List<String> chosenRegions) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkChosenRegions(country, region, chosenRegions);
    }

    @MethodSource("typeRegionsAndCheckPresence")
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия блоков регионов после их выбора через печатание в строке поиска")
    void typeRegionsAndCheckPresence(List<String> chosenRegions) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.typeRegionsAndCheck(chosenRegions);
    }
}
