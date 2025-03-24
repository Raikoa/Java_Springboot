package com.example.practiceAPI.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

@org.springframework.boot.test.autoconfigure.json.JsonTest
public class JsonTest {
    @Autowired
    private JacksonTester<Account> json;

    @Test
    void serializeTest() throws IOException {
        Account JSON = new Account(99L, 100L);
        assertThat(json.write(JSON)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(JSON)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(JSON)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertThat(json.write(JSON)).hasJsonPathNumberValue("@.password");
        assertThat(json.write(JSON)).extractingJsonPathNumberValue("@.password").isEqualTo(100);
    }

}
