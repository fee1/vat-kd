package com.bw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TYhExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TYhExample() {
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

        public Criteria andYhidIsNull() {
            addCriterion("yhid is null");
            return (Criteria) this;
        }

        public Criteria andYhidIsNotNull() {
            addCriterion("yhid is not null");
            return (Criteria) this;
        }

        public Criteria andYhidEqualTo(Integer value) {
            addCriterion("yhid =", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidNotEqualTo(Integer value) {
            addCriterion("yhid <>", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidGreaterThan(Integer value) {
            addCriterion("yhid >", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidGreaterThanOrEqualTo(Integer value) {
            addCriterion("yhid >=", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidLessThan(Integer value) {
            addCriterion("yhid <", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidLessThanOrEqualTo(Integer value) {
            addCriterion("yhid <=", value, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidIn(List<Integer> values) {
            addCriterion("yhid in", values, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidNotIn(List<Integer> values) {
            addCriterion("yhid not in", values, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidBetween(Integer value1, Integer value2) {
            addCriterion("yhid between", value1, value2, "yhid");
            return (Criteria) this;
        }

        public Criteria andYhidNotBetween(Integer value1, Integer value2) {
            addCriterion("yhid not between", value1, value2, "yhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidIsNull() {
            addCriterion("dlyhid is null");
            return (Criteria) this;
        }

        public Criteria andDlyhidIsNotNull() {
            addCriterion("dlyhid is not null");
            return (Criteria) this;
        }

        public Criteria andDlyhidEqualTo(String value) {
            addCriterion("dlyhid =", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidNotEqualTo(String value) {
            addCriterion("dlyhid <>", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidGreaterThan(String value) {
            addCriterion("dlyhid >", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidGreaterThanOrEqualTo(String value) {
            addCriterion("dlyhid >=", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidLessThan(String value) {
            addCriterion("dlyhid <", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidLessThanOrEqualTo(String value) {
            addCriterion("dlyhid <=", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidLike(String value) {
            addCriterion("dlyhid like", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidNotLike(String value) {
            addCriterion("dlyhid not like", value, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidIn(List<String> values) {
            addCriterion("dlyhid in", values, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidNotIn(List<String> values) {
            addCriterion("dlyhid not in", values, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidBetween(String value1, String value2) {
            addCriterion("dlyhid between", value1, value2, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andDlyhidNotBetween(String value1, String value2) {
            addCriterion("dlyhid not between", value1, value2, "dlyhid");
            return (Criteria) this;
        }

        public Criteria andYhmcIsNull() {
            addCriterion("yhmc is null");
            return (Criteria) this;
        }

        public Criteria andYhmcIsNotNull() {
            addCriterion("yhmc is not null");
            return (Criteria) this;
        }

        public Criteria andYhmcEqualTo(String value) {
            addCriterion("yhmc =", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotEqualTo(String value) {
            addCriterion("yhmc <>", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcGreaterThan(String value) {
            addCriterion("yhmc >", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcGreaterThanOrEqualTo(String value) {
            addCriterion("yhmc >=", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcLessThan(String value) {
            addCriterion("yhmc <", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcLessThanOrEqualTo(String value) {
            addCriterion("yhmc <=", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcLike(String value) {
            addCriterion("yhmc like", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotLike(String value) {
            addCriterion("yhmc not like", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcIn(List<String> values) {
            addCriterion("yhmc in", values, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotIn(List<String> values) {
            addCriterion("yhmc not in", values, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcBetween(String value1, String value2) {
            addCriterion("yhmc between", value1, value2, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotBetween(String value1, String value2) {
            addCriterion("yhmc not between", value1, value2, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmmIsNull() {
            addCriterion("yhmm is null");
            return (Criteria) this;
        }

        public Criteria andYhmmIsNotNull() {
            addCriterion("yhmm is not null");
            return (Criteria) this;
        }

        public Criteria andYhmmEqualTo(String value) {
            addCriterion("yhmm =", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmNotEqualTo(String value) {
            addCriterion("yhmm <>", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmGreaterThan(String value) {
            addCriterion("yhmm >", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmGreaterThanOrEqualTo(String value) {
            addCriterion("yhmm >=", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmLessThan(String value) {
            addCriterion("yhmm <", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmLessThanOrEqualTo(String value) {
            addCriterion("yhmm <=", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmLike(String value) {
            addCriterion("yhmm like", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmNotLike(String value) {
            addCriterion("yhmm not like", value, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmIn(List<String> values) {
            addCriterion("yhmm in", values, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmNotIn(List<String> values) {
            addCriterion("yhmm not in", values, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmBetween(String value1, String value2) {
            addCriterion("yhmm between", value1, value2, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhmmNotBetween(String value1, String value2) {
            addCriterion("yhmm not between", value1, value2, "yhmm");
            return (Criteria) this;
        }

        public Criteria andYhjgIsNull() {
            addCriterion("yhjg is null");
            return (Criteria) this;
        }

        public Criteria andYhjgIsNotNull() {
            addCriterion("yhjg is not null");
            return (Criteria) this;
        }

        public Criteria andYhjgEqualTo(Integer value) {
            addCriterion("yhjg =", value, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgNotEqualTo(Integer value) {
            addCriterion("yhjg <>", value, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgGreaterThan(Integer value) {
            addCriterion("yhjg >", value, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgGreaterThanOrEqualTo(Integer value) {
            addCriterion("yhjg >=", value, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgLessThan(Integer value) {
            addCriterion("yhjg <", value, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgLessThanOrEqualTo(Integer value) {
            addCriterion("yhjg <=", value, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgIn(List<Integer> values) {
            addCriterion("yhjg in", values, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgNotIn(List<Integer> values) {
            addCriterion("yhjg not in", values, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgBetween(Integer value1, Integer value2) {
            addCriterion("yhjg between", value1, value2, "yhjg");
            return (Criteria) this;
        }

        public Criteria andYhjgNotBetween(Integer value1, Integer value2) {
            addCriterion("yhjg not between", value1, value2, "yhjg");
            return (Criteria) this;
        }

        public Criteria andXbIsNull() {
            addCriterion("xb is null");
            return (Criteria) this;
        }

        public Criteria andXbIsNotNull() {
            addCriterion("xb is not null");
            return (Criteria) this;
        }

        public Criteria andXbEqualTo(String value) {
            addCriterion("xb =", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotEqualTo(String value) {
            addCriterion("xb <>", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThan(String value) {
            addCriterion("xb >", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThanOrEqualTo(String value) {
            addCriterion("xb >=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThan(String value) {
            addCriterion("xb <", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThanOrEqualTo(String value) {
            addCriterion("xb <=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLike(String value) {
            addCriterion("xb like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotLike(String value) {
            addCriterion("xb not like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbIn(List<String> values) {
            addCriterion("xb in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotIn(List<String> values) {
            addCriterion("xb not in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbBetween(String value1, String value2) {
            addCriterion("xb between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotBetween(String value1, String value2) {
            addCriterion("xb not between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andLrsjIsNull() {
            addCriterion("lrsj is null");
            return (Criteria) this;
        }

        public Criteria andLrsjIsNotNull() {
            addCriterion("lrsj is not null");
            return (Criteria) this;
        }

        public Criteria andLrsjEqualTo(Date value) {
            addCriterion("lrsj =", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotEqualTo(Date value) {
            addCriterion("lrsj <>", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjGreaterThan(Date value) {
            addCriterion("lrsj >", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjGreaterThanOrEqualTo(Date value) {
            addCriterion("lrsj >=", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjLessThan(Date value) {
            addCriterion("lrsj <", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjLessThanOrEqualTo(Date value) {
            addCriterion("lrsj <=", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjIn(List<Date> values) {
            addCriterion("lrsj in", values, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotIn(List<Date> values) {
            addCriterion("lrsj not in", values, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjBetween(Date value1, Date value2) {
            addCriterion("lrsj between", value1, value2, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotBetween(Date value1, Date value2) {
            addCriterion("lrsj not between", value1, value2, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrryIsNull() {
            addCriterion("lrry is null");
            return (Criteria) this;
        }

        public Criteria andLrryIsNotNull() {
            addCriterion("lrry is not null");
            return (Criteria) this;
        }

        public Criteria andLrryEqualTo(Integer value) {
            addCriterion("lrry =", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryNotEqualTo(Integer value) {
            addCriterion("lrry <>", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryGreaterThan(Integer value) {
            addCriterion("lrry >", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryGreaterThanOrEqualTo(Integer value) {
            addCriterion("lrry >=", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryLessThan(Integer value) {
            addCriterion("lrry <", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryLessThanOrEqualTo(Integer value) {
            addCriterion("lrry <=", value, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryIn(List<Integer> values) {
            addCriterion("lrry in", values, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryNotIn(List<Integer> values) {
            addCriterion("lrry not in", values, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryBetween(Integer value1, Integer value2) {
            addCriterion("lrry between", value1, value2, "lrry");
            return (Criteria) this;
        }

        public Criteria andLrryNotBetween(Integer value1, Integer value2) {
            addCriterion("lrry not between", value1, value2, "lrry");
            return (Criteria) this;
        }

        public Criteria andXgsjIsNull() {
            addCriterion("xgsj is null");
            return (Criteria) this;
        }

        public Criteria andXgsjIsNotNull() {
            addCriterion("xgsj is not null");
            return (Criteria) this;
        }

        public Criteria andXgsjEqualTo(Date value) {
            addCriterion("xgsj =", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotEqualTo(Date value) {
            addCriterion("xgsj <>", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjGreaterThan(Date value) {
            addCriterion("xgsj >", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjGreaterThanOrEqualTo(Date value) {
            addCriterion("xgsj >=", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjLessThan(Date value) {
            addCriterion("xgsj <", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjLessThanOrEqualTo(Date value) {
            addCriterion("xgsj <=", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjIn(List<Date> values) {
            addCriterion("xgsj in", values, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotIn(List<Date> values) {
            addCriterion("xgsj not in", values, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjBetween(Date value1, Date value2) {
            addCriterion("xgsj between", value1, value2, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotBetween(Date value1, Date value2) {
            addCriterion("xgsj not between", value1, value2, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgryIsNull() {
            addCriterion("xgry is null");
            return (Criteria) this;
        }

        public Criteria andXgryIsNotNull() {
            addCriterion("xgry is not null");
            return (Criteria) this;
        }

        public Criteria andXgryEqualTo(Integer value) {
            addCriterion("xgry =", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryNotEqualTo(Integer value) {
            addCriterion("xgry <>", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryGreaterThan(Integer value) {
            addCriterion("xgry >", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryGreaterThanOrEqualTo(Integer value) {
            addCriterion("xgry >=", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryLessThan(Integer value) {
            addCriterion("xgry <", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryLessThanOrEqualTo(Integer value) {
            addCriterion("xgry <=", value, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryIn(List<Integer> values) {
            addCriterion("xgry in", values, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryNotIn(List<Integer> values) {
            addCriterion("xgry not in", values, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryBetween(Integer value1, Integer value2) {
            addCriterion("xgry between", value1, value2, "xgry");
            return (Criteria) this;
        }

        public Criteria andXgryNotBetween(Integer value1, Integer value2) {
            addCriterion("xgry not between", value1, value2, "xgry");
            return (Criteria) this;
        }

        public Criteria andRoleidsIsNull() {
            addCriterion("roleIds is null");
            return (Criteria) this;
        }

        public Criteria andRoleidsIsNotNull() {
            addCriterion("roleIds is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidsEqualTo(String value) {
            addCriterion("roleIds =", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsNotEqualTo(String value) {
            addCriterion("roleIds <>", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsGreaterThan(String value) {
            addCriterion("roleIds >", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsGreaterThanOrEqualTo(String value) {
            addCriterion("roleIds >=", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsLessThan(String value) {
            addCriterion("roleIds <", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsLessThanOrEqualTo(String value) {
            addCriterion("roleIds <=", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsLike(String value) {
            addCriterion("roleIds like", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsNotLike(String value) {
            addCriterion("roleIds not like", value, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsIn(List<String> values) {
            addCriterion("roleIds in", values, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsNotIn(List<String> values) {
            addCriterion("roleIds not in", values, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsBetween(String value1, String value2) {
            addCriterion("roleIds between", value1, value2, "roleids");
            return (Criteria) this;
        }

        public Criteria andRoleidsNotBetween(String value1, String value2) {
            addCriterion("roleIds not between", value1, value2, "roleids");
            return (Criteria) this;
        }

        public Criteria andZtbzIsNull() {
            addCriterion("ztbz is null");
            return (Criteria) this;
        }

        public Criteria andZtbzIsNotNull() {
            addCriterion("ztbz is not null");
            return (Criteria) this;
        }

        public Criteria andZtbzEqualTo(String value) {
            addCriterion("ztbz =", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzNotEqualTo(String value) {
            addCriterion("ztbz <>", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzGreaterThan(String value) {
            addCriterion("ztbz >", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzGreaterThanOrEqualTo(String value) {
            addCriterion("ztbz >=", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzLessThan(String value) {
            addCriterion("ztbz <", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzLessThanOrEqualTo(String value) {
            addCriterion("ztbz <=", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzLike(String value) {
            addCriterion("ztbz like", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzNotLike(String value) {
            addCriterion("ztbz not like", value, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzIn(List<String> values) {
            addCriterion("ztbz in", values, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzNotIn(List<String> values) {
            addCriterion("ztbz not in", values, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzBetween(String value1, String value2) {
            addCriterion("ztbz between", value1, value2, "ztbz");
            return (Criteria) this;
        }

        public Criteria andZtbzNotBetween(String value1, String value2) {
            addCriterion("ztbz not between", value1, value2, "ztbz");
            return (Criteria) this;
        }

        public Criteria andDlcwsIsNull() {
            addCriterion("dlcws is null");
            return (Criteria) this;
        }

        public Criteria andDlcwsIsNotNull() {
            addCriterion("dlcws is not null");
            return (Criteria) this;
        }

        public Criteria andDlcwsEqualTo(Integer value) {
            addCriterion("dlcws =", value, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsNotEqualTo(Integer value) {
            addCriterion("dlcws <>", value, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsGreaterThan(Integer value) {
            addCriterion("dlcws >", value, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dlcws >=", value, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsLessThan(Integer value) {
            addCriterion("dlcws <", value, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsLessThanOrEqualTo(Integer value) {
            addCriterion("dlcws <=", value, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsIn(List<Integer> values) {
            addCriterion("dlcws in", values, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsNotIn(List<Integer> values) {
            addCriterion("dlcws not in", values, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsBetween(Integer value1, Integer value2) {
            addCriterion("dlcws between", value1, value2, "dlcws");
            return (Criteria) this;
        }

        public Criteria andDlcwsNotBetween(Integer value1, Integer value2) {
            addCriterion("dlcws not between", value1, value2, "dlcws");
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