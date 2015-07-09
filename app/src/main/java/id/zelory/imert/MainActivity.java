package id.zelory.imert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Spinner spinner;
    TextView widthInitial, heightInitial;
    ImageView warningWidth, warningHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.asset_spinner);
        widthInitial = (TextView) findViewById(R.id.width_initial);
        heightInitial = (TextView) findViewById(R.id.height_initial);
        warningHeight = (ImageView) findViewById(R.id.warning_heiht);
        warningWidth = (ImageView) findViewById(R.id.warning_width);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.asset_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    /**
     * Display asset size
     *
     * @param view
     */
    public void displayAssetSize(View view)
    {
        if (widthInitial.getText().toString().equals(""))
        {
            warningWidth.setVisibility(View.VISIBLE);
            warningHeight.setVisibility(View.INVISIBLE);
        } else if (heightInitial.getText().toString().equals(""))
        {
            warningWidth.setVisibility(View.INVISIBLE);
            warningHeight.setVisibility(View.VISIBLE);
        } else
        {
            warningWidth.setVisibility(View.INVISIBLE);
            warningHeight.setVisibility(View.INVISIBLE);
            cekSpinner();
            ScrollView scrollView = (ScrollView) findViewById(R.id.asset_scroll_view);
            scrollView.setVisibility(View.VISIBLE);
        }

    }

    public void cekSpinner()
    {
        if(spinner.getSelectedItem().toString().equals("xxhdpi"))
        {
            hitung(3.0);
        }
        else if(spinner.getSelectedItem().toString().equals("xhdpi"))
        {
            hitung(2.0);
        }
        else if (spinner.getSelectedItem().toString().equals("hdpi"))
        {
            hitung(1.5);
        }
        else if(spinner.getSelectedItem().toString().equals("mdpi"))
        {
            hitung(1.0);
        }
        else if(spinner.getSelectedItem().toString().equals("ldpi"))
        {
            hitung(0.75);
        }
    }
    public void hitung(double x)
    {
        TextView widthXxhdpi,widthXhdpi,widthHdpi,widthMdpi,widthLdpi,heightXxhdpi,heightXhdpi,heightHdpi,heightMdpi,heightLdpi;
        double w0 = Double.parseDouble(widthInitial.getText().toString());
        double h0 = Double.parseDouble(heightInitial.getText().toString());

        //find view by id and set text
        widthXxhdpi = (TextView) findViewById(R.id.width_xxhdpi);
        widthXxhdpi.setText("width\t:\t"+ (w0/x)*3);
        heightXxhdpi = (TextView) findViewById(R.id.height_xxhdpi);
        heightXxhdpi.setText("height\t:\t"+ (h0/x)*3);

        widthXhdpi = (TextView) findViewById(R.id.width_xhdpi);
        widthXhdpi.setText("width\t:\t"+ (w0/x)*2);
        heightXhdpi = (TextView) findViewById(R.id.height_xhdpi);
        heightXhdpi.setText("height\t:\t"+ (h0/x)*2);

        widthHdpi = (TextView) findViewById(R.id.width_hdpi);
        widthHdpi.setText("width\t:\t"+ (w0/x)*1.5);
        heightHdpi = (TextView) findViewById(R.id.height_hdpi);
        heightHdpi.setText("height\t:\t"+ (h0/x)*1.5);

        widthMdpi = (TextView) findViewById(R.id.width_mdpi);
        widthMdpi.setText("width\t:\t"+ (w0/x)*1);
        heightMdpi = (TextView) findViewById(R.id.height_mdpi);
        heightMdpi.setText("height\t:\t"+ (h0/x)*1);

        widthLdpi = (TextView) findViewById(R.id.width_ldpi);
        widthLdpi.setText("width\t:\t"+ (w0/x)*0.75);
        heightLdpi = (TextView) findViewById(R.id.height_ldpi);
        heightLdpi.setText("height\t:\t"+ (h0/x)*0.75);

    }
}
