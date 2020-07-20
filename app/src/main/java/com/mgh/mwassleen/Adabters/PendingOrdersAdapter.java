package com.mgh.mwassleen.Adabters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mgh.mwassleen.R;
import com.mgh.mwassleen.models.PindingOrderModels.Datum;


public class PendingOrdersAdapter extends PagedListAdapter<Datum , PendingOrdersAdapter.PendingOrdersVmodel> {
    private Context context;

    private static final DiffUtil.ItemCallback<Datum> item_COMPARATOR = new DiffUtil.ItemCallback<Datum>() {
        @Override
        public boolean areItemsTheSame(@NonNull Datum oldItem, @NonNull Datum newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Datum oldItem, @NonNull Datum newItem) {
            return oldItem == newItem;
        }
    };

    public PendingOrdersAdapter(Context context) {
        super(item_COMPARATOR);
        this.context = context;
    }

    public void ClearAdapter() {

    }

    @NonNull
    @Override
    public PendingOrdersAdapter.PendingOrdersVmodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orders_rv, parent, false);
        return new PendingOrdersVmodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingOrdersAdapter.PendingOrdersVmodel holder, int position) {

        final Datum item = getItem(position);
        holder.code.setText(item.getId()+"");
        holder.date.setText(item.getDay() + "");
     //   holder.productNum.setText(context.getString(R.string.countProducts) + "(" + item.getOrderProducts().size() + ")" + context.getString(R.string.product));
     //   holder.cost.setText(context.getString(R.string.totalprice) + item.getFinalPrice() + context.getResources().getString(R.string.EGP));


//        String time = item.getCreatedAt();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        try {
//            date = sdf.parse(time);
//        } catch (ParseException e) {
//            Log.e("22222", e.getMessage());
//        }
//        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//        String formatedTime = sdf2.format(date);
//

   //     holder.date.setText(formatedTime + "");


//        holder.btn_details.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent=new Intent(context, DetailsOrderActivity.class);
////                intent.putExtra("myid", item.getId() + "");
////                context.startActivity(intent);
//
//                //ShowAndHideDetails
//            }
//        });
    }

    public class PendingOrdersVmodel extends RecyclerView.ViewHolder {
        TextView date , code , productName , city ;
        Button btn_details;
        public PendingOrdersVmodel(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.dateOrder);
            code=itemView.findViewById(R.id.codeOrder);


        }
    }
}
