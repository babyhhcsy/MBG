package com.cpp.core.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanPaymentTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoanPaymentTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("TYPE_NAME =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("TYPE_NAME <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("TYPE_NAME >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("TYPE_NAME <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("TYPE_NAME like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("TYPE_NAME not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("TYPE_NAME in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("TYPE_NAME not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("TYPE_NAME between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("TYPE_NAME not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(String value) {
            addCriterion("SEQ =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(String value) {
            addCriterion("SEQ <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(String value) {
            addCriterion("SEQ >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(String value) {
            addCriterion("SEQ >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(String value) {
            addCriterion("SEQ <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(String value) {
            addCriterion("SEQ <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLike(String value) {
            addCriterion("SEQ like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotLike(String value) {
            addCriterion("SEQ not like", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<String> values) {
            addCriterion("SEQ in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<String> values) {
            addCriterion("SEQ not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(String value1, String value2) {
            addCriterion("SEQ between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(String value1, String value2) {
            addCriterion("SEQ not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andIsExternalIsNull() {
            addCriterion("IS_EXTERNAL is null");
            return (Criteria) this;
        }

        public Criteria andIsExternalIsNotNull() {
            addCriterion("IS_EXTERNAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsExternalEqualTo(String value) {
            addCriterion("IS_EXTERNAL =", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalNotEqualTo(String value) {
            addCriterion("IS_EXTERNAL <>", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalGreaterThan(String value) {
            addCriterion("IS_EXTERNAL >", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalGreaterThanOrEqualTo(String value) {
            addCriterion("IS_EXTERNAL >=", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalLessThan(String value) {
            addCriterion("IS_EXTERNAL <", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalLessThanOrEqualTo(String value) {
            addCriterion("IS_EXTERNAL <=", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalLike(String value) {
            addCriterion("IS_EXTERNAL like", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalNotLike(String value) {
            addCriterion("IS_EXTERNAL not like", value, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalIn(List<String> values) {
            addCriterion("IS_EXTERNAL in", values, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalNotIn(List<String> values) {
            addCriterion("IS_EXTERNAL not in", values, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalBetween(String value1, String value2) {
            addCriterion("IS_EXTERNAL between", value1, value2, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsExternalNotBetween(String value1, String value2) {
            addCriterion("IS_EXTERNAL not between", value1, value2, "isExternal");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("IS_ACTIVE is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("IS_ACTIVE is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(String value) {
            addCriterion("IS_ACTIVE =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(String value) {
            addCriterion("IS_ACTIVE <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(String value) {
            addCriterion("IS_ACTIVE >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(String value) {
            addCriterion("IS_ACTIVE >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(String value) {
            addCriterion("IS_ACTIVE <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(String value) {
            addCriterion("IS_ACTIVE <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLike(String value) {
            addCriterion("IS_ACTIVE like", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotLike(String value) {
            addCriterion("IS_ACTIVE not like", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<String> values) {
            addCriterion("IS_ACTIVE in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<String> values) {
            addCriterion("IS_ACTIVE not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(String value1, String value2) {
            addCriterion("IS_ACTIVE between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(String value1, String value2) {
            addCriterion("IS_ACTIVE not between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIntRateIsNull() {
            addCriterion("INT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andIntRateIsNotNull() {
            addCriterion("INT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andIntRateEqualTo(String value) {
            addCriterion("INT_RATE =", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateNotEqualTo(String value) {
            addCriterion("INT_RATE <>", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateGreaterThan(String value) {
            addCriterion("INT_RATE >", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateGreaterThanOrEqualTo(String value) {
            addCriterion("INT_RATE >=", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateLessThan(String value) {
            addCriterion("INT_RATE <", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateLessThanOrEqualTo(String value) {
            addCriterion("INT_RATE <=", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateLike(String value) {
            addCriterion("INT_RATE like", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateNotLike(String value) {
            addCriterion("INT_RATE not like", value, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateIn(List<String> values) {
            addCriterion("INT_RATE in", values, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateNotIn(List<String> values) {
            addCriterion("INT_RATE not in", values, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateBetween(String value1, String value2) {
            addCriterion("INT_RATE between", value1, value2, "intRate");
            return (Criteria) this;
        }

        public Criteria andIntRateNotBetween(String value1, String value2) {
            addCriterion("INT_RATE not between", value1, value2, "intRate");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdIsNull() {
            addCriterion("RPMNT_MTHD is null");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdIsNotNull() {
            addCriterion("RPMNT_MTHD is not null");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdEqualTo(String value) {
            addCriterion("RPMNT_MTHD =", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdNotEqualTo(String value) {
            addCriterion("RPMNT_MTHD <>", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdGreaterThan(String value) {
            addCriterion("RPMNT_MTHD >", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdGreaterThanOrEqualTo(String value) {
            addCriterion("RPMNT_MTHD >=", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdLessThan(String value) {
            addCriterion("RPMNT_MTHD <", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdLessThanOrEqualTo(String value) {
            addCriterion("RPMNT_MTHD <=", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdLike(String value) {
            addCriterion("RPMNT_MTHD like", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdNotLike(String value) {
            addCriterion("RPMNT_MTHD not like", value, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdIn(List<String> values) {
            addCriterion("RPMNT_MTHD in", values, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdNotIn(List<String> values) {
            addCriterion("RPMNT_MTHD not in", values, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdBetween(String value1, String value2) {
            addCriterion("RPMNT_MTHD between", value1, value2, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRpmntMthdNotBetween(String value1, String value2) {
            addCriterion("RPMNT_MTHD not between", value1, value2, "rpmntMthd");
            return (Criteria) this;
        }

        public Criteria andRecVerIsNull() {
            addCriterion("REC_VER is null");
            return (Criteria) this;
        }

        public Criteria andRecVerIsNotNull() {
            addCriterion("REC_VER is not null");
            return (Criteria) this;
        }

        public Criteria andRecVerEqualTo(String value) {
            addCriterion("REC_VER =", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerNotEqualTo(String value) {
            addCriterion("REC_VER <>", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerGreaterThan(String value) {
            addCriterion("REC_VER >", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerGreaterThanOrEqualTo(String value) {
            addCriterion("REC_VER >=", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerLessThan(String value) {
            addCriterion("REC_VER <", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerLessThanOrEqualTo(String value) {
            addCriterion("REC_VER <=", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerLike(String value) {
            addCriterion("REC_VER like", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerNotLike(String value) {
            addCriterion("REC_VER not like", value, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerIn(List<String> values) {
            addCriterion("REC_VER in", values, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerNotIn(List<String> values) {
            addCriterion("REC_VER not in", values, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerBetween(String value1, String value2) {
            addCriterion("REC_VER between", value1, value2, "recVer");
            return (Criteria) this;
        }

        public Criteria andRecVerNotBetween(String value1, String value2) {
            addCriterion("REC_VER not between", value1, value2, "recVer");
            return (Criteria) this;
        }

        public Criteria andTagSeqIsNull() {
            addCriterion("TAG_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andTagSeqIsNotNull() {
            addCriterion("TAG_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andTagSeqEqualTo(String value) {
            addCriterion("TAG_SEQ =", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqNotEqualTo(String value) {
            addCriterion("TAG_SEQ <>", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqGreaterThan(String value) {
            addCriterion("TAG_SEQ >", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqGreaterThanOrEqualTo(String value) {
            addCriterion("TAG_SEQ >=", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqLessThan(String value) {
            addCriterion("TAG_SEQ <", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqLessThanOrEqualTo(String value) {
            addCriterion("TAG_SEQ <=", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqLike(String value) {
            addCriterion("TAG_SEQ like", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqNotLike(String value) {
            addCriterion("TAG_SEQ not like", value, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqIn(List<String> values) {
            addCriterion("TAG_SEQ in", values, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqNotIn(List<String> values) {
            addCriterion("TAG_SEQ not in", values, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqBetween(String value1, String value2) {
            addCriterion("TAG_SEQ between", value1, value2, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andTagSeqNotBetween(String value1, String value2) {
            addCriterion("TAG_SEQ not between", value1, value2, "tagSeq");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateIsNull() {
            addCriterion("PENALTY_RATE is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateIsNotNull() {
            addCriterion("PENALTY_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateEqualTo(String value) {
            addCriterion("PENALTY_RATE =", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateNotEqualTo(String value) {
            addCriterion("PENALTY_RATE <>", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateGreaterThan(String value) {
            addCriterion("PENALTY_RATE >", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateGreaterThanOrEqualTo(String value) {
            addCriterion("PENALTY_RATE >=", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateLessThan(String value) {
            addCriterion("PENALTY_RATE <", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateLessThanOrEqualTo(String value) {
            addCriterion("PENALTY_RATE <=", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateLike(String value) {
            addCriterion("PENALTY_RATE like", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateNotLike(String value) {
            addCriterion("PENALTY_RATE not like", value, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateIn(List<String> values) {
            addCriterion("PENALTY_RATE in", values, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateNotIn(List<String> values) {
            addCriterion("PENALTY_RATE not in", values, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateBetween(String value1, String value2) {
            addCriterion("PENALTY_RATE between", value1, value2, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andPenaltyRateNotBetween(String value1, String value2) {
            addCriterion("PENALTY_RATE not between", value1, value2, "penaltyRate");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNull() {
            addCriterion("ADJUST_FEE is null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNotNull() {
            addCriterion("ADJUST_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeEqualTo(String value) {
            addCriterion("ADJUST_FEE =", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotEqualTo(String value) {
            addCriterion("ADJUST_FEE <>", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThan(String value) {
            addCriterion("ADJUST_FEE >", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_FEE >=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThan(String value) {
            addCriterion("ADJUST_FEE <", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_FEE <=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLike(String value) {
            addCriterion("ADJUST_FEE like", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotLike(String value) {
            addCriterion("ADJUST_FEE not like", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIn(List<String> values) {
            addCriterion("ADJUST_FEE in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotIn(List<String> values) {
            addCriterion("ADJUST_FEE not in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeBetween(String value1, String value2) {
            addCriterion("ADJUST_FEE between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotBetween(String value1, String value2) {
            addCriterion("ADJUST_FEE not between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andIsSelfIsNull() {
            addCriterion("is_Self is null");
            return (Criteria) this;
        }

        public Criteria andIsSelfIsNotNull() {
            addCriterion("is_Self is not null");
            return (Criteria) this;
        }

        public Criteria andIsSelfEqualTo(String value) {
            addCriterion("is_Self =", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfNotEqualTo(String value) {
            addCriterion("is_Self <>", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfGreaterThan(String value) {
            addCriterion("is_Self >", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfGreaterThanOrEqualTo(String value) {
            addCriterion("is_Self >=", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfLessThan(String value) {
            addCriterion("is_Self <", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfLessThanOrEqualTo(String value) {
            addCriterion("is_Self <=", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfLike(String value) {
            addCriterion("is_Self like", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfNotLike(String value) {
            addCriterion("is_Self not like", value, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfIn(List<String> values) {
            addCriterion("is_Self in", values, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfNotIn(List<String> values) {
            addCriterion("is_Self not in", values, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfBetween(String value1, String value2) {
            addCriterion("is_Self between", value1, value2, "isSelf");
            return (Criteria) this;
        }

        public Criteria andIsSelfNotBetween(String value1, String value2) {
            addCriterion("is_Self not between", value1, value2, "isSelf");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("Updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("Updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("Updated_by =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("Updated_by <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("Updated_by >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("Updated_by >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("Updated_by <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("Updated_by <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("Updated_by like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("Updated_by not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("Updated_by in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("Updated_by not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("Updated_by between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("Updated_by not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("Update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("Update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("Update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("Update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("Update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("Update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("Update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("Update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("Update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNull() {
            addCriterion("FRemark is null");
            return (Criteria) this;
        }

        public Criteria andFremarkIsNotNull() {
            addCriterion("FRemark is not null");
            return (Criteria) this;
        }

        public Criteria andFremarkEqualTo(String value) {
            addCriterion("FRemark =", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotEqualTo(String value) {
            addCriterion("FRemark <>", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThan(String value) {
            addCriterion("FRemark >", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkGreaterThanOrEqualTo(String value) {
            addCriterion("FRemark >=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThan(String value) {
            addCriterion("FRemark <", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLessThanOrEqualTo(String value) {
            addCriterion("FRemark <=", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkLike(String value) {
            addCriterion("FRemark like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotLike(String value) {
            addCriterion("FRemark not like", value, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkIn(List<String> values) {
            addCriterion("FRemark in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotIn(List<String> values) {
            addCriterion("FRemark not in", values, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkBetween(String value1, String value2) {
            addCriterion("FRemark between", value1, value2, "fremark");
            return (Criteria) this;
        }

        public Criteria andFremarkNotBetween(String value1, String value2) {
            addCriterion("FRemark not between", value1, value2, "fremark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}