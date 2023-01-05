package chebon.vincent.cashregister;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Cash Adapter
 *
 * An adapter to access the data and connect the data with
 * the UI using a recycler view.
 */
public class CashAdapter extends RecyclerView.Adapter<CashAdapter.ViewHolder> {
    private final ArrayList<CashModel> cashLists;

    /**
     * Constructor
     *
     * Pass the data as an array list from the UI to this adapter
     *
     * @param cashModelArrayList
     */
    public CashAdapter(ArrayList<CashModel> cashModelArrayList) {
        this.cashLists = cashModelArrayList;
    }

    /**
     * Here we get the layout view and prepairing to receive the data
     *
     * @param parent
     * @param viewType
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.price_list_item, parent, false);
        return new ViewHolder(v);
    }

    /**
     * Bind the view with data
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CashAdapter.ViewHolder holder, int position) {
        CashModel cashModel = cashLists.get(position);
        holder.textViewPrice.setText(String.format(Locale.getDefault(),"KSH %.2f", cashModel.getPrice()));
    }

    @Override
    public int getItemCount() {
        return cashLists.size();
    }

    /**
     * Here we hold the view to set the price per item in the array list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPrice = itemView.findViewById(R.id.prices);
        }
    }
}
