package com.redis.graph.impl;

import java.util.ArrayList;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.PipelineBlock;

public class InsertGraphData {

	public static void main(String[] args) {

		Jedis j = new Jedis("192.168.99.100", 6379);
		j.connect();
		System.out.println("Connected");

		ArrayList<Permission> perm = new SplitData().splitD();
		insertData(j, perm);
		insertDatas(j, perm);
		System.out.println("Finished");
	}

	@SuppressWarnings("deprecation")
	private static void insertData(Jedis j, ArrayList<Permission> perm) {
		j.select(0);
		j.flushDB();
		for (Permission per : perm) {
			if (per.getOpcode().trim().equalsIgnoreCase("D".trim())) {
				 j.srem(per.getBca(),per.getBca()+":"+per.getCtc_id());
				j.pipelined(new PipelineBlock() {

					@Override
					public void execute() {
						j.del(per.getBca() + ":" + per.getCtc_id() + ":ctc_id");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":bca");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":load_ts");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":mca");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":cid");
						j.del(per.getBca() + ":" + per.getCtc_id()
								+ ":ica_hier_group_text");

					}
				});
			} else if (per.getOpcode().trim().equalsIgnoreCase("U".trim())) {
				 j.sadd(per.getBca(),per.getBca()+":"+per.getCtc_id());
				j.pipelined(new PipelineBlock() {

					@Override
					public void execute() {
						j.del(per.getBca() + ":" + per.getCtc_id() + ":ctc_id");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":bca");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":load_ts");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":mca");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":cid");
						j.del(per.getBca() + ":" + per.getCtc_id()
								+ ":ica_hier_group_text");

					}
				});
				j.pipelined(new PipelineBlock() {

					@Override
					public void execute() {
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":ctc_id",
								per.getCtc_id());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":bca",
								per.getBca());
						j.sadd(per.getBca() + ":" + per.getCtc_id()
								+ ":load_ts", per.getLoad_ts());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":mca",
								per.getMca());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd",
								per.getMkt_cd());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":cid",
								per.getCid());
						j.sadd(per.getBca() + ":" + per.getCtc_id()
								+ ":ica_hier_group_text", per
								.getIca_hier_group_text().split(","));
					}
				});

			} else {
				j.sadd(per.getBca(),per.getBca()+":"+per.getCtc_id());
				j.pipelined(new PipelineBlock() {

					@Override
					public void execute() {
						j.del(per.getBca() + ":" + per.getCtc_id() + ":ctc_id");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":bca");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":load_ts");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":mca");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd");
						j.del(per.getBca() + ":" + per.getCtc_id() + ":cid");
						j.del(per.getBca() + ":" + per.getCtc_id()
								+ ":ica_hier_group_text");

					}
				});
				j.pipelined(new PipelineBlock() {

					@Override
					public void execute() {
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":ctc_id",
								per.getCtc_id());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":bca",
								per.getBca());
						j.sadd(per.getBca() + ":" + per.getCtc_id()
								+ ":load_ts", per.getLoad_ts());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":mca",
								per.getMca());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd",
								per.getMkt_cd());
						j.sadd(per.getBca() + ":" + per.getCtc_id() + ":cid",
								per.getCid());
						j.sadd(per.getBca() + ":" + per.getCtc_id()
								+ ":ica_hier_group_text", per
								.getIca_hier_group_text().split(","));
					}
				});
			}
		}
	}

	
	
	private static void insertDatas(Jedis j, ArrayList<Permission> perm) {
		j.select(1);
		j.flushDB();
		for (Permission per : perm) {
			if (per.getOpcode().trim().equalsIgnoreCase("D".trim())) {
				 Pipeline pipeline= j.pipelined();
				 pipeline.del(per.getBca() + ":" + per.getCtc_id() + ":ctc_id");
				 pipeline.del(per.getBca() + ":" + per.getCtc_id() + ":bca");
				 pipeline.del(per.getBca() + ":" + per.getCtc_id() + ":load_ts");
				 pipeline.del(per.getBca() + ":" + per.getCtc_id() + ":mca");
				 pipeline.del(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd");
				 pipeline.del(per.getBca() + ":" + per.getCtc_id() + ":cid");
				 pipeline.del(per.getBca() + ":" + per.getCtc_id() + ":ica_hier_group_text");
				 pipeline.srem(per.getBca(),per.getBca()+":"+per.getCtc_id());
				 pipeline.syncAndReturnAll();
				// pipeline.sync();
				// pipeline.exec();
				
			} else if (per.getOpcode().trim().equalsIgnoreCase("U".trim())) {
				
				Pipeline pipe=j.pipelined();
				pipe.sadd(per.getBca(),per.getBca()+":"+per.getCtc_id());				 
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":ctc_id",per.getCtc_id());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":bca",per.getBca());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id()	+ ":load_ts", per.getLoad_ts());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":mca",per.getMca());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd",per.getMkt_cd());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":cid",per.getCid());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id()+ ":ica_hier_group_text", per.getIca_hier_group_text().split(","));
				pipe.sadd(per.getBca(),per.getBca()+":"+per.getCtc_id());
				pipe.syncAndReturnAll();

			} else {
				Pipeline pipe=j.pipelined();
				pipe.sadd(per.getBca(),per.getBca()+":"+per.getCtc_id());				 
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":ctc_id",per.getCtc_id());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":bca",per.getBca());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id()	+ ":load_ts", per.getLoad_ts());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":mca",per.getMca());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":mkt_cd",per.getMkt_cd());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id() + ":cid",per.getCid());
				pipe.lpush(per.getBca() + ":" + per.getCtc_id()+ ":ica_hier_group_text", per.getIca_hier_group_text().split(","));
				pipe.sadd(per.getBca(),per.getBca()+":"+per.getCtc_id());
				pipe.syncAndReturnAll();
				
			}
		}
	}
}
