package com.rino.fel.function;

import com.rino.fel.parser.FelNode;

public class ErrorValue {

    /**
     * 错误节点
     */
    private FelNode node;

    /**
     * 错误信息
     */
    private String errorMsg;

    public ErrorValue(FelNode node, String errorMsg) {
        this.node = node;
        this.errorMsg = errorMsg;
    }

    public FelNode getNode() {
        return node;
    }

    public void setNode(FelNode node) {
        this.node = node;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        if (errorMsg != null) {
            return errorMsg;
        }
        return "执行脚本出错";
    }

}
