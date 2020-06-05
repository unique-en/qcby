package com.qcby.entity;

import java.util.ArrayList;
import java.util.List;

public class JiandaAnalysisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JiandaAnalysisExample() {
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

        public Criteria andTiIdIsNull() {
            addCriterion("ti_id is null");
            return (Criteria) this;
        }

        public Criteria andTiIdIsNotNull() {
            addCriterion("ti_id is not null");
            return (Criteria) this;
        }

        public Criteria andTiIdEqualTo(Integer value) {
            addCriterion("ti_id =", value, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdNotEqualTo(Integer value) {
            addCriterion("ti_id <>", value, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdGreaterThan(Integer value) {
            addCriterion("ti_id >", value, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ti_id >=", value, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdLessThan(Integer value) {
            addCriterion("ti_id <", value, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdLessThanOrEqualTo(Integer value) {
            addCriterion("ti_id <=", value, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdIn(List<Integer> values) {
            addCriterion("ti_id in", values, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdNotIn(List<Integer> values) {
            addCriterion("ti_id not in", values, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdBetween(Integer value1, Integer value2) {
            addCriterion("ti_id between", value1, value2, "tiId");
            return (Criteria) this;
        }

        public Criteria andTiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ti_id not between", value1, value2, "tiId");
            return (Criteria) this;
        }

        public Criteria andCorrectRateIsNull() {
            addCriterion("correct_rate is null");
            return (Criteria) this;
        }

        public Criteria andCorrectRateIsNotNull() {
            addCriterion("correct_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectRateEqualTo(String value) {
            addCriterion("correct_rate =", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotEqualTo(String value) {
            addCriterion("correct_rate <>", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateGreaterThan(String value) {
            addCriterion("correct_rate >", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateGreaterThanOrEqualTo(String value) {
            addCriterion("correct_rate >=", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateLessThan(String value) {
            addCriterion("correct_rate <", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateLessThanOrEqualTo(String value) {
            addCriterion("correct_rate <=", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateLike(String value) {
            addCriterion("correct_rate like", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotLike(String value) {
            addCriterion("correct_rate not like", value, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateIn(List<String> values) {
            addCriterion("correct_rate in", values, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotIn(List<String> values) {
            addCriterion("correct_rate not in", values, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateBetween(String value1, String value2) {
            addCriterion("correct_rate between", value1, value2, "correctRate");
            return (Criteria) this;
        }

        public Criteria andCorrectRateNotBetween(String value1, String value2) {
            addCriterion("correct_rate not between", value1, value2, "correctRate");
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