package com.example.todoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.APIClient;
import model.RestController;
import model.Task;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private Button newTask;
    RestController restController;
    final List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTheme(R.style.ShowAlertDialogTheme);

        restController = APIClient.getClient().create(RestController.class);

        final ListView listView = findViewById(R.id.listView);
        //  final TextAdapter textAdapter = new TextAdapter();

        //   textAdapter.setData(list);
        //   listView.setAdapter(textAdapter);

        newTask = findViewById(R.id.newTask);

        newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText title = new EditText(MainActivity.this);
                final EditText taskInput = new EditText(MainActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add a New Task")
                        .setMessage("You Can Enter Your Task Here!")
                        .setView(taskInput)
                        .setPositiveButton("Add Task", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // list.add(taskInput.getText().toString());
                                // textAdapter.setData(list);

                                final Task task = new Task("hvdghcvvcdc");
                                Call<Task> call = restController.createTask(task);
                                call.enqueue(new Callback<Task>() {
                                    @Override
                                    public void onResponse(Call<Task> call, Response<Task> response) {
                                        String taskBody = taskInput.getText().toString();
                                        Toast.makeText(getApplicationContext(), taskBody +"\nwas created!", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<Task> call, Throwable t) {
                                        call.cancel();
                                    }
                                });
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });


    }
/**
 class TextAdapter extends BaseAdapter {


 List<String> list = new ArrayList<>();

 void setData(List<String> List) {
 list.clear();
 list.addAll(List);
 notifyDataSetChanged();
 }

 @Override public int getCount() {
 return list.size();
 }

 @Override public Object getItem(int position) {
 return null;
 }

 @Override public long getItemId(int position) {
 return 0;
 }

 @Override public View getView(int position, View convertView, ViewGroup parent) {
 final LayoutInflater inflater = (LayoutInflater)
 MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 final View rowView = inflater.inflate(R.layout.itemlist, parent, false);
 final TextView text = rowView.findViewById(R.id.task);
 text.setText(list.get(position));
 return rowView;
 }
 }
 */


}
