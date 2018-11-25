package mariam.berishvili.ge.bogapp.model.actives;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AssetsAndLiabilities {
    @SerializedName("Assets")
    private List<Asset> assets;
    @SerializedName("AvailableAmounts")
    private List<AvailableAmount> availableAmounts;
    @SerializedName("Liabilities")
    private List<Liability> liabilities;
    @SerializedName("Points")
    private List<Point> points;

    public List<List<AssetBase> > getAssetLists(){
        return  new ArrayList(Arrays.asList(assets, availableAmounts, liabilities, points));
    }



}
