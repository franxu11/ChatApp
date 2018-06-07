package com.android.teaching.chatapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChatActivity extends AppCompatActivity {

    private EditText username;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        //Detectar si tenemos conectividad.
        ConnectivityManager myConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo myNetworkInfo = myConnectivityManager.getActiveNetworkInfo();
        boolean hasConnectivity = myNetworkInfo != null && myNetworkInfo.isConnectedOrConnecting();




        FirebaseDatabase database =FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("messages").child("text").child("username"); //Esto ultimo lo he añadido pero nada. D:

        myRef.setValue("otraprueba");


       /* FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference chatDatabaseReference = database.getReference("messages");
        chatDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Aquí recibimos los datos de la base de datos
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Algún error ha ocurrido
            }
        }); */



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myInflater = getMenuInflater();
        myInflater.inflate(R.menu.menu_activity_chat, menu);
        return true;
    }

    //Me aparece en el preview pero no en la activity. 

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent newMessageIntent = new Intent(this, NewMessageActivity.class);
        startActivity(newMessageIntent);
        return super.onOptionsItemSelected(item);
    }


}
