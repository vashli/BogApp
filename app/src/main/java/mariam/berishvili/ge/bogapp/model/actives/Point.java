package mariam.berishvili.ge.bogapp.model.actives;

import com.google.gson.annotations.SerializedName;

import mariam.berishvili.ge.bogapp.model.Constants;

public class Point implements AssetBase {
    @SerializedName("ProductName")
    private String productName;
    @SerializedName("ProdType")
    private String productType;
    @SerializedName("Amount")
    private double amountBase;
    @SerializedName("Id")
    private int id;
    @SerializedName("OrderNo")
    private int orderNo;

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public double getAmount() {
        return amountBase;
    }

    @Override
    public Integer getId() { return id; }

    @Override
    public Integer getOrderNo() {
        return orderNo;
    }

    @Override
    public String getTitle() {
        return Constants.TITLE_POINTS;
    }
}
