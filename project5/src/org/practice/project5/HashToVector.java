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
		h.put("범죄", "112");
		h.put("화재", "119");
		h.put("전화번호", "114");
		Vector<String> v = HashToVector.hashTovec(h);
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
	}

}
