package com.example.resturantmariam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Loginfragmentcoustumer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Loginfragmentcoustumer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText etusername;
    private EditText etpassword;
    private Button etbtnlogin;
    private Button etbtnsignup;
    private ImageView etimageView;
    private TextView ettextView;
    private FirebaseAuth mAuth;

    public Loginfragmentcoustumer() {
        // Required empty public constructor
    }
    public void initialize() {
        etusername = getView().findViewById(R.id.username);
        etpassword = getView().findViewById(R.id.password);
        etbtnlogin = getView().findViewById(R.id.loginbt);
        etimageView = getView().findViewById(R.id.loginimage);
        etimageView.setImageResource(R.drawable.loginrest);
        ettextView = getView().findViewById(R.id.forgot);
        ettextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.forgot, new Forgetpassfragment());
                ft.commit();
                return;*/
            }
        });
        mAuth = FirebaseAuth.getInstance();

        etbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;

                username = etusername.getText().toString();

                password = etpassword.getText().toString();


                if (username.trim().isEmpty() || password.trim().isEmpty()) {
                    Toast.makeText(getContext(), "SOMTHING FAILED ! " + "", Toast.LENGTH_SHORT).show();
                    return;
                }
//FIRE BASE CONNECT
                if (mAuth != null) {
                    mAuth.signInWithEmailAndPassword(username, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(getContext(), "User signed in successfully.", Toast.LENGTH_SHORT).show();
                        } }) .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                        }   }  );
                }
            }
        });

//THE COUSTUMER HAVE TWO WAYS TO CREATE USER , THE FIRST WAY "IF THERE IS NI ACOUNT OTOMATIC GO THE CREATE USER" , "CLICK BUTTON SIGN UP"


        // NO USER (CREATE USER)
        etbtnsignup = getView().findViewById(R.id.sigtupbt);
        etbtnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.signup, new SignupFragment());
                ft.commit();*/


            }
        });
    }

//go to the menu


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Loginfragmentcoustumer.
     */
    // TODO: Rename and change types and number of parameters
    public static Loginfragmentcoustumer newInstance(String param1, String param2) {
        Loginfragmentcoustumer fragment = new Loginfragmentcoustumer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loginfragmentcoustumer, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initialize();

    }
}