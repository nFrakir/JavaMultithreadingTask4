package com.gmail.seliverstova.hanna;

import java.io.File;

public class App {
    public static void main(String[] args) {
        File path = new File(".");
        MultiThreadCopying.copyFiles(new File(path, "resources/from"), new File(path, "resources/to"), 10);
    }
}
