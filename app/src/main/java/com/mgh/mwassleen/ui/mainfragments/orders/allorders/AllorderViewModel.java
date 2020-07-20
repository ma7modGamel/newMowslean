package com.mgh.mwassleen.ui.mainfragments.orders.allorders;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.mgh.mwassleen.models.PindingOrderModels.Datum;
import com.mgh.mwassleen.models.PindingOrderModels.PendingOrdersDataSource;
import com.mgh.mwassleen.models.PindingOrderModels.PendingOrdersDataSourceFactory;

public class AllorderViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public LiveData<PagedList<Datum>> mutableLiveDataAllOrdersPageList;
    MutableLiveData<PendingOrdersDataSource> pendingOrdersDataSourceMutableLiveData;

    public void init(Context context) {
        PendingOrdersDataSourceFactory pendingOrdersDataSourceFactory = new PendingOrdersDataSourceFactory(context);
        pendingOrdersDataSourceMutableLiveData = pendingOrdersDataSourceFactory.userLiveDataSource;
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(PendingOrdersDataSource.PAGE_SIZE)
                .build();
        mutableLiveDataAllOrdersPageList = new LivePagedListBuilder<>(pendingOrdersDataSourceFactory, config).build();

    }
}