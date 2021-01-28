package by.epam.tc.reader.impl;

import by.epam.tc.reader.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader implements Reader {
    @Override
    public String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder text = new StringBuilder();
        while (reader.ready()){
            text.append(reader.readLine().trim());
        }
        return text.toString();
    }
}
