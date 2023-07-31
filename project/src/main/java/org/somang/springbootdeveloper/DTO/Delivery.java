package org.somang.springbootdeveloper.DTO;

public class Delivery {

    private String userId;
    private String deliverySeq;
    private String aliasNm;
    private String receiverNm;
    private String cellNum;
    private String addrMain;
    private String addrDetail;
    private String addrRef;
    private String zipCd;
    private String basicYn;

    private String cellNumPre;
    private String cellNumMiddle;
    private String cellNumEnd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeliverySeq() {
        return deliverySeq;
    }

    public void setDeliverySeq(String deliverySeq) {
        this.deliverySeq = deliverySeq;
    }

    public String getAliasNm() {
        return aliasNm;
    }

    public void setAliasNm(String aliasNm) {
        this.aliasNm = aliasNm;
    }

    public String getReceiverNm() {
        return receiverNm;
    }

    public void setReceiverNm(String receiverNm) {
        this.receiverNm = receiverNm;
    }

    public String getCellNum() {
        return cellNum;
    }

    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }

    public String getAddrMain() {
        return addrMain;
    }

    public void setAddrMain(String addrMain) {
        this.addrMain = addrMain;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public String getAddrRef() {
        return addrRef;
    }

    public void setAddrRef(String addrRef) {
        this.addrRef = addrRef;
    }

    public String getZipCd() {
        return zipCd;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getBasicYn() {
        return basicYn;
    }

    public void setBasicYn(String basicYn) {
        this.basicYn = basicYn;
    }

    public String getCellNumPre() {
        return cellNumPre;
    }

    public void setCellNumPre(String cellNumPre) {
        this.cellNumPre = cellNumPre;
    }

    public String getCellNumMiddle() {
        return cellNumMiddle;
    }

    public void setCellNumMiddle(String cellNumMiddle) {
        this.cellNumMiddle = cellNumMiddle;
    }

    public String getCellNumEnd() {
        return cellNumEnd;
    }

    public void setCellNumEnd(String cellNumEnd) {
        this.cellNumEnd = cellNumEnd;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "userId='" + userId + '\'' +
                ", deliverySeq='" + deliverySeq + '\'' +
                ", aliasNm='" + aliasNm + '\'' +
                ", receiverNm='" + receiverNm + '\'' +
                ", cellNum='" + cellNum + '\'' +
                ", addrMain='" + addrMain + '\'' +
                ", addrDetail='" + addrDetail + '\'' +
                ", addrRef='" + addrRef + '\'' +
                ", zipCd='" + zipCd + '\'' +
                ", basicYn='" + basicYn + '\'' +
                ", cellNumPre='" + cellNumPre + '\'' +
                ", cellNumMiddle='" + cellNumMiddle + '\'' +
                ", cellNumEnd='" + cellNumEnd + '\'' +
                '}';
    }
}
