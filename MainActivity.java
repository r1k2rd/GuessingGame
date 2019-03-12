package com.richardriispere.mygrocerylist.guessinggame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editNumber;
    private Button guessButton;
    private TextView result;

    private int randomNumber;

    public void checkNumber(){

        String guess = editNumber.getText().toString();

        try{
            int theNumber = Integer.parseInt(guess);

            if(theNumber > randomNumber){
                result.setText("Too high");
            }
            else if(theNumber < randomNumber){
                result.setText("Too low");
            }
            else{
                result.setText("Congrats! You guessed it!");
                newGame();
            }

        }catch (Exception e){
            result.setText("Enter a number between 1-100");
        }
        finally {
            editNumber.requestFocus();
            editNumber.selectAll();
        }

    }

    public void newGame(){
        randomNumber = (int)(Math.random() * 100 + 1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = (EditText) findViewById(R.id.EnterNrID);
        guessButton = (Button) findViewById(R.id.ButtonID);
        result = (TextView) findViewById(R.id.ResultID);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        newGame();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNumber();
            }
        });

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
