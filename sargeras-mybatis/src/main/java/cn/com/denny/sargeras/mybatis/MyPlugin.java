package cn.com.denny.sargeras.mybatis;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

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
 * @version 1.0.0 2019/6/13
 */
@Intercepts({
  @Signature(
      type = ParameterHandler.class,
      method = "setParameters",
      args = PreparedStatement.class)
})
public class MyPlugin implements Interceptor {

  private long time;

  // 方法拦截
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
    PreparedStatement ps = (PreparedStatement) invocation.getArgs()[0];
    return null;
  }

  // 获取到拦截的对象，底层也是通过代理实现的，实际上是拿到一个目标代理对象
  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  // 获取设置的阈值等参数
  @Override
  public void setProperties(Properties properties) {
    this.time = Long.parseLong(properties.getProperty("time"));
  }
}
