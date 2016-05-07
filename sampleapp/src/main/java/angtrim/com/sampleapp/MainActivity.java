package angtrim.com.sampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import angtrim.com.fivestarslibrary.FiveStarsDialog;
import angtrim.com.fivestarslibrary.NegativeReviewListener;
import angtrim.com.fivestarslibrary.ReviewListener;


public class MainActivity extends AppCompatActivity implements NegativeReviewListener, ReviewListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this,"destpstrzy@gmail.com");
        fiveStarsDialog.setRateText("Your custom text")
                .setTitle("Your custom title")
                .setStyle(R.style.DialogTheme)
                .setForceMode(false)
                .setUpperBound(3)
                .setShowOnZeroStars(true)
                .setNegativeReviewListener(this)
                .setReviewListener(this)
                .showAfter(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNegativeReview(int stars) {
        Log.d(TAG, "Negative review " + stars);
        Toast.makeText(this,"You gave my app a bad review, bas***!!11!!!",Toast.LENGTH_LONG);
    }

    @Override
    public void onReview(int stars) {
        Log.d(TAG, "Review " + stars);
    }
}
