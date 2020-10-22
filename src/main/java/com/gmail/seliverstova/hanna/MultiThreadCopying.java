package com.gmail.seliverstova.hanna;

import java.io.File;

public class MultiThreadCopying {

    static void copyFiles(File folderFrom, File folderTo, int threadNumber) {
        SingleThreadCopying[] threadarray = new SingleThreadCopying[threadNumber];
        File[] array = folderFrom.listFiles();

        for (int i = 0; i < threadarray.length; i++) {
            int size = array.length / threadNumber;
            int begin = size * i;
            int end = ((i + 1) * size);
            if (((array.length - end) < size) || (i == (threadarray.length - 1))) {
                end = array.length;
            }
            threadarray[i] = new SingleThreadCopying(array, folderFrom, folderTo, begin, end);
        }
        for (int i = 0; i < threadarray.length; i++) {
            try {
                threadarray[i].getThr().join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}