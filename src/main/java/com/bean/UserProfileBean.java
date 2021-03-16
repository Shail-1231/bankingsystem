package com.bean;

public class UserProfileBean {

	int userProfileId, userId, addressProofTypeId;
	public int getAddressProofTypeId() {
		return addressProofTypeId;
	}

	public void setAddressProofTypeId(int addressProofTypeId) {
		this.addressProofTypeId = addressProofTypeId;
	}

	String addressProofType;
	String addressProof;
	String profilePicture;
	String panNumber;
	String panPicture;

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddressProofType() {
		return addressProofType;
	}

	public void setAddressProofType(String addressProofType) {
		this.addressProofType = addressProofType;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPanPicture() {
		return panPicture;
	}

	public void setPanPicture(String panPicture) {
		this.panPicture = panPicture;
	}

}
