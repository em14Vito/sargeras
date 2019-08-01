package cn.com.denny.sargeras.mybatis.mapper;

import cn.com.denny.sargeras.mybatis.po.Variate;
import cn.com.denny.sargeras.mybatis.po.VariateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VariateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    long countByExample(VariateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int deleteByExample(VariateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int insert(Variate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int insertSelective(Variate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    List<Variate> selectByExample(VariateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    Variate selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Variate record, @Param("example") VariateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Variate record, @Param("example") VariateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Variate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table variate
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Variate record);
}