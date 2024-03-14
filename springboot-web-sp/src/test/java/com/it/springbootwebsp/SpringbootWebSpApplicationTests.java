package com.it.springbootwebsp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class SpringbootWebSpApplicationTests {

    @Test
    public void testUuid() {

        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /*
    jwt测试
     */
    @Test
    public void testGenJWT(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("username","邢凯");
        claims.put("password", "123456");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"xing") //签名算法 密钥为“xing”
                .setClaims(claims) //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000)) //设置有效期为一小时
                .compact();
        System.out.println(jwt);
    }

    /*
    jwt令牌解析*/
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("xing") //密钥必须一致
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTcxMDQxMTQzMCwidXNlcm5hbWUiOiLpgqLlh68ifQ.44uiIBS73zk3bcSurzCxMT-OHSfzLSxSq9BzrltVwjg")
                .getBody();
        System.out.println(claims);
    }
}
