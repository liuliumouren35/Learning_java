package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;


@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }
    // 测试JWT
    @Test
    public void testJwt(){
        String token = Jwts.builder()
                .setSubject("spring-coming")// 设置主题
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))// 设置过期时间
                .signWith(SignatureAlgorithm.HS256, "itheima")// 设置签名算法和密钥
                .compact();// 生成token
        System.out.println(token);
    }
    // 测试JWT解析
    @Test
    public void testJwtParse(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzcHJpbmctY29taW5nIiwiZXhwIjoxNzQ2OTQ5MDY1fQ.qX_oQxPUtD5M4L17A3r-EDk2cIhJm4Od5Ltaz5HTpjk";
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws(token);
        System.out.println(claims);
    }
}
