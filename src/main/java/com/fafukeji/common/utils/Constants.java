package com.fafukeji.common.utils;

import java.io.Serializable;

public class Constants implements Serializable {

	private static final long serialVersionUID = -660290450566261359L;


	public final static byte CHANGE_TYPE_ADD = 0;
	public final static byte CHANGE_TYPE_REDUCE = 1;

	/**
	 * 金钱变化方式 0->提现 1->充值 2-购买积分减少 3-购买代理 4-购买有效期 5-推广用户购买积分提成 6-推广用户购买有效期提成 7-积分转换  8-提现拒绝退还金额
	 */

	//提现
	public final static byte CHANGE_ACTION_WITHDRAWAL = 0;

	//充值
	public final static byte CHANGE_ACTION_EXCHANGE = 1;

	//购买积分
	public final static byte CHANGE_ACTION_BUY_SCORE = 2;


	//购买代理
	public final static byte CHANGE_ACTION_BUY_AGENT = 3;

	//购买有效期
	public final static byte CHANGE_ACTION_BUY_VALIDITY = 4;

	//推广用户购买积分提成
	public final static byte CHANGE_ACTION_PROMOTE_BUY_SCORE = 5;

	//推广用户购买有效期提成
	public final static byte CHANGE_ACTION_PROMOTE_BUY_VALIDITY = 6;

	//积分转换
	public final static byte CHANGE_ACTION_SCORE_TO = 7;

	//提现拒绝退还金额
	public final static byte CHANGE_ACTION_WITHDRAWAL_RETURN = 8;

	/**
	 * 系统设置keyword
	 * money_to_score:一元钱可以购买的积分数
	 * score_to_money:一分可以换取金钱数
	 * agent_money:购买代理消费的金钱
	 * buy_score_percentage:推广用户购买积分提成比例
	 * buy_validity_percentage:推广用户购买有效期提成比例
	 * scheduler_minutes:定时任务执行间隔时间
	 */

	public final static String SYSTEM_SETTING_MONEY_TO_SCORE = "money_to_score";

	public final static String SYSTEM_SETTING_SCORE_TO_MONEY = "score_to_money";

	public final static String SYSTEM_SETTING_AGENT_MONEY = "agent_money";

	public final static String SYSTEM_SETTING_PROMOTE_BUY_SCORE_PERCENTAGE = "buy_score_percentage";

	public final static String SYSTEM_SETTING_PROMOTE_BUY_VALIDITY_PERCENTAGE = "buy_validity_percentage";

	public final static String SYSTEM_SETTING_SCHEDULER_MINUTES = "scheduler_minutes";

	public final static String SYSTEM_SETTING_NEED_SCORES = "need_scores";

	public final static String SYSTEM_SETTING_WITHDRAWAL_NEED_MONEY = "withdrawal_need_money";

	public final static String SYSTEM_SETTING_WITHDRAWAL_MAX_TASK_NUM = "max_task_num";

	public final static String SYSTEM_SETTING_HTTP_DOMAIN = "http_domain";
	public final static String SYSTEM_SETTING_CLIENT_ID = "client_id";
	public final static String SYSTEM_SETTING_CLIENT_SECRET = "client_secret";


	/**
	 * 积分变化方式 0->充值  1->积分转换为金钱  2->购买积分 3->完成任务增加 4->完成任务减少
	 */

	//充值
	public final static byte CHANGE_ACTION_SCORE_WITHDRAWAL = 0;

	//积分转换为金钱
	public final static byte CHANGE_ACTION_SCORE_TO_MONEY = 1;

	//积分转换为金钱
	public final static byte CHANGE_ACTION_MONEY_TO_SCORE = 2;

	//完成任务增加
	public final static byte CHANGE_ACTION_FINISH_TASK_ADD = 3;

	//完成任务减少
	public final static byte CHANGE_ACTION_FINISH_TASK_REDUCE = 4;


	public final static String HOST  = "http://localhost:8080/";

	public final static String REGISTER_URL = "/admin/register/index";

	public final static int COOKIE_TIME = 30 * 24 * 60 * 60;

	/**
	 * 任务状态0->等待确认,1->已上线,2->暂停,3->已下线
	 */
	public final static int TASK_STATE_NEED_CONFIRM = 0;
	public final static int TASK_STATE_ONLINE = 1;
	public final static int TASK_STATE_PAUSE = 2;
	public final static int TASK_STATE_OFFLINE = 3;


	/**
	 * 用户充值管理， 充值状态：0-待充值,1-已充值,2-充值拒绝
	 */
	public final static int RECHARGE_STATE_WAIT = 0;
	public final static int RECHARGE_STATE_HAS = 1;
	public final static int RECHARGE_STATE_REFUSE = 2;


	/**
	 * 获取任务状态,0-未完成,2-已完成,3-为完成删除
	 */
	public final static byte OBTAIN_TASK_UNDONE = 0;
	public final static byte OBTAIN_TASK_DONE = 1;
	public final static byte OBTAIN_TASK_UNDONE_DELETE = 2;


	/**
	 * 短信模板
	 */

	public final static String CAPTCHA_CONTENT = "验证码为%s,在30分钟之内有效。如非本人操作请忽略本短信。";
	public final static String RESET_PASSWORD_CONTENT = "你重置后的密码为:%s,请妥善保管,并及时修改密码!";


	/**
	 * 默认分页每页显示条数
	 */
	public final static int DEFAULT_PAGE_SIZE = 10;
}
