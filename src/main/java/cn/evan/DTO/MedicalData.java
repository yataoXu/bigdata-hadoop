package cn.evan.DTO;

import lombok.Data;

/**
 * @Description
 * @ClassName ddd
 * @Author Evan
 * @date 2019.11.11 17:34
 */
@Data
public class MedicalData {
    private String NEW患者唯一识别;
    private String NEW患者编号;
    private String 参保类型;
    private String 性别;
    private String 年龄;
    private String 就诊类别;
    private String 医疗机构级别;
    private String 出生日期;
    private String 就诊入院日期;
    private String 出院日期;
    private String 住院天数;
    private String 出院科室_上报;
    private String 出院科室;
    private String 出院主要诊断_上报;
    private String 出院主要诊断编码_上报;
    private String 出院主要诊断编码;
    private String 出院主要诊断名称;
    private String 大类编码;
    private String 大类名称;
    private String 亚类编码;
    private String 亚类名称;
    private String 疾病组编码;
    private String 疾病组;
    private String 出院第2诊断;
    private String 出院第2诊断编码;
    private String 出院第3诊断;
    private String 出院第3诊断编码;
    private String 总费用;
    private String 基金支付金额;
    private String 患者自付金额;
    private String 患者自费金额;
    private String 按病种结算的费用;
    private String 医保结算方式;
    private String 省份名称;
    private String 城市名称;
    private String 区域;
    private String 城市类别;
    private String 城市等级;
}




