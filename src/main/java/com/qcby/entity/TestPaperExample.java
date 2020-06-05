package com.qcby.entity;

import java.util.ArrayList;
import java.util.List;

public class TestPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestPaperExample() {
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

        public Criteria andTestIdIsNull() {
            addCriterion("test_id is null");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNotNull() {
            addCriterion("test_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestIdEqualTo(String value) {
            addCriterion("test_id =", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotEqualTo(String value) {
            addCriterion("test_id <>", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThan(String value) {
            addCriterion("test_id >", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThanOrEqualTo(String value) {
            addCriterion("test_id >=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThan(String value) {
            addCriterion("test_id <", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThanOrEqualTo(String value) {
            addCriterion("test_id <=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLike(String value) {
            addCriterion("test_id like", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotLike(String value) {
            addCriterion("test_id not like", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdIn(List<String> values) {
            addCriterion("test_id in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotIn(List<String> values) {
            addCriterion("test_id not in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdBetween(String value1, String value2) {
            addCriterion("test_id between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotBetween(String value1, String value2) {
            addCriterion("test_id not between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestTitleIsNull() {
            addCriterion("test_title is null");
            return (Criteria) this;
        }

        public Criteria andTestTitleIsNotNull() {
            addCriterion("test_title is not null");
            return (Criteria) this;
        }

        public Criteria andTestTitleEqualTo(String value) {
            addCriterion("test_title =", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotEqualTo(String value) {
            addCriterion("test_title <>", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleGreaterThan(String value) {
            addCriterion("test_title >", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleGreaterThanOrEqualTo(String value) {
            addCriterion("test_title >=", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleLessThan(String value) {
            addCriterion("test_title <", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleLessThanOrEqualTo(String value) {
            addCriterion("test_title <=", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleLike(String value) {
            addCriterion("test_title like", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotLike(String value) {
            addCriterion("test_title not like", value, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleIn(List<String> values) {
            addCriterion("test_title in", values, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotIn(List<String> values) {
            addCriterion("test_title not in", values, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleBetween(String value1, String value2) {
            addCriterion("test_title between", value1, value2, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestTitleNotBetween(String value1, String value2) {
            addCriterion("test_title not between", value1, value2, "testTitle");
            return (Criteria) this;
        }

        public Criteria andTestProjectIsNull() {
            addCriterion("test_project is null");
            return (Criteria) this;
        }

        public Criteria andTestProjectIsNotNull() {
            addCriterion("test_project is not null");
            return (Criteria) this;
        }

        public Criteria andTestProjectEqualTo(String value) {
            addCriterion("test_project =", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectNotEqualTo(String value) {
            addCriterion("test_project <>", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectGreaterThan(String value) {
            addCriterion("test_project >", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectGreaterThanOrEqualTo(String value) {
            addCriterion("test_project >=", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectLessThan(String value) {
            addCriterion("test_project <", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectLessThanOrEqualTo(String value) {
            addCriterion("test_project <=", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectLike(String value) {
            addCriterion("test_project like", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectNotLike(String value) {
            addCriterion("test_project not like", value, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectIn(List<String> values) {
            addCriterion("test_project in", values, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectNotIn(List<String> values) {
            addCriterion("test_project not in", values, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectBetween(String value1, String value2) {
            addCriterion("test_project between", value1, value2, "testProject");
            return (Criteria) this;
        }

        public Criteria andTestProjectNotBetween(String value1, String value2) {
            addCriterion("test_project not between", value1, value2, "testProject");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("teacher_id like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("teacher_id not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
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

        public Criteria andIsreleaseIsNull() {
            addCriterion("isRelease is null");
            return (Criteria) this;
        }

        public Criteria andIsreleaseIsNotNull() {
            addCriterion("isRelease is not null");
            return (Criteria) this;
        }

        public Criteria andIsreleaseEqualTo(Integer value) {
            addCriterion("isRelease =", value, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseNotEqualTo(Integer value) {
            addCriterion("isRelease <>", value, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseGreaterThan(Integer value) {
            addCriterion("isRelease >", value, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("isRelease >=", value, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseLessThan(Integer value) {
            addCriterion("isRelease <", value, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseLessThanOrEqualTo(Integer value) {
            addCriterion("isRelease <=", value, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseIn(List<Integer> values) {
            addCriterion("isRelease in", values, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseNotIn(List<Integer> values) {
            addCriterion("isRelease not in", values, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseBetween(Integer value1, Integer value2) {
            addCriterion("isRelease between", value1, value2, "isrelease");
            return (Criteria) this;
        }

        public Criteria andIsreleaseNotBetween(Integer value1, Integer value2) {
            addCriterion("isRelease not between", value1, value2, "isrelease");
            return (Criteria) this;
        }

        public Criteria andDifficultIsNull() {
            addCriterion("difficult is null");
            return (Criteria) this;
        }

        public Criteria andDifficultIsNotNull() {
            addCriterion("difficult is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultEqualTo(String value) {
            addCriterion("difficult =", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultNotEqualTo(String value) {
            addCriterion("difficult <>", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultGreaterThan(String value) {
            addCriterion("difficult >", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultGreaterThanOrEqualTo(String value) {
            addCriterion("difficult >=", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultLessThan(String value) {
            addCriterion("difficult <", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultLessThanOrEqualTo(String value) {
            addCriterion("difficult <=", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultLike(String value) {
            addCriterion("difficult like", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultNotLike(String value) {
            addCriterion("difficult not like", value, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultIn(List<String> values) {
            addCriterion("difficult in", values, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultNotIn(List<String> values) {
            addCriterion("difficult not in", values, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultBetween(String value1, String value2) {
            addCriterion("difficult between", value1, value2, "difficult");
            return (Criteria) this;
        }

        public Criteria andDifficultNotBetween(String value1, String value2) {
            addCriterion("difficult not between", value1, value2, "difficult");
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