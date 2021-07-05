package guru.ga.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

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
        $("#firstName").setValue("Serega");
        $("#lastName").setValue("Borisoglebsky");
        $("#userEmail").setValue("SBorisoglebsky@gmail.com");

       // $("input[id=gender-radio-1]").setSelected(true);
       // $x("//input[@id='gender-radio-1']").isEnabled();
        $(byText("Male")).click();
        //.custom-radio:nth-child(3)>.custom-control-label

        $("#userNumber").setValue("123456789");
       // $("#dateOfBirthInput").setValue("30 Jan 1976");
        //.react-datepicker__month-container.selectOptions("April");


        $("#subjectsContainer").click();

        var sub = $("#subjectsContainer").getValue();
        System.out.println("var = "+sub);

        $("#subjectsInput").setValue("QA.GURU");
        //$("#subjectsContainer:nth-child(2)").setValue("QA.GURU");

        $(byText("Music")).click();

        String dir = System.getProperty("user.dir");
        System.out.println("var = "+dir);

        $("#uploadPicture").uploadFile(new File("README.md"));
        $("#currentAddress").setValue("Moscow, Lenina street 2");

        String l = $("#stateCity-label").getText();
        System.out.println("label  = "+l);

        $("#state").scrollIntoView(false);

        $("#state > div").exists();
        //#state > div > div.css-1hwfws3

                //.setValue("Haryana");
        //#stateCity-label


        $("#lastName").setValue("Borisoglebsky");

    }


}
