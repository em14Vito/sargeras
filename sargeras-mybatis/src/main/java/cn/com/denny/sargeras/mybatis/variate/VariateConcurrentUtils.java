package cn.com.denny.sargeras.mybatis.variate;

import cn.com.denny.sargeras.mybatis.mapper.VariateMapper;
import cn.com.denny.sargeras.mybatis.po.Variate;
import cn.com.denny.sargeras.mybatis.po.VariateExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author denny
 * @version 1.0.0 2019/7/13
 */
@Service
public class VariateConcurrentUtils {

  public static final List<Variate> nullVariate = new ArrayList<>();
  public static final List<Variate> notNullVariate = new ArrayList<>();

  Logger logger = LoggerFactory.getLogger(VariateConcurrentUtils.class);

  public static VariateConcurrentUtils utils = new VariateConcurrentUtils();

  private static int size = 100000;
  public static CountDownLatch downLatch = new CountDownLatch(size);
  @Autowired
  public VariateMapper variateMapper;

  public void init() {
    buildNotNullVariate();
    buildNullVariate();
    utils.variateMapper = variateMapper;
  }

  @Transactional
  public void process(Variate variate, VariateExample example,int time){

    variateMapper.updateByExampleSelective(variate, example);
//    try {
//      Thread.sleep(time);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
  }

  public void start() {
    init();

    ExecutorService executorService = Executors.newFixedThreadPool(32);

    for (int i = 0; i < size/2; i++) {
      executorService.submit(new NotNullThread());
    }

    for (int i = 0; i < size/2; i++) {
      executorService.submit(new NullThread());
    }
    try {
      downLatch.await();
      logger.info("所有更新完成");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public void buildNullVariate() {
    Variate variate = new Variate();
    variate.setCustId("1");
    variate.setPhone(null);
    variate.setCode("1");
    variate.setValue("a+");

    Variate variate5 = new Variate();
    variate5.setCustId("1");
    variate5.setPhone(null);
    variate5.setCode("1");
    variate5.setValue("a");

    Variate variate2 = new Variate();
    variate2.setCustId("1");
    variate2.setPhone(null);
    variate2.setCode("4");
    variate2.setValue("d+");

    Variate variate6 = new Variate();
    variate6.setCustId("1");
    variate6.setPhone(null);
    variate6.setCode("4");
    variate6.setValue("d");

    Variate variate3 = new Variate();
    variate3.setCustId("1");
    variate3.setPhone(null);
    variate3.setCode("6");
    variate3.setValue("f+");

    Variate variate4 = new Variate();
    variate4.setCustId("1");
    variate4.setPhone(null);
    variate4.setCode("6");
    variate4.setValue("f");

    nullVariate.add(variate);
    nullVariate.add(variate2);
    nullVariate.add(variate3);
    nullVariate.add(variate4);
    nullVariate.add(variate5);
    nullVariate.add(variate6);
    Collections.shuffle(nullVariate);
  }

  public void buildNotNullVariate() {
    Variate variate = new Variate();
    variate.setCustId("1");
    variate.setPhone("A");
    variate.setCode("2");
    variate.setValue("b+");

    Variate variate5 = new Variate();
    variate5.setCustId("1");
    variate5.setPhone("A");
    variate5.setCode("2");
    variate5.setValue("b");

    Variate variate2 = new Variate();
    variate2.setCustId("1");
    variate2.setPhone("A");
    variate2.setCode("3");
    variate2.setValue("c+");

    Variate variate6 = new Variate();
    variate6.setCustId("1");
    variate6.setPhone("A");
    variate6.setCode("3");
    variate6.setValue("c");

    Variate variate3 = new Variate();
    variate3.setCustId("1");
    variate3.setPhone("B");
    variate3.setCode("5");
    variate3.setValue("e+");

    Variate variate4 = new Variate();
    variate4.setCustId("1");
    variate4.setPhone("B");
    variate4.setCode("5");
    variate4.setValue("e");


    Variate variate7 = new Variate();
    variate7.setCustId("1");
    variate7.setPhone("C");
    variate7.setCode("7");
    variate7.setValue("g+");

    Variate variate8 = new Variate();
    variate8.setCustId("1");
    variate8.setPhone("C");
    variate8.setCode("7");
    variate8.setValue("g");


    notNullVariate.add(variate);
    notNullVariate.add(variate2);
    notNullVariate.add(variate3);
    notNullVariate.add(variate4);
    notNullVariate.add(variate5);
    notNullVariate.add(variate6);
    notNullVariate.add(variate7);
    notNullVariate.add(variate8);

    Collections.shuffle(notNullVariate);
  }
}
