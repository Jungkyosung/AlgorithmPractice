package mypack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CalculateMaxMinNumber {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//몇개의 임의의 숫자를 비교할지 숫자 입력
		int numbers = scan.nextInt();
		scan.close();
		
		//위에서 정한 숫자만큼 배열 생성
		int[] arrayInt = new int[numbers];
		
		//배열에 랜덤 값 넣기
		for (int i=0; i < numbers; i++) {
			arrayInt[i] = (int)(Math.random() * numbers)+1;
		}
		
		System.out.println(Arrays.toString(arrayInt));
		
		while(arrayInt.length > 1) {
		//비교할 홀수 숫자와, 짝수 숫자 필드 선언
		int odd = 0;
		int even = 0;
		int winNumber = 0;
		int lastOddNumber = 0; 
		
		//이긴 숫자 배열 필드 선언
		int[] winNumberArray = new int[(int)(arrayInt.length/2)];
		
		//만약 기초 배열의 크기가 홀수라면 마지막 숫자는 따로 저장해둠.
		if (arrayInt.length%2 == 1) {
			lastOddNumber = arrayInt[arrayInt.length-1];
		}
		System.out.println("lastOddNumber = " + lastOddNumber);
		
		//홀수 짝수 큰값 비교하기
		for (int i=2; i < arrayInt.length+1; i+=2) {
			
				even = arrayInt[i-1];
				odd = arrayInt[i-2];
			
			if (odd >= even) {
				winNumber = odd;
			} else {
				winNumber = even;
			}
			winNumberArray[(i/2)-1] = winNumber;
		}
		
		//따로 빼둔 홀수가 있다면 마지막값에 대입
		if (lastOddNumber != 0) {
			
			int[] TempArray = new int[winNumberArray.length];
			TempArray = winNumberArray;
			
			winNumberArray = new int[winNumberArray.length+1];
			
			for (int i=0; i < winNumberArray.length-1; i++) {
				winNumberArray[i] = TempArray[i];
			}
			winNumberArray[winNumberArray.length-1] = lastOddNumber;
			
		}
		
		arrayInt = new int[winNumberArray.length];
		arrayInt = winNumberArray;
		
		System.out.println(Arrays.toString(arrayInt));
		System.out.println(Arrays.toString(winNumberArray));
		
		}
		
		//위의 로직을 어떻게 해야 마지막 까지 배열의 크기를 줄여가면서 돌릴 수 있을까?(while문 사용?)
		
		//한바퀴 돌고 난 후 어떻게 해야 다시 배열을 생성해서 넣어 줄 수 있을까?
		//홀수일 경우엔 마지막 숫자를 빼뒀다가 배열에 다시 합치면 될 듯. 아래와 동일
		//목적이 최대값 찾기라면 홀수일 경우엔 마지막 자리숫자를 따로 빼뒀다가 마지막에 비교하면 될 듯.

		
	}
}
