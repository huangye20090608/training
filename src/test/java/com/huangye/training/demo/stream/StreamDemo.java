package com.huangye.training.demo.stream;

import java.io.*;

/**
 * Created by huangye on 2017/4/1.
 */
public class StreamDemo {

    public static void main(String agrs[]){
        try {

            StringBuffer str = new StringBuffer();
            char[] buf = new char[1024];
            FileReader f = new FileReader("file");
            while(f.read(buf)>0){
                str.append(buf);
            }
            str.toString();

            OutputStream out = new BufferedOutputStream
                    (new ObjectOutputStream(
                            new FileOutputStream("E:\\stream.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
