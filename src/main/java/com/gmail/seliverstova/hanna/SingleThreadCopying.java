package com.gmail.seliverstova.hanna;

import java.io.File;
import java.io.IOException;

public class SingleThreadCopying implements Runnable {

    private File[] array;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private boolean stop = false;

    private File folderTo;
    private File sourceFile;

    public SingleThreadCopying(File[] array, File sourceFile, File folderTo, int begin, int end) {
        super();
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.folderTo = folderTo;
        this.sourceFile = sourceFile;
        thr = new Thread(this);

        thr.start();
        this.index = begin;
    }

    public SingleThreadCopying() {
        super();
    }

    public File[] getArray() {
        return array;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public Thread getThr() {
        return thr;
    }

    public int getIndex() {
        return index;
    }

    public boolean isStop() {
        return stop;
    }

    public File getFolderTo() {
        return folderTo;
    }

    public File getSourceFile() {
        return sourceFile;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i += 1) {
            File sourceFile = this.array[i];
            try {
                FileOperation.fileCopy(sourceFile, new File(this.folderTo, sourceFile.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
