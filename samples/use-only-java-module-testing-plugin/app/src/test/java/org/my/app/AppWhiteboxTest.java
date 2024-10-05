package org.my.app;

import io.github.pixee.security.BoundedLineReader;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppWhiteboxTest {

    @Test
    public void printDataTest() throws IOException {
        App.printData();
        assertEquals("org.my.app", AppWhiteboxTest.class.getModule().getName());

        try (InputStream is = AppWhiteboxTest.class.getResourceAsStream("AppTestData.txt")) {
            System.out.println(BoundedLineReader.readLine(new BufferedReader(new InputStreamReader(is)), 5_000_000));
        }
    }

}
