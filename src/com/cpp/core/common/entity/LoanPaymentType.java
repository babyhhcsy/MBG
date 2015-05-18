package com.cpp.core.common.entity;

import java.util.Date;

public class LoanPaymentType {
    private Integer fid;

    private String code;

    private String typeName;

    private String seq;

    private String isExternal;

    private String isActive;

    private String intRate;

    private String rpmntMthd;

    private String recVer;

    private String tagSeq;

    private String penaltyRate;

    private String adjustFee;

    private String isSelf;

    private String createdBy;

    private Date createTime;

    private String updatedBy;

    private Date updateTime;

    private String fremark;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(String isExternal) {
        this.isExternal = isExternal == null ? null : isExternal.trim();
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    public String getIntRate() {
        return intRate;
    }

    public void setIntRate(String intRate) {
        this.intRate = intRate == null ? null : intRate.trim();
    }

    public String getRpmntMthd() {
        return rpmntMthd;
    }

    public void setRpmntMthd(String rpmntMthd) {
        this.rpmntMthd = rpmntMthd == null ? null : rpmntMthd.trim();
    }

    public String getRecVer() {
        return recVer;
    }

    public void setRecVer(String recVer) {
        this.recVer = recVer == null ? null : recVer.trim();
    }

    public String getTagSeq() {
        return tagSeq;
    }

    public void setTagSeq(String tagSeq) {
        this.tagSeq = tagSeq == null ? null : tagSeq.trim();
    }

    public String getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(String penaltyRate) {
        this.penaltyRate = penaltyRate == null ? null : penaltyRate.trim();
    }

    public String getAdjustFee() {
        return adjustFee;
    }

    public void setAdjustFee(String adjustFee) {
        this.adjustFee = adjustFee == null ? null : adjustFee.trim();
    }

    public String getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf == null ? null : isSelf.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
    }
}