package com.cqut.crud.controller;

import com.cqut.crud.bean.ChartData;
import com.cqut.crud.bean.Dictionary;
import com.cqut.crud.bean.FundingInfo;
import com.cqut.crud.bean.Msg;
import com.cqut.crud.service.DicSerivce;
import com.cqut.crud.service.FundingInfoSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenTengfei
 * @date 2019/6/2 12:51
 **/
@Controller
public class ChartController {

    @Autowired
    FundingInfoSerive fundingInfoSerive;

    @Autowired
    DicSerivce dicSerivce;

    /**
     * 获取柱状图数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/getbarGraph")
    public Msg getbarGraph(){
        //获取资助记录列表
        List<FundingInfo> fundingInfoList = fundingInfoSerive.getSchoolPhaseFundingInfo();
        Map<String,Double> map = new HashMap<>();
        for(FundingInfo fundingInfo:fundingInfoList){
            if(map.get(fundingInfo.getPhase())==null){
                map.put(fundingInfo.getPhase(),fundingInfo.getAmount());
            }else{
                double a1 = map.get(fundingInfo.getPhase());
                double a2 = fundingInfo.getAmount();
                map.put(fundingInfo.getPhase(),add(a1,a2));
            }
        }
        //组装数据
        List<String> XchartDataList = new ArrayList<>();
        List<Double> YchartDataList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            Dictionary need_school_phase = dicSerivce.translate("NEED_SCHOOL_PHASE", entry.getKey().toString());
            if(need_school_phase!=null){
                XchartDataList.add(need_school_phase.getDicName());
            }
            YchartDataList.add(Double.parseDouble(entry.getValue().toString()));
        }


        return Msg.success().add("XchartDataList",XchartDataList).add("YchartDataList",YchartDataList);
    }

    /**
     * 获取饼图数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPieChart")
    public Msg getPieChart(){
        //获取资助记录列表
        List<FundingInfo> fundingInfoList = fundingInfoSerive.getSchoolPhaseFundingInfo();
        Map<String,Double> map = new HashMap<>();
        for(FundingInfo fundingInfo:fundingInfoList){
            if(map.get(fundingInfo.getPhase())==null){
                map.put(fundingInfo.getPhase(),fundingInfo.getAmount());
            }else{
                double a1 = map.get(fundingInfo.getPhase());
                double a2 = fundingInfo.getAmount();
                map.put(fundingInfo.getPhase(),add(a1,a2));
            }
        }

        //组装数据

        List<ChartData> chartDataList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        for (Map.Entry entry : map.entrySet()) {
            Dictionary need_school_phase = dicSerivce.translate("NEED_SCHOOL_PHASE", entry.getKey().toString());
            if(need_school_phase!=null){
                nameList.add(need_school_phase.getDicName());
                chartDataList.add(new ChartData<Double>(Double.parseDouble(entry.getValue().toString()),need_school_phase.getDicName()));
            }
        }

        return Msg.success().add("chartDataList",chartDataList).add("nameList",nameList);
    }

    /* 提供精确的加法运算
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
    public static double add(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
}