package id.ac.budiluhur.bukabuku.features.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


import id.ac.budiluhur.bukabuku.R;
import id.ac.budiluhur.bukabuku.base.mvp.MvpActivity;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {

    FloatingActionButton fb;
    EditText edtKodeISBN;
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fb = (FloatingActionButton) findViewById(R.id.fab);
        edtKodeISBN = (EditText) findViewById(R.id.edt_kodeisbn);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null)
        {
            if (result.getContents() == null)
            {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_SHORT).show();
            }
            else
            {
                edtKodeISBN.setText(result.getContents());
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
