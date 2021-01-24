package com.travelbyair.pojoclasses;

public class SearchSession {
	
	public SearchSession(String members, String fid) {
		super();
		this.members = members;
		this.fid = fid;
	}

	
	private String members;
	private String fid;
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	
	
}
