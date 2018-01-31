package com.lakefarm.pojo;

import java.util.ArrayList;
import java.util.List;

public class PersonGrowplantsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonGrowplantsExample() {
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

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andZzIdIsNull() {
            addCriterion("zz_id is null");
            return (Criteria) this;
        }

        public Criteria andZzIdIsNotNull() {
            addCriterion("zz_id is not null");
            return (Criteria) this;
        }

        public Criteria andZzIdEqualTo(Integer value) {
            addCriterion("zz_id =", value, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdNotEqualTo(Integer value) {
            addCriterion("zz_id <>", value, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdGreaterThan(Integer value) {
            addCriterion("zz_id >", value, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("zz_id >=", value, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdLessThan(Integer value) {
            addCriterion("zz_id <", value, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdLessThanOrEqualTo(Integer value) {
            addCriterion("zz_id <=", value, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdIn(List<Integer> values) {
            addCriterion("zz_id in", values, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdNotIn(List<Integer> values) {
            addCriterion("zz_id not in", values, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdBetween(Integer value1, Integer value2) {
            addCriterion("zz_id between", value1, value2, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzIdNotBetween(Integer value1, Integer value2) {
            addCriterion("zz_id not between", value1, value2, "zzId");
            return (Criteria) this;
        }

        public Criteria andZzCountIsNull() {
            addCriterion("zz_count is null");
            return (Criteria) this;
        }

        public Criteria andZzCountIsNotNull() {
            addCriterion("zz_count is not null");
            return (Criteria) this;
        }

        public Criteria andZzCountEqualTo(Integer value) {
            addCriterion("zz_count =", value, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountNotEqualTo(Integer value) {
            addCriterion("zz_count <>", value, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountGreaterThan(Integer value) {
            addCriterion("zz_count >", value, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("zz_count >=", value, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountLessThan(Integer value) {
            addCriterion("zz_count <", value, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountLessThanOrEqualTo(Integer value) {
            addCriterion("zz_count <=", value, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountIn(List<Integer> values) {
            addCriterion("zz_count in", values, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountNotIn(List<Integer> values) {
            addCriterion("zz_count not in", values, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountBetween(Integer value1, Integer value2) {
            addCriterion("zz_count between", value1, value2, "zzCount");
            return (Criteria) this;
        }

        public Criteria andZzCountNotBetween(Integer value1, Integer value2) {
            addCriterion("zz_count not between", value1, value2, "zzCount");
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