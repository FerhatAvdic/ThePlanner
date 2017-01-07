package com.example.ferhat.planner;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {
    Button goToDos;
    Button goRemainders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        goToDos = (Button) findViewById(R.id.goToDo);
        goToDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ToDoActivity.class);
                startActivity(intent);
            }
        });
        goRemainders = (Button) findViewById(R.id.goRemainder);
        goRemainders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, RemainderActivity.class);
                startActivity(intent);
            }
        });
    }
}
