package 杂项;


import java.net.URL;
import java.io.*;

public class Week8 {

    public static void main(String[] args)
            throws Exception {
        final URL[] urls = {
                new URL("https://www.pku.edu.cn"),
                new URL("https://www.baidu.com"),
                new URL("https://www.sina.com.cn"),
                new URL("https://www.dstang.com")
        };
        final String[] files = {
                "pku.htm",
                "baidu.htm",
                "sina.htm",
                "study.htm",
        };
        try {
            MyThread t1 = new MyThread(new URL("http://www.pku.edu.cn"), "pku.htm");
            MyThread t2 = new MyThread(new URL("http://www.baidu.com"), "baidu.htm");
            MyThread t3 = new MyThread(new URL("http://www.sina.com.cn"), "sina.htm");
            MyThread t4 = new MyThread(new URL("http://www.dstang.com"), "study.htm");
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        } catch (Exception e) {

        }


    }

    static void download(URL url, String file)
            throws IOException {
        try (InputStream input = url.openStream();
             OutputStream output = new FileOutputStream(file)) {
            byte[] data = new byte[1024];
            int length;
            while ((length = input.read(data)) != -1) {
                output.write(data, 0, length);
            }
        }
    }

    static class MyThread extends Thread {
        URL url;
        String file;

        MyThread(URL url, String file) {
            this.url = url;
            this.file = file;
        }

        @Override
        public void run() {
            try {
                System.out.println(url);
                download(url, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
