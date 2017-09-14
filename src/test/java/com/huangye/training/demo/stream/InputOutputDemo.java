package com.huangye.training.demo.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huangye on 2017/8/27.
 */
public class InputOutputDemo {

    public static void main(String args[]){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("E:\\inputStream.txt");
            fos = new FileOutputStream("E:\\outputStream.txt");
            int hasRead = 0;
            byte[] readByte = new byte[32];
            while((hasRead = fis.read(readByte))>0){
                fos.write(readByte,0,hasRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
