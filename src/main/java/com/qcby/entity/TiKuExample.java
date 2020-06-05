package com.qcby.entity;

import java.util.ArrayList;
import java.util.List;

public class TiKuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TiKuExample() {
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

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTopicIsNull() {
            addCriterion("topic is null");
            return (Criteria) this;
        }

        public Criteria andTopicIsNotNull() {
            addCriterion("topic is not null");
            return (Criteria) this;
        }

        public Criteria andTopicEqualTo(String value) {
            addCriterion("topic =", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotEqualTo(String value) {
            addCriterion("topic <>", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThan(String value) {
            addCriterion("topic >", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThanOrEqualTo(String value) {
            addCriterion("topic >=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThan(String value) {
            addCriterion("topic <", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThanOrEqualTo(String value) {
            addCriterion("topic <=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLike(String value) {
            addCriterion("topic like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotLike(String value) {
            addCriterion("topic not like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicIn(List<String> values) {
            addCriterion("topic in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotIn(List<String> values) {
            addCriterion("topic not in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicBetween(String value1, String value2) {
            addCriterion("topic between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotBetween(String value1, String value2) {
            addCriterion("topic not between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andAIsNull() {
            addCriterion("A is null");
            return (Criteria) this;
        }

        public Criteria andAIsNotNull() {
            addCriterion("A is not null");
            return (Criteria) this;
        }

        public Criteria andAEqualTo(String value) {
            addCriterion("A =", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotEqualTo(String value) {
            addCriterion("A <>", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThan(String value) {
            addCriterion("A >", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThanOrEqualTo(String value) {
            addCriterion("A >=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThan(String value) {
            addCriterion("A <", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThanOrEqualTo(String value) {
            addCriterion("A <=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALike(String value) {
            addCriterion("A like", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotLike(String value) {
            addCriterion("A not like", value, "a");
            return (Criteria) this;
        }

        public Criteria andAIn(List<String> values) {
            addCriterion("A in", values, "a");
            return (Criteria) this;
        }

        public Criteria andANotIn(List<String> values) {
            addCriterion("A not in", values, "a");
            return (Criteria) this;
        }

        public Criteria andABetween(String value1, String value2) {
            addCriterion("A between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andANotBetween(String value1, String value2) {
            addCriterion("A not between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andBIsNull() {
            addCriterion("B is null");
            return (Criteria) this;
        }

        public Criteria andBIsNotNull() {
            addCriterion("B is not null");
            return (Criteria) this;
        }

        public Criteria andBEqualTo(String value) {
            addCriterion("B =", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotEqualTo(String value) {
            addCriterion("B <>", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThan(String value) {
            addCriterion("B >", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThanOrEqualTo(String value) {
            addCriterion("B >=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThan(String value) {
            addCriterion("B <", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThanOrEqualTo(String value) {
            addCriterion("B <=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLike(String value) {
            addCriterion("B like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotLike(String value) {
            addCriterion("B not like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBIn(List<String> values) {
            addCriterion("B in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBNotIn(List<String> values) {
            addCriterion("B not in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBBetween(String value1, String value2) {
            addCriterion("B between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andBNotBetween(String value1, String value2) {
            addCriterion("B not between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andCIsNull() {
            addCriterion("C is null");
            return (Criteria) this;
        }

        public Criteria andCIsNotNull() {
            addCriterion("C is not null");
            return (Criteria) this;
        }

        public Criteria andCEqualTo(String value) {
            addCriterion("C =", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotEqualTo(String value) {
            addCriterion("C <>", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThan(String value) {
            addCriterion("C >", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThanOrEqualTo(String value) {
            addCriterion("C >=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThan(String value) {
            addCriterion("C <", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThanOrEqualTo(String value) {
            addCriterion("C <=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLike(String value) {
            addCriterion("C like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotLike(String value) {
            addCriterion("C not like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCIn(List<String> values) {
            addCriterion("C in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCNotIn(List<String> values) {
            addCriterion("C not in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCBetween(String value1, String value2) {
            addCriterion("C between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andCNotBetween(String value1, String value2) {
            addCriterion("C not between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andDIsNull() {
            addCriterion("D is null");
            return (Criteria) this;
        }

        public Criteria andDIsNotNull() {
            addCriterion("D is not null");
            return (Criteria) this;
        }

        public Criteria andDEqualTo(String value) {
            addCriterion("D =", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotEqualTo(String value) {
            addCriterion("D <>", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThan(String value) {
            addCriterion("D >", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThanOrEqualTo(String value) {
            addCriterion("D >=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThan(String value) {
            addCriterion("D <", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThanOrEqualTo(String value) {
            addCriterion("D <=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLike(String value) {
            addCriterion("D like", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotLike(String value) {
            addCriterion("D not like", value, "d");
            return (Criteria) this;
        }

        public Criteria andDIn(List<String> values) {
            addCriterion("D in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDNotIn(List<String> values) {
            addCriterion("D not in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDBetween(String value1, String value2) {
            addCriterion("D between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andDNotBetween(String value1, String value2) {
            addCriterion("D not between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andParsingIsNull() {
            addCriterion("parsing is null");
            return (Criteria) this;
        }

        public Criteria andParsingIsNotNull() {
            addCriterion("parsing is not null");
            return (Criteria) this;
        }

        public Criteria andParsingEqualTo(String value) {
            addCriterion("parsing =", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingNotEqualTo(String value) {
            addCriterion("parsing <>", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingGreaterThan(String value) {
            addCriterion("parsing >", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingGreaterThanOrEqualTo(String value) {
            addCriterion("parsing >=", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingLessThan(String value) {
            addCriterion("parsing <", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingLessThanOrEqualTo(String value) {
            addCriterion("parsing <=", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingLike(String value) {
            addCriterion("parsing like", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingNotLike(String value) {
            addCriterion("parsing not like", value, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingIn(List<String> values) {
            addCriterion("parsing in", values, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingNotIn(List<String> values) {
            addCriterion("parsing not in", values, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingBetween(String value1, String value2) {
            addCriterion("parsing between", value1, value2, "parsing");
            return (Criteria) this;
        }

        public Criteria andParsingNotBetween(String value1, String value2) {
            addCriterion("parsing not between", value1, value2, "parsing");
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

        public Criteria andFractionIsNull() {
            addCriterion("fraction is null");
            return (Criteria) this;
        }

        public Criteria andFractionIsNotNull() {
            addCriterion("fraction is not null");
            return (Criteria) this;
        }

        public Criteria andFractionEqualTo(Double value) {
            addCriterion("fraction =", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotEqualTo(Double value) {
            addCriterion("fraction <>", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThan(Double value) {
            addCriterion("fraction >", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThanOrEqualTo(Double value) {
            addCriterion("fraction >=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThan(Double value) {
            addCriterion("fraction <", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThanOrEqualTo(Double value) {
            addCriterion("fraction <=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionIn(List<Double> values) {
            addCriterion("fraction in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotIn(List<Double> values) {
            addCriterion("fraction not in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionBetween(Double value1, Double value2) {
            addCriterion("fraction between", value1, value2, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotBetween(Double value1, Double value2) {
            addCriterion("fraction not between", value1, value2, "fraction");
            return (Criteria) this;
        }

        public Criteria andRigIsNull() {
            addCriterion("rig is null");
            return (Criteria) this;
        }

        public Criteria andRigIsNotNull() {
            addCriterion("rig is not null");
            return (Criteria) this;
        }

        public Criteria andRigEqualTo(String value) {
            addCriterion("rig =", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigNotEqualTo(String value) {
            addCriterion("rig <>", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigGreaterThan(String value) {
            addCriterion("rig >", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigGreaterThanOrEqualTo(String value) {
            addCriterion("rig >=", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigLessThan(String value) {
            addCriterion("rig <", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigLessThanOrEqualTo(String value) {
            addCriterion("rig <=", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigLike(String value) {
            addCriterion("rig like", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigNotLike(String value) {
            addCriterion("rig not like", value, "rig");
            return (Criteria) this;
        }

        public Criteria andRigIn(List<String> values) {
            addCriterion("rig in", values, "rig");
            return (Criteria) this;
        }

        public Criteria andRigNotIn(List<String> values) {
            addCriterion("rig not in", values, "rig");
            return (Criteria) this;
        }

        public Criteria andRigBetween(String value1, String value2) {
            addCriterion("rig between", value1, value2, "rig");
            return (Criteria) this;
        }

        public Criteria andRigNotBetween(String value1, String value2) {
            addCriterion("rig not between", value1, value2, "rig");
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