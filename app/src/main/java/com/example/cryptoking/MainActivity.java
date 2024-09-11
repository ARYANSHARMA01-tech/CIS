package com.example.cryptoking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button enc, dec, abt;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        enc = findViewById(R.id.encd);
        dec = findViewById(R.id.decd);
        vf = findViewById(R.id.vf);  // Initialize the ViewFlipper

        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temp = new Intent(MainActivity.this, Encoder.class);
                startActivity(temp);
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temp = new Intent(MainActivity.this, Decoder.class);
                startActivity(temp);
            }
        });

        // Array of images to be used in the ViewFlipper
        int images[] = {R.drawable.bellaso_cipher, R.drawable.caesar_cipher_encryption, R.drawable.dorabella_cipher};

        // Loop through images and call the flipper function
        for (int i = 0; i < images.length; i++) {
            flipper(images[i]);
        }
    }

    // Method to add images to ViewFlipper
    public void flipper(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vf.addView(imageView);
        vf.setFlipInterval(3000);  // Set the flipping interval (3 seconds)
        vf.setAutoStart(true);     // Start automatically
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
