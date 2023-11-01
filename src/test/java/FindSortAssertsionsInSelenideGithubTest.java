import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSortAssertsionsInSelenideGithubTest {
    @BeforeAll
    static void beforeAll() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com/";
        //Configuration.pageLoadStrategy = "eager";
        //Configuration.timeout = 5000; // секунды

    }

    @Test
    void findSortAssertion(){


        //Откройте страницу Selenide в Github
        open("selenide/selenide");

        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        //Откройте страницу SoftAssertions
        $(".markdown-body ul li").sibling(6).$("a").click();

        //Проверьте что внутри есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").shouldHave(text("Junit5"));


    }
    @AfterAll
    static void clearCookies() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

}
