package cn.com.denny.sargeras.javase.analysis.stack;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author denny
 * @version 1.0.0 2019/5/22
 **/
public class MyTest {

    Object obj1 = new Object();
    Object obj2 = new Object();

    public void fun1(){
        synchronized (obj1){
            fun2();
        }
    }


    public void fun2()
    {
        synchronized(obj2){
            while(true){ //为了演示需要，该函数永不退出
                System.out.print("");
            }
        } }
    public static void main(String[] args) {
        MyTest aa = new MyTest();
        aa.fun1();
    }
}
