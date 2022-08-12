package com.simbirsoft.tests;

import com.simbirsoft.pages.AdvancedSearchPage;
import com.simbirsoft.pages.MainPage;
import com.simbirsoft.pages.SearchResultPage;
import io.qameta.allure.AllureId;
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
    @DisplayName("Проверка наличия самых важных элементов на главной странице")
    @AllureId("11863")
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
    @DisplayName("Проверка наличия самых важных элементов на странице результата поиска (без фильтров)")
    @AllureId("11864")
    void checkElementsOnSearchResultPage(String searchRequest) {

        mainPage.openPage();
        SearchResultPage searchResultPage = mainPage.searchJob(searchRequest);
        searchResultPage.checkPresenceOfVitalElements();
    }

    @Test
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия самых важных элементов на странице расширенного поиска")
    @AllureId("11865")
    void checkElementsOnAdvancedSearchPage() {

        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkPresenceOfVitalElements();
    }

    @Test
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия элементов в модальных окнах на странице расширенного поиска")
    @AllureId("11866")
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
    @DisplayName("Проверка наличия блоков специализаций на странице расширенного поиска после их выбора в модальном окне")
    @AllureId("11867")
    void selectSpecializationsAndCheckPresence(String category, List<String> chosenSpecializations) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkChosenSpecializations(category, chosenSpecializations);
    }

    @MethodSource("selectIndustriesAndCheckPresence")
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия блоков отраслей на странице расширенного поиска после их выбора в модальном окне")
    @AllureId("11868")
    void selectIndustriesAndCheckPresence(String category, List<String> chosenIndustries) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkChosenIndustries(category, chosenIndustries);
    }

    @MethodSource("selectRegionsAndCheckPresence")
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия блоков регионов на странице расширенного поиска после их выбора в модальном окне")
    @AllureId("11869")
    void selectRegionsAndCheckPresence(String country, String region, List<String> chosenRegions) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.checkChosenRegions(country, region, chosenRegions);
    }

    @MethodSource("typeRegionsAndCheckPresence")
    @ParameterizedTest
    @Tag("element_presence_tests")
    @Story("Проверка наличия элементов на странице расширенного поиска")
    @DisplayName("Проверка наличия блоков регионов на странице расширенного поиска после их выбора через печатание в строке поиска")
    @AllureId("11870")
    void typeRegionsAndCheckPresence(List<String> chosenRegions) {
        mainPage.openPage();
        AdvancedSearchPage advancedSearchPage = mainPage.openAdvancedSearch();
        advancedSearchPage.typeRegionsAndCheck(chosenRegions);
    }
}
