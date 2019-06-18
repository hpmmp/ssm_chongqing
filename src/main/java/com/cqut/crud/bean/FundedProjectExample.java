package com.cqut.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundedProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundedProjectExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdIsNull() {
            addCriterion("project_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdIsNotNull() {
            addCriterion("project_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdEqualTo(Integer value) {
            addCriterion("project_type_id =", value, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdNotEqualTo(Integer value) {
            addCriterion("project_type_id <>", value, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdGreaterThan(Integer value) {
            addCriterion("project_type_id >", value, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_type_id >=", value, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdLessThan(Integer value) {
            addCriterion("project_type_id <", value, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_type_id <=", value, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdIn(List<Integer> values) {
            addCriterion("project_type_id in", values, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdNotIn(List<Integer> values) {
            addCriterion("project_type_id not in", values, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("project_type_id between", value1, value2, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_type_id not between", value1, value2, "projectTypeId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(Integer value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(Integer value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(Integer value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(Integer value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(Integer value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<Integer> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<Integer> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(Integer value1, Integer value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(Integer value1, Integer value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSponsorIsNull() {
            addCriterion("sponsor is null");
            return (Criteria) this;
        }

        public Criteria andSponsorIsNotNull() {
            addCriterion("sponsor is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorEqualTo(String value) {
            addCriterion("sponsor =", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorNotEqualTo(String value) {
            addCriterion("sponsor <>", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorGreaterThan(String value) {
            addCriterion("sponsor >", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorGreaterThanOrEqualTo(String value) {
            addCriterion("sponsor >=", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorLessThan(String value) {
            addCriterion("sponsor <", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorLessThanOrEqualTo(String value) {
            addCriterion("sponsor <=", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorLike(String value) {
            addCriterion("sponsor like", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorNotLike(String value) {
            addCriterion("sponsor not like", value, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorIn(List<String> values) {
            addCriterion("sponsor in", values, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorNotIn(List<String> values) {
            addCriterion("sponsor not in", values, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorBetween(String value1, String value2) {
            addCriterion("sponsor between", value1, value2, "sponsor");
            return (Criteria) this;
        }

        public Criteria andSponsorNotBetween(String value1, String value2) {
            addCriterion("sponsor not between", value1, value2, "sponsor");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andStandardCommentIsNull() {
            addCriterion("standard_comment is null");
            return (Criteria) this;
        }

        public Criteria andStandardCommentIsNotNull() {
            addCriterion("standard_comment is not null");
            return (Criteria) this;
        }

        public Criteria andStandardCommentEqualTo(String value) {
            addCriterion("standard_comment =", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentNotEqualTo(String value) {
            addCriterion("standard_comment <>", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentGreaterThan(String value) {
            addCriterion("standard_comment >", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentGreaterThanOrEqualTo(String value) {
            addCriterion("standard_comment >=", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentLessThan(String value) {
            addCriterion("standard_comment <", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentLessThanOrEqualTo(String value) {
            addCriterion("standard_comment <=", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentLike(String value) {
            addCriterion("standard_comment like", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentNotLike(String value) {
            addCriterion("standard_comment not like", value, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentIn(List<String> values) {
            addCriterion("standard_comment in", values, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentNotIn(List<String> values) {
            addCriterion("standard_comment not in", values, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentBetween(String value1, String value2) {
            addCriterion("standard_comment between", value1, value2, "standardComment");
            return (Criteria) this;
        }

        public Criteria andStandardCommentNotBetween(String value1, String value2) {
            addCriterion("standard_comment not between", value1, value2, "standardComment");
            return (Criteria) this;
        }

        public Criteria andPhaseIsNull() {
            addCriterion("phase is null");
            return (Criteria) this;
        }

        public Criteria andPhaseIsNotNull() {
            addCriterion("phase is not null");
            return (Criteria) this;
        }

        public Criteria andPhaseEqualTo(String value) {
            addCriterion("phase =", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseNotEqualTo(String value) {
            addCriterion("phase <>", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseGreaterThan(String value) {
            addCriterion("phase >", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseGreaterThanOrEqualTo(String value) {
            addCriterion("phase >=", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseLessThan(String value) {
            addCriterion("phase <", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseLessThanOrEqualTo(String value) {
            addCriterion("phase <=", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseLike(String value) {
            addCriterion("phase like", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseNotLike(String value) {
            addCriterion("phase not like", value, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseIn(List<String> values) {
            addCriterion("phase in", values, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseNotIn(List<String> values) {
            addCriterion("phase not in", values, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseBetween(String value1, String value2) {
            addCriterion("phase between", value1, value2, "phase");
            return (Criteria) this;
        }

        public Criteria andPhaseNotBetween(String value1, String value2) {
            addCriterion("phase not between", value1, value2, "phase");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLimitCommentIsNull() {
            addCriterion("limit_comment is null");
            return (Criteria) this;
        }

        public Criteria andLimitCommentIsNotNull() {
            addCriterion("limit_comment is not null");
            return (Criteria) this;
        }

        public Criteria andLimitCommentEqualTo(String value) {
            addCriterion("limit_comment =", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentNotEqualTo(String value) {
            addCriterion("limit_comment <>", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentGreaterThan(String value) {
            addCriterion("limit_comment >", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentGreaterThanOrEqualTo(String value) {
            addCriterion("limit_comment >=", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentLessThan(String value) {
            addCriterion("limit_comment <", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentLessThanOrEqualTo(String value) {
            addCriterion("limit_comment <=", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentLike(String value) {
            addCriterion("limit_comment like", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentNotLike(String value) {
            addCriterion("limit_comment not like", value, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentIn(List<String> values) {
            addCriterion("limit_comment in", values, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentNotIn(List<String> values) {
            addCriterion("limit_comment not in", values, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentBetween(String value1, String value2) {
            addCriterion("limit_comment between", value1, value2, "limitComment");
            return (Criteria) this;
        }

        public Criteria andLimitCommentNotBetween(String value1, String value2) {
            addCriterion("limit_comment not between", value1, value2, "limitComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentIsNull() {
            addCriterion("material_comment is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentIsNotNull() {
            addCriterion("material_comment is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentEqualTo(String value) {
            addCriterion("material_comment =", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentNotEqualTo(String value) {
            addCriterion("material_comment <>", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentGreaterThan(String value) {
            addCriterion("material_comment >", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentGreaterThanOrEqualTo(String value) {
            addCriterion("material_comment >=", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentLessThan(String value) {
            addCriterion("material_comment <", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentLessThanOrEqualTo(String value) {
            addCriterion("material_comment <=", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentLike(String value) {
            addCriterion("material_comment like", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentNotLike(String value) {
            addCriterion("material_comment not like", value, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentIn(List<String> values) {
            addCriterion("material_comment in", values, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentNotIn(List<String> values) {
            addCriterion("material_comment not in", values, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentBetween(String value1, String value2) {
            addCriterion("material_comment between", value1, value2, "materialComment");
            return (Criteria) this;
        }

        public Criteria andMaterialCommentNotBetween(String value1, String value2) {
            addCriterion("material_comment not between", value1, value2, "materialComment");
            return (Criteria) this;
        }

        public Criteria andGrantModeIsNull() {
            addCriterion("grant_mode is null");
            return (Criteria) this;
        }

        public Criteria andGrantModeIsNotNull() {
            addCriterion("grant_mode is not null");
            return (Criteria) this;
        }

        public Criteria andGrantModeEqualTo(String value) {
            addCriterion("grant_mode =", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeNotEqualTo(String value) {
            addCriterion("grant_mode <>", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeGreaterThan(String value) {
            addCriterion("grant_mode >", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeGreaterThanOrEqualTo(String value) {
            addCriterion("grant_mode >=", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeLessThan(String value) {
            addCriterion("grant_mode <", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeLessThanOrEqualTo(String value) {
            addCriterion("grant_mode <=", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeLike(String value) {
            addCriterion("grant_mode like", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeNotLike(String value) {
            addCriterion("grant_mode not like", value, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeIn(List<String> values) {
            addCriterion("grant_mode in", values, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeNotIn(List<String> values) {
            addCriterion("grant_mode not in", values, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeBetween(String value1, String value2) {
            addCriterion("grant_mode between", value1, value2, "grantMode");
            return (Criteria) this;
        }

        public Criteria andGrantModeNotBetween(String value1, String value2) {
            addCriterion("grant_mode not between", value1, value2, "grantMode");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardIsNull() {
            addCriterion("need_id_card is null");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardIsNotNull() {
            addCriterion("need_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardEqualTo(String value) {
            addCriterion("need_id_card =", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardNotEqualTo(String value) {
            addCriterion("need_id_card <>", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardGreaterThan(String value) {
            addCriterion("need_id_card >", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("need_id_card >=", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardLessThan(String value) {
            addCriterion("need_id_card <", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardLessThanOrEqualTo(String value) {
            addCriterion("need_id_card <=", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardLike(String value) {
            addCriterion("need_id_card like", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardNotLike(String value) {
            addCriterion("need_id_card not like", value, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardIn(List<String> values) {
            addCriterion("need_id_card in", values, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardNotIn(List<String> values) {
            addCriterion("need_id_card not in", values, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardBetween(String value1, String value2) {
            addCriterion("need_id_card between", value1, value2, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedIdCardNotBetween(String value1, String value2) {
            addCriterion("need_id_card not between", value1, value2, "needIdCard");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionIsNull() {
            addCriterion("need_tuition is null");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionIsNotNull() {
            addCriterion("need_tuition is not null");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionEqualTo(String value) {
            addCriterion("need_tuition =", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionNotEqualTo(String value) {
            addCriterion("need_tuition <>", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionGreaterThan(String value) {
            addCriterion("need_tuition >", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionGreaterThanOrEqualTo(String value) {
            addCriterion("need_tuition >=", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionLessThan(String value) {
            addCriterion("need_tuition <", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionLessThanOrEqualTo(String value) {
            addCriterion("need_tuition <=", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionLike(String value) {
            addCriterion("need_tuition like", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionNotLike(String value) {
            addCriterion("need_tuition not like", value, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionIn(List<String> values) {
            addCriterion("need_tuition in", values, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionNotIn(List<String> values) {
            addCriterion("need_tuition not in", values, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionBetween(String value1, String value2) {
            addCriterion("need_tuition between", value1, value2, "needTuition");
            return (Criteria) this;
        }

        public Criteria andNeedTuitionNotBetween(String value1, String value2) {
            addCriterion("need_tuition not between", value1, value2, "needTuition");
            return (Criteria) this;
        }

        public Criteria andCreatAtIsNull() {
            addCriterion("creat_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatAtIsNotNull() {
            addCriterion("creat_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatAtEqualTo(Date value) {
            addCriterion("creat_at =", value, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtNotEqualTo(Date value) {
            addCriterion("creat_at <>", value, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtGreaterThan(Date value) {
            addCriterion("creat_at >", value, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_at >=", value, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtLessThan(Date value) {
            addCriterion("creat_at <", value, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtLessThanOrEqualTo(Date value) {
            addCriterion("creat_at <=", value, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtIn(List<Date> values) {
            addCriterion("creat_at in", values, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtNotIn(List<Date> values) {
            addCriterion("creat_at not in", values, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtBetween(Date value1, Date value2) {
            addCriterion("creat_at between", value1, value2, "creatAt");
            return (Criteria) this;
        }

        public Criteria andCreatAtNotBetween(Date value1, Date value2) {
            addCriterion("creat_at not between", value1, value2, "creatAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtIsNull() {
            addCriterion("apply_finished_at is null");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtIsNotNull() {
            addCriterion("apply_finished_at is not null");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtEqualTo(Date value) {
            addCriterion("apply_finished_at =", value, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtNotEqualTo(Date value) {
            addCriterion("apply_finished_at <>", value, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtGreaterThan(Date value) {
            addCriterion("apply_finished_at >", value, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_finished_at >=", value, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtLessThan(Date value) {
            addCriterion("apply_finished_at <", value, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtLessThanOrEqualTo(Date value) {
            addCriterion("apply_finished_at <=", value, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtIn(List<Date> values) {
            addCriterion("apply_finished_at in", values, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtNotIn(List<Date> values) {
            addCriterion("apply_finished_at not in", values, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtBetween(Date value1, Date value2) {
            addCriterion("apply_finished_at between", value1, value2, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andApplyFinishedAtNotBetween(Date value1, Date value2) {
            addCriterion("apply_finished_at not between", value1, value2, "applyFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtIsNull() {
            addCriterion("audit_finished_at is null");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtIsNotNull() {
            addCriterion("audit_finished_at is not null");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtEqualTo(Date value) {
            addCriterion("audit_finished_at =", value, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtNotEqualTo(Date value) {
            addCriterion("audit_finished_at <>", value, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtGreaterThan(Date value) {
            addCriterion("audit_finished_at >", value, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_finished_at >=", value, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtLessThan(Date value) {
            addCriterion("audit_finished_at <", value, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtLessThanOrEqualTo(Date value) {
            addCriterion("audit_finished_at <=", value, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtIn(List<Date> values) {
            addCriterion("audit_finished_at in", values, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtNotIn(List<Date> values) {
            addCriterion("audit_finished_at not in", values, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtBetween(Date value1, Date value2) {
            addCriterion("audit_finished_at between", value1, value2, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andAuditFinishedAtNotBetween(Date value1, Date value2) {
            addCriterion("audit_finished_at not between", value1, value2, "auditFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtIsNull() {
            addCriterion("publicize_finished_at is null");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtIsNotNull() {
            addCriterion("publicize_finished_at is not null");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtEqualTo(Date value) {
            addCriterion("publicize_finished_at =", value, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtNotEqualTo(Date value) {
            addCriterion("publicize_finished_at <>", value, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtGreaterThan(Date value) {
            addCriterion("publicize_finished_at >", value, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("publicize_finished_at >=", value, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtLessThan(Date value) {
            addCriterion("publicize_finished_at <", value, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtLessThanOrEqualTo(Date value) {
            addCriterion("publicize_finished_at <=", value, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtIn(List<Date> values) {
            addCriterion("publicize_finished_at in", values, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtNotIn(List<Date> values) {
            addCriterion("publicize_finished_at not in", values, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtBetween(Date value1, Date value2) {
            addCriterion("publicize_finished_at between", value1, value2, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andPublicizeFinishedAtNotBetween(Date value1, Date value2) {
            addCriterion("publicize_finished_at not between", value1, value2, "publicizeFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtIsNull() {
            addCriterion("grant_finished_at is null");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtIsNotNull() {
            addCriterion("grant_finished_at is not null");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtEqualTo(Date value) {
            addCriterion("grant_finished_at =", value, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtNotEqualTo(Date value) {
            addCriterion("grant_finished_at <>", value, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtGreaterThan(Date value) {
            addCriterion("grant_finished_at >", value, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("grant_finished_at >=", value, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtLessThan(Date value) {
            addCriterion("grant_finished_at <", value, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtLessThanOrEqualTo(Date value) {
            addCriterion("grant_finished_at <=", value, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtIn(List<Date> values) {
            addCriterion("grant_finished_at in", values, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtNotIn(List<Date> values) {
            addCriterion("grant_finished_at not in", values, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtBetween(Date value1, Date value2) {
            addCriterion("grant_finished_at between", value1, value2, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andGrantFinishedAtNotBetween(Date value1, Date value2) {
            addCriterion("grant_finished_at not between", value1, value2, "grantFinishedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNull() {
            addCriterion("deleted_at is null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNotNull() {
            addCriterion("deleted_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtEqualTo(Date value) {
            addCriterion("deleted_at =", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotEqualTo(Date value) {
            addCriterion("deleted_at <>", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThan(Date value) {
            addCriterion("deleted_at >", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("deleted_at >=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThan(Date value) {
            addCriterion("deleted_at <", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThanOrEqualTo(Date value) {
            addCriterion("deleted_at <=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIn(List<Date> values) {
            addCriterion("deleted_at in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotIn(List<Date> values) {
            addCriterion("deleted_at not in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtBetween(Date value1, Date value2) {
            addCriterion("deleted_at between", value1, value2, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotBetween(Date value1, Date value2) {
            addCriterion("deleted_at not between", value1, value2, "deletedAt");
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