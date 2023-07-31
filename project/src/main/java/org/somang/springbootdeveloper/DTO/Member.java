package org.somang.springbootdeveloper.DTO;

import java.util.List;

public class Member {

    private String userId;
    private String userName;
    private String birthDate;
    private String sex;
    private String phoneNumber;
    private String email;
    private List<String> interest;
    private String interests;

    private String zipcode;
    private String addressMain;
    private String addressDetail;
    private String addressRef;

    public Member(String userId, String userName, String birthDate, String sex, String phoneNumber, String email, List<String> interest, String interests,
                  String zipcode, String addressMain, String addressDetail, String addressRef) {
        this.userId = userId;
        this.userName = userName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.interest = interest;
        this.interests = interests;
        this.zipcode = zipcode;
        this.addressMain = addressMain;
        this.addressDetail = addressDetail;
        this.addressRef = addressRef;


    }
    public Member() {

    };

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddressMain() {
        return addressMain;
    }

    public void setAddressMain(String addressMain) {
        this.addressMain = addressMain;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressRef() {
        return addressRef;
    }

    public void setAddressRef(String addressRef) {
        this.addressRef = addressRef;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", interest=" + interest +
                ", interests='" + interests + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", addressMain='" + addressMain + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", addressRef='" + addressRef + '\'' +
                '}';
    }
}
