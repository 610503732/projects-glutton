package cn.com.git.common.utils;

import java.lang.reflect.Field;


/**
 * 反射
 * @author git
 *
 */
public class ReflectUtils {

    /**
     * 根据类名（全名）创建实例
     * @param bean
     * @return
     * @throws Exception
     */
    public static Object createBean(String bean) throws Exception {
        //①通过类装载器获取类对象  
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> c = loader.loadClass(bean);

        //获取类的默认构造器对象并通过它实例化改类
        Object obj = c.getDeclaredConstructor((Class[]) null).newInstance();

        return obj;
    }

    /**
     *  填充一个对象 
     * @param target
     * @param source
     * @throws Exception 
     * @throws SecurityException 
     */
    public static void fillFieldValue(Object target, Object source) throws Exception {

        //获取该类对象的所有属性
        Field[] targetFields = target.getClass().getDeclaredFields();

        for (Field targetField : targetFields) {
            //获取源对象中对应属性
            Field sourceField = source.getClass().getDeclaredField(targetField.getName());
            //设置属性可访问
            targetField.setAccessible(true);
            //源对象中匹配到该属性
            if (sourceField != null
                && targetField.getType().toString().equals(sourceField.getType().toString())) {
                if (sourceField.isAccessible()) {
                    targetField.set(target, sourceField.get(source));
                } else {
                    sourceField.setAccessible(true);
                    targetField.set(target, sourceField.get(source));
                    sourceField.setAccessible(false);
                }
            }
            //设置属性不可访问
            targetField.setAccessible(false);
        }

    }
    
    /**
     *目标对象与与转换的对象属性名称相同
     * @param srouce 目标对象
     * @param destn 要copy的对象
     */
//    public static void copy(final Object source,final Object destn){
//        
//        DozerBeanMapper dozer = new DozerBeanMapper();
//        final Field[] fields = source.getClass().getDeclaredFields();
//        BeanMappingBuilder beanMappingBuilder = new BeanMappingBuilder(){
//            @Override
//            protected void configure() {
//                if(fields.length > 0){
//                    TypeMappingBuilder typeMappingBuilder = mapping(source.getClass(), destn.getClass());
//                    for(int i =0;i<fields.length;i++){
//                        Field field = fields[i];
//                        final String  name = field.getName();
//                        Convert convert = field.getAnnotation(Convert.class);
//                        if(convert != null){
//                            final String customeConverter = convert.value();
//                            typeMappingBuilder.fields(name, name,customConverter(customeConverter));
//                        }
//                    }
//                }
//            }
//        };
//        dozer.addMapping(beanMappingBuilder);
//        dozer.map(source, destn);
//        
//    }

    /**
     * 填充一个字段值
     * @param target 填充对象
     * @param targetField 填充字段
     * @param source 来源对象
     * @param sourceField 来源字段
     * @throws Exception 
     */
    public static void fillFieldValue(Object target, String targetField, Object source, String sourceField)
                                                                                                           throws Exception {
        try {
            setValueByFieldName(target, targetField, getValueByFieldName(source, sourceField));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取obj对象fieldName的Field
     * @param obj
     * @param fieldName
     * @return
     * @throws NoSuchFieldException 
     */
    public static Field getFieldByFieldName(Object obj, String fieldName) throws NoSuchFieldException {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
            	throw e;
            }
        }
        return null;
    }

    /**
     * 获取obj对象fieldName的属性值
     * @param obj
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName) throws Exception {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * 设置obj对象fieldName的属性值
     * @param obj
     * @param fieldName
     * @param value
     * @throws Exception 
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws Exception {
        Field field = getFieldByFieldName(obj, fieldName);
        if (field != null) {
            if (field.isAccessible()) {
                field.set(obj, value);
            } else {
                field.setAccessible(true);
                field.set(obj, value);
                field.setAccessible(false);
            }
        } else {
            throw new Exception("属性不存在！");
        }
    }
}
