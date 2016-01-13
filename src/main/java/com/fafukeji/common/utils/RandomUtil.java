package com.fafukeji.common.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 随机数工具类
 * 
 * @author wjx
 */

public class RandomUtil {
	/**
	 * 获取range范围内的整数
	 * 
	 * @param range
	 * @return
	 */
	public static int getRandomIntNum(int range) {
		if (range < 0) {
			range = Math.abs(range);
		}
		Random random = new Random();
		return random.nextInt(range);
	}

	/**
	 * 返回长度为length的随机数
	 * 
	 * @param length
	 * @return
	 */
	public static String getFixLengthInt(int length) {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(length);
	}

	/**
	 * 获取6位的数字随机码
	 * 
	 * @return
	 */
	public static int getSixLengthRandomNum() {
		return (int) ((Math.random() * 9 + 1) * 100000);
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomString(20));
	}
	
	/**
	 * 返回长度为length的随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {   
        StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");   
        StringBuffer sb = new StringBuffer();   
        Random random = new Random();   
        int range = buffer.length();   
        for (int i = 0; i < length; i ++) {   
            sb.append(buffer.charAt(random.nextInt(range)));   
        }   
        return sb.toString();   
    }  
}
