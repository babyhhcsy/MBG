package com.thero.framework.util;
/**
 * 工具类
 * @author YZP
 *
 */
public class ToolUtility {
	
	public static int digitInfo = 5;
	
	public static String  areaInfo = "gamearea#gamesrv";
	//Chica.Yu 2013年4月25日15:38:51 add 新模板需求
	//3级联动
	public static String game_area_server = "chargegame#gamearea#gamesrv";
	//2级联动
	public static String game_area = "chargegame#gamearea";
	//游戏的一级联动
	public static String game = "chargegame";
	
	public static String  areaMark = "gamearea";
	
	public static String  noRule = "noRule";
	
	/**
	 * 32卡类型
	 */
	public static int cardType = 3;
	
	/**
	 * 状态
	 */
	public static final String status0 = "0,1,2";
	public static final String status1 = "1,2";
	
	/**
	 * 分隔符
	 */
	public static final String separativeSign = "@@@@@";
	
	
	/**
	 * 参数初始化
	 */
	public static long mark = 0;
	
	
	/**
	 * 储存时间(秒)
	 */
	public static final int adminLoginOutTime = 600;
	
	/**
	 * 集合查询默认起始数
	 */
	public static int defaultBegin = 0;
	
	/**
	 * 数据库插入条数
	 */
	public static int insertNumber = 1000;
	
	/**
	 * 集合查询默认条数
	 */
	public static int defaultEnd = 10000;
	
	/**
	 * 单据号分割数
	 */
	public static int cardNumber = 500;
	
	/** 
	 *类型编号
	 */
	public static int typeZeo = 0;
	
	/**
	 *类型编号
	 */
	public static int typeOne = 1;
	
	/**
	 * 类型编号
	 */
	public static int typeTwo = 2;
	
	/**
	 * 类型编号
	 */
	public static int typeThree = 3;
	
	/**
	 * 类型编号
	 */
	public static int TypeFour = 4;
	
	/**
	 * 类型编号
	 */
	public static int TypeFive = 5;
	
	/**
	 * 类型编号
	 */
	public static int TypeSix = 6;
	
	/**
	 * 类型编号
	 */
	public static int TypeSeven = 7;
	
	/**
	 * 商户号初始值
	 */
	public static int storeNumber = 1000000000;
	
	/**
	 * 接入商户号初始值
	 */
	public static int joinStoreNumber = 2000000000;
	
	/**
	 * json名称
	 */
	public static String jsonName = "desc";
	
	/**
	 * 手机直充用户编号    
	 */
	public static int userID = -1;
	
	
	/**
	 * 参数初始化
	 */
	public static int number = 0;
	
	/**
	 * 参数初始化
	 */
	public static int numberall = 100000;
	
	/**
	 * 管理员菜单缓存名称
	 */
	public static String memName = "managerUser_";
	
	/**
	 * 模板缓存名称
	 */
	public static String memTempName = "template_xml_";
	
	
	/**
	 * 后台用户登录缓存
	 */
	public static String loginAdmin = "loginAdmin_";
	
	/**
	 * SupUser缓存前缀
	 */
	public static final String SUPUSER_KEY = "supUser_";
	
	/**
	 * SupUser公司名称缓存前缀
	 */
	public static final String SUPUSER_NAME_KEY = "supUser_comName_";

    /**
     * 经销商缓存超时时间
     */
	public static final int SUPUSER_KEY_OUTTIME = 1200;

	
	
	/**Web_News【32卡网站】Sup_News【代理商网站】Supply_News【供货商网站】App_News【App平台】Wap_News【手机网站】**/
	
	/**
	 * 新闻条数
	 */
	public static int NewsLimit = 5;
	public static String Web_News = "Web_News";
	public static String Sup_News = "Sup_News";
	public static String Supply_News = "Supply_News";
	public static String App_News = "App_News";
	public static String Wap_News = "Wap_News";
	
	/**Web_Notice【32卡网站】Sup_Notice【代理商网站】Supply_Notice【供货商网站】App_Notice【App平台】Wap_Notice【手机网站】**/
	public static String Web_Notice = "Web_Notice";
	public static String Supply_Notice = "Supply_Notice";
	public static String Sup_Notice = "Sup_Notice";
	public static String App_Notice = "App_Notice";
	public static String Wap_Notice = "Wap_Notice";
	
	/**Web_Banner【32卡网站】Sup_Banner【代理商网站】Supply_Banner【供货商网站】App_Banner【App平台】Wap_Banner【手机网站】**/
	public static String Web_Banner = "Web_Banner";
	public static String Sup_Banner = "Sup_Banner";
	public static String Supply_Banner = "Supply_News";
	public static String App_Banner = "App_Banner";
	public static String Wap_Banner = "Wap_Banner";
	
	/**代理站点更新**/
	public static String Sup_Vip_Site = "sup_vip_website_";
	
	
	
	
	/**
	 * 管理员菜单缓存时间
	 */
	public static int memMenuTime = 1 * 60 * 60 * 24 * 8;
	
	/**
	 * 管理员菜单缓存时间
	 */
	public static int memTempTime = 1 * 60 * 60 * 24 * 20;
	
	/**
	 * 参数初始化
	 */
	public static int numberok = 1;
	
	/**
	 * 多表查询标示
	 */
	public  static String UNION = "UNION";
	
	/**
	 * 此游戏已经是推荐状态
	 */
	public static String gamesIndexErr = "此游戏已经是推荐状态";
	
	/**
	 * 此厂商已经是推荐状态
	 */
	public static String goodIndexErr = "此厂商已经是推荐状态";
	
	/**
	 * 操作对象不能为空
	 */
	public static String objectNull = "操作对象不能为空";
	
	/**
	 * 参数不能为空
	 */
	public static String errNull = "参数不能为空";
	
	/**
	 * 操作数据库异常
	 */
	public static String dbExcepiotn = "数据库操作异常";
	
	/**
	 * 名称读取失败
	 */
	public static String dbNameFaild = "名称读取失败";
	
	/**
	 * 对象信息不存在
	 */
	public static String objectNotFind = "对象信息不存在";
	
	/**
	 * 代理商用户的冻结金额不足
	 */
	public static String supUserFreeMoney = "代理商用户的解冻金额不足";
	
	/**
	 * 代理商用户的账户资金不够冻结
	 */
	public static String supUserFreeMoney1 = "代理商用户的账户资金不够冻结";
	
	/**
	 * 代理商用户的金额不足
	 */
	public static String supUserMoney = "代理商用户的金额不足";
	
	/**
	 * 代理商用户不存在
	 */
	public static String supUserNoFunnd = "代理商用户不存在";
	
	/**
	 * 代理商账户被冻结
	 */
	public static String supUserFree = "代理商账户被冻结";


    /**
     * 提现金额不能高于账户金额
     */
	public static String SUP_USER_DRAW_FREE_FAIL = "提现金额不能高于账户金额！";

    /**
     * 经销商不能操作自己的账户
     */
    public static final String SUP_USER_SELF_FAIL = "经销商不能操作自己的账户";

    /**
     * 操作金额不得高于可用金额
     */
    public static final String SUP_USER_BALANCE = "操作金额不得高于可用金额";

    /**
     * 需要管理员允许才能提取授信资金！
     */
    public static final String SUP_USER_CREDITMONEY_ISALLOW_FAIL = "需要管理员允许才能提取授信资金！";

    /**
     * 您没有可领取的授信资金
     */
    public static final String SUP_USER_CREDITMONEY_FAIL = "您没有可领取的授信资金！";

    /**
     * 您领取的金额不能大于授信资金
     */
    public static final String SUP_USER_CREDITCOUNT_FAIL = "您领取的金额不能大于授信资金！";

	/**
	 * 上下级关系不对应
	 */
	public static String supUserLevelErr = "上下级关系不对应";
	
	/**
	 * 此订单已经处理过
	 */
	public static String order_operatcash_Status_Fail = "此订单已经处理过";
	
	/**
	 * 此订单操作类型有误
	 */
	public static String order_operatcash_Type_Fail = "此订单操作类型有误";
	
	/**
	 * 此生成卡申请已经处理过
	 */
	public static String card_Task_Status_Fail = "此生成卡申请已经处理过";
	
	
	/**
	 * 令牌序列号不存在
	 */
	public static String RESP_FAIL_RESET1 = "令牌序列号不存在";
	
	
	/**
	 * 动态码错误
	 */
	public static String RESP_FAIL_RESET2 = "动态码错误";
	
	/**
	 * 重复绑定
	 */
	public static String RESP_FAIL_RESET3 = "重复绑定";

    /**
     * 重复绑定
     */
    public static String RESP_SUCCESS_RESET = "动态码已过期";
	
	/**
	 * 操作金额不能为空
	 */
	public static String Money_Null = "操作金额不能为空";
	
	/**
	 * 操作金额必须为数字
	 */
	public static String Money_Number = "操作金额必须为数字";
	
	/**
	 * 操作类型不能为空
	 */
	public static String Type_Null = "操作类型不能为空";
	
	/**
	 * 操作用户名不能为空
	 */
	public static String UserName_Null = "操作用户名不能为空";
	
	/**
	 * 操作用户名不存在
	 */
	public static String UserName_NoFound = "操作用户名不存在";
	
	/**
	 * 操作用户状态被冻结
	 */
	public static String UserName_Free = "操作用户状态被冻结";
	
	/**
	 * 操作编号不能为空
	 */
	public static String Id_Null = "操作编号不能为空";
	
	/**
	 *提现方式不能为空
	 */
	public static String Bank_Type = "提现方式不能为空";
	
	/**
	 *提现账号不能为空
	 */
	public static String Bank_User_Null = "提现账号不能为空";
	
	/**
	 *提现 金额不能为空
	 */
	public static String Bank_Money_Null = "提现 金额不能为空";
	/**
	 *提现手续费不能为空
	 */
	public static String Bank_Cashfee_Null = "提现手续费不能为空";
	
	/**
	 *收款人姓名不能为空
	 */
	public static String Bank_TrueUser_Null = "收款人姓名不能为空";
	
	
	
	/**
	 * 卡号前五位不能为空
	 */
	public static String Card_Five_Null = "卡号前五位不能为空";
	
	/**
	 * 参数必须为五位
	 */
	public static String Card_Five_Err = "参数必须为五位";
	
	/**
	 * 卡类型编号不能为空
	 */
	public static String Card_Id_Null = "卡类型编号不能为空";
	
	/**
	 * 操作编号不能为空
	 */
	public static String Pass_Null = "密码不能为空";

    /**
     * 密码
     */
	public static String PASSWORD = "密码";


    /**
     * 经销商权限
     */
    public static String USER_SUP_ACTION = "经销商权限";

    /**
     * 支付密码不能为空
     */
	public static String PAY_PASSWORD_NULL = "支付密码不能为空";

    /**
     * 新支付密码
     */
	public static String PAY_PASSWORD = "新支付密码";

    /**
     * 令牌序号不能为空
     */
	public static String USEKEY_EXISTS  = "令牌绑定状态不存在";

    /**
     * 令牌序号解除绑定失败
     */
    public static String USEKEY_UNBIND_FAIL02 = "令牌序号解除绑定失败";

    /**
     * 令牌序号绑定失败
     */
    public static String USEKEY_FAIL = "令牌序号绑定失败";

    /**
     * 状态不存在
     */
	public static String STATUS_EXISTS  = "状态不存在";

    /**
     * 绑定状态不存在
     */
	public static String USEKEY_NULL = "令牌序号不能为空";

    /**
     * 易众宝动态密码不能为空
     */
	public static String USEKEY_VERIFICATIONCODE_NULL = "易众宝动态密码不能为空";


    /**
     * 动态密码
     */
	public static String USEKEY_VERIFICATIONCODE = "动态密码";

    /**
     * 绑定状态不存在
     */
    public static String USEKEY_UNBIND_FAIL = "令牌序号已经解除绑定";

    /**
     * 令牌
     */

    public static final String USEKEY = "令牌";

	/**
	 *登录I判断不能为空
	 */
	public static String IP_Null = "登录IP不能为空";
	
	/**
	 *修改状态不能为空
	 */
	public static String Status_Null = "修改状态不能为空";
	
	/**
	 *操作卡号不能为空
	 */
	public static String CardNumber_Null = "操作卡号不能为空";
	
	/**
	 * 操作密码不能为空
	 */
	public static String CardPass_Null = "操作密码不能为空";
	
	/**
	 *订单编号不能为空
	 */
	public static String OrderNum_Null = "订单编号不能为空";
	
	/**
	 * 订单编号的长度不能超过20
	 */
	public static String OrderNumLength_Err = "订单编号的长度不能超过20";
	
	/**
	 *请求json格式信息不能为空
	 */
	public static String JsonInfo_Null = "请求json格式信息不能为空";
	
	/**
	 *卡号必须为数字
	 */
	public static String CardNumber_Number = "卡号必须为数字";
	
	/**
	 *卡号格式不正确
	 */
	public static String CardNumber_Err1 = "卡号格式不正确";
	/**
	 *卡号不能为空
	 */
	public static String CardNum_Null = "卡号不能为空";
	
	/**
	 *二级代理商id不能为空
	 */
	public static String Ownerlevel2id_Null = "二级代理商id不能为空";
	
	/**
	 *卡号余额不足
	 */
	public static String CardNumber_Err2 = "卡号余额不足";
	
	/**
	 *专属卡不能给账户充值
	 */
	public static String CardNumber_Err3 = "专属卡不能给账户充值";
	
	
	/**
	 *卡号不存在
	 */
	public static String CardNumber_No = "卡号不存在";
	
	/**
	 *会员不存在
	 */
	public static String CenterUser_No = "会员不存在不存在";
	
	
	
	/**
	 * 订单状态不能为空
	 */
    public static String OrderStatus_Null = "订单状态不能为空";
    
    /**
     * 卡片类型或状态不统一
     */
    public static String CardTypeOrStatus_NoUnit = "存在不统一的卡片类型或状态";
    
    /**
     * 开始号段不能为空
     */
    public static String beginNumberNull = "开始号段不能为空";

    /**
     * 结束号段不能为空
     */
	public static String endNumberNull = "结束号段不能为空";
    
    
    
    
    
    /**
     * 号段内存在无法销毁的卡片状态
     */
    public static String CardDestroy_NoStatus = "号段内存在无法销毁的卡片状态";
    
    /**
     * 退货未受理的卡片不能销毁
     */
    public static String CardDestroy_NoCheck = "退货未受理的卡片不能销毁";
    /**
     * 生成的卡片未使用时不能销毁
     */
    public static String CardDestroy_NoUserd = "未使用的卡片不能销毁";
    
    /**
     * 不能划拨的卡片状态
     */
    public static String CardAllocated_NoStatus = "号段内存在不能划拨的卡片状态";
    
    /**
     * 起始号不能比结束号大
     */
    public static String CardNum_NoComprision = "起始号不能比结束号大";
    
    /**
     * 公司名称不能为空--注册
     */
    public static String OwnerName_Null="公司名称不能为空";
    
    /**
     * 姓名不能为空--注册
     */
    public static String Contact_Null="姓名不能为空";
    /**
     * 省市不能为空--注册
     */
    public static String Area_Null="省市不能为空";
    /**
     * 身份证号不合法--注册
     */
    public static String IdCard_Err="身份证号不合法";
    
    public static String MobilePhone_Err="手机号不合法";
    
    public static String HomePhone_Err="固定电话不合法";
    
    public static String Sex_Err="性别不合法";
    
    public static String Post_Err="邮编不合法";
    
    public static String Password_Err="密码不合法";
    
    public static String ConfirmPassword_Err="两次密码不相同";
    
    public static String Address_Null="公司地址不能为空";
    
    public static String RegEmailUrl_Null="邮箱地址不能为空";
    
    public static String CardBeginNumber="卡起始号";
    
    public static String CardEndNumber="卡结束号";
    
    public static String UserName = "用户名称";
    public static String OwnerName = "公司名称";
    public static String Contact = "联系人";
    public static String IdCard = "身份证号码";
    public static String MobilePhone = "手机号码";
    public static String HomePhone = "固定电话";
    public static String Post = "邮编";
    public static String CompanyAddress = "公司地址";    
    public static String UserSupStatus_Err = "代理商当前状态不能为锁定或未激活";
    public static String ParamMustNumber = "参数必须为数字";
    public static String ListIsNull="号段内不存在可操作数据";
    public static String CardExpried="号段内存在已过期的卡片";
    //模板
    /**
     * 模板不存在
     */
    public static String Template_NotFound = "对应模板不存在";
    
    
    
	/**
	 * 系统生成
	 *//*
	public static String systemCreate = "系统生成";
	
	*//**
	 * 系统开卡
	 *//*
	public static String systemOpen = "系统开卡";
	
	*//**
	 * 自助开卡
	 *//*
	public static String ownerOpen = "自助开卡";
	
	*//**
	 * 操作成功
	 *//*
	public static String orderSuccess = "订单操作成功";
	
	*//**
	 * 操作成功
	 *//*
	public static String orderInfoFail = "订单操作失败";
	
	*//**
	 * 接口返回正确标示
	 *//*
	public static String success = "000000#成功";
	
	*//**
	 * 参数格式有误
	 *//*
	public static String err = "100#参数格式有误";
	
	*//**
	 * 参数不能为空
	 *//*
	public static String errNull = "102#参数不能为空";
	
	
	*//**
	 * 操作数据库异常
	 *//*
	public static String dbExcepiotn = "103#数据库操作异常";
	
	*//**
	 * 对象信息不存在
	 *//*
	public static String objectNotFind = "104#对象信息不存在";
	
	*//**
	 * 手机号已经注册
	 *//*
	public static String phoneErr = "105#此手机号已经注册";
	
	
	*//**
	 * 邮箱已经注册
	 *//*
	public static String emailErr = "106#此邮箱已经注册";
	
	*//**
	 * 账号已经激活
	 *//*
	public static String accountInfo = "107#账号已经激活";
	
	*//**
	 * 号码格式有误
	 *//*
	public static String mobileErr = "108#手机号码格式有误";
	
	*//**
	 * 手机号为空
	 *//*
	public static String mobileNull = "109#手机号不能为空";
	
	*//**
	 * 密码为空
	 *//*
	public static String passwordNull = "110#密码不能为空";
	
	*//**
	 * 邮箱为空
	 *//*
	public static String emailNull = "111#邮箱不能为空";
	
	*//**
	 * 日志描述
	 *//*
	public static String psswordErr = "112#账号或密码错误";
	
	*//**
	 * 日志描述
	 *//*
	public static String UserUpdateInfo = "113#用户修改个人信息";
	
	*//**
	 * 日志描述
	 *//*
	public static String UserUpdatePassword = "114#用户修改密码";
	
	*//**
	 * 日志描述
	 *//*
	public static String UserUpdatePhone = "115#用户修改手机号";
	
	*//**
	 * 日志描述
	 *//*
	public static String UserLogin = "116#用户修改密码";
	
	*//**
	 * 商户名称不能为空
	 *//*
	public static String merentNull = "117#商户名称不能为空";
	
	*//**
	 * 商户编号不能为空
	 *//*
	public static String merentIDNull = "118#商户编号不能为空";
	
	*//**
	 * 游戏编号不能为空
	 *//*
	public static String gameIDNull = "119#游戏编号不能为空";
	
	*//**
	 * 卡已经使用
	 *//*
	public static String cardCenterErr = "120#此卡已经被使用";
	
	*//**
	 * 卡未启用使用
	 *//*
	public static String cardCenterUErr = "121#此卡未启用";
	
	*//**
	 * 卡类型名称不能
	 *//*
	public static String cardTypeNull = "122#卡类型名称不能为空";
	
	*//**
	 * 卡号不能为空
	 *//*
	public static String cardCenterNull = "123#卡号不能为空";
	
	*//**
	 * 卡号为空
	 *//*
	public static String orderNull = "124#订单号不能为空";
	
	*//**
	 * 状态为空
	 *//*
	public static String statusNull = "125#状态不能为空";
	
	*//**
	 * 状态为数字
	 *//*
	public static String statusErr = "126#状态必须为数字";
	
	*//**
	 * 金额为空
	 *//*
	public static String paynumNull = "127#金额不能为空";
	
	*//**
	 * 金额为数字
	 *//*
	public static String paynumErr = "128#金额必须为数字";
	
	*//**
	 * 订单为数字
	 *//*
	public static String orderErr = "129#订单号必须为数字";
	
	*//**
	 * 卡号必须是数字
	 *//*
	public static String cardTypeErr = "130#充值卡号必须为数字";
	
	*//**
	 * 卡号密码不能为空
	 *//*
	public static String cardPassNull = "131#充值卡密码不能为空";
	
	*//**
	 * 卡密码必须是数字
	 *//*
	public static String cardPassErr = "132#充值卡密码必须为数字";
	
	*//**
	 * 金额为空
	 *//*
	public static String balanceNull = "133#金额不能为空";
	
	*/
    /** 金额不够 */
	public static String balanceless = "134#账户余额不足";
	
	/**//**
	 * 用户编号
	 *//*
	public static String userIDNull = "135#用户编号不能为空";
	
	*//**
	 * 用户编号不存在
	 *//*
	public static String userIDNot = "136#用户不存在";
	
	*//**
	 * 用户状态
	 *//*
	public static String userStatus = "137#用户状态未激活";
	
	*//**
	 * 金额格式错误
	 *//*
	public static String balanceErr = "138#金额格式不正确";
	
	*//**
	 * 商户名称不能为空
	 *//*
	public static String merentName = "139#商户名称已经存在";
	
	*//**
	 * 商户游戏列表
	 *//*
	public static String storeGameList = "140#商户游戏关系已经存在";
	
	*//**
	 * 卡类型名称存在
	 *//*
	public static String cardTypeName = "141#卡类型名称已经存在";
	
	*//**
	 * 充值卡号不存在
	 *//*
	public static String carNumErr = "142#充值卡号不存在";
	
	*//**
	 * 充值卡状态失败
	 *//*
	public static String carStatusErr = "143#充值卡状态更新失败";
	
	*//**
	 * 充值卡密码错误
	 *//*
	public static String carNumPassErr = "144#充值卡密码错误";
	
	*//**
	 * 订单号存在
	 *//*
	public static String orderName = "145#订单号已经存在";
	
	*//**
	 * 订单号生成失败
	 *//*
	public static String orderFail = "146#订单号生成失败";
	
	*//**
	 * 订单状态更新失败
	 *//*
	public static String orderStatusFail = "147#订单状态更新失败";
	
	
	*//**
	 * 卡号名称存在
	 *//*
	public static String cardnumName = "148#卡号名称已经存在";
	
	/**
	 * 游戏名称不能为空
	 */
	public static String gameNull = "游戏名称不能为空";
	
	/**
	 * 游戏名称存在
	 */
	public static String gameErr = "游戏名称已经存在";
	
	 /**//**
	 * 游戏区域名称存在
	 *//*
	public static String gameAreaErr = "151#游戏区域名称已经存在";
	
	*//**
	 * 卡类型不存在
	 *//*
	public static String cardNot = "152#卡类型不存在";
	
	*//**
	 * 商户不存在
	 *//*
	public static String merentNot = "153#商户不存在";
	
	*//**
	 * 未开卡
	 *//*
	public static String unActivation = "154#卡未开";
	
	*//**
	 * 已充值
	 *//*
	public static String recharge = "155#卡已充值";
	
	*//**
	 * 冻结
	 *//*
	public static String freeze = "156#卡已冻结";
	
	*//**
	 * 游戏编号不能为空
	 *//*
	public static String gameIdNull = "157#游戏编号不能为空";
	
	*//**
	 * 卡面值不能为空
	 *//*
	public static String CardWorthNull = "158#卡面值不能为空";
	
	*//**
	 * 卡面值不能为空
	 *//*
	public static String activation = "159#号段已激活，请勿重复操作";
	
	*//**
	 * 卡已经过期
	 *//*
	public static String cardGQ = "160#此卡已经过期";
	
	*//**
	 * 卡金额不够
	 *//*
	public static String cardBalanceless = "161#卡余额不足";
	
	*//**
	 * 生成卡越界
	 *//*
	public static String cardCreateErr = "162#生成卡的个数越界";
	
	*//**
	 * 随机生成卡不能按照号段操作
	 *//*
	public static String haoduanErr = "164#不能按照号段操作";
	
	*//**
	 * 卡号段已经过期
	 *//*
	public static String cardHDErr = "165#卡号段已经过期";
	
	*//**
	 * 游戏厂商编号不能为空
	 *//*
	public static String gameIdInfoNull = "166#游戏或厂商编号不能为空";
	
	*//**
	 * 游戏厂商编号不能为空
	 *//*
	public static String gameNameInfoNull = "167#游戏或厂商名称不能为空";
	
	*//**
	 * 游戏或厂商对象已经存在
	 *//*
	public static String gameInfoErr = "168#游戏或厂商对象已经存在";
	
	
	
	
	
	*//**********************************************后台管理信息提示**********************************************//*
	
	*//**
	 * 用户名称不能为空
	 *//*
	public static String userNameNUll = "500#用户名不能为空";
	
	*//**
	 * 用户密码不能为空
	 *//*
	public static String userPassNUll = "501#用户密码不能为空";
	
	*//**
	 * 用户名已经存在
	 *//*
	public static String userErr = "502#用户名已经存在";
	
	*//**
	 * 用户新密码不能为空
	 *//*
	public static String userNewPassNull = "503#用户新密码不能为空";
	
	*//**
	 * 用户旧密码不能为空
	 *//*
	public static String userOldPassNull = "504#用户旧密码不能为空";
	
	*//**
	 * 用户旧密码不能为空
	 *//*
	public static String userOldPassErr = "505#用户旧密码不能为空";
	
	*//**
	 * 菜单名称不能为空
	 *//*
	public static String menuNameNull = "506#菜单名称不能为空";
	
	*//**
	 * 菜单路径不能为空
	 *//*
	public static String menuUrlNull = "507#菜单路径不能为空";
	
	*//**
	 * 菜单名称已经存在
	 *//*
	public static String menuNameErr = "508#菜单名称已经存在";
	
	*//**
	 * 角色名称不能为空
	 *//*
	public static String roleNull = "509#角色名称不能为空";
	
	*//**
	 * 角色名称已经存在
	 *//*
	public static String roleErr = "510#角色名称已经存在";
	
	*//**
	 * 用户名密码错误
	 *//*
	public static String loginErr = "511#账号或密码错误";
	
	*//**
	 * 功能名称不能为空
	 *//*
	public static String functionNull = "512#功能名称不能为空";
	
	*//**
	 * 功能名称不能为空
	 *//*
	public static String functionErr  = "512#功能名称已经存在";
	
	*//**
	 * 归属人名称不能为空
	 *//*
	public static String cardOwnerNull = "514#经销商名称不能为空";
	
	*//**
	 * 归属人名称已经存在
	 *//*
	public static String cardOwnerErr = "515#经销商用户名已经存在";	
	
	*//**
	 * 归属人编号不存在
	 *//*
	public static String cardOwnerIdErr = "516#经销商不存在";	
	
	
	*//**
	 * 规则字符不能为空
	 *//*
	public static String cardTaskNull = "517#开始字符不能为空";	
	
	
	*//**
	 * 规则字符已经存在
	 *//*
	public static String cardTaskErr = "518#开始字符已经存在";	
	
	*//**
	 * 单据号不存在
	 *//*
	public static String cardRegeErr = "519#单据号不存在";	
	
	*//**
	 * 单据号已经开卡
	 *//*
	public static String cardRegeOpen = "520#此单据号已经开卡";	
	
	*//**
	 * 单据号已经部分开卡
	 *//*
	public static String cardRegePartOpen = "521#此单据号部分已经开卡";	
	
	*//**
	 * 单据号已经开卡
	 *//*
	public static String cardOpenErr = "522#此单据号还未开卡";
	
	*//**
	 * 单据号已经开卡
	 *//*
	public static String cardFree = "523#此单据号已经冻结";
	
	*//**
	 * 单据号已经开卡
	 *//*
	public static String cardPartFree = "524#此单据号部分已经冻结";
	
	*//**
	 * 单据号未经开卡
	 *//*
	public static String cardRegeNoOpen = "525#此单据号未开卡";	
	
	*//**
	 * 单据号已经解冻
	 *//*
	public static String cardAlreadFree = "526#此单据号已经冻结";
	
	*//**
	 * 单据号不能为空
	 *//*
	public static String cardRegeNull = "527#单据号不能为空";
	
	*//**
	 * 开始号段不能为空
	 *//*
	public static String beginNumberNull = "528#开始号段不能为空";
	
	*//**
	 *结束号段不能为空
	 *//*
	public static String endNumberNull = "529#结束号段不能为空";
	
	*//**
	 *号段不正确
	 *//*
	public static String numberErr = "530#号段错误";
	
	*//**
	 *经销商级别为空
	 *//*
	public static String levelNull = "531#经销商级别名称不能为空";
	
	*//**
	 *经销商级别已经存在
	 *//*
	public static String levelErr = "532#经销商级别名称已经存在";
	
	*//**
	 *返点不能为空
	 *//*
	public static String pointlNull = "533#返点数不能为空";
	
	*//**
	 *返点已经存在
	 *//*
	public static String pointErr = "534#返点数已经存在";
	
	
	*//**
	 * 操作方式不能为空
	 *//*
	public static String caozuoErr = "535#操作方式不能为空";
	
	*//**
	 * 开始号段不能为空
	 *//*
	public static String beginNumberErr = "536#开始号段不存在";
	
	*//**
	 *结束号段不能为空
	 *//*
	public static String endNumberErr = "537#结束号段不存在";
	
	*//**
	 *归属人不一致
	 *//*
	public static String ownerErr = "538#归属人不一致";
	
	*//**
	 * 账号已经冻结
	 *//*
	public static String accountInfoNo = "539#账号已经冻结";

	*//**
	 * 上下级关系已经存在
	 *//*
	public static String regardErr = "540#上下级关系已经存在";
	
	*//**
	 * 账号已经冻结
	 *//*
	public static String ownerUserErr = "541#商户账号已经冻结";
	
	*//**
	 * 商户余额不足
	 *//*
	public static String ownerAmountErr = "542#商户余额不足";
	
	*//**
	 * 游戏类型或属性不能为空
	 *//*
	public static String gameTypeNull = "543#游戏类型或属性不能为空";
	
	*//**
	 * 游戏类型或属性不能为空
	 *//*
	public static String gameTypeErr = "544#游戏类型或属性已经存在";
	
	*//**
	 * 游戏卡关系存在
	 *//*
	public static String gameCardErr = "545#游戏点卡关系已经存在";
	
	*//**
	 * 标签名称不能为空
	 *//*
	public static String tagNull = "546#标签名称不能为空";
	
	*//**
	 * 标签名称已经存在
	 *//*
	public static String tagErr = "547#标签名称已经存在";
	
	*//**
	 * 地区名称不能为空
	 *//*
	public static String areaNameNull= "548#地区名称不能为空";
	
	*//**
	 * 模板名称不能为空
	 *//*
	public static String templateNull = "549#模板名称不能为空";
	
	*//**
	 * 模板名称已经存在
	 *//*
	public static String templateErr = "550#模板名称已经存在";
	
	/**
	 * 点卡商品名称不能为空
	 */
	public static String commodityNull = "点卡商品名称不能为空";
	
	/**
	 * 点卡商品名称已经存在
	 */
	public static String commodityErr = "点卡商品名称已经存在";
	

	/*//**
	 * 地区序号不能为空
	 *//*
	public static String areaScoreNull = "553#地区序号不能为空";
	
	*//**
	 * 地区序号已经存在
	 *//*
	public static String areaScoreErr = "554#地区序号已经存在";
	
	*//**
	 * 地区名称已经存在
	 *//*
	public static String areaNameErr = "555#地区名称已经存在";
	
	*//**
	 * 过期时间名称不能为空
	 *//*
	public static String pastTimeNull = "556# 过期时间名称不能为空";
	
	*//**
	 * 过期时间名称已经存在
	 *//*
	public static String pastTimeErr = "557# 过期时间名称已经存在";
	
	*//**
	 * 商品编号不能为空
	 *//*
	public static String commodityIdNull = "558# 商品编号不能为空";
	
	*//**
	 * 厂商目录编号不能为空
	 *//*
	public static String goodsCatalogueNull = "559#厂商目录编号不能为空";
	
	*//**
	 * 厂商目录序列号更新失败
	 *//*
	public static String goodsCatalogueSerialUpdateFail = "560#厂商目录序列号更新失败";
	
	*//**
	 * 厂商目录序列号还原失败
	 *//*
	public static String goodsCatalogueSerialComebackFail = "561#厂商目录序列号还原失败";
	
	*//**
	 * 卡名称不能为空
	 *//*
	public static String cardNameNotNull = "562# 账号名称不能为空";
	
	*//**
	 * 卡名称已经存在
	 *//*
	public static String cardNameErr = "563# 账号名称已经存在";
	
	*//**
	 * 卡的密码不能为空
	 *//*
	public static String cardPassNotNull = "564#账号密码不能为空";
	
	*//**
	 * 卡密任务名称
	 *//*
	public static String cardPassTaskNull = "564#卡密任务名称不能为空";
	
	*//**
	 * 区域编号不能为空
	 *//*
	public static String areaNull = "565#区域编号不能为空";
	
	*//**
	 * 区域和商品关系已经存在
	 *//*
	public static String areaErr = "566#区域和商品关系已经存在";
	
	*//**
	 *商品编号不能为空
	 *//*
	public static String goodIdNull = "567#商品编号不能为空";
	
	*//**
	 *代理商编号不能为空
	 *//*
	public static String agentIdNull = "568#代理商编号不能为空";
	
	*//**
	 *代理商和商品关系已经存在
	 *//*
	public static String agentIdErr = "569#代理商和商品关系已经存在";
	
	*//**
	 *操作类型有误
	 *//*
	public static String typeErr = "570#操作类型有误";
	
	*//**
	 *编号不能为空
	 *//*
	public static String idNull = "571#编号不能为空";
	
	*//**
	 *数量不能为空
	 *//*
	public static String storageNull = "571#数量不能为空";
	
	*//**
	 *属性编号不能为空
	 *//*
	public static String attIdNull = "572#属性编号不能为空";
	
	*//**
	 *厂商目录名称存在
	 *//*
	public static String goodsCatalogueNameNull = "573#厂商目录名称已经存在";
	
	*//**
	 *批量更新卡状态失败
	 *//*
	public static String batchUpdateCardStatusFail = "574#批量更新卡状态失败";
	
	*//**
	 * 元素名称不能为空
	 *//*
	public static String elementNull = "576#元素名称不能为空";
	
	*//**
	 * 元素名称已经存在
	 *//*
	public static String elementErr = "577#元素名称已经存在";
	
	*//**
	 * 元素属性名称不能为空
	 *//*
	public static String elementAttNull = "578#元素属性名称不能为空";
	
	*//**
	 * 模板名称不能为空
	 *//*
	public static String AutomaticTemplateNull = "579#模板名称不能为空";
	
	*//**
	 * 模板名称已经存在
	 *//*
	public static String AutomaticTemplateErr = "580# 模板名称已经存在";
	
	*//**
	 * 单据号已经划分
	 *//*
	public static String DivideErr = "581#此单据号已经划分";	
	
	*//**
	 * 此单据号必须处于开卡状态
	 *//*
	public static String cardOpenCErr = "582#此单据号必须处于开卡状态";
	
	*//**
	 * 此单据号必须处于封停状态
	 *//*
	public static String cardFreeErr = "583#此单据号必须处于封停状态";
	
	*//**
	 * 返点ID为空
	 *//*
	public static String ReturnPointIDNull = "584#返回ID不能为空";
	
	*//**
	 * 开卡后的卡不可以划分
	 *//*
	public static String OpenCardNoHf = "585#开卡后的卡不可以划分";
	
	/**
	 * 游戏拼音不能为空
	 */
	public static String gameSpellNull = "游戏拼音不能为空";
	
	/**
	 * 游戏拼音存在
	 */
	public static String gameSpellErr = "游戏拼音已经存在";
	
	/**
	 * 游戏编码和唯一标示不存在
	 */
	public static String templateErrInfo = "唯一标示编码不存在";
	
	/**
	 * 唯一标示不能为空
	 */
	public static String templateOnlyErr = "唯一标示编码不能为空";
	
	/*//**
	 * 模板编号不能为空
	 *//*
	public static String templateIdNull = "590#模板编号不能为空";
	
	*//**
	 * 游戏别名关系已经存在
	 *//*
	public static String gameTagErr = "591#游戏别名关系已经存在";
	
	*//**
	 * 别名编号不能为空
	 *//*
	public static String TagIDErr = "592#别名编号不能为空";
	
	*//**
	 * 唯一标示编码已经存在
	 *//*
	public static String OnlyErr = "593#唯一标示编码已经存在";
	
	*//**
	 * 厂商拼音存在
	 *//*
	public static String goodsErr = "597#厂商拼音名称已经存在";
	
	*//**
	 * 此密钥已经存在
	 *//*
	public static String keyErr = "594#此密钥已经存在";
	
	public static String UpdateIdNull = "595#最新更新点不能为空";
	
	public static String LastUpIdNull = "596#上次更新点不能为空";
	
	*//**
	 * 顾问名称不能为空
	 *//*
	public static String salesConsultantNull = "598#顾问名称不能为空";
	
	*//**
	 * 顾问名称已经存在
	 *//*
	public static String salesConsultantErr = "599#顾问名称已经存在";

	
	*//**
	 * 顾问编号不能为空
	 *//*
	public static String salesConsultantIdNull = "600#顾问编号不能为空";
	
	*//**
	 * 绑定的手机号码不能为空
	 *//*
	public static String bindPhoneNull = "601#绑定的手机号码不能为空";
	
	*//**
	 * 操作行为不能为空
	 *//*
	public static String bindNull = "602#操作行为不能为空";
	
	*//**
	 * 代理商用户名不能为空
	 *//*
	public static String ownerNameNull = "603#代理商用户名不能为空";
	
	*//**
	 * 代理商编号不能为空
	 *//*
	public static String ownerIdNull = "604#代理商编号不能为空";
	
	*//**
	 * 返点编号不能为空
	 *//*
	public static String ownerPointIdNull = "605#返点编号不能为空";
	
	*//**
	 * 面值类型编号不能为空
	 *//*
	public static String faceTypeIdNull = "606#面值类型编号不能为空";
	
	*//**
	 * 采购类型编号不能为空
	 *//*
	public static String caigouIdNull = "607#采购类型编号不能为空";
	
	*//**
	 * 开始时间不能为空
	 *//*
	public static String beginTimeNull = "608#采购类型编号不能为空";
	
	*//**
	 * 结束时间不能为空
	 *//*
	public static String endTimeNull = "609#采购类型编号不能为空";
	
	*//**
	 * 此月返点已经生成
	 *//*
	public static String openMoneyErr = "610# 此月返点已经生成";
	
	*//**
	 * 省份不能为空
	 *//*
	public static String provincesNull = "611# 省份不能为空";
	
	*//**
	 * 城市不能为空
	 *//*
	public static String cityNull = "612# 城市不能为空";
	
	*//**
	 * 年份不能为空
	 *//*
	public static String yearNull = "613# 年份不能为空";
	
	*//**
	 * 月份不能为空
	 *//*
	public static String monthNull = "614# 月份不能为空";
	
	*//**
	 * 押金不能为空
	 *//*
	public static String scoreNull = "615#押金不能为空";
	
	*//**
	 * 该月份返点已经发放
	 *//*
	public static String ffPointErr = "616#该月份返点已经发放";
	

	
	*//**
	 * 加密解密信息不能为空
	 *//*
	public static String cardPassNoNull = "632#加密解密信息不能为空";
	
	*//**   
	 * 请选择同一单据号的号段进行操作
	 *//*
	public static String haoduanInfoErr = "633#请选择同一单据号的号段进行操作";

	*//**   
	 * 大图片路径不能为空
	 *//*
	public static String bigImageNull = "634#大图片路径不能为空";
	
	*//**   
	 * 小图片路径不能为空
	 *//*
	public static String smallImageNull = "635#小图片路径不能为空";
	
 
	*//**   
	 * 代理商没有默认级别
	 *//*
	public static String ownerLevelNull = "636#代理商没有默认级别";
	
	*//**   
	 * 对应的动态卡库存不够
	 *//*
	public static String cardErr = "637#对应的随机卡库存不够";
	
	
	*//**   
	 * 卡面值不一致
	 *//*
	public static String cardno639 = "639#卡面值不一致";
	*//**   
	 * 卡面值不一致
	 *//*
	public static String cardpricenosame = "640#卡面值不一致";
	
	*//**
	 * 该月份返点发放失败
	 *//*
	public static String ffPointFail = "641#该月份返点发放失败";
	*//**
	 * 商户KEY不能为空
	 *//*
	public static String merentKey = "642#商户密匙重复";
	
	*//**
	 * 公告禁用
	 *//*
	public static String announcementErr = "643#公告已经禁用";
	
	*//**
	 * 卡禁止操作
	 *//*
	public static String cardBuySettingErr = "644#卡禁止操作";
	
	*//**
	 * 接入商订单号不能为空
	 *//*
	public static String orderIDNull = "645#接入商订单号不能为空";
	
	*//**
	 * 接入商订单订单状态编号不能为空
	 *//*
	public static String orderStatusIDNull = "646#接入商订单状态编号不能为空";
	
	public static String partHDSetted = "647#部分卡已设置购买权限";
	
	*//**
	 * 此卡不允许购买此游戏
	 *//*
	public static String cardErrorBuy = "648#此卡不允许购买此游戏";
	
	*//**
	 * 返点未发放
	 *//*
	public static String backNoOpen = "649#返点未发放";
	
	*//**
	 * 返点已经领取
	 *//*
	public static String backOk = "650#返点已经领取";
	
	*//**
	 * 网银标示不能为空
	 *//*
	public static String bankMarkNull = "651#网银标示不能为空";*/
}
