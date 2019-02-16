package api;

import java.util.Scanner;

public class CheckIdCard {
	public static void main(String[] args) {
		/*
		 * У�����֤����
		 * 1�����֤ǰʮ��λ�ֱ���Բ�ͬϵ��
		 * ��     1 2 3  4 5 6 7 8 9 10 11 12 13 14 15 16 17λ
		 * ϵ�� 7 9 10 5 8 4 2 1 6 3  7  9  10  5  8  4  2
		 * 2��ǰʮ��λ�ֱ�˶�Ӧϵ���󽫽����ӵ�sum
		 * 3��sum%11���Ϊa
		 * 4��a����Ϊ			0 1 2 3 4 5 6 7 8 9 10
		 * �ֱ��Ӧ���֤���һλ	1 0 X 9 8 7 6 5 4 3 2
		 */
		//����һ��ϵ������
		int[] xishu = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
		//���չ���4��˳�򴴽������������Ŀ���ֵ
		int[] as = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//���չ���4��˳�򴴽����һλ�Ĳο�����
		char[] last = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
		//����Scanner����
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("���������֤���룺");
			String idNo = scanner.next();
			//�ж�����λ���Ƿ���ȷ
			if (idNo.length() == 18) {
				//�������Ϊ�˻�֮��
				//��һ������stringת��Ϊint[]����
				//�½�int[]����,��Ϊ����ǰʮ��λ���֣����Գ���Ϊstr.length()-1
				int[] cardidArray = new int[idNo.length()-1];
			    for(int i=0;i<cardidArray.length;i++){
			        cardidArray[i] = Integer.parseInt(idNo.charAt(i)+"");
			    }
			    int sum = 0;
			    for (int j = 0; j < xishu.length; j++) {
					sum = sum + cardidArray[j] * xishu[j];
				}
				//ȡ��
				int a = sum % 11;
				//�жϵ�ʮ��λ��Ӧ������a�Ƿ�һ�£�һ������ȷ���������,ͨ��as�����last�����±�ȷ��
				//ȷ�����һλ���±�
				int lastIndex = 0;
				int asIndex = 0;
				char endNo = idNo.charAt(idNo.length()-1);
				for (int j = 0; j < last.length; j++) {
					if (last[j]==endNo) {
						lastIndex = j;
					}
				}
				for (int j = 0; j < as.length; j++) {
					if (a == as[j]) {
						asIndex = j;
					}
				}
				//�ж��±��Ƿ���ͬ
				if (lastIndex == asIndex) {
					System.out.println("���֤������ȷ��");
				} else {
					System.out.println("���֤���벻�Ϸ���");
				}
			} else {
				//����λ������
				System.out.println("���֤����λ������ȷ��");
			}
			System.out.println("=======================================");
		}
	}
}
