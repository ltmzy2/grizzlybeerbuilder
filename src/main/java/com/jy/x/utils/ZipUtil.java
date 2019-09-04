package com.jy.x.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 11:06
 **/
public class ZipUtil {


    /**
     * 打包文件夹为zip
     *
     * @param outPutFileName 输出文件全路径绝对路径包含自定义文件名
     * @param inputPath      输入文件路径
     * @return void
     * @author: Jy  2019/8/5 14:32
     */
    public static void zip(String outPutFileName, String inputPath) {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(outPutFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //加入缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(out);
        File sourceFile = new File(inputPath);
        compress(out, bos, sourceFile, sourceFile.getName());
        try {
            bos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param out        输出文件输出流
     * @param bos        输出文件缓冲流
     * @param sourceFile 源文件或文件夹
     * @param fileName   源文件或文件夹的文件名
     * @return void
     * @author: Jy  2019/8/5 15:39
     */
    private static void compress(ZipOutputStream out, BufferedOutputStream bos, File sourceFile, String fileName) {
        if (sourceFile.isDirectory()) {
            File[] flist = sourceFile.listFiles();
            if (flist == null || flist.length == 0) {
                try {
                    //没有子级直接put
                    out.putNextEntry(new ZipEntry(fileName + File.separator));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // 如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
                for ( int i = 0; i < flist.length; i++ ) {
                    compress(out, bos, flist[i], fileName + File.separator + flist[i].getName());
                }
            }
        } else {
            //不是目录 开始压缩 只压缩java文件
            if (sourceFile.getName().contains(".java")) {
                try {
                    //开始put并写入
                    out.putNextEntry(new ZipEntry(fileName));
                    FileInputStream fos = new FileInputStream(sourceFile);
                    BufferedInputStream bis = new BufferedInputStream(fos);
                    int tag;
                    while ((tag = bis.read()) != -1) {
                        out.write(tag);
                    }
                    bis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 打包zip以后删除生成的文件
     *
     * @param
     * @return boolean
     * @author: Jy  2019/8/6 10:42
     */
    public static boolean deleteGenFile(File file) {
        boolean success = false;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for ( File child : files ) {
                    deleteGenFile(child);
                }
            } else {
                if (file.getName().contains(".java")) {
                    success = file.delete();
                }
            }
        }
        return success;
    }
}
