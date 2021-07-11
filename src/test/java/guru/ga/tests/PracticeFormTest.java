package guru.ga.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.security.Key;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest(){
        open("/automation-practice-form");
        String eMail = "SBorisoglebsky@gmail.com";
        String phoneNumber ="9165556677";

        $("#firstName").setValue("Serega");
        $("#lastName").setValue("Borisoglebsky");
        $("#userEmail").setValue(eMail);

        $(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);

        //BirthDay
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1976");
        $(".react-datepicker__day--010").click();

        //Subject
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $(byText("Music")).click();

        String dir = System.getProperty("user.dir");
        System.out.println("var = "+dir);

        $("#uploadPicture").uploadFile(new File("README.md"));
        $("#currentAddress").setValue("Moscow, Lenina street 2");

        $("#submit").scrollIntoView(false);

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $("tbody").$(byText("Student Name")).parent().shouldHave(text("Serega Borisoglebsky"));
        $("tbody").$(byText("Student Email")).parent().shouldHave(text(eMail));
        $("tbody").$(byText("Gender")).parent().shouldHave(text("Male"));
        $("tbody").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        $("tbody").$(byText("Date of Birth")).parent().shouldHave(text("10 January,1976"));
        $("tbody").$(byText("Subjects")).parent().shouldHave(text("Hindi"));
        $("tbody").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $("tbody").$(byText("Picture")).parent().shouldHave(text("README.md"));
        $("tbody").$(byText("Address")).parent().shouldHave(text("Moscow, Lenina street 2"));
        $("tbody").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));

    }

}
