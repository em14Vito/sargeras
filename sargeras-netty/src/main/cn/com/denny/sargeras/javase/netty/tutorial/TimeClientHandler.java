package cn.com.denny.sargeras.javase.netty.tutorial;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

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
 * @version 1.0.0 2019/5/15
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

  private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());

  private final ByteBuf firstMessage;

  public TimeClientHandler() {
    byte[] req = "QUERY TIME ORDER".getBytes();
    firstMessage = Unpooled.buffer(req.length);
    firstMessage.writeBytes(req);
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    ctx.writeAndFlush(firstMessage);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf byteBuf = (ByteBuf) msg;
    byte[] req = new byte[byteBuf.readableBytes()];
    byteBuf.readBytes(req);
    String body = new String(req, "UTF-8");
    System.out.println("Now is " + body);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    logger.warning("Unexpected exception from downstream" + cause.getMessage());
    ctx.close();
  }
}
