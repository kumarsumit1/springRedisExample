package com.redis.graph.impl;

import java.util.ArrayList;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class FetchData {

	public static void main(String[] args) {
		Jedis j = new Jedis("192.168.99.100", 6379);
		DenormPermission dPerm=new DenormPermission();
		dPerm.setBca("006005550011135");
		j.connect();
		System.out.println("Connected");
		
		j.select(0);
		Set<String> cgidSet=j.smembers(dPerm.getBca());
		ArrayList<String> ica=new ArrayList<String>();
		ArrayList<String> ctc_id=new ArrayList<String>();
		ArrayList<String> mca=new ArrayList<String>();
		ArrayList<String> cid=new ArrayList<String>();
		for(String cgidKey:cgidSet){
			ica.add(cgidKey+":ica_hier_group_text");
			ctc_id.add(cgidKey+":cid");
			mca.add(cgidKey+":mca");
			cid.add(cgidKey+":ctc_id");
		}
		
		Pipeline pipeline = j.pipelined();
		pipeline.multi();
		Response<Set<String>>  icadet=pipeline.sunion(ica.toArray(new String[ica.size()]));
		Response<Set<String>>  ctcdet=pipeline.sunion(ctc_id.toArray(new String[ctc_id.size()]));
		Response<Set<String>>  mcadet=pipeline.sunion(mca.toArray(new String[mca.size()]));
		Response<Set<String>>  ciddet=pipeline.sunion(cid.toArray(new String[cid.size()]));
	    pipeline.exec();
	    java.util.List<Object> pipelineResult = pipeline.syncAndReturnAll();
		
	    dPerm.setIca_hier_group_text(icadet.get());
		dPerm.setCtc_id(ctcdet.get());
		dPerm.setMca(mcadet.get());
		dPerm.setCid(ciddet.get());
		System.out.println("The data for "+dPerm);
		/*for(Object str:pipelineResult){
			System.out.println(str);
		}*/
		System.out.println("Finished");

	}

}
