package com.lakefarm.pojo;

import java.util.ArrayList;
import java.util.List;

public class GrowPlantsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GrowPlantsExample() {
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

        public Criteria andZzTypeIsNull() {
            addCriterion("zz_type is null");
            return (Criteria) this;
        }

        public Criteria andZzTypeIsNotNull() {
            addCriterion("zz_type is not null");
            return (Criteria) this;
        }

        public Criteria andZzTypeEqualTo(String value) {
            addCriterion("zz_type =", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeNotEqualTo(String value) {
            addCriterion("zz_type <>", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeGreaterThan(String value) {
            addCriterion("zz_type >", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeGreaterThanOrEqualTo(String value) {
            addCriterion("zz_type >=", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeLessThan(String value) {
            addCriterion("zz_type <", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeLessThanOrEqualTo(String value) {
            addCriterion("zz_type <=", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeLike(String value) {
            addCriterion("zz_type like", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeNotLike(String value) {
            addCriterion("zz_type not like", value, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeIn(List<String> values) {
            addCriterion("zz_type in", values, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeNotIn(List<String> values) {
            addCriterion("zz_type not in", values, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeBetween(String value1, String value2) {
            addCriterion("zz_type between", value1, value2, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzTypeNotBetween(String value1, String value2) {
            addCriterion("zz_type not between", value1, value2, "zzType");
            return (Criteria) this;
        }

        public Criteria andZzNameIsNull() {
            addCriterion("zz_name is null");
            return (Criteria) this;
        }

        public Criteria andZzNameIsNotNull() {
            addCriterion("zz_name is not null");
            return (Criteria) this;
        }

        public Criteria andZzNameEqualTo(String value) {
            addCriterion("zz_name =", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameNotEqualTo(String value) {
            addCriterion("zz_name <>", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameGreaterThan(String value) {
            addCriterion("zz_name >", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameGreaterThanOrEqualTo(String value) {
            addCriterion("zz_name >=", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameLessThan(String value) {
            addCriterion("zz_name <", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameLessThanOrEqualTo(String value) {
            addCriterion("zz_name <=", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameLike(String value) {
            addCriterion("zz_name like", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameNotLike(String value) {
            addCriterion("zz_name not like", value, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameIn(List<String> values) {
            addCriterion("zz_name in", values, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameNotIn(List<String> values) {
            addCriterion("zz_name not in", values, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameBetween(String value1, String value2) {
            addCriterion("zz_name between", value1, value2, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzNameNotBetween(String value1, String value2) {
            addCriterion("zz_name not between", value1, value2, "zzName");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeIsNull() {
            addCriterion("zz_growntime is null");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeIsNotNull() {
            addCriterion("zz_growntime is not null");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeEqualTo(Integer value) {
            addCriterion("zz_growntime =", value, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeNotEqualTo(Integer value) {
            addCriterion("zz_growntime <>", value, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeGreaterThan(Integer value) {
            addCriterion("zz_growntime >", value, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("zz_growntime >=", value, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeLessThan(Integer value) {
            addCriterion("zz_growntime <", value, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeLessThanOrEqualTo(Integer value) {
            addCriterion("zz_growntime <=", value, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeIn(List<Integer> values) {
            addCriterion("zz_growntime in", values, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeNotIn(List<Integer> values) {
            addCriterion("zz_growntime not in", values, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeBetween(Integer value1, Integer value2) {
            addCriterion("zz_growntime between", value1, value2, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzGrowntimeNotBetween(Integer value1, Integer value2) {
            addCriterion("zz_growntime not between", value1, value2, "zzGrowntime");
            return (Criteria) this;
        }

        public Criteria andZzPriceIsNull() {
            addCriterion("zz_price is null");
            return (Criteria) this;
        }

        public Criteria andZzPriceIsNotNull() {
            addCriterion("zz_price is not null");
            return (Criteria) this;
        }

        public Criteria andZzPriceEqualTo(Integer value) {
            addCriterion("zz_price =", value, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceNotEqualTo(Integer value) {
            addCriterion("zz_price <>", value, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceGreaterThan(Integer value) {
            addCriterion("zz_price >", value, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("zz_price >=", value, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceLessThan(Integer value) {
            addCriterion("zz_price <", value, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceLessThanOrEqualTo(Integer value) {
            addCriterion("zz_price <=", value, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceIn(List<Integer> values) {
            addCriterion("zz_price in", values, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceNotIn(List<Integer> values) {
            addCriterion("zz_price not in", values, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceBetween(Integer value1, Integer value2) {
            addCriterion("zz_price between", value1, value2, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("zz_price not between", value1, value2, "zzPrice");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionIsNull() {
            addCriterion("zz_description is null");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionIsNotNull() {
            addCriterion("zz_description is not null");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionEqualTo(String value) {
            addCriterion("zz_description =", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionNotEqualTo(String value) {
            addCriterion("zz_description <>", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionGreaterThan(String value) {
            addCriterion("zz_description >", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("zz_description >=", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionLessThan(String value) {
            addCriterion("zz_description <", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionLessThanOrEqualTo(String value) {
            addCriterion("zz_description <=", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionLike(String value) {
            addCriterion("zz_description like", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionNotLike(String value) {
            addCriterion("zz_description not like", value, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionIn(List<String> values) {
            addCriterion("zz_description in", values, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionNotIn(List<String> values) {
            addCriterion("zz_description not in", values, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionBetween(String value1, String value2) {
            addCriterion("zz_description between", value1, value2, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzDescriptionNotBetween(String value1, String value2) {
            addCriterion("zz_description not between", value1, value2, "zzDescription");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountIsNull() {
            addCriterion("zz_minplantcount is null");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountIsNotNull() {
            addCriterion("zz_minplantcount is not null");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountEqualTo(Integer value) {
            addCriterion("zz_minplantcount =", value, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountNotEqualTo(Integer value) {
            addCriterion("zz_minplantcount <>", value, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountGreaterThan(Integer value) {
            addCriterion("zz_minplantcount >", value, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("zz_minplantcount >=", value, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountLessThan(Integer value) {
            addCriterion("zz_minplantcount <", value, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountLessThanOrEqualTo(Integer value) {
            addCriterion("zz_minplantcount <=", value, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountIn(List<Integer> values) {
            addCriterion("zz_minplantcount in", values, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountNotIn(List<Integer> values) {
            addCriterion("zz_minplantcount not in", values, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountBetween(Integer value1, Integer value2) {
            addCriterion("zz_minplantcount between", value1, value2, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzMinplantcountNotBetween(Integer value1, Integer value2) {
            addCriterion("zz_minplantcount not between", value1, value2, "zzMinplantcount");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeIsNull() {
            addCriterion("zz_sicktype is null");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeIsNotNull() {
            addCriterion("zz_sicktype is not null");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeEqualTo(String value) {
            addCriterion("zz_sicktype =", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeNotEqualTo(String value) {
            addCriterion("zz_sicktype <>", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeGreaterThan(String value) {
            addCriterion("zz_sicktype >", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeGreaterThanOrEqualTo(String value) {
            addCriterion("zz_sicktype >=", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeLessThan(String value) {
            addCriterion("zz_sicktype <", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeLessThanOrEqualTo(String value) {
            addCriterion("zz_sicktype <=", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeLike(String value) {
            addCriterion("zz_sicktype like", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeNotLike(String value) {
            addCriterion("zz_sicktype not like", value, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeIn(List<String> values) {
            addCriterion("zz_sicktype in", values, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeNotIn(List<String> values) {
            addCriterion("zz_sicktype not in", values, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeBetween(String value1, String value2) {
            addCriterion("zz_sicktype between", value1, value2, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzSicktypeNotBetween(String value1, String value2) {
            addCriterion("zz_sicktype not between", value1, value2, "zzSicktype");
            return (Criteria) this;
        }

        public Criteria andZzIconIsNull() {
            addCriterion("zz_icon is null");
            return (Criteria) this;
        }

        public Criteria andZzIconIsNotNull() {
            addCriterion("zz_icon is not null");
            return (Criteria) this;
        }

        public Criteria andZzIconEqualTo(String value) {
            addCriterion("zz_icon =", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconNotEqualTo(String value) {
            addCriterion("zz_icon <>", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconGreaterThan(String value) {
            addCriterion("zz_icon >", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconGreaterThanOrEqualTo(String value) {
            addCriterion("zz_icon >=", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconLessThan(String value) {
            addCriterion("zz_icon <", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconLessThanOrEqualTo(String value) {
            addCriterion("zz_icon <=", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconLike(String value) {
            addCriterion("zz_icon like", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconNotLike(String value) {
            addCriterion("zz_icon not like", value, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconIn(List<String> values) {
            addCriterion("zz_icon in", values, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconNotIn(List<String> values) {
            addCriterion("zz_icon not in", values, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconBetween(String value1, String value2) {
            addCriterion("zz_icon between", value1, value2, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzIconNotBetween(String value1, String value2) {
            addCriterion("zz_icon not between", value1, value2, "zzIcon");
            return (Criteria) this;
        }

        public Criteria andZzProductionIsNull() {
            addCriterion("zz_production is null");
            return (Criteria) this;
        }

        public Criteria andZzProductionIsNotNull() {
            addCriterion("zz_production is not null");
            return (Criteria) this;
        }

        public Criteria andZzProductionEqualTo(Integer value) {
            addCriterion("zz_production =", value, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionNotEqualTo(Integer value) {
            addCriterion("zz_production <>", value, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionGreaterThan(Integer value) {
            addCriterion("zz_production >", value, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionGreaterThanOrEqualTo(Integer value) {
            addCriterion("zz_production >=", value, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionLessThan(Integer value) {
            addCriterion("zz_production <", value, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionLessThanOrEqualTo(Integer value) {
            addCriterion("zz_production <=", value, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionIn(List<Integer> values) {
            addCriterion("zz_production in", values, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionNotIn(List<Integer> values) {
            addCriterion("zz_production not in", values, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionBetween(Integer value1, Integer value2) {
            addCriterion("zz_production between", value1, value2, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzProductionNotBetween(Integer value1, Integer value2) {
            addCriterion("zz_production not between", value1, value2, "zzProduction");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseIsNull() {
            addCriterion("zz_singlehfuse is null");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseIsNotNull() {
            addCriterion("zz_singlehfuse is not null");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseEqualTo(Integer value) {
            addCriterion("zz_singlehfuse =", value, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseNotEqualTo(Integer value) {
            addCriterion("zz_singlehfuse <>", value, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseGreaterThan(Integer value) {
            addCriterion("zz_singlehfuse >", value, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("zz_singlehfuse >=", value, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseLessThan(Integer value) {
            addCriterion("zz_singlehfuse <", value, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseLessThanOrEqualTo(Integer value) {
            addCriterion("zz_singlehfuse <=", value, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseIn(List<Integer> values) {
            addCriterion("zz_singlehfuse in", values, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseNotIn(List<Integer> values) {
            addCriterion("zz_singlehfuse not in", values, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseBetween(Integer value1, Integer value2) {
            addCriterion("zz_singlehfuse between", value1, value2, "zzSinglehfuse");
            return (Criteria) this;
        }

        public Criteria andZzSinglehfuseNotBetween(Integer value1, Integer value2) {
            addCriterion("zz_singlehfuse not between", value1, value2, "zzSinglehfuse");
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