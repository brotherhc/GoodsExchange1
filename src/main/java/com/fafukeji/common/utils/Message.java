package com.fafukeji.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fafukeji.model.MessageInfo;
import com.fafukeji.utils.LogUtils.SaveLogThread;

public class Message {
	private static final String URL = "http://www.106008.com/WebAPI/SmsAPI.asmx/SendSmsExt";
	private static final String USER = "fafukeji";
	private static final String PWD = "fafukeji1044";
	public static Logger log = Logger.getLogger(Message.class);
	public static void sendMessage(MessageInfo messageInfo){
		try {
			//异步发送短信
			new SendMessageThread(messageInfo).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setChid(0);
		messageInfo.setMobiles("18223265008");
		messageInfo.setSendtime("");//发送时间
		messageInfo.setContents("test");
		sendMessage(messageInfo);
	}
	
	/**
	 * 保存日志线程
	 */
	public static class SendMessageThread extends Thread{
		private MessageInfo messageInfo;
		public SendMessageThread(MessageInfo messageInfo){
			super(SaveLogThread.class.getSimpleName());
			this.messageInfo = messageInfo;
		}
		
		@Override
		public void run() {
			Map<Object, Object> urlMap = new HashMap<>();
			urlMap.put("chid", 0);
			urlMap.put("user", USER);
			urlMap.put("pwd", PWD);
			urlMap.put("mobiles", messageInfo.getMobiles());
			urlMap.put("sendtime", messageInfo.getSendtime() == null ? "":messageInfo.getSendtime());
			urlMap.put("contents", messageInfo.getContents());
			try {
				String result = HttpRequestUtil.sendPost(URL, UrlUtils.urlEncodeUTF8(urlMap));
				log.debug("message result==========="+ result);
				int code = Integer.parseInt(result.split("<Code>")[1].split("</Code>")[0]);
				if (code>=0){
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
