package com.id.alnsmth.customselection;

public class DataModel {
    String unit;
    Integer fraction;
    Double normalPrice, promoPrice;
    boolean isPromo;
    boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public Double getNormalPrice() {
        return normalPrice;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

    public Integer getFraction() {
        return fraction;
    }

    public String getUnit() {
        return unit;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public void setNormalPrice(Double normalPrice) {
        this.normalPrice = normalPrice;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
