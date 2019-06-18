package com.cqut.crud.dao;

import com.cqut.crud.bean.BankcardChangeRecord;
import com.cqut.crud.bean.BankcardChangeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankcardChangeRecordMapper {
    long countByExample(BankcardChangeRecordExample example);

    int deleteByExample(BankcardChangeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BankcardChangeRecord record);

    int insertSelective(BankcardChangeRecord record);

    List<BankcardChangeRecord> selectByExample(BankcardChangeRecordExample example);

    BankcardChangeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BankcardChangeRecord record, @Param("example") BankcardChangeRecordExample example);

    int updateByExample(@Param("record") BankcardChangeRecord record, @Param("example") BankcardChangeRecordExample example);

    int updateByPrimaryKeySelective(BankcardChangeRecord record);

    int updateByPrimaryKey(BankcardChangeRecord record);
}