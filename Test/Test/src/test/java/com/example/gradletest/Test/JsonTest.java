package com.example.gradletest.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class AccountJsonTest{
    @Autowired
    private JacksonTester<Account> json;
    @Test
    void serialization() throws IOException {
        Account a = new Account(99L,100L);
        assertThat(json.write(a)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write((a))).hasJsonPathNumberValue("@.id");
        assertThat(json.write(a)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertThat(json.write((a))).hasJsonPathNumberValue("@.password");
        assertThat(json.write(a)).extractingJsonPathNumberValue("@.password").isEqualTo(100);
    }
}