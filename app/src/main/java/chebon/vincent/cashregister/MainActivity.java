package chebon.vincent.cashregister;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import chebon.vincent.cashregister.databinding.ActivityMainBinding;

/**
 * Launcher Activity Class
 *
 * An entry point class to our app
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Entry point of the app life cycle
     *
     * Here we bind the main activity with navigation jetcompose component.
     * to load the Cash Fragment activity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
    }
}