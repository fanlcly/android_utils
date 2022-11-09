package com.fancy.androidutils.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author fanlei
 * @version V1.0
 * @Description: (用于从内存卡读取文件 ， 或者将文本写入到内存卡)
 * @date 2022/11/9 20:08
 */
public class ReadWriteFileUtils {

    /**
     * 写入文件 默认根目录
     *
     * @param context 上下文
     * @param fileName 文件名
     * @param writeStr 写入内容
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void writeFileByTotal(Context context, String fileName, String writeStr) {
        // 默认文件路径为根目录
        String filePath = context.getExternalFilesDir(null).getPath();
        writeFileByTotal(fileName, filePath, writeStr);
    }

    /**
     * 写入文件
     * @param fileName 文件名
     * @param filePath 文件路径
     * @param writeStr 写入内容
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void writeFileByTotal(String fileName, String filePath, String writeStr) {
        File file = makeFile(filePath, fileName);
        // 先读取文件内容，再把内容放到stringBuilder，接着把新内容写进去，重新放到流里面。
        String readTxt = txt2String(file);
        StringBuilder sb = new StringBuilder();
        sb.append(readTxt);
        FileOutputStream fos = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            sb.append(writeStr);
            byte[] bytes = sb.toString().getBytes();
            fos.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 读取txt文件的内容
     *
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String txt2String(File file) {
//        File file = new File(filePath);
        if (!file.exists()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        BufferedReader br = null;
        try {
            // 构造一个BufferedReader类来读取文件
            br = new BufferedReader(new FileReader(file));
            String s;
            // 使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
//                result.append(System.lineSeparator()).append(s);
                result.append(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }


    /**
     * 创建文件
     *
     * @param filePath 路径
     * @param fileName 文件名
     * @return file 文件对象
     */
    public static File makeFile(String filePath, String fileName) {
        File file = null;
        makeDir(filePath);
        try {
            file = new File(filePath + File.separator + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            Log.i("f_utils", "生成文件错误");
        }

        return file;
    }


    /**
     * 生成文件夹
     *
     * @param path 路径
     */
    public static void makeDir(String path) {
        File file;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            Log.i("f_utils", "生成文件夹错误");
        }


    }


}
