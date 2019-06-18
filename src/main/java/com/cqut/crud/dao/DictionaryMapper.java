package com.cqut.crud.dao;

import com.cqut.crud.bean.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/11 14:27
 **/
public interface DictionaryMapper {

    Dictionary translate(@Param("dicType") String dicType, @Param("dicValue") String dicValue);

    List<Dictionary> selectDictionaries(List<String> dicType);
}
