package cn.com.git.common.utils;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

/**
 *
 * 功能描述：
 * 	File文件类工具类
 * @author Administrator
 * @Date Jul 19, 2008
 * @Time 9:46:11 AM
 * @version 1.0
 */
public class FileUtil {


    /**文件删除
     * 功能描述：
     * 		删除文件、删除单级、删除多级目录，在删除目录前，会先清空目录
     * 		然后再删除目录，
     *
     * @param file
     * 			需要删除的文件
     * @return	在执行删除程序前，会对文件的存在性进行验证
     * 		true	文件存在，删除成功
     * 		false	目标文件不存在，中断deleteDirs程序
     */
    public static boolean deleteDirs(File file){
        //判断文件是否存在
        if(!file.exists()){
            //文件不存在，中断deleteDirs程序
            return false ;
        }

        //判断文件的类型
        if(file.isDirectory()){
            //是目录
            //获取所有子项
            File[] fs = file.listFiles() ;
            for(File f:fs){
                deleteDirs(f) ;
            }
            //删除完目录下的文件后，删除该目录
            file.delete() ;
        }
        if(file.isFile()){
            //是文档
            file.delete() ;
        }

        return true ;
    }

    /**文件遍历
     * 功能描述：
     * 		列出某文件夹及其子文件夹下面的文件(目录不会列出)，并可根据扩展名过滤
     * 		将需要过滤显示出来的文件的后缀存放入prefix集合中，由系统自动识别过滤。
     * 		若prefix集合长度为0，则显示全部，不为0则进行过滤操作
     * @param path
     * 			文件夹
     *
     * @return boolean
     * 			因为会出现用户传入的根目录不存在的情况，所有设定返回值
     * 		true	根目录存在，并执行显示操作,程序会在所有子文件显示完毕后返回
     * 		false	根目录不存在，中断显示操作
     *
     */
    public static boolean list(File path,List<String> prefixList) {
        if (!path.exists()) {
            //文件名不存在
            return false ;
        } else {
            if (path.isFile()) {
                String pathName  = path.getName().toLowerCase();
                //有的文件不一定是以.*结尾的，所有要进行处理
                int point = pathName.lastIndexOf(".")==-1?0:pathName.lastIndexOf(".") ;

                if (prefixList.size()==0||prefixList.contains(pathName.substring(point) )) {// 文件格式
                    System.out.println(path);
                    System.out.println(path.getName());
                }
            } else {
                File[] files = path.listFiles();
                for (File f:files) {
                    list(f,prefixList);
                }
            }
        }

        return true ;
    }

    /**	文件拷贝
     * 功能描述：
     * 		拷贝一个目录或者文件到指定路径(目录)下，即把源文件拷贝到目标文件路径下
     * 		且保留原有文件的目录层次结构，系统在copy文件前会对source文件和target文件的
     * 		存在性和类型合法性进行验证
     * @param source
     * 			源文件 可以是文件，也可以是目录
     * @param target
     *          目标文件  必须是目录且已经被创建
     * @return boolean
     * 			false	目标文件不是目录或未被创建，则中断copy程序
     * 			true	文件复制成功
     */
    public static boolean copy(File source, File target) {
        /*
         * File(File parent, String child)
         * 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例,
         * 即在parent文件夹下创建一个叫child的文件
         */
        if(!target.isDirectory()){
            //若目标文件不是目录，则中断copy程序
            return false ;
        }

        File tarpath = new File(target, source.getName());
        if (source.isDirectory()) {
            tarpath.mkdir();
            File[] dir = source.listFiles();
            for (int i = 0; i < dir.length; i++) {
                copy(dir[i], tarpath);
            }
        }else if(source.isFile()){
            try {
                InputStream is = new FileInputStream(source); // 用于读取文件的原始字节流
                OutputStream os = new FileOutputStream(tarpath); // 用于写入文件的原始字节的流
                byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
                int len = 0;
                while ((len = is.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                is.close();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //source文件不存在,中断copy程序
            return false ;
        }

        return true ;
    }

    /**
     * 将指定的文件解压缩到指定的文件夹，解压后的文件夹目录和给定的压缩文件名相同.
     *
     * @param zipFilePath
     *            全路径
     * @param unZipDirectory
     *            全路径
     * @return 解压缩文件是否成功.
     * @throws IOException
     */
    public static boolean unZipFile(String zipFilePath, String unZipDirectory)
            throws IOException {
        ZipFile zipFile = new ZipFile(zipFilePath);
        Enumeration<?> entries = zipFile.getEntries();
        if (zipFile == null) {
            return false;
        }
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            File f = new File(unZipDirectory + File.separator
                    + zipEntry.getName());
            if (zipEntry.isDirectory())
            {
                if (!f.exists() && !f.mkdirs())
                    throw new IOException("Couldn't create directory: " + f);
            } else {
                BufferedInputStream is = null;
                BufferedOutputStream os = null;
                try {
                    is = new BufferedInputStream(zipFile
                            .getInputStream(zipEntry));
                    File destDir = f.getParentFile();
                    if (!destDir.exists() && !destDir.mkdirs()) {
                        throw new IOException("Couldn't create dir " + destDir);
                    }
                    os = new BufferedOutputStream(new FileOutputStream(f));
                    int b = -1;
                    while ((b = is.read()) != -1) {
                        os.write(b);
                    }
                } finally {
                    if (is != null)
                        is.close();
                    if (os != null)
                        os.close();
                }
            }
        }
        zipFile.close();
        return true;
    }

    /**
     *  压缩一个文件
     * @param filePath
     * @param zipPath
     * @return
     */
    public static boolean zipFile(String filePath,String zipPath){
        BufferedReader in=null;
        org.apache.tools.zip.ZipOutputStream out=null;
        try{
            File file=new File(filePath);
            in=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"ISO-8859-1"));
            FileOutputStream f=new FileOutputStream(zipPath);
            CheckedOutputStream ch=new CheckedOutputStream(f,new CRC32());
            out=new org.apache.tools.zip.ZipOutputStream(new BufferedOutputStream(ch));

            int c;
            out.putNextEntry(new org.apache.tools.zip.ZipEntry(file.getName()));
            while((c=in.read())!=-1)
                out.write(c);
        }

        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally{
            try {
                if(in!=null) in.close();
                if(out!=null)  out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    /**
     * 压缩一个目录
     * @param dir
     * @param zipPath
     * @return
     */
    public static boolean zipDirectory(String dir,String zipPath ){
        org.apache.tools.zip.ZipOutputStream out=null;
        try{
            File dirFile=new File(dir);
            if(!dirFile.isDirectory())return false;
            FileOutputStream fo=new FileOutputStream(zipPath);
            CheckedOutputStream ch=new CheckedOutputStream(fo,new CRC32());
            out=new org.apache.tools.zip.ZipOutputStream(new BufferedOutputStream(ch));
            zip(out,dirFile,"");

        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally{
            try {
                if(out!=null)  out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void zip(org.apache.tools.zip.ZipOutputStream out,File f,String base)throws Exception{
//		System.out.println("Zipping  "+f.getName());
        if (f.isDirectory()) {
            File[] fl=f.listFiles();
            out.putNextEntry(new org.apache.tools.zip.ZipEntry(base+"/"));
            base=base.length()==0?"":base+"/";
            for (int i=0;i<fl.length ;i++ )	{
                zip(out,fl[i],base+fl[i].getName());
            }
        }
        else {
            out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
            FileInputStream is=new FileInputStream(f);
            BufferedInputStream in = new BufferedInputStream(is);//修改BUG!二进制输出采用buffered
            int b;
            while ((b=in.read()) != -1)
                out.write(b);
            in.close();
        }

    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        unZipFile("D:\\压缩文件相关  ant.rar", "D:\\");

        /**
         * 子文件显示测试
         */
//		File file = new File("D:\\E_应用软件");
//		List<String> prefixList = new ArrayList<String>() ;
//		prefixList.add(".exe") ;
//		boolean result = list(file,prefixList);
//
//		System.out.println(result?"执行成功":"文件夹不存在");

        /**
         * 文件拷贝测试
         */
//		File source = new File("D:\\aa");
//		System.out.println(copy(source, new File("D:\\杂")));

        /**
         * 文件删除
         */
//		System.out.println(deleteDirs(new File("D:\\a"))) ;

    }

}

