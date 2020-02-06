package com.example.cookingdiary;

import android.content.Context;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.MyApplication;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable {


    private List<Ricetta> ricettas;
    private Context context;
    private List<Ricetta> ricettasFull;




    public RecyclerViewAdapter(List<Ricetta> ricettas, Context context) {
        this.ricettas = ricettas;
        this.context = context;
        ricettasFull = new ArrayList<>(ricettas);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {
        Ricetta ricetta = ricettas.get(i);
        String s = ricetta.getIngredienti().toString();
        s = s.substring(1, s.length()-1);
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(MyApplication.getAppContext());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
        UniversalImageLoader.setImage(ricetta.getImage1(), myViewHolder.imageView, null);
        myViewHolder.title.setText(ricetta.getTitolo());
        myViewHolder.paroleChiave.setText(ricetta.getParoleChiave());
        myViewHolder.ingredienti.setText(s);
        myViewHolder.touchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sendObject(context, i);
                notifyItemChanged(myViewHolder.getAdapterPosition());

            }
        });
    }

    @Override
    public int getItemCount() {
        return ricettas.size();
    }

    @Override
    public Filter getFilter() {
        return ricettaFilter;
    }

    private Filter ricettaFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Ricetta> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0)
                filteredList.addAll(ricettasFull);
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Ricetta ricettaItem : ricettasFull) {
                    if (ricettaItem.getTitolo().toLowerCase().contains(filterPattern) ||
                            ricettaItem.getParoleChiave().toLowerCase().contains(filterPattern) ||
                            ricettaItem.getIngredienti().toString().toLowerCase().contains(filterPattern))
                        filteredList.add(ricettaItem);
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            ricettas.clear();
            ricettas.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title, paroleChiave, ingredienti;
        private ImageView imageView;
        private RelativeLayout touchLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ImmagineLista);
            title = itemView.findViewById(R.id.titoloListText);
            ingredienti = itemView.findViewById(R.id.ingredientiList);
            paroleChiave = itemView.findViewById(R.id.paroleChiaveListText);
            touchLayout = itemView.findViewById(R.id.touchLayout);
        }
    }

}
