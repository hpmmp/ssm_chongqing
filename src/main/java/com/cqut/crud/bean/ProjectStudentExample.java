package com.cqut.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectStudentExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Integer value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Integer value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Integer value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Integer value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Integer> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Integer> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Integer value1, Integer value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdIsNull() {
            addCriterion("school_roll_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdIsNotNull() {
            addCriterion("school_roll_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdEqualTo(Integer value) {
            addCriterion("school_roll_id =", value, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdNotEqualTo(Integer value) {
            addCriterion("school_roll_id <>", value, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdGreaterThan(Integer value) {
            addCriterion("school_roll_id >", value, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_roll_id >=", value, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdLessThan(Integer value) {
            addCriterion("school_roll_id <", value, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_roll_id <=", value, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdIn(List<Integer> values) {
            addCriterion("school_roll_id in", values, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdNotIn(List<Integer> values) {
            addCriterion("school_roll_id not in", values, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdBetween(Integer value1, Integer value2) {
            addCriterion("school_roll_id between", value1, value2, "schoolRollId");
            return (Criteria) this;
        }

        public Criteria andSchoolRollIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_roll_id not between", value1, value2, "schoolRollId");
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

        public Criteria andGrantStatusIsNull() {
            addCriterion("grant_status is null");
            return (Criteria) this;
        }

        public Criteria andGrantStatusIsNotNull() {
            addCriterion("grant_status is not null");
            return (Criteria) this;
        }

        public Criteria andGrantStatusEqualTo(String value) {
            addCriterion("grant_status =", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotEqualTo(String value) {
            addCriterion("grant_status <>", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusGreaterThan(String value) {
            addCriterion("grant_status >", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusGreaterThanOrEqualTo(String value) {
            addCriterion("grant_status >=", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusLessThan(String value) {
            addCriterion("grant_status <", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusLessThanOrEqualTo(String value) {
            addCriterion("grant_status <=", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusLike(String value) {
            addCriterion("grant_status like", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotLike(String value) {
            addCriterion("grant_status not like", value, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusIn(List<String> values) {
            addCriterion("grant_status in", values, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotIn(List<String> values) {
            addCriterion("grant_status not in", values, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusBetween(String value1, String value2) {
            addCriterion("grant_status between", value1, value2, "grantStatus");
            return (Criteria) this;
        }

        public Criteria andGrantStatusNotBetween(String value1, String value2) {
            addCriterion("grant_status not between", value1, value2, "grantStatus");
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

        public Criteria andTuitionIsNull() {
            addCriterion("tuition is null");
            return (Criteria) this;
        }

        public Criteria andTuitionIsNotNull() {
            addCriterion("tuition is not null");
            return (Criteria) this;
        }

        public Criteria andTuitionEqualTo(Double value) {
            addCriterion("tuition =", value, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionNotEqualTo(Double value) {
            addCriterion("tuition <>", value, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionGreaterThan(Double value) {
            addCriterion("tuition >", value, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionGreaterThanOrEqualTo(Double value) {
            addCriterion("tuition >=", value, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionLessThan(Double value) {
            addCriterion("tuition <", value, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionLessThanOrEqualTo(Double value) {
            addCriterion("tuition <=", value, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionIn(List<Double> values) {
            addCriterion("tuition in", values, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionNotIn(List<Double> values) {
            addCriterion("tuition not in", values, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionBetween(Double value1, Double value2) {
            addCriterion("tuition between", value1, value2, "tuition");
            return (Criteria) this;
        }

        public Criteria andTuitionNotBetween(Double value1, Double value2) {
            addCriterion("tuition not between", value1, value2, "tuition");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNull() {
            addCriterion("from_type is null");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNotNull() {
            addCriterion("from_type is not null");
            return (Criteria) this;
        }

        public Criteria andFromTypeEqualTo(String value) {
            addCriterion("from_type =", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotEqualTo(String value) {
            addCriterion("from_type <>", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThan(String value) {
            addCriterion("from_type >", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThanOrEqualTo(String value) {
            addCriterion("from_type >=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThan(String value) {
            addCriterion("from_type <", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThanOrEqualTo(String value) {
            addCriterion("from_type <=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLike(String value) {
            addCriterion("from_type like", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotLike(String value) {
            addCriterion("from_type not like", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeIn(List<String> values) {
            addCriterion("from_type in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotIn(List<String> values) {
            addCriterion("from_type not in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeBetween(String value1, String value2) {
            addCriterion("from_type between", value1, value2, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotBetween(String value1, String value2) {
            addCriterion("from_type not between", value1, value2, "fromType");
            return (Criteria) this;
        }

        public Criteria andAppliedAtIsNull() {
            addCriterion("applied_at is null");
            return (Criteria) this;
        }

        public Criteria andAppliedAtIsNotNull() {
            addCriterion("applied_at is not null");
            return (Criteria) this;
        }

        public Criteria andAppliedAtEqualTo(Date value) {
            addCriterion("applied_at =", value, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtNotEqualTo(Date value) {
            addCriterion("applied_at <>", value, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtGreaterThan(Date value) {
            addCriterion("applied_at >", value, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("applied_at >=", value, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtLessThan(Date value) {
            addCriterion("applied_at <", value, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtLessThanOrEqualTo(Date value) {
            addCriterion("applied_at <=", value, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtIn(List<Date> values) {
            addCriterion("applied_at in", values, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtNotIn(List<Date> values) {
            addCriterion("applied_at not in", values, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtBetween(Date value1, Date value2) {
            addCriterion("applied_at between", value1, value2, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andAppliedAtNotBetween(Date value1, Date value2) {
            addCriterion("applied_at not between", value1, value2, "appliedAt");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterIsNull() {
            addCriterion("census_register is null");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterIsNotNull() {
            addCriterion("census_register is not null");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterEqualTo(String value) {
            addCriterion("census_register =", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterNotEqualTo(String value) {
            addCriterion("census_register <>", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterGreaterThan(String value) {
            addCriterion("census_register >", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("census_register >=", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterLessThan(String value) {
            addCriterion("census_register <", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterLessThanOrEqualTo(String value) {
            addCriterion("census_register <=", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterLike(String value) {
            addCriterion("census_register like", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterNotLike(String value) {
            addCriterion("census_register not like", value, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterIn(List<String> values) {
            addCriterion("census_register in", values, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterNotIn(List<String> values) {
            addCriterion("census_register not in", values, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterBetween(String value1, String value2) {
            addCriterion("census_register between", value1, value2, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andCensusRegisterNotBetween(String value1, String value2) {
            addCriterion("census_register not between", value1, value2, "censusRegister");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andOwnershipIsNull() {
            addCriterion("ownership is null");
            return (Criteria) this;
        }

        public Criteria andOwnershipIsNotNull() {
            addCriterion("ownership is not null");
            return (Criteria) this;
        }

        public Criteria andOwnershipEqualTo(Integer value) {
            addCriterion("ownership =", value, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipNotEqualTo(Integer value) {
            addCriterion("ownership <>", value, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipGreaterThan(Integer value) {
            addCriterion("ownership >", value, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipGreaterThanOrEqualTo(Integer value) {
            addCriterion("ownership >=", value, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipLessThan(Integer value) {
            addCriterion("ownership <", value, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipLessThanOrEqualTo(Integer value) {
            addCriterion("ownership <=", value, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipIn(List<Integer> values) {
            addCriterion("ownership in", values, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipNotIn(List<Integer> values) {
            addCriterion("ownership not in", values, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipBetween(Integer value1, Integer value2) {
            addCriterion("ownership between", value1, value2, "ownership");
            return (Criteria) this;
        }

        public Criteria andOwnershipNotBetween(Integer value1, Integer value2) {
            addCriterion("ownership not between", value1, value2, "ownership");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseIsNull() {
            addCriterion("school_phase is null");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseIsNotNull() {
            addCriterion("school_phase is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseEqualTo(String value) {
            addCriterion("school_phase =", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseNotEqualTo(String value) {
            addCriterion("school_phase <>", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseGreaterThan(String value) {
            addCriterion("school_phase >", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseGreaterThanOrEqualTo(String value) {
            addCriterion("school_phase >=", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseLessThan(String value) {
            addCriterion("school_phase <", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseLessThanOrEqualTo(String value) {
            addCriterion("school_phase <=", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseLike(String value) {
            addCriterion("school_phase like", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseNotLike(String value) {
            addCriterion("school_phase not like", value, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseIn(List<String> values) {
            addCriterion("school_phase in", values, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseNotIn(List<String> values) {
            addCriterion("school_phase not in", values, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseBetween(String value1, String value2) {
            addCriterion("school_phase between", value1, value2, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andSchoolPhaseNotBetween(String value1, String value2) {
            addCriterion("school_phase not between", value1, value2, "schoolPhase");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeIsNull() {
            addCriterion("poverty_type is null");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeIsNotNull() {
            addCriterion("poverty_type is not null");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeEqualTo(String value) {
            addCriterion("poverty_type =", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeNotEqualTo(String value) {
            addCriterion("poverty_type <>", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeGreaterThan(String value) {
            addCriterion("poverty_type >", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("poverty_type >=", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeLessThan(String value) {
            addCriterion("poverty_type <", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeLessThanOrEqualTo(String value) {
            addCriterion("poverty_type <=", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeLike(String value) {
            addCriterion("poverty_type like", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeNotLike(String value) {
            addCriterion("poverty_type not like", value, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeIn(List<String> values) {
            addCriterion("poverty_type in", values, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeNotIn(List<String> values) {
            addCriterion("poverty_type not in", values, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeBetween(String value1, String value2) {
            addCriterion("poverty_type between", value1, value2, "povertyType");
            return (Criteria) this;
        }

        public Criteria andPovertyTypeNotBetween(String value1, String value2) {
            addCriterion("poverty_type not between", value1, value2, "povertyType");
            return (Criteria) this;
        }

        public Criteria andBankcardIdIsNull() {
            addCriterion("bankcard_id is null");
            return (Criteria) this;
        }

        public Criteria andBankcardIdIsNotNull() {
            addCriterion("bankcard_id is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardIdEqualTo(Integer value) {
            addCriterion("bankcard_id =", value, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdNotEqualTo(Integer value) {
            addCriterion("bankcard_id <>", value, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdGreaterThan(Integer value) {
            addCriterion("bankcard_id >", value, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankcard_id >=", value, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdLessThan(Integer value) {
            addCriterion("bankcard_id <", value, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdLessThanOrEqualTo(Integer value) {
            addCriterion("bankcard_id <=", value, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdIn(List<Integer> values) {
            addCriterion("bankcard_id in", values, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdNotIn(List<Integer> values) {
            addCriterion("bankcard_id not in", values, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdBetween(Integer value1, Integer value2) {
            addCriterion("bankcard_id between", value1, value2, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andBankcardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bankcard_id not between", value1, value2, "bankcardId");
            return (Criteria) this;
        }

        public Criteria andReturnedAtIsNull() {
            addCriterion("returned_at is null");
            return (Criteria) this;
        }

        public Criteria andReturnedAtIsNotNull() {
            addCriterion("returned_at is not null");
            return (Criteria) this;
        }

        public Criteria andReturnedAtEqualTo(Date value) {
            addCriterion("returned_at =", value, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtNotEqualTo(Date value) {
            addCriterion("returned_at <>", value, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtGreaterThan(Date value) {
            addCriterion("returned_at >", value, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("returned_at >=", value, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtLessThan(Date value) {
            addCriterion("returned_at <", value, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtLessThanOrEqualTo(Date value) {
            addCriterion("returned_at <=", value, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtIn(List<Date> values) {
            addCriterion("returned_at in", values, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtNotIn(List<Date> values) {
            addCriterion("returned_at not in", values, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtBetween(Date value1, Date value2) {
            addCriterion("returned_at between", value1, value2, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andReturnedAtNotBetween(Date value1, Date value2) {
            addCriterion("returned_at not between", value1, value2, "returnedAt");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonIsNull() {
            addCriterion("no_pass_reason is null");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonIsNotNull() {
            addCriterion("no_pass_reason is not null");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonEqualTo(String value) {
            addCriterion("no_pass_reason =", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonNotEqualTo(String value) {
            addCriterion("no_pass_reason <>", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonGreaterThan(String value) {
            addCriterion("no_pass_reason >", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonGreaterThanOrEqualTo(String value) {
            addCriterion("no_pass_reason >=", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonLessThan(String value) {
            addCriterion("no_pass_reason <", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonLessThanOrEqualTo(String value) {
            addCriterion("no_pass_reason <=", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonLike(String value) {
            addCriterion("no_pass_reason like", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonNotLike(String value) {
            addCriterion("no_pass_reason not like", value, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonIn(List<String> values) {
            addCriterion("no_pass_reason in", values, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonNotIn(List<String> values) {
            addCriterion("no_pass_reason not in", values, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonBetween(String value1, String value2) {
            addCriterion("no_pass_reason between", value1, value2, "noPassReason");
            return (Criteria) this;
        }

        public Criteria andNoPassReasonNotBetween(String value1, String value2) {
            addCriterion("no_pass_reason not between", value1, value2, "noPassReason");
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