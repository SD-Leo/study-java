package ru.davist.study.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by danil
 * on 30/05/17.
 */
public class InputOutputStreamMain {

    public static void main(String[] args) throws IOException {

        System.out.println("current absolute path: " + new File(".").getAbsolutePath());
        System.out.println("current canonical path: " + new File(".").getCanonicalPath());

        String fileName = "java-io/src/main/resources/file4reading.txt";

        try (FileInputStream fis = new FileInputStream(fileName)) {
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileOutputStream fos = new FileOutputStream("java-io/help.txt");

        char c = 'a';
        fos.write(c);
        fos.write(c);
        fos.write(c);
        fos.write(c);
        fos.write(c);

        fos.close();

    }
}
