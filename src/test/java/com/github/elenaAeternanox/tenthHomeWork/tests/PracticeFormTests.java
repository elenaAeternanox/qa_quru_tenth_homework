package com.github.elenaAeternanox.tenthHomeWork.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.github.elenaAeternanox.tenthHomeWork.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {

    private String birthdayCheck,
            listOfSubjects,
            listOfHobbies;

    @Tag("registration_page")
    @Test
    @DisplayName("Check Practice form on the 'https://demoqa.com/automation-practice-form' page")
    void fillFormTest() {
        step("Open Practice form", () -> {
            registrationPage
                    .openPage();
        });

        step("Fill the Practice form", () -> {
            step("Input first name, last name, email, gender and phone number", () -> {
                registrationPage
                        .typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(email)
                        .chooseGenderCheckbox(gender)
                        .typeMobile(phoneNumber);
            });
            step("Upload image", () -> {
                registrationPage
                        .selectPicture(pictureFileSource + fileName);
            });
            step("Set date in calendar", () -> {
                birthdayCheck = registrationPage.setBirthdayDate(birthdayDayMonthYear);
            });
            step("Set subject", () -> {
                listOfSubjects = registrationPage.setSubjects(subjectsNumber);
            });
            step("Set hobbies", () -> {
                listOfHobbies = registrationPage.setHobbies(hobbiesNumber);
            });
            step("Input address, state and city", () -> {
                registrationPage
                        .typeCurrentAddress(currentAddress)
                        .selectState(statePrefix, state)
                        .selectCity(cityPrefix, city);
            });
        });

        step("Click Submit button", () -> {
            registrationPage
                    .clickSubmitButton()
                    .checkResultsFormIsDisplayed();
        });

        step("Check fields on the result form", () -> {
            registrationPage
                    .checkResultsValue(rowStudentName, firstName + ' ' + lastName)
                    .checkResultsValue(rowStudentEmail, email)
                    .checkResultsValue(rowGender, gender)
                    .checkResultsValue(rowMobile, phoneNumber)
                    .checkResultsValue(rowDateOfBirth, birthdayCheck)
                    .checkResultsValue(rowSubjects, listOfSubjects)
                    .checkResultsValue(rowHobbies, listOfHobbies)
                    .checkResultsValue(rowPicture, fileName)
                    .checkResultsValue(rowAddress, currentAddress)
                    .checkResultsValue(rowStateAndCity, state + " " + city);
        });

        step("Close the result form", () -> {
            registrationPage
                    .clickCloseButton()
                    .checkResultsFormIsClosed();
        });
    }
}
