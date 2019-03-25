package com.to_do.TaskManager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by danielmalone on 10/27/17.
 */

class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private static final String TAG ="b" ;
    private List<Task> tasks;
    private List<Task>list;


    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int position) {
       holder.title.setText(tasks.get(position).tiltle);
        holder.description.setText(tasks.get(position).description);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView description;
        public  CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
             checkBox=itemView.findViewById(R.id.list_checkbox);



        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
