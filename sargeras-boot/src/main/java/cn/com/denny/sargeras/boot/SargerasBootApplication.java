package cn.com.denny.sargeras.boot;

import cn.com.denny.sargeras.mybatis.mapper.TestDAO;
import cn.com.denny.sargeras.mybatis.po.Test;
import cn.com.denny.sargeras.mybatis.variate.VariateConcurrentUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
    exclude = {MongoAutoConfiguration.class},
    scanBasePackages = "cn.com.denny.sargeras")
@EnableTransactionManagement
public class SargerasBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(SargerasBootApplication.class, args);
    SpringUtil.getBean(VariateConcurrentUtils.class).start();

//    Test test = new Test();
//    test.setUpdBy(123);
//    System.out.println(SpringUtil.getBean(TestDAO.class).insert(test));
  }
}
