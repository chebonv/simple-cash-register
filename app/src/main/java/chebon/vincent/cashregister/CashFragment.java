package chebon.vincent.cashregister;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import java.util.ArrayList;
import java.util.Locale;

import chebon.vincent.cashregister.databinding.FragmentCashBinding;

/**
 * Cash Fragment Activity
 *
 * This fragment class handles actions and events in UI
 */
public class CashFragment extends Fragment {

    private FragmentCashBinding binding;
    private String price;
    private RecyclerView cash_lists;
    private CashAdapter adapter;
    private ArrayList<CashModel> cashLists;

    /**
     * Removing the last char in the string.
     *
     * @param s - The actual price keyed in
     * @return price
     */
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }

    /**
     * Adds the price to the array list and update the UI
     *
     * @param s - The actual price keyed in.
     * @param view - UI
     */
    public void add(String s, View view) {
        if (s != null && s.length() > 0) {
            CashModel cashModel = new CashModel();
            cashModel.setPrice(Double.parseDouble(s));
            cashLists.add(cashModel);
            adapter.notifyDataSetChanged();
            sum(cashLists, view);
        }
    }

    /**
     * Sum the prices as added by the user from the array list.
     *
     * @param cashLists - A price array list
     * @param view - UI
     */
    private void sum(ArrayList<CashModel> cashLists, View view) {
        double sum = 0;
        for (int i = 0; i < cashLists.size(); i++) {
            CashModel cashModel = cashLists.get(i);
            sum += cashModel.getPrice();
        }

        TextView textViewTotal = view.findViewById(R.id.total);
        textViewTotal.setText(String.format(Locale.getDefault(), "KSH %.2f", sum));
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCashBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button_ui(view);

        cash_lists_ui(view);
    }

    /**
     * Setup the recycler view and connect the data from the array list
     *
     * @param view - UI
     */
    private void cash_lists_ui(View view) {
        cashLists = new ArrayList<>();

        cash_lists = view.findViewById(R.id.cash_list_recyclerview);
        LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        cash_lists.setLayoutManager(mLayoutManager);

        adapter = new CashAdapter(cashLists);
        cash_lists.setAdapter(adapter);
    }

    /**
     * Setup the number buttons UI
     *
     * @param view - UI
     */
    private void button_ui(View view) {
        Button btn_1 = view.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(view1 -> {
            if (price != null)
                price += "1";
            else
                price = "1";
            show_on_input_field_ui(price, view);
        });
        Button btn_2 = view.findViewById(R.id.btn_2);
        btn_2.setOnClickListener(view1 -> {
            if (price != null)
                price += "2";
            else
                price = "2";
            show_on_input_field_ui(price, view);
        });
        Button btn_3 = view.findViewById(R.id.btn_3);
        btn_3.setOnClickListener(view1 -> {
            if (price != null)
                price += "3";
            else
                price = "3";
            show_on_input_field_ui(price, view);
        });
        Button btn_4 = view.findViewById(R.id.btn_4);
        btn_4.setOnClickListener(view1 -> {
            if (price != null)
                price += "4";
            else
                price = "4";
            show_on_input_field_ui(price, view);
        });
        Button btn_5 = view.findViewById(R.id.btn_5);
        btn_5.setOnClickListener(view1 -> {
            if (price != null)
                price += "5";
            else
                price = "5";
            show_on_input_field_ui(price, view);
        });
        Button btn_6 = view.findViewById(R.id.btn_6);
        btn_6.setOnClickListener(view1 -> {
            if (price != null)
                price += "6";
            else
                price = "6";
            show_on_input_field_ui(price, view);
        });
        Button btn_7 = view.findViewById(R.id.btn_7);
        btn_7.setOnClickListener(view1 -> {
            if (price != null)
                price += "7";
            else
                price = "7";
            show_on_input_field_ui(price, view);
        });
        Button btn_8 = view.findViewById(R.id.btn_8);
        btn_8.setOnClickListener(view1 -> {
            if (price != null)
                price += "8";
            else
                price = "8";
            show_on_input_field_ui(price, view);
        });
        Button btn_9 = view.findViewById(R.id.btn_9);
        btn_9.setOnClickListener(view1 -> {
            if (price != null)
                price += "9";
            else
                price = "9";
            show_on_input_field_ui(price, view);
        });
        Button btn_0 = view.findViewById(R.id.btn_0);
        btn_0.setOnClickListener(view1 -> {
            if (price != null)
                price += "0";
            else
                price = "0";
            show_on_input_field_ui(price, view);
        });
        Button btn_add = view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(view1 -> {
            add(price, view);
        });
        Button btn_del = view.findViewById(R.id.btn_del);
        btn_del.setOnClickListener(view1 -> {
            price = removeLastChar(price);
            show_on_input_field_ui(price, view);
        });
    }

    /**
     * Updates the price text field as number buttons are clicked.
     *
     * @param price - The actual price value
     * @param view - UI
     */
    private void show_on_input_field_ui(String price, View view) {
        EditText edt_price_field = view.findViewById(R.id.price_view);
        if (price != null && price.length() < 7)
            edt_price_field.setText(price);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}