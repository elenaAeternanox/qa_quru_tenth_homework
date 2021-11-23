package com.github.elenaAeternanox.tenthHomeWork.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    private SelenideElement dateInput = $("#dateOfBirthInput");

    public void setDate(String day, String month, String year) {
        dateInput.click();

        $(byClassName("react-datepicker__year-select")).selectOption(year);
        $(byClassName("react-datepicker__month-select")).selectOption(month);
        $x("//div[text()='" + day + "' and (contains(@aria-label,'" + month + "'))]").click();
    }

}
