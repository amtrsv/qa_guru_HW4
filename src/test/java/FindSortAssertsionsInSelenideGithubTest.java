import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSortAssertsionsInSelenideGithubTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920X1000";

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
        $("#user-content-3-using-junit5-extend-test-class").scrollIntoView(true);
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


    }
    @AfterAll
    static void clearCookies() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

}
