package com.qcby.entity;

import java.util.ArrayList;
import java.util.List;

public class ClassInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassInfoExample() {
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

        public Criteria andClaIdIsNull() {
            addCriterion("cla_id is null");
            return (Criteria) this;
        }

        public Criteria andClaIdIsNotNull() {
            addCriterion("cla_id is not null");
            return (Criteria) this;
        }

        public Criteria andClaIdEqualTo(Integer value) {
            addCriterion("cla_id =", value, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdNotEqualTo(Integer value) {
            addCriterion("cla_id <>", value, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdGreaterThan(Integer value) {
            addCriterion("cla_id >", value, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cla_id >=", value, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdLessThan(Integer value) {
            addCriterion("cla_id <", value, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdLessThanOrEqualTo(Integer value) {
            addCriterion("cla_id <=", value, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdIn(List<Integer> values) {
            addCriterion("cla_id in", values, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdNotIn(List<Integer> values) {
            addCriterion("cla_id not in", values, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdBetween(Integer value1, Integer value2) {
            addCriterion("cla_id between", value1, value2, "claId");
            return (Criteria) this;
        }

        public Criteria andClaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cla_id not between", value1, value2, "claId");
            return (Criteria) this;
        }

        public Criteria andClaNameIsNull() {
            addCriterion("cla_name is null");
            return (Criteria) this;
        }

        public Criteria andClaNameIsNotNull() {
            addCriterion("cla_name is not null");
            return (Criteria) this;
        }

        public Criteria andClaNameEqualTo(String value) {
            addCriterion("cla_name =", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotEqualTo(String value) {
            addCriterion("cla_name <>", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameGreaterThan(String value) {
            addCriterion("cla_name >", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameGreaterThanOrEqualTo(String value) {
            addCriterion("cla_name >=", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameLessThan(String value) {
            addCriterion("cla_name <", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameLessThanOrEqualTo(String value) {
            addCriterion("cla_name <=", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameLike(String value) {
            addCriterion("cla_name like", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotLike(String value) {
            addCriterion("cla_name not like", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameIn(List<String> values) {
            addCriterion("cla_name in", values, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotIn(List<String> values) {
            addCriterion("cla_name not in", values, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameBetween(String value1, String value2) {
            addCriterion("cla_name between", value1, value2, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotBetween(String value1, String value2) {
            addCriterion("cla_name not between", value1, value2, "claName");
            return (Criteria) this;
        }

        public Criteria andClaProjectIsNull() {
            addCriterion("cla_project is null");
            return (Criteria) this;
        }

        public Criteria andClaProjectIsNotNull() {
            addCriterion("cla_project is not null");
            return (Criteria) this;
        }

        public Criteria andClaProjectEqualTo(String value) {
            addCriterion("cla_project =", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectNotEqualTo(String value) {
            addCriterion("cla_project <>", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectGreaterThan(String value) {
            addCriterion("cla_project >", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectGreaterThanOrEqualTo(String value) {
            addCriterion("cla_project >=", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectLessThan(String value) {
            addCriterion("cla_project <", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectLessThanOrEqualTo(String value) {
            addCriterion("cla_project <=", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectLike(String value) {
            addCriterion("cla_project like", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectNotLike(String value) {
            addCriterion("cla_project not like", value, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectIn(List<String> values) {
            addCriterion("cla_project in", values, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectNotIn(List<String> values) {
            addCriterion("cla_project not in", values, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectBetween(String value1, String value2) {
            addCriterion("cla_project between", value1, value2, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaProjectNotBetween(String value1, String value2) {
            addCriterion("cla_project not between", value1, value2, "claProject");
            return (Criteria) this;
        }

        public Criteria andClaTeacidIsNull() {
            addCriterion("cla_teacid is null");
            return (Criteria) this;
        }

        public Criteria andClaTeacidIsNotNull() {
            addCriterion("cla_teacid is not null");
            return (Criteria) this;
        }

        public Criteria andClaTeacidEqualTo(String value) {
            addCriterion("cla_teacid =", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidNotEqualTo(String value) {
            addCriterion("cla_teacid <>", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidGreaterThan(String value) {
            addCriterion("cla_teacid >", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidGreaterThanOrEqualTo(String value) {
            addCriterion("cla_teacid >=", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidLessThan(String value) {
            addCriterion("cla_teacid <", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidLessThanOrEqualTo(String value) {
            addCriterion("cla_teacid <=", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidLike(String value) {
            addCriterion("cla_teacid like", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidNotLike(String value) {
            addCriterion("cla_teacid not like", value, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidIn(List<String> values) {
            addCriterion("cla_teacid in", values, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidNotIn(List<String> values) {
            addCriterion("cla_teacid not in", values, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidBetween(String value1, String value2) {
            addCriterion("cla_teacid between", value1, value2, "claTeacid");
            return (Criteria) this;
        }

        public Criteria andClaTeacidNotBetween(String value1, String value2) {
            addCriterion("cla_teacid not between", value1, value2, "claTeacid");
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