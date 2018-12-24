package cn.com.git.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 应用入口
 */
@Controller
public class HomeController {



    @Autowired
    private RedisTemplate redisTemplate ;

    @RequestMapping("/login")
    public String index() {

        return "login" ;
    }

    @RequestMapping("/getByKey")
    @ResponseBody
    public String getByKey(@RequestParam("keyId") final String keyId){

        return (String) redisTemplate.execute(new RedisCallback() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {

                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                byte[] key = serializer.serialize(keyId);
                byte[] value = redisConnection.get(key);
                if (value == null) {
                    return null;
                }
                String nickname = serializer.deserialize(value);

                return nickname;
            }
        });

    }

}