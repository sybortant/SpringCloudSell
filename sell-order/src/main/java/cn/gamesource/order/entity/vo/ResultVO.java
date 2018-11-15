package cn.gamesource.order.entity.vo;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;

/**
 * 返回数据封装
 *
 * @author: LEIYU
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    @Getter
    public enum ResultMsg {

        OK(0, "成功"),
        FAIL(1, "失败,");

        private Integer code;
        private String message;

        ResultMsg(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public ResultVO(ResultMsg msg, T data) {
        this.code = msg.getCode();
        this.msg = msg.getMessage();
        this.data = data;
    }

    public ResultVO(ResultMsg msg) {
        this.code = msg.getCode();
        this.msg = msg.getMessage();
        this.data = (T) new HashMap();
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = (T) new HashMap();
    }

    public static ResultVO ofSuccess(Object data) {
        return new ResultVO(ResultMsg.OK, data);
    }

    public static ResultVO ofSuccess() {
        return new ResultVO(ResultMsg.OK);
    }

    public static ResultVO ofSuccess(String message) {
        return new ResultVO(ResultMsg.OK.code, message);
    }

    public static ResultVO ofFail() {
        return new ResultVO(ResultMsg.FAIL);
    }

    public static ResultVO ofFail(String message) {
        return new ResultVO(ResultMsg.FAIL.code, message);
    }
}
