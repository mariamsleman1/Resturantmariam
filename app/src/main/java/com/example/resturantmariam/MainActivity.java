package com.example.resturantmariam;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import org.w3c.dom.Text;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
      private ImageView etimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
    }

    private void connect() {
        etimage=findViewById(R.id.restlogo);
        etimage.setImageResource(R.drawable.aseelsrest);


    }

    public void employee(View view) {
    }

    public void maneger(View view) {
    }

    public void coustumer(View view) {
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMAIN, new Loginfragmentcoustumer());
        ft.commit();
    }


    }
