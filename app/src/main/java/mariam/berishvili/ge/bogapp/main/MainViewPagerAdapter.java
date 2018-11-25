package mariam.berishvili.ge.bogapp.main;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import mariam.berishvili.ge.bogapp.main.fragment.actives.ActivesFragment;
import mariam.berishvili.ge.bogapp.main.fragment.cards.CardsFragment;
import mariam.berishvili.ge.bogapp.main.fragment.profile.ProfileFragment;
import mariam.berishvili.ge.bogapp.main.fragment.transactions.TransactionsFragment;
import mariam.berishvili.ge.bogapp.model.Constants;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;
    private static final int PAGE_PROFILE = 0;
    private static final int PAGE_ACTIVES = 1;
    private static final int PAGE_TRANSACTIONS = 2;
    private static final int PAGE_CARDS = 3;


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case PAGE_PROFILE: return ProfileFragment.newInstance();
            case PAGE_ACTIVES: return ActivesFragment.newInstance();
            case PAGE_TRANSACTIONS: return TransactionsFragment.newInstance();
            case PAGE_CARDS: return CardsFragment.newInstance();
            default: return ProfileFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case PAGE_PROFILE: return Constants.PAGE_TITLE_PROFILE;
            case PAGE_ACTIVES: return Constants.PAGE_TITLE_ACTIVES;
            case PAGE_TRANSACTIONS: return Constants.PAGE_TITLE_TRANSACTIONS;
            case PAGE_CARDS: return Constants.PAGE_TITLE_CARDS;
            default: return null;
        }
    }



}
