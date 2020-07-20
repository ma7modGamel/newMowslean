package com.mgh.mwassleen.ui.mainfragments.orders.finishorders;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.FinishOrdersFragmentBinding;
import com.mgh.mwassleen.utils.GlobalPrefrencies;
import com.mgh.mwassleen.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class FinishOrdersFragment extends Fragment {

    private FinishOrdersViewModel mViewModel;


    FinishOrdersFragmentBinding finishOrdersFragmentBinding;
   // public static List<Datum> dataArrayListProduct = new ArrayList<>();

    public static FinishOrdersFragment newInstance() {
        return new FinishOrdersFragment();
    }

    GlobalPrefrencies globalPrefrencies;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        globalPrefrencies = new GlobalPrefrencies(getContext());
        Utils.setLocale(getContext(),globalPrefrencies.getLanguage());
        finishOrdersFragmentBinding = DataBindingUtil.inflate(inflater , R.layout.finish_orders_fragment , container , false);
        return finishOrdersFragmentBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =new FinishOrdersViewModel(getContext());
        // TODO: Use the ViewModel
        finishOrdersFragmentBinding.setLifecycleOwner(this);
        finishOrdersFragmentBinding.setFinishVmodel(mViewModel);

        //finishOrdersFragmentBinding.finishedOrdersProgress.setVisibility(View.VISIBLE);

       /* if (dataArrayListProduct.isEmpty()) {

            finishOrdersFragmentBinding.tvNoOrder.setVisibility(View.VISIBLE);


        } else {
            finishOrdersFragmentBinding.tvNoOrder.setVisibility(View.GONE);

        } */

       // setupFinishedOrders();
    }

//
//    private void setupFinishedOrders() {
//        final OrdersAdapter adapter = new OrdersAdapter(getContext());
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
//        finishOrdersFragmentBinding.rvFinishedOrders.setLayoutManager(manager);
//        mViewModel.mutableLiveDataOrdersPageList.observe(getViewLifecycleOwner(), new Observer<PagedList<Datum>>() {
//            @Override
//            public void onChanged(PagedList<Datum> data) {
//                adapter.submitList(data);
//                if (data.isEmpty()) {
//                    finishOrdersFragmentBinding.tvNoOrder.setVisibility(View.VISIBLE);
//                }else {
//                    finishOrdersFragmentBinding.tvNoOrder.setVisibility(View.GONE);
//                }
//                finishOrdersFragmentBinding.finishedOrdersProgress.setVisibility(View.GONE);
//                Log.e("finishXXXCXC", adapter.getItemCount() + "");
//            }
//        });
//
//        finishOrdersFragmentBinding.rvFinishedOrders.setAdapter(adapter);
//
//
//    }


}
