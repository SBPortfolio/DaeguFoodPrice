package com.example.daegufoodprice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceData {
    @SerializedName("Grid_20141225000000000163_1")
    @Expose
    private Grid201412250000000001631 grid201412250000000001631;

    public Grid201412250000000001631 getGrid201412250000000001631() {
        return grid201412250000000001631;
    }

    public void setGrid201412250000000001631(Grid201412250000000001631 grid201412250000000001631) {
        this.grid201412250000000001631 = grid201412250000000001631;
    }
}
