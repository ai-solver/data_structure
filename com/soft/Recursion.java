package com.gupt;

import java.util.Arrays;

public class Recursion {
	static int arr[] = {23,11,45,45,25,13};
	//����Сֵ��˼·
	// 1 6����,ȡ��һ������Ϊ��Сֵ
	// 2 ȡ�����minNum�ͺ�������Ƚ�,ȡ��Сֵ�滻֮ǰ�ı���minNum
	// 3 ѭ��������ʱ��,�������ǵ���Сֵ
	public int getMinValue(int arr[]){
		int minNum = arr[0]; //23
		int i=1;
		//ѭ��
		for(;i<arr.length;i++){
			//���±�Ϊ1������ʼ�Ƚϣ����αȽ�
			// i = 1  arr[i] = 11 minNum = 11
			// i = 2  arr[i] = 45 minNum = 11
			// i = 3  arr[i] = 45 minNum = 11
			// i = 4  arr[i] = 25 minNum = 11
			// i = 5  arr[i] = 13 minNum = 11
			if(arr[i] < minNum){
				minNum = arr[i];  
			}
		}
		return minNum;
	}
	
	
	//���Сֵ
	public int getLessMin(int arr[]){
		int minNum = arr[0]; //23
		int i=1;
		//index ������Сֵ��Ӧ���±꣬Ӧ�ú�minNum���±걣��һ��
		int index = 0;
		//ѭ��
		for(;i<arr.length;i++){
			
			if(arr[i] < minNum){
				minNum = arr[i];  
				index = i;
			}
		}
		
		//arr[index] �� arr[0]����, arr���±�Ϊi��ֵ���±�Ϊ0��ֵ����
		int temp = arr[index];
		arr[index] = arr[0];
		arr[0] = temp;
		System.out.println(Arrays.toString(arr));
		int lessMin = arr[1];
		for(int j=2;j<arr.length;j++){
			if(arr[j] < lessMin){
				lessMin = arr[j];  
			}
		}
		
		return lessMin;
	}
	
	public static void main(String args[]){
		Recursion recursion = new Recursion();
		System.out.println(recursion.getLessMin(arr));
	}
	
	

}
