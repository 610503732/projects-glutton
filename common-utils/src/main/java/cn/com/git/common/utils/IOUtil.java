package cn.com.git.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Collection;

/**
 * 该类提供若干读写方法为客户端使用
 * @author Administrator
 *
 */
public class IOUtil {

    //	字符流
    /**文件首行字符串写入
     * 将给定的字符串写入到文件的第一行
     *
     * @param str 源字符串
     * @param file 目标文件
     * @return boolean
     * 				true 写入成功
     * @throws Exception
     */
    public static boolean saveLong(
            String str,File file)
            throws Exception{
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            pw.println(str);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally{
            if(pw != null){
                pw.close();
            }
        }
        return true ;
    }

    /**读取文件首行字符串
     * 从给定的文件中读取一行字符返回。
     * 在返回字符串前，对其进行trim处理
     * @param file	源文件
     * @return String	读取到的字符串
     * @throws Exception
     */
    public static String readLine(File file)
            throws Exception{
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(
                                    file
                            )
                    )
            );
            String line = br.readLine().trim();
            return line ;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally{
            if(br != null){
                br.close();
            }
        }
    }

    /**对象持久化到文件
     * 将给定的集合中的每个元素的toString返回的字符
     * 串以行位单位写入到给定的文件中
     * @param c
     * @param file
     * @throws Exception
     */
    public static void saveCollection(
            Collection c,File file)
            throws Exception{
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for(Object obj : c){
                pw.println(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally{
            if(pw != null){
                pw.close();
            }
        }
    }


    //	字节流
    /**
     * 从给定的RandomAccessFile的当前位置开始
     * 连续读取给定长度的字节，并转换为字符串后返回
     * @param raf
     * @param length
     * @return
     * @throws Exception
     */
    public static String readString(
            RandomAccessFile raf,int length)
            throws Exception{
        try {
            byte[] data = new byte[length];
            raf.read(data);
            return new String(data,"ISO8859-1");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }



}


