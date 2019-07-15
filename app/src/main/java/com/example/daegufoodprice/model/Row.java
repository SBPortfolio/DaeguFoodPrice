package com.example.daegufoodprice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("ROW_NUM")
    @Expose
    private Integer rOWNUM;
    @SerializedName("EXAMIN_DE")
    @Expose
    private String eXAMINDE;
    @SerializedName("FRMPRD_CATGORY_NM")
    @Expose
    private String fRMPRDCATGORYNM;
    @SerializedName("FRMPRD_CATGORY_CD")
    @Expose
    private String fRMPRDCATGORYCD;
    @SerializedName("PRDLST_CD")
    @Expose
    private String pRDLSTCD;
    @SerializedName("PRDLST_NM")
    @Expose
    private String pRDLSTNM;
    @SerializedName("SPCIES_CD")
    @Expose
    private String sPCIESCD;
    @SerializedName("SPCIES_NM")
    @Expose
    private String sPCIESNM;
    @SerializedName("GRAD_CD")
    @Expose
    private String gRADCD;
    @SerializedName("GRAD_NM")
    @Expose
    private String gRADNM;
    @SerializedName("EXAMIN_UNIT")
    @Expose
    private String eXAMINUNIT;
    @SerializedName("AREA_CD")
    @Expose
    private String aREACD;
    @SerializedName("AREA_NM")
    @Expose
    private String aREANM;
    @SerializedName("MRKT_CD")
    @Expose
    private String mRKTCD;
    @SerializedName("MRKT_NM")
    @Expose
    private String mRKTNM;
    @SerializedName("AMT")
    @Expose
    private Integer aMT;

    public Integer getROWNUM() {
        return rOWNUM;
    }

    public void setROWNUM(Integer rOWNUM) {
        this.rOWNUM = rOWNUM;
    }

    public String getEXAMINDE() {
        return eXAMINDE;
    }

    public void setEXAMINDE(String eXAMINDE) {
        this.eXAMINDE = eXAMINDE;
    }

    public String getFRMPRDCATGORYNM() {
        return fRMPRDCATGORYNM;
    }

    public void setFRMPRDCATGORYNM(String fRMPRDCATGORYNM) {
        this.fRMPRDCATGORYNM = fRMPRDCATGORYNM;
    }

    public String getFRMPRDCATGORYCD() {
        return fRMPRDCATGORYCD;
    }

    public void setFRMPRDCATGORYCD(String fRMPRDCATGORYCD) {
        this.fRMPRDCATGORYCD = fRMPRDCATGORYCD;
    }

    public String getPRDLSTCD() {
        return pRDLSTCD;
    }

    public void setPRDLSTCD(String pRDLSTCD) {
        this.pRDLSTCD = pRDLSTCD;
    }

    public String getPRDLSTNM() {
        return pRDLSTNM;
    }

    public void setPRDLSTNM(String pRDLSTNM) {
        this.pRDLSTNM = pRDLSTNM;
    }

    public String getSPCIESCD() {
        return sPCIESCD;
    }

    public void setSPCIESCD(String sPCIESCD) {
        this.sPCIESCD = sPCIESCD;
    }

    public String getSPCIESNM() {
        return sPCIESNM;
    }

    public void setSPCIESNM(String sPCIESNM) {
        this.sPCIESNM = sPCIESNM;
    }

    public String getGRADCD() {
        return gRADCD;
    }

    public void setGRADCD(String gRADCD) {
        this.gRADCD = gRADCD;
    }

    public String getGRADNM() {
        return gRADNM;
    }

    public void setGRADNM(String gRADNM) {
        this.gRADNM = gRADNM;
    }

    public String getEXAMINUNIT() {
        return eXAMINUNIT;
    }

    public void setEXAMINUNIT(String eXAMINUNIT) {
        this.eXAMINUNIT = eXAMINUNIT;
    }

    public String getAREACD() {
        return aREACD;
    }

    public void setAREACD(String aREACD) {
        this.aREACD = aREACD;
    }

    public String getAREANM() {
        return aREANM;
    }

    public void setAREANM(String aREANM) {
        this.aREANM = aREANM;
    }

    public String getMRKTCD() {
        return mRKTCD;
    }

    public void setMRKTCD(String mRKTCD) {
        this.mRKTCD = mRKTCD;
    }

    public String getMRKTNM() {
        return mRKTNM;
    }

    public void setMRKTNM(String mRKTNM) {
        this.mRKTNM = mRKTNM;
    }

    public Integer getAMT() {
        return aMT;
    }

    public void setAMT(Integer aMT) {
        this.aMT = aMT;
    }

}