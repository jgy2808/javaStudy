package org.practice.AlphabetHistogram;

import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetHistogram {
	
	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
        try
        {
            while(true)    //ctrl + z키가 입력될때까지 라인 6-11부분이 무한 반봅됩니다.
            {
                int a = rd.read();
                if(a==-1)  //ctrl -z가 입력되면 read()는 -1을 리턴
                {
                    break;
                }
                if (a == '\r' || a == '\n') {
                	rd.read(); rd.read();
                }
                System.out.println((char)a + " , " + a); //입력된 문자 출력
            }
        }
        catch(IOException e)
        {
            System.out.println("입력 오류 발생");
        }
	}
}