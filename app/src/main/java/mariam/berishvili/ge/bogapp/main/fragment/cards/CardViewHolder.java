package mariam.berishvili.ge.bogapp.main.fragment.cards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mariam.berishvili.ge.bogapp.R;
import mariam.berishvili.ge.bogapp.model.Constants;
import mariam.berishvili.ge.bogapp.model.cards.Card;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private TextView type;
    private TextView cardNumber;
    private TextView name;
    private TextView validDate;
    private ImageView icon;
    private View view;
    private RelativeLayout layout;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        initViewComponents();
    }


    private void initViewComponents(){
        type = view.findViewById(R.id.fragment_card_cell_type);
        cardNumber = view.findViewById(R.id.fragment_card_cell_card_number);
        name = view.findViewById(R.id.fragment_card_cell_name);
        validDate = view.findViewById(R.id.fragment_card_cell_valid_value);
        icon = view.findViewById(R.id.fragment_card_cell_icon);
        layout = view.findViewById(R.id.list_container_bg);
    }

    public void setData(Card card){
        setTypeAndBackground(card.getCardType());
        setCardNumber(card.getLastFour());
        setName(card.getCardHolder());
        setValidDate(card.getExpDate());
        setIcon(card.getCardClass());
    }

    private void setIcon(String cardClass) {
        if(cardClass.equals(Constants.CARD_CLASS_AMEX)){
            icon.setImageResource(R.drawable.card_icon_amex_single);
        }else{
            icon.setImageResource(R.drawable.card_icon_visa_border_single);
        }
    }

    private void setValidDate(Long expDate) {
        Date date = new Date(expDate);
        SimpleDateFormat dt1 = new SimpleDateFormat("mm/yy", Locale.US);
        validDate.setText(dt1.format(date));
    }

    private void setName(String cardHolder) {
        name.setText(cardHolder);
    }

    private void setCardNumber(String lastFour) {
        String number = Constants.DEFAULT_CARD_PREFIX + lastFour;
        cardNumber.setText(number);
    }

    private void setTypeAndBackground(String cardType) {

        if (cardType.equals(Constants.CARD_TYPE_GOLD)){
            type.setText(R.string.fragment_card_cell_type_gold);
            layout.setBackgroundResource(R.drawable.account_background_visa_gold);
        }else if( cardType.equals(Constants.CARD_TYPE_SOLO)){
            type.setText(R.string.fragment_card_cell_type_solo);
            layout.setBackgroundResource(R.drawable.account_background_solo);
        }else {
            type.setText(R.string.fragment_card_cell_type_green);
            layout.setBackgroundResource(R.drawable.account_background_amex_green);
        }
    }
}
