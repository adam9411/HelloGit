package io.adam.practices.compress;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * zip tar.gz 解压缩
 * @author dcyu
 * @version 1.0.0
 * @since 2021-03-23 22:02
 */
public class ZipCompress extends AbstractCompress {


    public static void main(String[] args) {

        File file = new File("/Users/user/about-tech/ha.tar.gz");
        zipuncompress(file, "/Users/user/about-tech/zipuncompress");
    }

    private static void zipuncompress(File file, String path){
        try{
            GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(file));
            ZipInputStream inputStream = new ZipInputStream(gzipInputStream);
            ZipEntry entry;
            while((entry = inputStream.getNextEntry()) != null){
                if(entry.isDirectory()){
                    createDirectory(path, entry.getName());
                }else{
                    File tempFile = new File(path, entry.getName());
                    createDirectory(path, null);

                    //tempFile.setExecutable(true);
                    OutputStream outputStream = new FileOutputStream(tempFile);

                    /*OutputStream outputStream = new FileOutputStream(tempFile);*/
                    byte[] bytes = new byte[1024];
                    int len;
                    while((len = inputStream.read()) != -1){
                        outputStream.write(bytes, 0, len);
                    }
                    outputStream.close();
                }
            }
        }catch (IOException e){

        }
    }
}
