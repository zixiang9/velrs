package com.ysf.velrs.engine.utils;

import com.ysf.velrs.engine.constant.RuleRunnerConstant;
import com.ysf.velrs.engine.model.RunReqModel;

/**
 * @Author rui
 * @Date 2021-08-08 11:03
 **/
public class RuleRunnerUtil {

    /**
     * 获取类的名字。例如：R_101_1530604229117
     *
     * @param ruleId 规则id
     * @param time   时间戳
     * @return 类名
     */
    public static String getClassName(String ruleId, Long time) {
        return RuleRunnerConstant.NAME_PREFIX
                + ruleId
                + RuleRunnerConstant.UNDER_LINE
                + time;
    }

    /**
     * 获取规则bean名称。例如：R_101
     * 规则运行时的入参规则：最新规则不携带版本号。
     *
     * @param model 规则运行参数
     * @return bean名称
     */
    public static String getRuleBeanName(RunReqModel model) {
        Integer version = model.getVersion();
        return getRuleBeanName(model.getRuleId(), version, (version == null || version.intValue() <= 0));
    }

    /**
     * 获取规则bean名称
     *
     * @param ruleId
     * @param version
     * @param isLatest
     * @return
     */
    public static String getRuleBeanName(String ruleId, Integer version, boolean isLatest) {
        if (isLatest) {
            return RuleRunnerConstant.NAME_PREFIX + ruleId;
        } else {
            return RuleRunnerConstant.NAME_PREFIX + ruleId + RuleRunnerConstant.VERSION_TAG + version;
        }
    }

    /**
     * 测试bean名称
     *
     * @param ruleId
     * @return
     */
    public static String getTestRuleBeanName(String ruleId) {
        return RuleRunnerConstant.NAME_PREFIX + RuleRunnerConstant.TEST_TAG + ruleId;
    }
}