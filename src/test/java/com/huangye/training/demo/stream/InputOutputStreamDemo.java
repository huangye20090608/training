package com.huangye.training.demo.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huangye on 2017/4/5.
 */
public class InputOutputStreamDemo {

    public static void main(String agrs[]) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:\\inputStream.txt");
            fos = new FileOutputStream("E:\\outputStream.txt");

            int hasRead = 0;
            byte[] inputBytes = new byte[32];
            while((hasRead = fis.read(inputBytes))>0){
                fos.write(inputBytes,0,hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fos.close();
            fis.close();
        }
    }
}
