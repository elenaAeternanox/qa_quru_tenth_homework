package com.github.elenaAeternanox.tenthHomeWork.tests;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    private static String generateGender(int randomNumber) {
        String genderRandom = null;
        switch (randomNumber) {
            case 0:
                genderRandom = "Male";
                break;
            case 1:
                genderRandom = "Female";
                break;
            case 2:
                genderRandom = "Other";
                break;
        }
        return genderRandom;
    }

    private static String generateHobby(int randomHobbie) {
        String hobbyRandom = null;
        switch (randomHobbie) {
            case 1:
                hobbyRandom = "Sports";
                break;
            case 2:
                hobbyRandom = "Reading";
                break;
            case 3:
                hobbyRandom = "Music";
                break;
        }
        return hobbyRandom;
    }

    private static List<String> setBirthdayDate() {
        Date startDate = Date.from(LocalDate.now().minusYears(120).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(LocalDate.now().minusYears(8).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date birthdayDate = faker.date().between(startDate, endDate);
        LocalDate birthday = birthdayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String
                birthdayYear = String.valueOf(birthday.getYear()),
                birthdayMonthUpperCase = String.valueOf(birthday.getMonth()),
                birthdayMonth = birthdayMonthUpperCase.substring(0, 1) + birthdayMonthUpperCase.substring(1).toLowerCase(),
                birthdayDay = String.valueOf(birthday.getDayOfMonth());
        return Arrays.asList(birthdayDay, birthdayMonth, birthdayYear);
    }

    public static int subjectsNumber = faker.number().numberBetween(1, 2),
            hobbiesNumber = faker.number().numberBetween(1, 3);

    public static List<String> birthdayDayMonthYear = setBirthdayDate();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = generateGender(faker.number().numberBetween(0, 2)),
            phoneNumber = String.valueOf(faker.number().digits(10)),
            firstSubjectPrefix = "co",
            firstSubject = "Computer Science",
            secondSubjectPrefix = "e",
            secondSubject = "English",
            hobbyGenerated = generateHobby(hobbiesNumber),
            hobbySport = "Sports",
            hobbyRead = "Reading",
            hobbyMusic = "Music",
            fileName = "Tester.jpeg",
            pictureFileSource = "src/test/resources/images/",
            currentAddress = faker.address().streetAddress() + "" + faker.address().streetAddressNumber(),
            statePrefix = "r",
            state = "NCR",
            cityPrefix = "d",
            city = "Delhi";

    public static String
            rowStudentName = "Student Name",
            rowStudentEmail = "Student Email",
            rowGender = "Gender",
            rowMobile = "Mobile",
            rowDateOfBirth = "Date of Birth",
            rowSubjects = "Subjects",
            rowHobbies = "Hobbies",
            rowPicture = "Picture",
            rowAddress = "Address",
            rowStateAndCity = "State and City";
}
