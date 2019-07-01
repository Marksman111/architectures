package com.marksman.architectures.base.constant;

/**
 * @author Wei Laibao
 * @date 2019/7/1 17:04
 * @description 微信相关的常量
 **/
public class WeChatConstant {

    /**
     * 获取小程序全局唯一access_token
     * {1}：第1个参数传appId
     * {2}：第2个参数传secret
     * 用RestTemplate发送GET请求
     */
    public static final String APPLET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={1}&secret={2}";

    /**
     * 获取微信消息模板列表
     * {1}：传access_token
     * 用RestTemplate发送POST请求
     */
    public static final String WECHAT_MESSAGE_TEMPLATE_LIST = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token={1}";

    /**
     * 发送微信模板消息
     * {1}：传access_token
     * 用RestTemplate发送POST请求
     */
    public static final String SEND_WECHAT_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send?access_token={1}";
}
