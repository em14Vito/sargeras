package cn.com.denny.sargeras.mybatis.variate;

import cn.com.denny.sargeras.mybatis.po.Variate;
import cn.com.denny.sargeras.mybatis.po.VariateExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

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
public class NotNullThread implements Runnable {
  ThreadLocalRandom random = ThreadLocalRandom.current();
  Logger logger = LoggerFactory.getLogger(NotNullThread.class);

  @Override
  public void run() {
    int index = random.nextInt(0, VariateConcurrentUtils.notNullVariate.size());
    Variate variate = VariateConcurrentUtils.notNullVariate.get(index);

    VariateExample example = new VariateExample();
    VariateExample.Criteria criteria = example.createCriteria();

    criteria.andCustIdEqualTo(variate.getCustId());
    criteria.andCustIdEqualTo(variate.getCustId());
    criteria.andPhoneEqualTo(variate.getPhone());
    criteria.andCodeEqualTo(variate.getCode());

    try {
      //        logger.info("not null随机数为:{}",index);
      //        logger.info("Not Null Operation");
      VariateConcurrentUtils.utils.process(variate, example,random.nextInt(1000,3000));
    } catch (Exception e) {
      logger.error("报错了", e);
    } finally {
      VariateConcurrentUtils.downLatch.countDown();
    }
  }
}
