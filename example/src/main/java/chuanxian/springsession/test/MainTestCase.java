package chuanxian.springsession.test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTestCase {

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ExecutorService executorService1 = Executors.newFixedThreadPool(200);
                for (int i=0;i<300;i++) {
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            //打开URLConnection进行读取
                            URL url = new URL("http://localhost:8080/test/demo1");
                            URLConnection connection = url.openConnection();
                            try (InputStream in = connection.getInputStream()) {    //带资源的try-catch语句。自动关闭
                                InputStream buffer = new BufferedInputStream(in);
                                //将InputStream串链到一个Reader
                                Reader reader = new InputStreamReader(buffer);
                                int c;
                                while ((c = reader.read()) != -1) {
                                    System.out.print((char) c);
                                }
                            } catch (MalformedURLException e) {

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }, executorService1);
                }
            }
        }).start();;

        new Thread(new Runnable() {
            @Override
            public void run() {
                ExecutorService executorService2 = Executors.newFixedThreadPool(200);
                for (int i=0;i<300;i++) {
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            //打开URLConnection进行读取
                            URL url = new URL("http://localhost:8080/test/demo2");
                            URLConnection connection = url.openConnection();
                            try (InputStream in = connection.getInputStream()) {    //带资源的try-catch语句。自动关闭
                                InputStream buffer = new BufferedInputStream(in);
                                //将InputStream串链到一个Reader
                                Reader reader = new InputStreamReader(buffer);
                                int c;
                                while ((c = reader.read()) != -1) {
                                    System.out.print((char) c);
                                }
                            } catch (MalformedURLException e) {

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }, executorService2);
                }
            }
        }).start();


        Thread.sleep(1000L);
    }

}
