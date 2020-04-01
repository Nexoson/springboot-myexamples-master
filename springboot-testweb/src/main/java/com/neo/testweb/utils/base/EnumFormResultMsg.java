package com.neo.testweb.utils.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @ClassName SzxDataPlatFormResultMsg
 * @Descripition 错误枚举类
 * @Auther huangX
 * @Date 2020/4/1 10:29
 * @Version 1.0
 **/
public enum EnumFormResultMsg implements Serializable {

    /**
     * 公共错误代码
     * sasis-common（000000-099999）
     */
    SUCCESS("000000", "成功"),
    NO_SUCCESS("888888","接口未开放"),
    SYSTEM_ERROR("999999", "系统异常，请联系管理员"),
    NETWORK_ERROR("000001", "网络出错"),
    DATABASE_ERROR("000002", "数据库出错"),
    DATABASE_CONNECTION_ERROR("000003", "数据库连接出错"),
    MQ_CONNECTION_ERROR("000004", "消息队列连接出错"),
    FEIGN_CONNECTION_ERROR("000005", "Feign调用服务出错"),
    PARAM_NULL_ERROR("000006", "参数为空错误"),
    MD5_ALGORITHM_ERROR("000007", "MD5加密失败"),
    PARAM_NOT_MATCH("000008", "参数不符合格式"),
    NOT_FOUND_MATCH_DATA("000009", "未查询到符合条件的数据"),
    OPERATE_LOG_SAVE_FAIL("000010", "操作日志保存失败"),
    PARAM_NOT_COMPLETE("000011", "参数不完整"),
    NO_DATA("000012", "数据列为空"),
    EXPORT_DATA_NULL("000013", "查询数据为空,无法导出!请检查后重试"),
    EXCEL_FIELD_LENGTH("000014", "配置Excel导出错误！"),
    IMPORT_EXCEL_ERROR("000015", "导入Excel失败！"),
    IBE_CONNECTION_ERROR("000016", "IBE连接异常！"),
    JSON_FORMAT_ERROR("000017", "json格式错误！"),
    OPERATOR_NULL_ERROR("000018", "连接超时,请重新登录！"),
    EXCEL_PATTERN_ERROR("000019", "EXCEL文件内容或格式错误,导入失败！"),
    IMAGE_TO_BASE_ERROR("000020", "图片流转BASE64出错！"),
    FORGET_PASSWORD("000021", "忘记密码操作相关提示！"),
    NO_PARAM__ERROR("000022", "没有填写一个查询条件"),
    OUTUSE_ERROR("000023", "外网用户最后可用日期不能为空"),
    LOGIN_OUT("000024","登出失败"),
    YEAR_NOT_NULL("888001","年份不能为空"),
    MONTH_NOT_NULL("888002","月份不能为空"),
    DTIME_NOT_NULL("888003","日期不能为空"),
    FIND_TPYE_NULL("888004","查表类型不能为空"),
    START_TIME_NULL("888005","开始时间不能为空"),
    END_TIME_NULL("888006","结束时间不能为空"),
    TIME_ARES("888007","时间区间不合理"),
    HJ_NOT_NULL("888008","航季不能为空"),
    LSTIME_NOT_NULL("888009","历史时间不能为空"),
    OPERATION_ERROR("888010","数据格式错误！"),
    CYR_NOT_NULL("888011","承运人不能为空"),
    TRANS_TYPE_NULL("888012","运输类型不能为空"),
    AUTHENTICATION_UNAMEPWD_ERROR("000050","账户名或密码错误"),
    JWT_TOKEN_EXPIRED("000051","会话已过期，请重新登录"),
    AUTHENTICATION_FAIL("000052","没有访问权限，请联系管理员"),
    AUTHENTICATION_AUTHMETHOD_NOTSUPPORT("000053","请求方法不支持"),
    LOGOUT_FAIL("000054", "注销失败"),
    SERVICE_USER_NOTEXISTS("000055", "用户不存在"),
    SERVICE_UNAVAILABLE("000056", "服务不可用The service is unavailable"),
    SERVICE_SASIS_MANAGER_UNAVAILABLE("000057", "用户服务不可用，请联系管理员"),
    USER_NO_MENUS("000058", "用户没有分配任何菜单，请联系管理员"),
    BAD_CREDENTIALS_ERROR("000059","未授权，请重新登录"),
    VERIFYCODE_ERROR("000060","验证码错误"),
    OBJECT_IS_NULL("000061","对象不能为空"),

    /**
     * abnormal-service错误代码（100000-199999）
     */
    FLT_NUM_NULL("100001", "航班号不能为空"),
    FLT_DATE_NULL("100002", "航班日期不能为空"),
    ORIG_NULL("100003", "始发航站不能为空"),
    DEST_NULL("100004", "到达航站不能为空"),
    QUEY_DATA_NULL("100005", "查询数据为空"),
    FLT_DATE_FORMAT_ERROR("100006", "航班日期格式有误，正确格式（yyyy-MM-dd）"),
    CMD_NULL("100007", "指令不能为空"),
    CMD_FORMAT_ERROR("100008", "指令格式有误，正确格式（ML_B、ML_ZX1B、ML_NR）"),
    PARAM_NULL("100009", "请求参数不能为空"),
    JSON_ERROR("100010", "JSON格式有误，请检查"),
    START_END_DATE_NULL_FORMAT_ERROR("100011", "开始或截止日期不能为空或航班日期格式格式不正确,必须为yyyy-MM-dd!"),
    PNR_LIST_EMPTY("100012", "PNR列表不能为空"),
    CHANNEL_NULL("100013", "查询渠道不能为空"),

    /**
     * baggage-service错误代码（200000-299999）
     */
    //行李信息查询
    BAGGAGEINFO_NOT_NULL("200000", "传入的行李信息查询实体不能为空"),
    BAGGAGEINFO_FLTNUM_NULL("200001", "航班号不能为空"),
    BAGGAGEINFO_FLTDATE_NULL("200002", "日期不能为空"),
    BAGGAGEINFO_ID_NULL("200003", "查询id不能为空"),
    //遗失行李自助申报
    LOSTBAGEINFO_FLTDATE_NULL("200004", "开始日期不能为空"),
    LOSTBAGEINFO_FLTDATE1_NULL("200005", "结束日期不能为空"),
    //旅客失物申报管理
    PSGLOSTINFO_NOT_NULL("200006", "旅客失物申报信息不能为空"),
    PSGLOSTINFO_ID_NULL("200007", "传入的id不能为空"),
    PSGLOSTINFO_UPDATE_ERROR("200008", "信息更新失败"),

    //差错行李信息查询
    LUGGAGEINFO_MISTAKETYPE_NULL("200009", "差错类别不能为空"),
    LUGGAGEINFO_FLTNUM_NULL("200010", "航班号不能为空"),
    LUGGAGEINFO_FLTDATE_NULL("200011", "航班日期不能为空"),
    LUGGAGEINFO_PSG_NAME_NULL("200012", "旅客姓名不能为空"),
    LUGGAGEINFO_LUG_OPER_PSG_NULL("200013", "行李处理人不能为空"),
    LUGGAGEINFO_LUG_RECORD_NULL("200014", "行李处理记录不能为空"),
    LUGGAGEINFO_LUG_OPER_DATE_NULL("200015", "行李处理日期不能为空"),

    //差错行李信息 审批
    EXAMINATIONINFO_ID_NULL("200016", "id不能为空"),
    EXAMINATIONINFO_EID_NULL("200017", "审批组长id不能为空"),
    ADD_ERROR("E200018","该差错行李已经存在"),


    /**
     * baseData-service错误代码（300000-399999）
     */
    //航空公司信息查询
    AIRWAY_ID_NULL("300000", "航空公司ID不能为空"),
    AIRWAY_NOT_NULL("300001", "航空公司信息不能为空"),
    AIRWAY_NAME_NULL("300002", "航空公司名称不能为空"),
    AIRWAY_CODE_NULL("300003", "航空公司信息代码不能为空"),
    AIRWAY_CODE_EXIST("300004", "机场代码已经存在"),
    AIRWAY_NOT_EXIST("300005", "查询不到指定id的航空公司信息"),

    //航班延误原因
    DELAYREASON_NOT_NULL("300006", "航班延误原因不能为空"),
    DELAYREASON_ID_NULL("300007", "航班延误原因ID不能为空"),
    DELAYREASON_CATEGORY_NULL("300008", "航班延误原因分类不能为空"),
    DELAYREASON_NAME_NULL("300009", "航班延误原因名称不能为空"),
    DELAYREASON_IS_EXIST("300010", "该航班延误原因信息已存在"),
    DELAYREASON_NOT_EXIST("300011", "查询不到指定id的航班延误原因信息"),

    // 特殊旅客类别
    SPECIAL_NOT_FOUNT("300012", "查询特殊旅客信息记录失败"),
    SPECIAL_CODE_EXISTS("300013", "代码已存在"),
    SPECIAL_NAME_EXISTS("300014", "名称已存在"),
    SAVE_SUCCESS("300015", "保存成功"),
    SPECIAL_UPDATE_SUCCESS("300016", "特殊旅客信息更新成功"),
    SPECIAL_DELETE_SUCCESS("300017", "SpecialPassengerType has been deleted successfully."),

    // 系统参数管理
    CONFIG_PARAM_NAME_EXISTS("300018", "参数名已存在"),
    CONFIG_PARAM_VALUE_EXISTS("300019", "参数值已存在"),
    CONFIG_TYPE_NOT_FOUND("300020", "参数类型不存在"),
    CONFIG_PARAM_SAVE_SUCCESS("300021", "参设置数保存成功"),
    CONFIG_PARAM_UPDATE_SUCCESS("300022", "参设置更新成功"),
    CONFIG_PARAM_NOT_FOUND("300023", "参数设置不存在"),
    CONFIG_PARAM_DELETE_SUCCESS("300024", "参设置管理删除成功"),
    CONFIG_PARAM_NAME_NEEDED("300025", "参数名不能为空"),
    CONFIG_PARAM_VALUE_NEEDED("300026", "参数值不能为空"),
    INSERT_EXISTS("300113", "插入值已存在"),

    // 系统参数类型管理
    CONFIG_TYPE_SAVE_SUCCESS("300027", "参数类型保存成功"),
    CONFIG_TYPE_EXISTS("300028", "参数类型已存在"),
    CONFIG_TYPE_UPDATE_SUCCESS("300029", "参数类型更新成功"),
    CONFIG_TYPE_DELETE_SUCCESS("300030", "参数类型删除成功"),

    // 航线价格维护
    UPGRADE_PRICE_SAVE("300031", "航线价格维护保存成功"),
    UPGRADE_PRICE_UPDATE("300032", "航线价格维护更新成功"),
    UPGRADE_PRICE_DELETE("300033", "航线价格维护删除成功"),
    UPGRADE_PRICE_NOT_FOUND("300034", "查询航线价格维护失败"),
    UPGRADE_PRICE_EXISTS("300084", "航线价格维护已存在"),

    //城市信息维护
    CITY_ID_NULL("300035", "机场信息ID不能为空"),
    CITY_NOT_NULL("300036", "机场信息不能为空"),
    CITY_CODE_NULL("300037", "机场四字码不能为空"),
    CITY_CODEF_NULL("300038", "机场三字码不能为空"),
    CITY_CODES_IS_EXIST("300039", "机场三字码或机场四字码已经存在"),
    CITY_NOT_EXIST("300040", "查询不到指定id的城市信息"),
    CITY_CODE_EXIST("300071", "机场四字码已经存在"),
    CITY_CODEF_EXIST("300072", "机场三字码已经存在"),
    CITY_AIRPORT_NULL("300078", "机场名称不能为空"),
    CITY_NAME_NULL("300079", "机场简称不能为空"),
    CITY_CITYCODEF_NULL("300080", "城市三字码不能为空"),
    CITY_CITYNAME_NULL("300081", "城市名称不能为空"),
    CITY_TYPE_NULL("300082", "航站类型不能为空"),
    CITY_TIMEZONE_NULL("300083", "时区不能为空"),
    CITY_TIMEZONE_CALC_ERROR("300084", "时区转换出错,计算时差失败!"),
    CITY_TIMEZONE_PARAM_LACK("300085", "时区参入参数不完整"),
    CITY_TIMEZONE_PARAM_ERROE("300102", "时区类型传入参数错误!"),
    CITY_NAME_EXIST_ERROE("300086", "机场简称已经存在"),
    CITY_TIMEDIFFERENCE_NULL("300087", "时差不能为空"),


    // 舱位折扣维护
    DISCOUNT_UPDATE("300041", "舱位折扣维护更新成功"),

    // Y舱升舱航线价格维护
    YG_CABIN_NOT_FOUND("300042", "查询Y舱升舱航线价格失败"),
    YG_CABIN_SAVE("300043", "Y舱升舱航线价格保存成功"),
    YG_CABIN_UPDATE("300044", "Y舱升舱航线价格更新成功"),
    YG_CABIN_DELETE("300045", "Y舱升舱航线价格删除成功"),

    //航班状态查询
    FLIGHTSTATE_ID_NULL("300046", "航班状态ID不能为空"),
    FLIGHTSTATE_NOT_NULL("300047", "航班状态信息不能为空"),
    FLIGHTSTATE_CODE_NULL("300048", "航班状态四位代码不能为空"),
    FLIGHTSTATE_NAME_NULL("300049", "航班状态名称不能为空"),
    FLIGHTSTATE_CODES_IS_EXIST("300050", "代码或名称已经存在"),
    FLIGHTSTATE_NOT_EXIST("300051", "查询不到指定id的航班状态信息"),
    FLIGHTSTATE_CODE_EXIST("300073", "航班状态代码已经存在"),
    FLIGHTSTATE_NAME_EXIST("300074", "航班状态名称已经存在"),

    //旅客状态查询
    PASSENGERSTATE_ID_NULL("300052", "旅客状态ID不能为空"),
    PASSENGERSTATE_NOT_NULL("300053", "旅客状态信息不能为空"),
    PASSENGERSTATE_CODE_NULL("300054", "旅客状态代码不能为空"),
    PASSENGERSTATE_NAME_NULL("300055", "旅客状态名称不能为空"),
    PASSENGERSTATE_CODES_IS_EXIST("300056", "代码或名称已经存在"),
    PASSENGERSTATE_NOT_EXIST("300057", "查询不到指定id的旅客状态信息"),
    PASSENGERSTATE_CODE_EXIST("300075", "旅客状态代码已经存在"),
    PASSENGERSTATE_NAME_EXIST("300076", "旅客状态名称已经存在"),

    //协议酒店
    HOTEL_ID_NULL("300058", "协议酒店ID不能为空"),
    HOTEL_NOT_NULL("300059", "协议酒店信息不能为空"),
    HOTEL_ADDRESS_NULL("300060", "协议酒店地址不能为空"),
    HOTEL_NAME_NULL("300061", "协议酒店名称不能为空"),
    HOTEL_PHONE_NULL("300062", "协议酒店电话不能为空"),
    HOTEL_PRICE_NULL("300063", "协议酒店价格不能为空"),
    HOTEL_CODES_IS_EXIST("300064", "该酒店信息已经存在"),

    // 业务错误提示
    SAVE_FAIL("300065", "保存失败！"),
    DELETE_FAIL("300066", "删除失败！"),
    UPDATE_FAIL("300067", "更新失败！"),
    FOUND_FAIL("300068", "查询失败！"),
    NEEDED_FAIL("300069", "您有必填项未填写！"),
    UPDATE_SUCCESS("300070", "更新成功"),
    DELETE_SUCCESS("300077", "删除成功"),
    CANCEL_FAIL("300086", "取消失败"),

    // 高端旅客类别
    VIP_TYPE_NAME_EXISTS("300090", "名称已存在"),
    VIP_TYPE_CODE_EXISTS("300091", "代码已存在"),
    VIP_TYPE_ID_EXISTS("300092", "编码已存在"),
    USER_ID_NULL("300093", "用户账号不能为空"),

    // 旅客喜好类别管理
    VIP_LOVE_TYPE_NAME_EXISTS("300100", "名称已存在"),
    VIP_LOVE_TYPE_NOT_EXISTS("300101", "上级不存在！"),

    // 舱位折扣维护
    DISCOUNT_UPDATE_LENGTH("300110", "数据不全"),

    //航班超售信息
    OVER_SELL_PLAN_EXISTS("300111", "航班号、始发地、到达地数据已存在"),
    OVER_SELL_AC_REG_EXISTS("300112", "机尾号已存在"),

    //普通酒店轮班
    SHIFT_DATE_USED("300120", "该航班日期已经被其他分组占用，请选择未被占用的日期"),

    /**
     * fit-service错误代码（400000-499999）
     */
    //不正常航班处理
    INTO_INSERT_ERROR("400000", "信息插入失败"),
    INTO_UPDATE_ERROR("400001", "信息更新失败"),
    INTO_DELETE_ERROR("400002", "信息删除失败"),
    ABNORMALFLTHANDLE_STARTDATE_NULL("400003", "开始日期不能为空"),
    ABNORMALFLTHANDLE_ENDDATE_NULL("400004", "结束日期不能为空"),
    ABNORMALFLTHANDLE_ID_NULL("400005", "不正常航班信息id不能为空"),
    ABNORMALFLTHANDLE_FLTINFO_NULL("400006", "查询不到指定id的不正常航班信息"),
    ABNORMALFLTHANDLE_FLTNUM_NULL("400007", "航班号不能为空"),
    ABNORMALFLTHANDLE_FLTDATE_NULL("400008", "航班日期不能为空"),
    ABNORMALFLTHANDLE_ORIG_NULL("400009", "始发地不能为空"),
    ABNORMALFLTHANDLE_DEST_NULL("400010", "达到地不能为空"),
    ABNORMALFLTHANDLE_PSGID_NULL("400011", "不正常航班旅客信息id不能为空"),
    ABNORMALFLTHANDLE_PNRICS_NULL("400012", "不正常航班旅客信息pnrIcs不能为空"),
    ABNORMALFLTHANDLE_NOTICETEL_NULL("400013", "电话通知状态不能为空"),
    ABNORMALFLTHANDLE_NOTICETELTIME_NULL("400014", "电话通知时间不能为空"),
    ABNORMALFLTHANDLE_ABNORMALTYPE_NULL("400015", "不正常类型不能为空"),
    ABNORMALFLTHANDLE_CMD_NULL("400016", "指令不能为空"),
    ABNORMALFLTHANDLE_RESOURCE_NULL("400017", "下载源不能为空"),
    ABNORMALFLTHANDLE_DOWNLOAD_EXCEPTION("400018", "download_exception"),
    ABNORMALFLTHANDLE_RECHECK_EXCEPTION("400019", "recheck_exception"),
    ABNORMALFLTHANDLE_MSG_INSERT_FAIL("400020", "短信记录插入数据库失败,返回短信id为空"),
    ABNORMALFLTHANDLE_PSG_IDS_NULL("400021", "传入的需要发送的旅客id为空"),
    ABNORMALFLTHANDLE_BATCH_INSERT_PSGTEMP_ERROE("400031", "批量插入不正常航班旅客Temp数据时出现错误!请刷新页面"),
    ABNORMALFLTHANDLE_UPDATE_TEL_ERROE("400032", "更新旅客电话通知信息失败!请刷新页面"),
    ABNORMALFLTHANDLE_INSERT_TEL_RECORD_ERROE("400033", "插入旅客电话通知信息失败!请刷新页面"),
    ABNORMALFLTHANDLE_PSG_NULL("400039", "查询不到指定id的旅客信息"),
    ABNORMALFLTHANDLE_PSG_PROTECT_PATTERN_ERROR("400040", "旅客保护字段格式错误!"),
    ABNORMALFLTHANDLE_SEND_MSG_ERROR("400041", "执行发送短信过程中,获取不正常航班保护模板失败!"),
    ABNORMALFLTHANDLE_MSG_NULL_ERROR("400042", "短信内容不能为空!"),
    ABNORMALFLTHANDLE_DOWNLOAD_FEIGN_ERROR("400043", "网络连接异常,请重新执行下载操作!"),
    ABNORMALFLTHANDLE_RECHECK_FEIGN_ERROR("400044", "网络连接异常,请重新执行复核操作!"),
    ABNORMALFLTHANDLE_SEND_MSG_FEIGN_ERROR("400045", "网络连接异常,请重新执行发送短信操作!"),
    ABNORMALFLTHANDLE_RECEIPT_ERROR("400046", "网络连接异常,请重新执行回执操作!"),
    ABNORMALFLTHANDLE_MULTIRESULT_ERROR("400047", "连接超时,请重新执行下载操作!"),
    ABNORMALFLTHANDLE_TRACE_ERROR("400048", "下载trace数据失败,请重新执行下载操作!"),
    ABNORMALFLTHANDLE_MULTIRESULT_FALLBACK_ERROR("400049", "网络连接出现异常,请重新执行下载操作!"),
    ABNORMALFLTHANDLE_CODE_ERROR("400050", "下载失败,请重新执行下载操作!"),

    //不正常航班设置
    ABNORMALFLTSETTING_FLTNUM_NULL("400022", "航班号不能为空"),
    ABNORMALFLTSETTING_FLIINFOID_NULL("400023", "航班id不能为空"),
    ABNORMALFLTSETTING_FLTDATE_NULL("400024", "航班日期不能为空"),
    ABNORMALFLTSETTING_ACREG_NULL("400025", "飞机号不能为空"),

    //不正航班旅客通知状态查询
    ABNORMALPSGNOTIFY_STARTDATE_NULL("400026", "航班起始不能为空"),
    ABNORMALPSGNOTIFY_ENDDATE_NULL("400027", "航班结束不能为空"),
    ABNORMALPSGNOTIFY_FLTDATE_NULL("400028", "航班日期不能为空"),
    ABNORMALPSGNOTIFY_FLTNUM_NULL("400029", "航班号不能为空"),
    ABNORMALPSGNOTIFY_ORIG_NULL("400030", "航班始发地不能为空"),
    ABNORMALPSGNOTIFY_DEST_NULL("400034", "航班到达地不能为空"),

    //不正常航班外呼处理列表
    ABNFLTOUTCALL_ID_NULL("400035", "旅客id不能为空"),
    ABNFLTOUTCALL_LOCK_NULL("400036", "锁状态不能为空"),
    ABNFLTOUTCALL_PSG_NULL("400037", "获取不正常航班旅客信息失败"),
    ABNFLTOUTCALL_BATCH_UPDATE_LOCK_NULL("400038", "批量更新锁状态出现错误"),
    ABNFLTOUTCALL_BATCH_OPERATOR_NULL("400040", "批量处理执行过程出现错误,请联系管理员!"),


    /**
     * msg-service错误代码（500000-599999）
     */
    DATA_INSERT_ERROR("500000", "信息保存失败"),
    DATA_UPDATE_ERROR("500001", "信息更新失败"),
    DATA_DELETE_ERROR("500002", "信息删除失败"),
    DATA_QUERY_ERROR("500003", "信息查询失败"),
    MSG_ERROR("500004", "短信记录保存失败"),
    //登机口短信通知
    BOARDINGGATEMSG_ID_NULL("500004", "登机口短信通知ID不能为空"),
    BOARDINGGATEMSG_FLTDATE_NULL("500005", "登机口短信通知航班日期不能为空"),
    BOARDINGGATEMSG_FLTNUM_NULL("500006", "登机口短信通知航班号不能为空"),
    BOARDINGGATEMSG_MOBILE_NULL("500007", "登机口短信通知发送手机号不能为空"),
    BOARDINGGATEMSG_CONTENT_NULL("500008", "登机口短信通知发送内容不能为空"),
    BOARDINGGATEMSG_TYPE_NULL("500009", "登机口短信通知短信类型不能为空"),
    //短信历史查询
    MSGRECORD_FLTNUM_FLTDATE_NULL("500010", "航班号、航班日期必须至少输入一项"),
    //短信模板管理
    MSGTEMPLATE_ID_NULL("500011", "短信模板管理-ID不能为空"),
    MSGTEMPLATE_SMSTYPEID_NULL("500012", "短信模板管理-短信类型不能为空"),
    MSGTEMPLATE_NAME_NULL("500013", "短信模板管理-名称不能为空"),
    MSGTEMPLATE_CONTENT_NULL("500014", "短信模板管理-短信内容不能为空"),
    //短信类型管理
    MSGTYPE_ID_NULL("500015", "短信类型管理-ID不能为空"),
    MSGTYPE_MSGNAME_NULL("500016", "短信类型管理-短信类型名称不能为空"),
    MSGTYPE_MSGCODE_NULL("500017", "短信类型管理-类型编码不能为空"),
    MSGTYPE_MSGNAME_EXIST("500018", "短信类型管理-短信类型名称已经存在"),
    MSGTYPE_NOT_EXIST("500019", "短信类型管理-查询不到对应id的短信类型信息"),

    // 短信值机接口
    SMS_CHECK_SMS_FLAG("500020", "是否已发送短信值机提醒不能为空"),
    DATE_TIME_WRONG("500021", "时间格式为yyyy-MM-dd HH:mm:ss"),
    FAIL("500022", "失败！"),
    //短信接收人管理
    MSGRECEIVER_ID_NULL("500023", "短信接收人管理-ID不能为空"),
    MSGRECEIVER_MOBILE_NULL("500024", "短信接收人管理-手机号码不能为空"),
    MSGRECEIVER_SMSTYPE_NULL("500025", "短信接收人管理-短信类型不能为空"),
    MSGRECEIVER_RECEIVER_NULL("500026", "短信接收人管理-姓名不能为空"),
    //自定义短信发送
    CUSTOMMSGSEND_MOBILE_NULL("500027", "电话号码不能为空"),
    CUSTOMMSGSEND_CONTENT_NULL("500028", "短信内容不能为空"),
    CUSTOMMSGSEND_FILE_NULL("500029", "请选择要上传的EXCEL文件!"),
    CUSTOMMSGSEND_FILENAME_NULL("500030", "文件类型不匹配,请上传(.xls或.xlsx格式的)EXCEL文件!"),
    CUSTOMMSGSEND_EXCEL_DATA_NULL("500031", "请检查EXCEL文件中内容是否正确，稍后重试!"),
    CUSTOMMSGSEND_FILE_SIZE_MAX("500032", "传入的文件大小不能超过10M"),
    CUSTOMMSGSEND_FILE_NOT_EXIST("500033", "请求下载的文件不存在"),
    CUSTOMMSGSEND_FIND_FILE_ERROE("500034", "获取请求下载的文件路径时出现错误,文件路径为空!"),

    SMS_CHECK_REPEAT("500035", "参数条件重复"),
    SMS_CHECK_EXISTS("500036", "数据已存在"),
    MSG_NO_TEMPLATE("500040", "获取登机口通知模板失败！"),

    Booking_MEAL_MSG_TEMPLATE_IS_NULL("500051", "获取点餐邀请短信模板失败"),

    /**
     * psg-service错误代码（600000-699999）
     */


    // 机上会员查询
    MEMBER_DATE_WRONG("600009", "时间格式为yyyy-MM-dd"),

    // 孕妇查验管理
    PREGNANT_FLT_NUM_NULL("600010", "航班号不能为空"),
    PREGNANT_FLT_DATE_NULL("600011", "日期不能为空"),
    PREGNANT_EXISTS("600012", "该旅客该趟航班已保存！"),
    PREGNANT_PSG_NOT_FOUND("600013", "查询该旅客该趟航班失败！"),
    PREGNANT_DATE_WRONG("600014", "时间格式为yyyy-MM-dd"),
    PREGNANT_NOT_FOUND("600015", "查询孕妇查验管理失败"),
    FLIGHT_NOTIFY_NOT_FOUND("600016", "旅客通知情况记录不存在"),

    // 职业体验信息服务
    PROFESSIONAL_DATE_WRONG("600020", "时间格式为yyyy-MM-dd"),

    //出行秘书
    NOT_AUTHORITY("600030", "没有操作权限"),
    ENSURE_OPERATING("600031", "正在操作中,操作人请看data数据"),

    //升舱记录查询
    UPGRADE_ID_NOT_EXIST("600040", "升舱记录ID不存在"),


    /**
     * sasis-webservice错误代码（700000-799999）
     */
    CALL_ABNORMAL_QUERYTRACEPSR_FAIL("700001", "调用sasis-trace服务queryTracePsr接口失败"),
    CALL_ABNORMAL_QUERYTRACEPSR_RESULT_NULL("700002", "调用sasis-trace服务TracePsrFeign.queryTracePsr接口返回SasisResult对象为null"),
    CALL_SERVICE_TRIP_SASIS_QUERYTRACEPSR_FAIL("700003", "调用SERVICE-TRIP-SASIS服务TicketInfo接口失败"),
    CALL_SERVICE_TRIP_SASIS_QUERYTRACEPS_RRESULT_NULL("700004", "调用SERVICE-TRIP-SASIS服务TicketInfo接口返回结果为空"),
    CALL_PASSENGERTRACEINFO_RESULT_NULL("700005", "调用sasis-trace服务PassengerTraceFeign.queryPassengerTraceInfos接口返回SasisResult对象为null"),
    CALL_QUERYFLIGHTDYNAMIC_RESULT_NULL("700006", "调用sasis-trace服务FlightDynamicFeign.queryFlightDynamicInfos接口返回SasisResult对象为null"),
    CALL_ADDLOSTITEMS_RESULT_NULL("700007", "调用sasis-baggage服务LostInfoReportFeign.addLostItems接口返回SasisResult对象为null"),
    CALL_GETSATISFACTIONPASSENGERS_RESULT_NULL("700008", "调用sasis-core服务SatisfactionSurveyPsgInfosFeign.getSatisfactionPassengers接口返回SasisResult对象为null"),

    // 航变旅客获取接口
    CHANGE_ALL_KEY("700010", "必填项有参数缺失"),
    CHANGE_ALL_VALUE("700011", "必填项含有空值"),
    CHANGE_ORIG_ERROR("700012", "orig的值必须为大写三字码"),
    CHANGE_DEST_ERROR("700013", "dest的值必须为大写三字码"),
    FALL_BACK_ERROR("700014", "调用服务失败！"),
    CHANGE_DEST_3("700015", "到达航站的长度不能超过3"),
    CHANGE_ORIG_3("700016", "始发航站的长度不能超过3"),
    CHANGE_CITY("700017", "城市信息错误"),

    // 易行机场接收接口
    CAR_ID_CARD_NULL("700020", "身份证号不能为空"),
    CAR_NAME_NULL("700021", "姓名不能为空"),

    //短信值机接口
    TIME_ERROR("700030", "时间格式为yyyy-MM-dd HH:mm:ss"),
    DATE_ERROR("700031", "时间格式错误"),

    // CIP优惠券接口
    CITY_NOT_FOUND("700041", "根据三字码识别城市失败"),
    OUT_TRADE_NO_NULL("700042", "outTradeNo is null"),
    URL_NULL("700043", "urlString is null"),
    SECURITY_EXCEPTION("700044", "快速安检接口异常"),
    FILED_NOT_EXISTS("700045", "属性不存在"),
    CIP_SASIS("700046", "该旅客已在[深航易行高端组]渠道申请cip劵"),
    CIP_APP("700047", "该旅客已在[微信app]渠道申请cip劵"),
    CIP_B2C("700048", "该旅客已在[电商b2c]渠道申请cip劵"),
    CIP_CONFIG_NOT_FOUND("700049", "查询同行程同手机号旅客可重复次数失败"),
    DEP_TIME_FORMATTER("700200", "depTime格式为:yyyy-MM-dd HH:mm:ss"),
    ARR_TIME_FORMATTER("700201", "arrTime格式为:yyyy-MM-dd HH:mm:ss"),
    CONTACT_MOBILE_FORMATTER("700202", "contactMobile不符合格式"),
    ORG_CITY_FORMATTER("700203", "orgCity不符合格式"),
    START_DATE_FORMATTER("700204", "startDate格式为yyyy-MM-dd"),
    END_DATE_FORMATTER("700204", "endDate格式为yyyy-MM-dd"),
    NOT_EXISTS("700205", "没有指定的内容"),

    // 投诉信息接口
    COMPLAINT_NO_NULL("700050", "投诉单号不能为空！"),
    COMPLAINT_NO_15("700051", "投诉单号长度超过15！"),
    NAME_CN_26("700052", " 旅客中文名长度不能超过26！"),
    MEMBER_NO_20("700053", " 旅客会员卡号长度不能超过20！"),
    MEMBER_LEVEL_3("700054", " 旅客会员级别长度不能超过3！"),
    FLIGHT_NO_10("700055", " 旅客航班号长度不能超过10！"),
    TICKET_NO_15("700056", " 旅客票号长度不能超过15！"),
    FLIGHT_SEGMENT_F_13("700057", " 旅客航段起始地长度不能超过13！"),
    FLIGHT_SEGMENT_T_13("700058", " 旅客航段到达地长度不能超过13！"),
    CONTENT_1300("700059", " 旅客投诉内容长度不能超过1300！"),
    RESULT_3("700060", " 旅客投诉结果长度不能超过3！"),
    ID_CARD_30("700061", " 旅客证件号长度不能超过30！"),

    // 直销渠道手机号接口
    CT_EXISTS("700070", "<result><errorCode>1</errorCode><description>保存失败。数据库中已存在该记录，请检查ct项或operateType项内容！</description></result>"),
    SAVE_ERROR("700070", "<result><errorCode>1</errorCode><description>保存失败</description></result>"),
    SAVE_ERROR_2("700070", "<result><errorCode>1</errorCode><description>保存失败。请检查ct项或operateType项内容！</description></result>"),
    CT_NOT_EXISTS("700071", "更新失败。请检查ct项或operateType项内容！"),
    PNR_FORMATTER("700072", "pnr格式错误：多个订座编码用,隔开"),
    ORDER_MOBILE_FORMATTER("700073", "orderMobile格式错误：多个订座手机号用,隔开"),
    OPERATE_TYPE_FORMATTER("700073", "operateType：请填1(新增)或者2(更新)"),
    PARAM_NULL_1("700073", "<result><errorCode>2</errorCode><description>参数错误。xml文件格式有误，请仔细检查！</description></result>"),
    PARAM_NULL_2("700073", "<result><errorCode>2</errorCode><description>参数错误。数据格式或值不符合要求，请仔细检查！</description></result>"),

    // 特殊旅客接口
    TRANCE_ERROR("700080", "新增参数转换异常"),
    ATTENTION_20("700080", "备注信息不能超过20个字"),
    SPE_DELETED_NOT_BLANK("700081", "此为更新不可删除"),
    REPEAT_ERROR("700082", "数据不能重复"),
    SPE_STARTDATE_ERROR("700083", "开始日期不能为空"),
    SPE_ENDDATE_ERROR("700084", "结束日期不能为空"),
    PSG_NAME("700085", "psg_name不能为空"),
    FLIGHT_NUM("700086", "flight_num不能为空"),
    FLIGHT_DATE("700087", "flight_date不能为空"),
    TABLE_TYPE("700088", "table_type不能为空"),
    ID_CARD("700089", "id_card不能为空"),

    // 掌上深航降舱-特殊-重点关注-超售接口
    FLT_CITY_CODE("700090", "fltCityCode格式必须是三个大写英文字母组成"),
    SZAIR_FLT_TYPE("700091", "进出港值超过范围"),
    PSGNAME("700092", "旅客姓名不能为空"),
    IDCARD("700093", "证件号不能为空"),
    FLTNUM("700094", "航班号不能为空"),
    FLTDATE("700095", "航班日期不能为空"),
    TABLETYPE("700096", "表单不能为空"),
    IDX("700097", "idx不能为空"),
    CODE_ONE("700098", "{\"rspCode\":\"1\"}"),
    CODE_TWO("700099", "{\"rspCode\":\"2\"}"),
    CODE_THREE("700100", "{\"rspCode\":\"3\"}"),
    CODE_FOUR("700101", "{\"rspCode\":\"4\"}"),
    CODE_FIVE("700102", "{\"rspCode\":\"5\"}"),
    CODE_SIX("700103", "{\"rspCode\":\"6\"}"),
    //    CODE_0_DATAS("700104", "{\"rspCode\":\"0\",\"info\":\"参数格式错误\",\"totalnum\":\"0\"}"),
    CODE_TWO_2("700105", "{\"rspCode\":\"2\",\"info\":\"参数格式错误\",\"totalnum\":\"0\",\"data\":[]}"),
    CODE_6_ORIG("700106", "{\"rspCode\":\"6\",\"info\":\"orig参数值为空\",\"totalnum\":\"0\",\"data\":[]}"),
    CODE_5_ORIG("700107", "{\"rspCode\":\"5\",\"info\":\"flt_citycode参数格式不正确\",\"totalnum\":\"0\",\"data\":[]}"),
    CODE_6_DATE("700108", "{\"rspCode\":\"6\",\"info\":\"flt_date参数值为空\",\"totalnum\":\"0\",\"data\":[]}"),
    CODE_5_DATE("700109", "{\"rspCode\":\"5\",\"info\":\"flt_date参数格式不正确\",\"totalnum\":\"0\",\"data\":[]}"),
    CODE_FIVE_5("700110", "{\"rspCode\":\"5\",\"info\":\"参数格式错误\",\"totalnum\":\"0\",\"data\":[]}"),
    CODE_0_DATA("700110", "{\"rspCode\":\"0\",\"info\":\"查无数据\",\"totalnum\":\"0\",\"data\":[]}"),


    // 航班状态查询接口
    FLIGHT_NO_6("700140", "航班号长度不能超过6个字符"),
    FLIGHT_AIR_CODE_4("700141", "航空公司编码长度不能超过4个字符"),
    DEPART_CODE_4("700142", "起飞机场POD长度不能超过4个字符"),
    FLIGHT_ID_66("700143", "FIPS UUID长度不能超过66个字符"),
    PARKIN_APRON_3("700144", "停机位长度不能超过3个字符"),
    LEAVE_NUMBER_3("700145", "离港排序队列长度不能超过3个字符"),
    CMD_TYPE_4("700146", "报文类型长度不能超过4个字符"),
    COBT_FLAG_1("700147", "当前的COBT的锁定状态长度不能超过1个字符"),
    COBTPREV_FLAG_1("700148", "上一次的COBT的锁定状态长度不能超过1个字符"),
    REMARK_1300("700149", "备注长度不能超过1300个字符"),

    //遗失物品申报接口
    LOST_INFO_NULL("700160", "遗失物品申报对象为空"),
    PSG_NAME_NULL("700161", "失客姓名不能为空"),
    PSG_PHONE_NULL("700162", "手机号码不能为空"),
    LOST_OBJ_NULL("700163", "物品名称不能为空"),
    LOST_OBJ_DETAIL("700164", "遗失物品描述不能为空"),

    LOST_TYPE("700165", "物品类型不能为空"),
    PARAM_PARSE_ERROR("700166", "参数解析异常"),
    XML_ERROR("700167", "XML格式错误"),
    LOST_OBJ_LENGTH_LIMIT("700168", "物品名称长度不能超过10个字符"),
    LOST_OBJ_DETAIL_LENGTH_LIMIT("700169", "遗失物品描述长度不能超过100个字符"),

    LOST_OBJ_DETAIL_10("700170", "遗失物品描述不能超过10个字符"),

    // 天气接口
    AIR_PORT_CODE("700180", "airPortCode格式为3个字母"),
    NO_PSG_DATA("700181", "没有找到旅客信息"),

    ID_IS_NUMBER("700201","ID只能由数字组成,最大长度为38位"),


    /**
     * trip-service错误代码（800000-899999）
     */
    CARD_ID_NULL("800001", "证件号不能为空"),
    PRODUCT_NAME_NULL("800002", "产品名称不能为空"),

    /**
     * sasis-manager错误代码（900000-909999）
     */
    USERNAME_NULL("900001", "用户名或密码错误"),
    PASSWORD_ERROR("900002", "密码错误"),
    EMPLOYEE_INFO_NULL("900003", "员工信息不存在"),
    USER_NOT_NULL("900004", "用户信息不能为空"),
    ROLE_NOT_NULL("900005", "角色信息不能为空"),
    MENU_NOT_NULL("900006", "菜单信息不能为空"),
    DEPT_NOT_NULL("900007", "部门信息不能为空"),
    ID_NOT_NULL("900008", "ID不能为空"),
    USERID_NOT_NULL("900009", "账号不能为空"),
    MENU_NULL("900010", "菜单不能重复"),
    USER_NULL("900011", "用户ID不能重复"),
    ROLE_NULL("900012", "角色名称不能重复"),
    USER_IS_NULL("900013", "账号为空"),
    OLDPASSWORD_ERROR("900014", "旧密码错误"),
    DEPT_IS_NULL("900015", "部门名称或部门代码重复"),
    DEPTCODE_ERROR("900016", "不能新建部门代码"),
    PASSWORD_NULL("900017", "密码和确认密码为空或不一致"),
    USER_NAME_NULL("900018", "用户账号不能重复"),
    USER_NAME_NOT_EXISTS("900019", "用户账号不存在"),
    MENUPATH_NULL("900020", "菜单路径重复"),
    IPWHITELIST_NOT_NULL("900021", "ip不能为空"),
    USERLOGOUT("900022", "该用户已禁用,请勿重复操作"),
    /**
     * sasis-elasticJob错误代码（910000-919999）
     */
    MSG_TEMPLETE_NULL("910000", "短信模板为空"),
    CKI_MSG_TEMPLETE_NULL("910001", "值机统计短信模板为空"),
    MEAL_MSG_TEMPLETE_NULL("910002", "点餐统计短信模板为空"),
    FEIGN_CALL_BACK_ERROR("910003", "连接Feign失败"),


    //电商升舱券统计
    FLT_FORM_DATE("910004", "航班日期始不能为空"),
    FLT_END_DATE("910005", "航班日期止不能为空"),

    // 登机口自动提醒
    SAVE_RECORD_FAIL("910010", "保存短信历史失败"),

    // 满意度调查短信
    TEMPLATE_CONTENT_FAIL("910020", "获取短信失败！"),

    // 航班信息服务
    FLT_PSG_NOT_EXISTS("910030", "旅客信息不存在或不完整"),


    // 中转航班
    TRANSFER_NOT_FOUND("910040", "没有找到该航班的上传内容,请确认该航班已上传中转旅客名单!"),
    TRANSFER_NOT_NULL("910041", "中转住宿规则信息不能为空"),
    TRANSFER_ID_NULL("910042", "中转住宿规则ID不能为空"),
    TRANSFER_RULES_NOT_NULL("910043", "中转航班识别规则信息不能为空"),
    TRANSFER_RULES_ID_NULL("910044", "中转航班识别规则ID不能为空"),
    TRANSFER_INSERT_NULL("910045", "请先于机场信息维护录入您的机场信息！"),
    TRANSFER_SERVICE_TYPE("910046", "保障中转类型不能为空"),
    TRANSFER_ORIG_CITY("910047", "机场三字码不能为空"),
    TRANSFER_NUMBER("910048", "只能输入数字"),
    /**
     * trace错误代码（910000-919999）
     */
    QUERY_PARAM_NULL("E00000", "查询参数不能为空"),
    NOT_IS_JSON("E00001", "参数不是JSON格式"),
    QUERY_TYPE_IS_NULL("E00002", "查询条件类型不能为空"),
    QUERY_TYPE_ERROR("E00012", "查询条件类型错误，请输入(NI:证件、TN:票号）"),
    QUERY_NUM_IS_NULL("E00003", "证件号或票号不能为空"),


    START_DATE_IS_NULL("E00004", "航班起始日期不能为空"),
    START_DATE_FORMAT_ERROR("E00005", "航班起始日期格式错误，正确格式：yyyy-MM-dd"),
    END_DATE_IS_NULL("E00006", "航班截止日期不能为空"),
    END_DATE_FORMAT_ERROR("E00007", "航班截止日期格式错误，正确格式：yyyy-MM-dd"),
    SORT_TYPE_IS_NULL("E00008", "排序类型不能为空"),
    PAGE_NUM_IS_NULL("E00009", "页码不能为空"),
    PAGE_SIZE_IS_NULL("E00010", "条数不能为空"),
    QUERY_SOURCE_IS_NULL("E00011", "查询渠道不能为空"),
    FLT_NUM_IS_NULL("E00021", "航班号不能为空"),
    NAME_IS_NULL("E00022", "名称不能为空"),
    ID_NUM_IS_NULL("E00023", "证件号不能为空"),
    SORT_TYPE_ERROR("E00024", "排序类型错误，请输入（D：降序，A：升序）"),

    DATE_FORMAT_ERROR("E000024", "航班日期格式错误，正确格式：yyyy-MM-dd"),
    VIP_VVIP_CIP_ERROR("E000025", "VVIP、VIP、CIP只能选择其中一种！"),
    PASSENGER_ECHO_ERROR("E000032", "该旅客已存在,请勿重复添加 !"),


    EXIST_ORDER("E000026", "该订单已经存在 !"),
    NO_EXIST_ORDER("E000027", "该订单不存在 !"),
    NO_EXIST_MODEL("E000028", "该模型资源不存在 !"),

    ET_NUM_IS_13("E000029", "票号为13位数字"),
    NAME_IS_50("E000030", "姓名最多只支持50个字符"),
    ID_CARD_IS_18("E000031", "证件号只支持18个字符"),
    FLT_NUM_IS_8("E000032", "航班号不得超过8个字符"),
    ID_CARD_IS_NULL("E000033", "证件号不能为空"),
    ET_NUM_IS_NULL("E000034", "票号不能为空"),

    IMPORTBATCH_PASSENGER_ECHO_ERROR("E000035", "导入的数据中有旅客已经存在"),

    NAME_NOT_NULL("E000036", "文件名不能为空"),
    PSG_TRACE_FEIGN_CALL_BACK_ERROR("E000037", "查询旅客行程信息,连接Feign失败"),
    FLT_INFO_FEIGN_CALL_BACK_ERROR("E000038", "查询航班状态信息,连接Feign失败"),
    PARAM_NULL_BACK_ERROR("E000039", "查询航班状态,参数为空"),

    /**
     * 国航入会接口错误代码（R000001-R001018）
     */
    RED_PSG_ADD_SYS_ERROR("R000099", "国航入会接口系统异常"),
    RED_PSG_ADD_REQUIRED_ERROR("R000001", "必填参数缺失"),
    RED_PSG_ADD_DATATYPE_ERROR("R000002", "参数数据类型不匹配"),
    RED_PSG_ADD_IDCARD_ERROR("R000004", "参数身份证不正确 "),
    RED_PSG_ADD_CREATCARD_ERROR("R000005", "国航入会接口自动获取会员号失败"),
    RED_PSG_ADD_DUPMEMBER_ERROR("R000007", "会员已经注册"),
    RED_PSG_ADD_NULLPARAM_ERROR("R000027", "传入接口参数不完整"),
    RED_PSG_ADD_IDINVALID_ERROR("R000028", "传入接口参数ID项无效"),
    RED_PSG_ADD_DUPPHONE_ERROR("R000021", "参数手机号码重复"),
    RED_PSG_ADD_ERRPHONE_ERROR("R000022", "参数手机号无效"),
    RED_PSG_ADD_AUTHORITY_ERROR("R001018", "无权限调用接口"),
    RED_PSG_ADD_UNKNOWERR_ERROR("R000040", "未知异常请查看错误日志"),

    /**
     * param
     * 200001
     */
    PARAM_QUOTA_ERROR("200001","参数格式错误"),
    PARAM_DATATIME_ERROR("200002","日期参数异常"),
    QUOTA_NO_DATA_ERROR("200003","数据未找到"),
    SYSTEM_DATA_ERROR("200004","数据异常"),


    //三大指标年度目标值设置 lz 10000
    SET_QUOTA_INSERT_ERROR("10000","三大指标年度目标值新增失败"),
    SET_QUOTA_INSERT_EXCEPTION("10001","三大指标年度目标值新增数据异常"),
    SET_QUOTA_DELETE_ERROR("10002","三大指标年度目标值删除失败"),
    SET_QUOTA_DELETE_EXCEPTION("10003","三大指标年度目标值删除数据异常"),
    SET_QUOTA_UPDATE_ERROR("10004","三大指标年度目标值更新失败"),
    SET_QUOTA_UPDATE_EXCEPTION("10005","三大指标年度目标值更新数据异常"),
    SET_QUOTA_YEAR_EXIT("10006","此年的三大指标年度目标已存在"),
    SET_QUOTA_YEAR_EXCEPTION("10007","此年的三大指标年度目标数据异常"),
    DATE_FORMAT_EXCEPTION("10008","系统日期格式转换异常"),

    //舱单数据 白云 dzh
    TBCDMAIN_NOT_NULL("TBCDMAIN01", "航班动态数据不能为空"),
    TBCDMAIN_NOT_REPEAT("TBCDMAIN02", "系统已有该航班的舱单数据"),
    TBCDMAIN_NOT_EDIT("TBCDMAIN03", "舱单数据被审核或锁定，且非管理员操作"),
    TBCDMAIN_AUDIT("TBCDMAIN04", "舱单数据已被审核"),
    TBCDMAIN_UNAUDIT("TBCDMAIN05", "舱单数据未被审核"),
    TBCDMAIN_CANNOT_UNLOCK("TBCDMAIN06", "舱单数据未被审核或锁定"),
    TBCDMAIN_CANNOT_UNLOCK_MAN("TBCDMAIN07", "锁定人和解锁人不一致或非管理员角色"),
    TBCDMAIN_SF_UNDELETE("TBCDMAIN01", "系统未找到该FTID数据或找到数据大于1"),

    //通航城市
    TBCDTHCITY_PRAM_ERRO("TBCDTHCITY01","根据城市与货运类型发现数据已存在"),
    TBCDTHCITY_PRAM_NOTFIND("TBCDTHCITY02","原数据未找到"),

    //基础数据 白云 dzh
    ALLBASEDATA_REPEAT_DATA("ALLBASEDATA01", "数据重复"),
    ALLBASEDATA_SOUCENONE_DATA("ALLBASEDATA02", "成功，但该数据源未采集或名称错误，请联系管理员"),


    /**
     * app航线模块
     */

    HX_NOT_NULL("250001","航线查询参数不能为空"),
    HX_TYPE_NULL("250002","航线查询类型不能为空"),
    KHY_TYPE_NULL("250003","客货运类型不能为空"),
    FIND_BY_CITY("250004","按通航城市查询航线失败"),
    HBJH_CITY_NOT_NULL("250005", "通航城市不能为空"),
    AREA_NOT_NULL("250006", "区域类型不能为空"),
    //流量流向表  lz
    LIST_DATE_ERROR("LIULIANGDATA01","数据异常"),

    //App设备登记 lz
    USER_NOEXIST("DEVICE01","该账号不存在!"),
    USER_NOVALID("DEVICE02","该账号被禁用!"),
    DEVICE_WATING("DEVICE03","登记设备成功，请等待系统管理员审核！"),
    USERID_IS_NULL("DEVICE04","账号为空"),
    DEVICEID_ID_NULL("DEVICE05","设备ID为空"),
    CHEKER_NOT_NULL("DEVICE06","审核人不能为空"),
    DEVICEID_NOEXIST("DEVICE07", "该账号不存在"),
    DEVICEID_NOVALID("DEVICE08", "该账号被禁用,请联系管理员"),
    DEVICEID_CHECKING("DEVICE09", "绑定申请中，请等待后台审核！"),
    DEVICEID_REGED("DEVICE10", "该账号已经绑定该设备，可直接登录"),
    DEVICEID_FORBIDDEN("DEVICE11", "该账号已禁止与该设备绑定，请联系后台管理员!"),
    DEVICEID_WATING("DEVICE12", "登记设备成功，请等待系统管理员审核！"),
    DEVICEID_ADMIN("DEVICE13", "该账号不用登记设备，请直接登录！"),

    // 区域
    UNKNOW_AREA("UNKNOWAREA","未知区域"),

    // 小时架次颜色设置  lz
    COLOR_SET_NOT_NULL("COLORE01","设置不能为空！"),
    COLOR_SET_HAVE_NULL("COLORE02","设置信息有为空！"),
    COLOR_SET_SUCCESS("COLORE03","颜色设置保存成功"),
    COLOR_SET_FAILL("COLORE04","颜色设置保存失败"),

    //航线 lz
    AIRLINE_TIME_START_NOT_NULL("AIRLINE01","查询起始时间不能为空"),
    AIRLINE_TIME_END_NOT_NULL("AIRLINE02","查询结束时间不能为空"),
    AIRLINE_HISTOEY_TIME_START_NOT_NULL("AIRLINE03","查询历史起始时间不能为空"),
    AIRLINE_HISTOEY_TIME_END_NOT_NULL("AIRLINE04","查询历史结束时间不能为空"),

    //iam HW
    CODE_NOT_NULL("260001","code不能为空"),
    USERNAME_NOT_NULL("260002","中文名称不能为空"),
    DEPT_ID_NOT_NULL("260003","部门ID不能为空"),
    ISVAILD_NOT_NULL("260004","是否启用不能为空"),
    PWD_NOT_NULL("260005","密码不能为空"),
    TOKEN_EXCEPTION("260006","获取token异常"),

    //客座率
    KZL_PARAM_NOT_MATCH("KZL001","进出港航班号非同一航司"),
    KZL_RESULT_NO_DATA("KZL002","无此航班信息")
            ;
    /**
     * 代码
     */
    private String code;

    /**
     * 信息
     */
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    EnumFormResultMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("message", message);
        return JSON.toJSONString(object,
                // 输出key是包含双引号
                SerializerFeature.QuoteFieldNames,
                // 是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
                // 数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //  List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //  字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //  Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect);
    }

}
