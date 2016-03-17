package com.redis.graph.impl;
import java.util.Set;


public class DenormPermission {
	Set<String> ctc_id   ;
	String bca   ;
	//String load_ts   ;
	Set<String> mca   ;
	//String mkt_cd   ;
	Set<String> cid   ;
	Set<String> ica_hier_group_text;
	/**
	 * @return the ctc_id
	 */
	public Set<String> getCtc_id() {
		return ctc_id;
	}
	/**
	 * @param ctc_id the ctc_id to set
	 */
	public void setCtc_id(Set<String> ctc_id) {
		this.ctc_id = ctc_id;
	}
	/**
	 * @return the bca
	 */
	public String getBca() {
		return bca;
	}
	/**
	 * @param bca the bca to set
	 */
	public void setBca(String bca) {
		this.bca = bca;
	}
	/**
	 * @return the mca
	 */
	public Set<String> getMca() {
		return mca;
	}
	/**
	 * @param mca the mca to set
	 */
	public void setMca(Set<String> mca) {
		this.mca = mca;
	}
	/**
	 * @return the cid
	 */
	public Set<String> getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(Set<String> cid) {
		this.cid = cid;
	}
	/**
	 * @return the ica_hier_group_text
	 */
	public Set<String> getIca_hier_group_text() {
		return ica_hier_group_text;
	}
	/**
	 * @param ica_hier_group_text the ica_hier_group_text to set
	 */
	public void setIca_hier_group_text(Set<String> ica_hier_group_text) {
		this.ica_hier_group_text = ica_hier_group_text;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DenormPermission [ctc_id=").append(ctc_id)
				.append(", bca=").append(bca).append(", mca=").append(mca)
				.append(", cid=").append(cid).append(", ica_hier_group_text=")
				.append(ica_hier_group_text).append("]");
		return builder.toString();
	}
	
	
	
}
