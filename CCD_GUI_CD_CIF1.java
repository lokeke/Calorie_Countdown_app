package ese.com.caloriecountdownappforandroidbrown;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;

public class CCD_GUI_CD_CIF1 extends AppCompatActivity
{
    private static final String webadress = "https://web2.0calc.com/";
    private static final String CALCULATOR_PACKAGE_NAME = "com.android.calculator2";
    private static final String CALCULATOR_CLASS_NAME = "com.android.calculator2.Calculator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccd__gui__cd__cif1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Update your Food Diary", Snackbar.LENGTH_LONG)
                        .setAction("Update", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ccd__gui__cd__cif1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.sub_submenuitem1)
        {

            StartWebCalculatorFragment2();

            return true;
        }

        if (id == R.id.sub_submenuitem2)
        {

            Start_Native_Calculator();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void StartWebCalculatorFragment2()
    {

        Uri uri = Uri.parse(webadress);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

        //CancelAlarm();

    }



    private void Start_Native_Calculator()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setComponent(new android.content.ComponentName(CALCULATOR_PACKAGE_NAME, CALCULATOR_CLASS_NAME));
        try
        {
            this.startActivity(intent);
        }
        catch (android.content.ActivityNotFoundException noSuchActivity)
        {
            // handle exception where calculator intent filter is not registered
        }
    }
}
