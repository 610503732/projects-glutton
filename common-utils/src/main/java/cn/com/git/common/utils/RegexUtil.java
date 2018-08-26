package cn.com.git.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 *
 *
 */
public class RegexUtil {

    /** 汉字 **/
    public static final String CHINE_WORD = "^[\u4E00-\u9FA5]+$";

    /** email **/
    public static final String EMAIL      = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+$";

    /** 电话 **/
    public static final String PHONE_NUM      = "^[0-9]{11}$";

    /**
     * 捕获组
     * 可以用来获取字符串中的数字数组或者其他
     * @return
     */
    public static List<Object> regexGroup( String line,String pattern ){

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        List<Object> groups = new ArrayList<Object>() ;
        while(m.find()){
            groups.add(m.group()) ;
        }
        return groups ;
    }

    /**
     * 正则表达式匹配验证
     * @param src 需要校验的字符串
     * @param regEx 检验依据的正则表达式
     * @return
     */
    public static boolean matches(String src,String regEx){
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(src);
        return matcher.matches();
    }

    public static void main (String[] args){
        String line= "12,33,44,112,323,aadd,444" ;

        String pattern = "\\d+" ;

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);

        while (m.find( )){
            System.out.println("Found value: " + m.group());
        }

    }


}
