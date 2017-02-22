package com.tal.util;
public class IdGenerator {

	/**
	 * 订单号（生成规则：12位currentTimeMillis/10(10毫秒)+2位流水号）
	 * @return
	 */
	private static int i = 0;

	/**
	 * @DESCRIPION :每10毫秒可生成100个序列号；优于每毫秒10个序列号
	 * @Create on: 2013-4-16 下午5:27:05
	 * @Author : "Jack"
	 * @return : String
	 */
	public synchronized static String genOrdId16() {
		i = i % 100;
		String index = (i < 10) ? ("0" + i) : "" + i;
		String orderNum = System.currentTimeMillis() / 10 + index;
		i++;
		return orderNum;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					System.err.println(genOrdId16());

				}
			});
			t.start();
		}
	}

}