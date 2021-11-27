package com.github.elenaAeternanox.tenthHomeWork.tests;

import com.github.elenaAeternanox.tenthHomeWork.config.EnvironmentConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tags({@Tag("files_test"),@Tag("registration_page")})
public class EnvironmentTest {

    public EnvironmentConfig credentials = ConfigFactory.create(EnvironmentConfig.class);

    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();
        String environment = credentials.environment();

        String message = format("The build is run on %s. You are login as %s with password %s", environment, login, password);
        System.out.println(message);
    }
}
