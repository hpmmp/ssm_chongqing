package com.cqut.crud.service;

import com.cqut.crud.bean.Dictionary;
import com.cqut.crud.dao.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/5/11 14:16
 **/
@Service
public class DicSerivce {
    @Autowired
    DictionaryMapper dictionaryMapper;

    public Dictionary translate(String dicType, String dicValue) {
        return dictionaryMapper.translate(dicType, dicValue);
    }

    public List<Dictionary> getDictionaries(List<String> dicType) {
        return dictionaryMapper.selectDictionaries(dicType);
    }
}