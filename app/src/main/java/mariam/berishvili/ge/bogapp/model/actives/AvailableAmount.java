package mariam.berishvili.ge.bogapp.model.actives;

import com.google.gson.annotations.SerializedName;

import mariam.berishvili.ge.bogapp.model.Constants;

public class AvailableAmount implements AssetBase {
    @SerializedName("ProductName")
    private String productName;
    @SerializedName("ProductType")
    private String productType;
    @SerializedName("AmountBase")
    private double amountBase;

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
    public Integer getId() {
        return null;
    }

    @Override
    public Integer getOrderNo() {
        return null;
    }

    @Override
    public String getTitle() {
        return Constants.TITLE_AVAILABLE_AMOUNTS;
    }
}
