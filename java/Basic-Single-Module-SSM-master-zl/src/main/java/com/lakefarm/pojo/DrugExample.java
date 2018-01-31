package com.lakefarm.pojo;

import java.util.ArrayList;
import java.util.List;

public class DrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugExample() {
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

        public Criteria andYpIdIsNull() {
            addCriterion("yp_id is null");
            return (Criteria) this;
        }

        public Criteria andYpIdIsNotNull() {
            addCriterion("yp_id is not null");
            return (Criteria) this;
        }

        public Criteria andYpIdEqualTo(Integer value) {
            addCriterion("yp_id =", value, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdNotEqualTo(Integer value) {
            addCriterion("yp_id <>", value, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdGreaterThan(Integer value) {
            addCriterion("yp_id >", value, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("yp_id >=", value, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdLessThan(Integer value) {
            addCriterion("yp_id <", value, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdLessThanOrEqualTo(Integer value) {
            addCriterion("yp_id <=", value, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdIn(List<Integer> values) {
            addCriterion("yp_id in", values, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdNotIn(List<Integer> values) {
            addCriterion("yp_id not in", values, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdBetween(Integer value1, Integer value2) {
            addCriterion("yp_id between", value1, value2, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("yp_id not between", value1, value2, "ypId");
            return (Criteria) this;
        }

        public Criteria andYpNameIsNull() {
            addCriterion("yp_name is null");
            return (Criteria) this;
        }

        public Criteria andYpNameIsNotNull() {
            addCriterion("yp_name is not null");
            return (Criteria) this;
        }

        public Criteria andYpNameEqualTo(String value) {
            addCriterion("yp_name =", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameNotEqualTo(String value) {
            addCriterion("yp_name <>", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameGreaterThan(String value) {
            addCriterion("yp_name >", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameGreaterThanOrEqualTo(String value) {
            addCriterion("yp_name >=", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameLessThan(String value) {
            addCriterion("yp_name <", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameLessThanOrEqualTo(String value) {
            addCriterion("yp_name <=", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameLike(String value) {
            addCriterion("yp_name like", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameNotLike(String value) {
            addCriterion("yp_name not like", value, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameIn(List<String> values) {
            addCriterion("yp_name in", values, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameNotIn(List<String> values) {
            addCriterion("yp_name not in", values, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameBetween(String value1, String value2) {
            addCriterion("yp_name between", value1, value2, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpNameNotBetween(String value1, String value2) {
            addCriterion("yp_name not between", value1, value2, "ypName");
            return (Criteria) this;
        }

        public Criteria andYpPriceIsNull() {
            addCriterion("yp_price is null");
            return (Criteria) this;
        }

        public Criteria andYpPriceIsNotNull() {
            addCriterion("yp_price is not null");
            return (Criteria) this;
        }

        public Criteria andYpPriceEqualTo(Integer value) {
            addCriterion("yp_price =", value, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceNotEqualTo(Integer value) {
            addCriterion("yp_price <>", value, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceGreaterThan(Integer value) {
            addCriterion("yp_price >", value, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("yp_price >=", value, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceLessThan(Integer value) {
            addCriterion("yp_price <", value, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceLessThanOrEqualTo(Integer value) {
            addCriterion("yp_price <=", value, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceIn(List<Integer> values) {
            addCriterion("yp_price in", values, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceNotIn(List<Integer> values) {
            addCriterion("yp_price not in", values, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceBetween(Integer value1, Integer value2) {
            addCriterion("yp_price between", value1, value2, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("yp_price not between", value1, value2, "ypPrice");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionIsNull() {
            addCriterion("yp_description is null");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionIsNotNull() {
            addCriterion("yp_description is not null");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionEqualTo(String value) {
            addCriterion("yp_description =", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionNotEqualTo(String value) {
            addCriterion("yp_description <>", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionGreaterThan(String value) {
            addCriterion("yp_description >", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("yp_description >=", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionLessThan(String value) {
            addCriterion("yp_description <", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionLessThanOrEqualTo(String value) {
            addCriterion("yp_description <=", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionLike(String value) {
            addCriterion("yp_description like", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionNotLike(String value) {
            addCriterion("yp_description not like", value, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionIn(List<String> values) {
            addCriterion("yp_description in", values, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionNotIn(List<String> values) {
            addCriterion("yp_description not in", values, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionBetween(String value1, String value2) {
            addCriterion("yp_description between", value1, value2, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpDescriptionNotBetween(String value1, String value2) {
            addCriterion("yp_description not between", value1, value2, "ypDescription");
            return (Criteria) this;
        }

        public Criteria andYpRedhealIsNull() {
            addCriterion("yp_redheal is null");
            return (Criteria) this;
        }

        public Criteria andYpRedhealIsNotNull() {
            addCriterion("yp_redheal is not null");
            return (Criteria) this;
        }

        public Criteria andYpRedhealEqualTo(Integer value) {
            addCriterion("yp_redheal =", value, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealNotEqualTo(Integer value) {
            addCriterion("yp_redheal <>", value, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealGreaterThan(Integer value) {
            addCriterion("yp_redheal >", value, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealGreaterThanOrEqualTo(Integer value) {
            addCriterion("yp_redheal >=", value, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealLessThan(Integer value) {
            addCriterion("yp_redheal <", value, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealLessThanOrEqualTo(Integer value) {
            addCriterion("yp_redheal <=", value, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealIn(List<Integer> values) {
            addCriterion("yp_redheal in", values, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealNotIn(List<Integer> values) {
            addCriterion("yp_redheal not in", values, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealBetween(Integer value1, Integer value2) {
            addCriterion("yp_redheal between", value1, value2, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpRedhealNotBetween(Integer value1, Integer value2) {
            addCriterion("yp_redheal not between", value1, value2, "ypRedheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealIsNull() {
            addCriterion("yp_blueheal is null");
            return (Criteria) this;
        }

        public Criteria andYpBluehealIsNotNull() {
            addCriterion("yp_blueheal is not null");
            return (Criteria) this;
        }

        public Criteria andYpBluehealEqualTo(Integer value) {
            addCriterion("yp_blueheal =", value, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealNotEqualTo(Integer value) {
            addCriterion("yp_blueheal <>", value, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealGreaterThan(Integer value) {
            addCriterion("yp_blueheal >", value, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealGreaterThanOrEqualTo(Integer value) {
            addCriterion("yp_blueheal >=", value, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealLessThan(Integer value) {
            addCriterion("yp_blueheal <", value, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealLessThanOrEqualTo(Integer value) {
            addCriterion("yp_blueheal <=", value, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealIn(List<Integer> values) {
            addCriterion("yp_blueheal in", values, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealNotIn(List<Integer> values) {
            addCriterion("yp_blueheal not in", values, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealBetween(Integer value1, Integer value2) {
            addCriterion("yp_blueheal between", value1, value2, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpBluehealNotBetween(Integer value1, Integer value2) {
            addCriterion("yp_blueheal not between", value1, value2, "ypBlueheal");
            return (Criteria) this;
        }

        public Criteria andYpSpeedIsNull() {
            addCriterion("yp_speed is null");
            return (Criteria) this;
        }

        public Criteria andYpSpeedIsNotNull() {
            addCriterion("yp_speed is not null");
            return (Criteria) this;
        }

        public Criteria andYpSpeedEqualTo(Integer value) {
            addCriterion("yp_speed =", value, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedNotEqualTo(Integer value) {
            addCriterion("yp_speed <>", value, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedGreaterThan(Integer value) {
            addCriterion("yp_speed >", value, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("yp_speed >=", value, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedLessThan(Integer value) {
            addCriterion("yp_speed <", value, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("yp_speed <=", value, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedIn(List<Integer> values) {
            addCriterion("yp_speed in", values, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedNotIn(List<Integer> values) {
            addCriterion("yp_speed not in", values, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedBetween(Integer value1, Integer value2) {
            addCriterion("yp_speed between", value1, value2, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("yp_speed not between", value1, value2, "ypSpeed");
            return (Criteria) this;
        }

        public Criteria andYpIconIsNull() {
            addCriterion("yp_icon is null");
            return (Criteria) this;
        }

        public Criteria andYpIconIsNotNull() {
            addCriterion("yp_icon is not null");
            return (Criteria) this;
        }

        public Criteria andYpIconEqualTo(String value) {
            addCriterion("yp_icon =", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconNotEqualTo(String value) {
            addCriterion("yp_icon <>", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconGreaterThan(String value) {
            addCriterion("yp_icon >", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconGreaterThanOrEqualTo(String value) {
            addCriterion("yp_icon >=", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconLessThan(String value) {
            addCriterion("yp_icon <", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconLessThanOrEqualTo(String value) {
            addCriterion("yp_icon <=", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconLike(String value) {
            addCriterion("yp_icon like", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconNotLike(String value) {
            addCriterion("yp_icon not like", value, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconIn(List<String> values) {
            addCriterion("yp_icon in", values, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconNotIn(List<String> values) {
            addCriterion("yp_icon not in", values, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconBetween(String value1, String value2) {
            addCriterion("yp_icon between", value1, value2, "ypIcon");
            return (Criteria) this;
        }

        public Criteria andYpIconNotBetween(String value1, String value2) {
            addCriterion("yp_icon not between", value1, value2, "ypIcon");
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