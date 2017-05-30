package ru.davist.study.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * По сути такая штука нужна когда кому-то на вход нужен стрим, а у тебя только строка
 * Created by danil
 * on 30/05/17.
 */
public class ByteArrayInputOutputStream {

    public static void main(String[] args) {


        // Закрывать кстати стрим необязательно :) Это ж просто массив байт а не ресурс
        try (ByteArrayInputStream bais = new ByteArrayInputStream("abc".getBytes())) {

            int c;

            while ((c = bais.read()) != -1) {
                System.out.println((char) c);
            }

            bais.reset();

            // Типо два раза считали из потока
            while ((c = bais.read()) != -1) {
                System.out.println((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
