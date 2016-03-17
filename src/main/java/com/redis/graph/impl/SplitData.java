package com.redis.graph.impl;

import java.util.ArrayList;

public class SplitData {

	public ArrayList<Permission> splitD() {
		 ArrayList<Permission> perm=new ArrayList<Permission>();
		ArrayList<String> str =new ArrayList<String>(); 
		str.add("U~126545~006005550011135~2015-05-22 16:33:39.735121~006000000500260~006~500660~777,8888");
		str.add("I~126545~006005550011135~2015-05-22 16:33:39.735121~006000000500260~006~500660~777,8888");
		str.add("U~126545~006005550011135~2015-05-22 16:33:39.735121~006000000500260~006~500660~99,999");
		str.add("I~126545~006005550011137~2015-03-11 14:33:39.735121~006000000500260~006~500660~76656,66654");
		str.add("U~126545~006005550011137~2015-03-11 14:33:39.735121~006000000500261~007~444444~88890,3245,33456");
		str.add("I~126546~006005550011135~2015-03-11 14:33:39.735121~006000000500261~007~444444~88891,3245,33456");
		str.add("D~126546~006005550011135~2015-03-11 14:33:39.735121~006000000500261~007~444444~88890,3245,33456");
		str.add("I~126547~006005550011135~2015-03-11 14:33:39.735121~006000000500261~007~444444~666,999");
		str.add("U~126547~006005550011135~2015-03-11 14:33:39.735121~006000000500261~007~444444~1111,2222");
		for (String st:str){
		  String[] data=st.split("~");
		  Permission p=new Permission();
		  p.setOpcode(data[0]);
		  p.setCtc_id(data[1]);
		  p.setBca(data[2]);
		  p.setLoad_ts(data[3]);
		  p.setMca(data[4]);
		  p.setMkt_cd(data[5]);
		  p.setCid(data[6]);
		  p.setIca_hier_group_text(data[7]);
		  perm.add(p);
		}
		
		return perm;
	}

}
