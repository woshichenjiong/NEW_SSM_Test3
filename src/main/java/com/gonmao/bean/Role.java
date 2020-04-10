package com.gonmao.bean;

/**
 * @Author:陈炯
 * @Date：2020/3/314:43
 */
public class Role {

    private int rid;
    private String rname;
    private String rdesc;
    private String rmoney;
    private String rsex;

    public Role() {
    }

    public Role(int rid, String rname, String rdesc, String rmoney, String rsex) {
        this.rid = rid;
        this.rname = rname;
        this.rdesc = rdesc;
        this.rmoney = rmoney;
        this.rsex = rsex;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public String getRmoney() {
        return rmoney;
    }

    public void setRmoney(String rmoney) {
        this.rmoney = rmoney;
    }

    public String getRsex() {
        return rsex;
    }

    public void setRsex(String rsex) {
        this.rsex = rsex;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                ", rmoney='" + rmoney + '\'' +
                ", rsex='" + rsex + '\'' +
                '}';
    }


}
