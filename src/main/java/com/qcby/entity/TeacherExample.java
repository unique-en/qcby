package com.qcby.entity;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeacIdIsNull() {
            addCriterion("teac_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacIdIsNotNull() {
            addCriterion("teac_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacIdEqualTo(String value) {
            addCriterion("teac_id =", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdNotEqualTo(String value) {
            addCriterion("teac_id <>", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdGreaterThan(String value) {
            addCriterion("teac_id >", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdGreaterThanOrEqualTo(String value) {
            addCriterion("teac_id >=", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdLessThan(String value) {
            addCriterion("teac_id <", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdLessThanOrEqualTo(String value) {
            addCriterion("teac_id <=", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdLike(String value) {
            addCriterion("teac_id like", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdNotLike(String value) {
            addCriterion("teac_id not like", value, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdIn(List<String> values) {
            addCriterion("teac_id in", values, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdNotIn(List<String> values) {
            addCriterion("teac_id not in", values, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdBetween(String value1, String value2) {
            addCriterion("teac_id between", value1, value2, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacIdNotBetween(String value1, String value2) {
            addCriterion("teac_id not between", value1, value2, "teacId");
            return (Criteria) this;
        }

        public Criteria andTeacNameIsNull() {
            addCriterion("teac_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacNameIsNotNull() {
            addCriterion("teac_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacNameEqualTo(String value) {
            addCriterion("teac_name =", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameNotEqualTo(String value) {
            addCriterion("teac_name <>", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameGreaterThan(String value) {
            addCriterion("teac_name >", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameGreaterThanOrEqualTo(String value) {
            addCriterion("teac_name >=", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameLessThan(String value) {
            addCriterion("teac_name <", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameLessThanOrEqualTo(String value) {
            addCriterion("teac_name <=", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameLike(String value) {
            addCriterion("teac_name like", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameNotLike(String value) {
            addCriterion("teac_name not like", value, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameIn(List<String> values) {
            addCriterion("teac_name in", values, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameNotIn(List<String> values) {
            addCriterion("teac_name not in", values, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameBetween(String value1, String value2) {
            addCriterion("teac_name between", value1, value2, "teacName");
            return (Criteria) this;
        }

        public Criteria andTeacNameNotBetween(String value1, String value2) {
            addCriterion("teac_name not between", value1, value2, "teacName");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andTeacPwdIsNull() {
            addCriterion("teac_pwd is null");
            return (Criteria) this;
        }

        public Criteria andTeacPwdIsNotNull() {
            addCriterion("teac_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andTeacPwdEqualTo(String value) {
            addCriterion("teac_pwd =", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdNotEqualTo(String value) {
            addCriterion("teac_pwd <>", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdGreaterThan(String value) {
            addCriterion("teac_pwd >", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdGreaterThanOrEqualTo(String value) {
            addCriterion("teac_pwd >=", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdLessThan(String value) {
            addCriterion("teac_pwd <", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdLessThanOrEqualTo(String value) {
            addCriterion("teac_pwd <=", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdLike(String value) {
            addCriterion("teac_pwd like", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdNotLike(String value) {
            addCriterion("teac_pwd not like", value, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdIn(List<String> values) {
            addCriterion("teac_pwd in", values, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdNotIn(List<String> values) {
            addCriterion("teac_pwd not in", values, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdBetween(String value1, String value2) {
            addCriterion("teac_pwd between", value1, value2, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andTeacPwdNotBetween(String value1, String value2) {
            addCriterion("teac_pwd not between", value1, value2, "teacPwd");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
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