package com.redis.graph.impl;

public class Permission {
	String opcode   ;
	String opt_ts   ;
	String ctc_id   ;
	String bca   ;
	String load_ts   ;
	String mca   ;
	String mkt_cd   ;
	String cid   ;
	String ica_hier_group_text;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Permission [opcode=%s, opt_ts=%s, ctc_id=%s, bca=%s, load_ts=%s, mca=%s, mkt_cd=%s, cid=%s, ica_hier_group_text=%s]",
						opcode, opt_ts, ctc_id, bca, load_ts, mca, mkt_cd, cid,
						ica_hier_group_text);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bca == null) ? 0 : bca.hashCode());
		result = prime * result + ((ctc_id == null) ? 0 : ctc_id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Permission)) {
			return false;
		}
		Permission other = (Permission) obj;
		if (bca == null) {
			if (other.bca != null) {
				return false;
			}
		} else if (!bca.equals(other.bca)) {
			return false;
		}
		if (ctc_id == null) {
			if (other.ctc_id != null) {
				return false;
			}
		} else if (!ctc_id.equals(other.ctc_id)) {
			return false;
		}
		return true;
	}
	public String getOpcode() {
		return opcode;
	}
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	public String getOpt_ts() {
		return opt_ts;
	}
	public void setOpt_ts(String opt_ts) {
		this.opt_ts = opt_ts;
	}
	public String getCtc_id() {
		return ctc_id;
	}
	public void setCtc_id(String ctc_id) {
		this.ctc_id = ctc_id;
	}
	public String getBca() {
		return bca;
	}
	public void setBca(String bca) {
		this.bca = bca;
	}
	public String getLoad_ts() {
		return load_ts;
	}
	public void setLoad_ts(String load_ts) {
		this.load_ts = load_ts;
	}
	public String getMca() {
		return mca;
	}
	public void setMca(String mca) {
		this.mca = mca;
	}
	public String getMkt_cd() {
		return mkt_cd;
	}
	public void setMkt_cd(String mkt_cd) {
		this.mkt_cd = mkt_cd;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getIca_hier_group_text() {
		return ica_hier_group_text;
	}
	public void setIca_hier_group_text(String ica_hier_group_text) {
		this.ica_hier_group_text = ica_hier_group_text;
	}

}
