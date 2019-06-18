package com.cqut.crud.service;

import com.cqut.crud.bean.FundingInfo;
import com.cqut.crud.dao.FundingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenTengfei
 * @date 2019/6/3 3:10
 **/
@Service
public class FundingInfoSerive {
    @Autowired
    FundingInfoMapper fundingInfoMapper;

    public List<FundingInfo> getSchoolPhaseFundingInfo() {
        return fundingInfoMapper.selectByExample(null);
    }
}