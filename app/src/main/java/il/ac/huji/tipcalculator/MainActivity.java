package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import java.lang.String;
import android.widget.CheckBox;






public class MainActivity extends ActionBarActivity {
    Button button;
    EditText result;
    EditText input;
    CheckBox roundCheckbox;
    double tipPercent = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick();

//       final Button btn = (Button)findViewById(R.id.btnCalculate);
//       btn.setOnClickListener(new OnClickListener() {/* Some Code */ });
         btnClick();
    }

    public void btnClick() {

        button = (Button) findViewById(R.id.btnCalculate);
        result = (EditText) findViewById(R.id.txtTipResult);
        input = (EditText) findViewById(R.id.edtBillAmount);
        roundCheckbox = (CheckBox) findViewById(R.id.chkRound);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String inputNumber = input.getText().toString();
                if (!inputNumber.matches("")) {
                    result.setText(calculate(inputNumber, roundCheckbox.isChecked()));
                }
            }
        });
    }

    public String calculate(String input, Boolean round) {
        double dInput = Double.parseDouble(input);
        double result = (dInput / 100)*tipPercent;
        if(round){
            result = Math.round(result);
        }
        result=(double)Math.round(result * 10000) / 10000;
        String sResult = String.valueOf(result);
        //String sResult = String.format("%.2g%n", result);
        return  "$"+sResult;
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


}
