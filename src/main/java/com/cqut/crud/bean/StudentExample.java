package com.cqut.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationIsNull() {
            addCriterion("guardian_relation is null");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationIsNotNull() {
            addCriterion("guardian_relation is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationEqualTo(String value) {
            addCriterion("guardian_relation =", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationNotEqualTo(String value) {
            addCriterion("guardian_relation <>", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationGreaterThan(String value) {
            addCriterion("guardian_relation >", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationGreaterThanOrEqualTo(String value) {
            addCriterion("guardian_relation >=", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationLessThan(String value) {
            addCriterion("guardian_relation <", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationLessThanOrEqualTo(String value) {
            addCriterion("guardian_relation <=", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationLike(String value) {
            addCriterion("guardian_relation like", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationNotLike(String value) {
            addCriterion("guardian_relation not like", value, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationIn(List<String> values) {
            addCriterion("guardian_relation in", values, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationNotIn(List<String> values) {
            addCriterion("guardian_relation not in", values, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationBetween(String value1, String value2) {
            addCriterion("guardian_relation between", value1, value2, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianRelationNotBetween(String value1, String value2) {
            addCriterion("guardian_relation not between", value1, value2, "guardianRelation");
            return (Criteria) this;
        }

        public Criteria andGuardianNameIsNull() {
            addCriterion("guardian_name is null");
            return (Criteria) this;
        }

        public Criteria andGuardianNameIsNotNull() {
            addCriterion("guardian_name is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianNameEqualTo(String value) {
            addCriterion("guardian_name =", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameNotEqualTo(String value) {
            addCriterion("guardian_name <>", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameGreaterThan(String value) {
            addCriterion("guardian_name >", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameGreaterThanOrEqualTo(String value) {
            addCriterion("guardian_name >=", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameLessThan(String value) {
            addCriterion("guardian_name <", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameLessThanOrEqualTo(String value) {
            addCriterion("guardian_name <=", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameLike(String value) {
            addCriterion("guardian_name like", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameNotLike(String value) {
            addCriterion("guardian_name not like", value, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameIn(List<String> values) {
            addCriterion("guardian_name in", values, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameNotIn(List<String> values) {
            addCriterion("guardian_name not in", values, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameBetween(String value1, String value2) {
            addCriterion("guardian_name between", value1, value2, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianNameNotBetween(String value1, String value2) {
            addCriterion("guardian_name not between", value1, value2, "guardianName");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberIsNull() {
            addCriterion("guardian_id_number is null");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberIsNotNull() {
            addCriterion("guardian_id_number is not null");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberEqualTo(String value) {
            addCriterion("guardian_id_number =", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberNotEqualTo(String value) {
            addCriterion("guardian_id_number <>", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberGreaterThan(String value) {
            addCriterion("guardian_id_number >", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("guardian_id_number >=", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberLessThan(String value) {
            addCriterion("guardian_id_number <", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberLessThanOrEqualTo(String value) {
            addCriterion("guardian_id_number <=", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberLike(String value) {
            addCriterion("guardian_id_number like", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberNotLike(String value) {
            addCriterion("guardian_id_number not like", value, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberIn(List<String> values) {
            addCriterion("guardian_id_number in", values, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberNotIn(List<String> values) {
            addCriterion("guardian_id_number not in", values, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberBetween(String value1, String value2) {
            addCriterion("guardian_id_number between", value1, value2, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andGuardianIdNumberNotBetween(String value1, String value2) {
            addCriterion("guardian_id_number not between", value1, value2, "guardianIdNumber");
            return (Criteria) this;
        }

        public Criteria andPolityIsNull() {
            addCriterion("polity is null");
            return (Criteria) this;
        }

        public Criteria andPolityIsNotNull() {
            addCriterion("polity is not null");
            return (Criteria) this;
        }

        public Criteria andPolityEqualTo(String value) {
            addCriterion("polity =", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotEqualTo(String value) {
            addCriterion("polity <>", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityGreaterThan(String value) {
            addCriterion("polity >", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityGreaterThanOrEqualTo(String value) {
            addCriterion("polity >=", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityLessThan(String value) {
            addCriterion("polity <", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityLessThanOrEqualTo(String value) {
            addCriterion("polity <=", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityLike(String value) {
            addCriterion("polity like", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotLike(String value) {
            addCriterion("polity not like", value, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityIn(List<String> values) {
            addCriterion("polity in", values, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotIn(List<String> values) {
            addCriterion("polity not in", values, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityBetween(String value1, String value2) {
            addCriterion("polity between", value1, value2, "polity");
            return (Criteria) this;
        }

        public Criteria andPolityNotBetween(String value1, String value2) {
            addCriterion("polity not between", value1, value2, "polity");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIsNull() {
            addCriterion("linkman_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIsNotNull() {
            addCriterion("linkman_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneEqualTo(String value) {
            addCriterion("linkman_phone =", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotEqualTo(String value) {
            addCriterion("linkman_phone <>", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneGreaterThan(String value) {
            addCriterion("linkman_phone >", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_phone >=", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLessThan(String value) {
            addCriterion("linkman_phone <", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLessThanOrEqualTo(String value) {
            addCriterion("linkman_phone <=", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneLike(String value) {
            addCriterion("linkman_phone like", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotLike(String value) {
            addCriterion("linkman_phone not like", value, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneIn(List<String> values) {
            addCriterion("linkman_phone in", values, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotIn(List<String> values) {
            addCriterion("linkman_phone not in", values, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneBetween(String value1, String value2) {
            addCriterion("linkman_phone between", value1, value2, "linkmanPhone");
            return (Criteria) this;
        }

        public Criteria andLinkmanPhoneNotBetween(String value1, String value2) {
            addCriterion("linkman_phone not between", value1, value2, "linkmanPhone");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andFromIsNull() {
            addCriterion("from is null");
            return (Criteria) this;
        }

        public Criteria andFromIsNotNull() {
            addCriterion("from is not null");
            return (Criteria) this;
        }

        public Criteria andFromEqualTo(String value) {
            addCriterion("from =", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotEqualTo(String value) {
            addCriterion("from <>", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThan(String value) {
            addCriterion("from >", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThanOrEqualTo(String value) {
            addCriterion("from >=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThan(String value) {
            addCriterion("from <", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThanOrEqualTo(String value) {
            addCriterion("from <=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLike(String value) {
            addCriterion("from like", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotLike(String value) {
            addCriterion("from not like", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromIn(List<String> values) {
            addCriterion("from in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotIn(List<String> values) {
            addCriterion("from not in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromBetween(String value1, String value2) {
            addCriterion("from between", value1, value2, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotBetween(String value1, String value2) {
            addCriterion("from not between", value1, value2, "from");
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

        public Criteria andFamilyPovertyDescIsNull() {
            addCriterion("family_poverty_desc is null");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescIsNotNull() {
            addCriterion("family_poverty_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescEqualTo(String value) {
            addCriterion("family_poverty_desc =", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescNotEqualTo(String value) {
            addCriterion("family_poverty_desc <>", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescGreaterThan(String value) {
            addCriterion("family_poverty_desc >", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescGreaterThanOrEqualTo(String value) {
            addCriterion("family_poverty_desc >=", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescLessThan(String value) {
            addCriterion("family_poverty_desc <", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescLessThanOrEqualTo(String value) {
            addCriterion("family_poverty_desc <=", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescLike(String value) {
            addCriterion("family_poverty_desc like", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescNotLike(String value) {
            addCriterion("family_poverty_desc not like", value, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescIn(List<String> values) {
            addCriterion("family_poverty_desc in", values, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescNotIn(List<String> values) {
            addCriterion("family_poverty_desc not in", values, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescBetween(String value1, String value2) {
            addCriterion("family_poverty_desc between", value1, value2, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andFamilyPovertyDescNotBetween(String value1, String value2) {
            addCriterion("family_poverty_desc not between", value1, value2, "familyPovertyDesc");
            return (Criteria) this;
        }

        public Criteria andIsPoolIsNull() {
            addCriterion("is_pool is null");
            return (Criteria) this;
        }

        public Criteria andIsPoolIsNotNull() {
            addCriterion("is_pool is not null");
            return (Criteria) this;
        }

        public Criteria andIsPoolEqualTo(Integer value) {
            addCriterion("is_pool =", value, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolNotEqualTo(Integer value) {
            addCriterion("is_pool <>", value, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolGreaterThan(Integer value) {
            addCriterion("is_pool >", value, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pool >=", value, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolLessThan(Integer value) {
            addCriterion("is_pool <", value, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolLessThanOrEqualTo(Integer value) {
            addCriterion("is_pool <=", value, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolIn(List<Integer> values) {
            addCriterion("is_pool in", values, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolNotIn(List<Integer> values) {
            addCriterion("is_pool not in", values, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolBetween(Integer value1, Integer value2) {
            addCriterion("is_pool between", value1, value2, "isPool");
            return (Criteria) this;
        }

        public Criteria andIsPoolNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pool not between", value1, value2, "isPool");
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