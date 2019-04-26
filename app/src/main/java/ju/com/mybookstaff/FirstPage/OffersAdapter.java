package ju.com.mybookstaff.FirstPage;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ju.com.mybookstaff.R;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MyViewHolder> {

    List<OfferModel> offers;
    Context myContext;


    public OffersAdapter(List<OfferModel> offerModels, Context myContext) {
        this.offers = offerModels;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public OffersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(myContext).inflate(R.layout.offer_card, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OffersAdapter.MyViewHolder holder, int position) {
        final OfferModel offer = offers.get(position);
        holder.bookName.setText(offer.getBookName());
        Glide.with(myContext).load(offer.getBookPhoto()).into(holder.bookImage);
        holder.from.setText(offer.getFromName());
        holder.to.setText(offer.getToName());
        holder.price.setText(offer.getBookPrice());

        holder.fromPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + offer.getFromPhone()));
                if (ActivityCompat.checkSelfPermission(myContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                myContext.startActivity(intent);
            }
        });

        holder.toPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + offer.getToPhone()));
                if (ActivityCompat.checkSelfPermission(myContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                myContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /*

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(myContext).inflate(R.layout.offer_card, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OffersAdapter.MyViewHolder holder, int position) {
        final OfferModel offer = offers.get(position);
        holder.bookName.setText(offer.getBookName());
        Glide.with(myContext).load(offer.getBookPhoto()).into(holder.bookImage);
        holder.from.setText(offer.getFromName());
        holder.to.setText(offer.getToName());
        holder.price.setText(offer.getBookPrice());

        holder.fromPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + offer.getFromPhone()));
                if (ActivityCompat.checkSelfPermission(myContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                myContext.startActivity(intent);
            }
        });

        holder.toPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + offer.getToPhone()));
                if (ActivityCompat.checkSelfPermission(myContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                myContext.startActivity(intent);

            }
        });






    }

    @Override
    public int getItemCount() {
        return 0;
    }

*/
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView bookName;
        public ImageView bookImage;
        public TextView from;
        public TextView to;
        public TextView price;
        public TextView date;
        public TextView time;
        public TextView place;
        public ImageView toPhone;
        public ImageView fromPhone;

        public MyViewHolder(View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.bookName);
            bookImage = itemView.findViewById(R.id.bookImage);
            price = itemView.findViewById(R.id.price);

            from = itemView.findViewById(R.id.from);
            to = itemView.findViewById(R.id.to);
            toPhone = itemView.findViewById(R.id.toPhone);
            fromPhone =itemView.findViewById(R.id.fromPhone);

            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            place = itemView.findViewById(R.id.place);

        }

    }

}

