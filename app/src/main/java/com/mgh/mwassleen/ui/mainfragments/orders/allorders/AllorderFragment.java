package com.mgh.mwassleen.ui.mainfragments.orders.allorders;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mgh.mwassleen.Adabters.PendingOrdersAdapter;
import com.mgh.mwassleen.R;
import com.mgh.mwassleen.databinding.AllorderFragmentBinding;
import com.mgh.mwassleen.models.PindingOrderModels.Datum;
import com.mgh.mwassleen.utils.GlobalPrefrencies;
import com.mgh.mwassleen.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class AllorderFragment extends Fragment {

    private AllorderViewModel mViewModel;
    AllorderFragmentBinding allorderFragmentBinding;
    public static List<Datum> dataArrayListProduct = new ArrayList<>();

    public static AllorderFragment newInstance() {
        return new AllorderFragment();
    }

    GlobalPrefrencies globalPrefrencies;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        globalPrefrencies = new GlobalPrefrencies(getContext());
        Utils.setLocale(getContext(),globalPrefrencies.getLanguage());
        allorderFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.allorder_fragment , container,false);
        return allorderFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
        mViewModel = ViewModelProviders.of(this).get(AllorderViewModel.class);
        allorderFragmentBinding.setLifecycleOwner(this);
        allorderFragmentBinding.setAllorderVmodel(mViewModel);


        mViewModel.init(getContext());
        setupPendingOrders();

    }

    private void setupPendingOrders()
    {
        final PendingOrdersAdapter adapter = new PendingOrdersAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        allorderFragmentBinding.rvPinding.setLayoutManager(manager);
        mViewModel.mutableLiveDataAllOrdersPageList.observe(getViewLifecycleOwner(), new Observer<PagedList<Datum>>() {
            @Override
            public void onChanged(PagedList<Datum> data) {

                adapter.submitList(data);
                Log.e("sscsc", "scscsccccc");
            }
        });
        allorderFragmentBinding.rvPinding.setAdapter(adapter);


    }

}