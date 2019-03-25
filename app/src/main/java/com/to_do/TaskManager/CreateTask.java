package com.to_do.TaskManager;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by danielmalone on 10/27/17.
 */

public class CreateTask extends AppCompatActivity {

    public  static AppDatabase db;
    EditText title;
    EditText description;

    Button button;
    public static Task task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        button = findViewById(R.id.button);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               task = new Task(title.getText().toString(), description.getText().toString(),0);
                db.userDao().insert(task);
                startActivity(new Intent(CreateTask.this, MainActivity.class));
            }
        });
    }

}
