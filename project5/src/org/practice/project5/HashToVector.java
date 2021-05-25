package org.practice.project5;

import java.util.*;

public class HashToVector {
	public static Vector<String> hashTovec(HashMap<String, String> h){
		Vector<String> v = new Vector<String>();
		Collection<String> set = h.values();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			v.add(it.next());
		}
		return v;
		
	}
	public static void main(String[] args) {
		HashMap<String, String> h = new HashMap<String, String>();
		h.put("����", "112");
		h.put("ȭ��", "119");
		h.put("��ȭ��ȣ", "114");
		Vector<String> v = HashToVector.hashTovec(h);
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}

}
