package top.gsc.utils;

import top.gsc.result.ResultVo;
import top.gsc.result.StatusCode;

public class ResultUtils {

    /**
     * 成功响应，无参数
     *
     * @return 统一响应对象
     */
    public static ResultVo<?> success() {
        return vo(null, StatusCode.SUCCESS_CODE, null);
    }

    /**
     * 成功响应，带消息
     *
     * @param msg 消息内容
     * @return 统一响应对象
     */
    public static ResultVo<?> success(String msg) {
        return vo(msg, StatusCode.SUCCESS_CODE, null);
    }

    /**
     * 成功响应，带消息和数据
     *
     * @param msg 消息内容
     * @param data 数据内容
     * @return 统一响应对象
     */
    public static ResultVo<?> success(String msg, Object data) {
        return vo(msg, StatusCode.SUCCESS_CODE, data);
    }

    /**
     * 成功响应，带消息和自定义状态码和数据
     *
     * @param msg 消息内容
     * @param code 自定义状态码
     * @param data 数据内容
     * @return 统一响应对象
     */
    public static ResultVo<?> success(String msg, int code, Object data) {
        return vo(msg, code, data);
    }

    /**
     * 统一响应对象构建器
     *
     * @param msg 消息内容
     * @param code 状态码
     * @param data 数据内容
     * @return 统一响应对象
     */
    public static ResultVo<?> vo(String msg, int code, Object data) {
        return new ResultVo<>(msg, code, data);
    }

    /**
     * 错误响应，无参数
     *
     * @return 统一响应对象
     */
    public static ResultVo<?> error() {
        return vo(null, StatusCode.ERROR_CODE, null);
    }

    /**
     * 错误响应，带消息
     *
     * @param msg 消息内容
     * @return 统一响应对象
     */
    public static ResultVo<?> error(String msg) {
        return vo(msg, StatusCode.ERROR_CODE, null);
    }

    /**
     * 错误响应，带消息和自定义状态码
     *
     * @param msg 消息内容
     * @param code 自定义状态码
     * @return 统一响应对象
     */
    public static ResultVo<?> error(String msg, int code) {
        return vo(msg, code, null);
    }

    /**
     * 错误响应，带消息和数据
     *
     * @param msg 消息内容
     * @param data 数据内容
     * @return 统一响应对象
     */
    public static ResultVo<?> error(String msg, Object data) {
        return vo(msg, StatusCode.ERROR_CODE, data);
    }
}
