package org.practice.AlphabetHistogram;

import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetHistogram {
	
	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
        try
        {
            while(true)    //ctrl + zŰ�� �Էµɶ����� ���� 6-11�κ��� ���� �ݺ��˴ϴ�.
            {
                int a = rd.read();
                if(a==-1)  //ctrl -z�� �ԷµǸ� read()�� -1�� ����
                {
                    break;
                }
                if (a == '\r' || a == '\n') {
                	rd.read(); rd.read();
                }
                System.out.println((char)a + " , " + a); //�Էµ� ���� ���
            }
        }
        catch(IOException e)
        {
            System.out.println("�Է� ���� �߻�");
        }
	}
}