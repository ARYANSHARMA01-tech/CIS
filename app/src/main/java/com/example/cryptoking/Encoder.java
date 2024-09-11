package com.example.cryptoking;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Encoder extends AppCompatActivity {

    EditText etenc;
    TextView enctv;
    Spinner encodingSpinner;
    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);

        etenc = findViewById(R.id.etenc);
        enctv = findViewById(R.id.enctv);
        encodingSpinner = findViewById(R.id.spinner_encoding_type);
        cpb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void enc(View view) {
        String temp = etenc.getText().toString();
        String selectedEncoding = encodingSpinner.getSelectedItem().toString(); // Get selected encoding type
        String rv = encode.enc(temp, selectedEncoding);  // Pass both string and encoding type
        enctv.setText(rv);
    }

    public void cp2(View view) {
        String data = enctv.getText().toString();
        if (!data.isEmpty()) {
            ClipData temp = ClipData.newPlainText("text", data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this, "Copied", Toast.LENGTH_LONG).show();
        }
    }
}
