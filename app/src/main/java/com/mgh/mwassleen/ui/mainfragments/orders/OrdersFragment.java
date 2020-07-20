package com.mgh.mwassleen.ui.mainfragments.orders;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.OrdersFragmentBinding;
import com.mgh.mwassleen.ui.mainfragments.orders.allorders.AllorderFragment;
import com.mgh.mwassleen.ui.mainfragments.orders.finishorders.FinishOrdersFragment;
import com.mgh.mwassleen.utils.GlobalPrefrencies;
import com.mgh.mwassleen.utils.PagerAdaptar;
import com.mgh.mwassleen.utils.Utils;

public class OrdersFragment extends Fragment {


        private OrdersViewModel mViewModel;

        OrdersFragmentBinding ordersFragmentBinding;
        public static OrdersFragment newInstance() {
            return new OrdersFragment();
        }

        PagerAdaptar adaptar;

        GlobalPrefrencies globalPrefrencies;
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            globalPrefrencies = new GlobalPrefrencies(getContext());
            Utils.setLocale(getContext(),globalPrefrencies.getLanguage());
            ordersFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.orders_fragment, container, false);
            return ordersFragmentBinding.getRoot();
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            mViewModel = ViewModelProviders.of(this).get(OrdersViewModel.class);
            ordersFragmentBinding.setOrderVmodel(mViewModel);
            ordersFragmentBinding.setLifecycleOwner(this);
            // TODO: Use the ViewModel
            initWidget();
        }

        private void initWidget() {

            adaptar = new PagerAdaptar(getChildFragmentManager());
            adaptar.addNewFragment(new AllorderFragment());
            adaptar.addNewFragment(new FinishOrdersFragment());
            ordersFragmentBinding.tabLayout.setupWithViewPager(ordersFragmentBinding.viewpager);
            ordersFragmentBinding.viewpager.setAdapter(adaptar);
            setUpTabsTopPager();

        }

        private void setUpTabsTopPager() {
            ordersFragmentBinding.tabLayout.getTabAt(0).setText("قيد التنفيذ");
            ordersFragmentBinding.tabLayout.getTabAt(1).setText("طلبات سابقة");
            //tabLayout.setTabTextColors(Color.parseColor("#FFAFAFAF"), Color.parseColor("#000000"));

        }
    }
