package ru.bert7438.stomatology;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bert7438.stomatology.controllers.DoctorsController;
import ru.bert7438.stomatology.controllers.LoginController;
import ru.bert7438.stomatology.controllers.RegisterController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private DoctorsController doctorsController;
    @Autowired
    private RegisterController registerController;
    @Autowired
    private LoginController loginController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(doctorsController).isNotNull();
        assertThat(registerController).isNotNull();
        assertThat(loginController).isNotNull();
    }
}
