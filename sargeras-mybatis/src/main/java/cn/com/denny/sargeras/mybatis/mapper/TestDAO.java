package cn.com.denny.sargeras.mybatis.mapper;

import cn.com.denny.sargeras.mybatis.po.Test;
import cn.com.denny.sargeras.mybatis.po.TestExample;
import org.springframework.stereotype.Repository;

/**
 * TestDAO继承基类
 */
@Repository
public interface TestDAO extends MyBatisBaseDao<Test, Integer, TestExample> {
}