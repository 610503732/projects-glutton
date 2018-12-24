package cn.com.git.common.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * jaxb  xml与对象序列化操作工具类
 * Created by tangzan on 2016/10/20.
 */
public class JAXBUtils {

    private JAXBUtils() {

    }

    /**
     * 将xml字符串转化为指定对象
     * @param clz
     * @param xml
     * @return
     * @throws JAXBException
     */
    public static Object toObj(Class<?> clz, String xml) throws JAXBException {

        StringReader sr = new StringReader(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(clz);
        Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnMarshaller.unmarshal(sr);
    }

    /**
     * 对象转化为XML字符串
     * @param clz
     * @param obj
     * @return
     * @throws JAXBException
     */
    public static String toXML(Class<?> clz, Object obj) throws JAXBException {

        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(clz);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        jaxbMarshaller.marshal(obj, sw);

        return sw.toString();
    }
}
