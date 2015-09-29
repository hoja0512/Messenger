package com.jason.messenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {
    //createmessage gets text and passes it along to receive message activity which displays it.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    public void onSendMessage(View view){

        EditText messageView = (EditText) findViewById(R.id.message); //gets edittext object from the xml
        String messageText = messageView.getText().toString();//converts the edittext object to string
        //Intent intent = new Intent(this,ReceiveMessageActivity.class); //intents are used to tell another activity to start. this creates the intent object.
        //intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText); //extra message you can pass along to second activity using intent.
        Intent intent = new Intent (Intent.ACTION_SEND); //sends an action intent to Android
        intent.setType("text/plain"); //android sees that intent can only be passed to activities able to handle action_send and text/plain data. android displays options
        intent.putExtra(Intent.EXTRA_TEXT, messageText);

        startActivity(intent); //this method start receivemessage activity with the intent that was created.


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_message, menu);
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
