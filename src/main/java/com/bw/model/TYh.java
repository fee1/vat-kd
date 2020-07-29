package com.bw.model;

import java.io.Serializable;
import java.util.Date;

public class TYh implements Serializable {
    private Integer yhid;

    private String dlyhid;

    private String yhmc;

    private String yhmm;

    private Integer yhjg;

    private String xb;

    private Date lrsj;

    private Integer lrry;

    private Date xgsj;

    private Integer xgry;

    private String roleids;

    private String ztbz;

    private Integer dlcws;

    private static final long serialVersionUID = 1L;

    public Integer getYhid() {
        return yhid;
    }

    public void setYhid(Integer yhid) {
        this.yhid = yhid;
    }

    public String getDlyhid() {
        return dlyhid;
    }

    public void setDlyhid(String dlyhid) {
        this.dlyhid = dlyhid;
    }

    public String getYhmc() {
        return yhmc;
    }

    public void setYhmc(String yhmc) {
        this.yhmc = yhmc;
    }

    public String getYhmm() {
        return yhmm;
    }

    public void setYhmm(String yhmm) {
        this.yhmm = yhmm;
    }

    public Integer getYhjg() {
        return yhjg;
    }

    public void setYhjg(Integer yhjg) {
        this.yhjg = yhjg;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public Integer getLrry() {
        return lrry;
    }

    public void setLrry(Integer lrry) {
        this.lrry = lrry;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public Integer getXgry() {
        return xgry;
    }

    public void setXgry(Integer xgry) {
        this.xgry = xgry;
    }

    public String getRoleids() {
        return roleids;
    }

    public void setRoleids(String roleids) {
        this.roleids = roleids;
    }

    public String getZtbz() {
        return ztbz;
    }

    public void setZtbz(String ztbz) {
        this.ztbz = ztbz;
    }

    public Integer getDlcws() {
        return dlcws;
    }

    public void setDlcws(Integer dlcws) {
        this.dlcws = dlcws;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yhid=").append(yhid);
        sb.append(", dlyhid=").append(dlyhid);
        sb.append(", yhmc=").append(yhmc);
        sb.append(", yhmm=").append(yhmm);
        sb.append(", yhjg=").append(yhjg);
        sb.append(", xb=").append(xb);
        sb.append(", lrsj=").append(lrsj);
        sb.append(", lrry=").append(lrry);
        sb.append(", xgsj=").append(xgsj);
        sb.append(", xgry=").append(xgry);
        sb.append(", roleids=").append(roleids);
        sb.append(", ztbz=").append(ztbz);
        sb.append(", dlcws=").append(dlcws);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}