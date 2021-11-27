package com.github.elenaAeternanox.tenthHomeWork.tests;

import com.github.elenaAeternanox.tenthHomeWork.config.EnvironmentConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tags({@Tag("files_test"), @Tag("registration_page")})
public class EnvironmentTest {

    public EnvironmentConfig credentials = ConfigFactory.create(EnvironmentConfig.class);

    @Test
    void environmentTest() {
        String login = credentials.login();
        String password = credentials.password();
        String environment = credentials.environment();

        String message = format("The build is run on %s. You are login as %s with password %s", environment, login, password);
        System.out.println(message);

        switch (System.getProperty("tag")) {
            case "registration_page":
                System.out.println("Build includes fillFormTest");
                break;
            case "files_test":
                System.out.println("Build includes downloadAndCheckPdfFile, downloadAndCheckXlsFile");
                break;
            default:
                System.out.println("Oooops, something wrong !");
        }
    }
}
