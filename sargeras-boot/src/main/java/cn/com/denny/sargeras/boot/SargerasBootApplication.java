package cn.com.denny.sargeras.boot;

import cn.com.denny.sargeras.mybatis.mapper.TestDAO;
import cn.com.denny.sargeras.mybatis.po.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(
    exclude = {MongoAutoConfiguration.class},
    scanBasePackages = "cn.com.denny.sargeras")

public class SargerasBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(SargerasBootApplication.class, args);
    Test test = new Test();
    test.setUpdBy(123);
    System.out.println(SpringUtil.getBean(TestDAO.class).insert(test));
  }
}
