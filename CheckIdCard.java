package api;

import java.util.Scanner;

public class CheckIdCard {
	public static void main(String[] args) {
		/*
		 * 校验身份证规则：
		 * 1、身份证前十七位分别乘以不同系数
		 * 第     1 2 3  4 5 6 7 8 9 10 11 12 13 14 15 16 17位
		 * 系数 7 9 10 5 8 4 2 1 6 3  7  9  10  5  8  4  2
		 * 2、前十七位分别乘对应系数后将结果相加得sum
		 * 3、sum%11结果为a
		 * 4、a可能为			0 1 2 3 4 5 6 7 8 9 10
		 * 分别对应身份证最后一位	1 0 X 9 8 7 6 5 4 3 2
		 */
		//创建一个系数数组
		int[] xishu = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
		//按照规则4的顺序创建数组存放余数的可能值
		int[] as = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//按照规则4的顺序创建最后一位的参考数组
		char[] last = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
		//创建Scanner对象
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("请输入身份证号码：");
			String idNo = scanner.next();
			//判断输入位数是否正确
			if (idNo.length() == 18) {
				//计算各个为乘积之和
				//第一步：将string转化为char[]类型
				char[] tmp = idNo.toCharArray();
				//创建一个长度和idNo长度相同的int[]数组
			    int[] cardidArray = new int[tmp.length-1];
			    //循环将char类型存入int[],完成类型转换最终为int类型
			    int i=0;
			    for(i=0;i<tmp.length-1;i++){
			        cardidArray[i] = Integer.parseInt(tmp[i]+"");
			    }
			    int sum = 0;
			    for (int j = 0; j < xishu.length; j++) {
					sum = sum + cardidArray[j] * xishu[j];
				}
			   
				//取余
				int a = sum % 11;
				//判断第十八位对应的数和a是否一致，一致则正确，否则错误,通过as数组和last数组下标确认
				//确认最后一位的下标
				int lastIndex = 0;
				int asIndex = 0;
				for (int j = 0; j < last.length; j++) {
					if (last[j]==(tmp[tmp.length-1])) {
						lastIndex = j;
					}
				}
				for (int j = 0; j < as.length; j++) {
					if (a == as[j]) {
						asIndex = j;
					}
				}
				//判断下标是否相同
				if (lastIndex == asIndex) {
					System.out.println("身份证号码正确！");
				} else {
					System.out.println("身份证号码不合法！");
				}
			} else {
				//否则位数错误
				System.out.println("身份证号码位数不正确！");
			}
			System.out.println("=======================================");
		}
	}
}
