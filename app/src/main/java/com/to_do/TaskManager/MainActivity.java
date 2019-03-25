package com.to_do.TaskManager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    AppDatabase db;

    FloatingActionButton fab;
    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        adapter = new TaskAdapter(db.userDao().getAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateTask.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_ids:
                db.userDao().delete();
                startActivity(new Intent(MainActivity.this, CreateTask.class));
                return true;


        }
        return true;
    }


        private void addNotification() {
            Notification.Builder nBuilder =new Notification.Builder(this);
            nBuilder.setSmallIcon(android.R.drawable.ic_dialog_email);
            nBuilder.setContentTitle("To-do list");
            List<Task>uncheckedTasks=db.userDao().getUnChecked();
            int listSize=uncheckedTasks.size();
            nBuilder.setContentText("The unchecked tasks number is"+listSize);
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            nBuilder.setSound(uri);
            NotificationManager notificationManager=
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent i =new Intent(this,MainActivity.class);
            PendingIntent pendingIntent =PendingIntent.getActivity(this, 0,i,0);
            nBuilder.setContentIntent(pendingIntent);

            notificationManager.notify(4,nBuilder.build());
            nBuilder.setAutoCancel(true);
        }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        addNotification();

    }

}
