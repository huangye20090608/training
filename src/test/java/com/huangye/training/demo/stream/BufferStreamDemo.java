package com.huangye.training.demo.stream;

import java.io.*;

/**
 * Created by huangye on 2017/4/5.
 */
public class BufferStreamDemo {

    public static void main(String args[]) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream("E:\\inputStream.txt");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("E:\\outputStream.txt");
            bos = new BufferedOutputStream(fos);

            int hasRead = 0;
            byte[] inputBytes = new byte[1024];
            while((hasRead = bis.read(inputBytes))>0){
                bos.write(inputBytes,0,hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            bos.close();
            bis.close();
//            fos.close();
//            fis.close();
        }
    }
}
