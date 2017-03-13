package ranobe.ru.rura_android.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Project;

public class ProjectChapterAdapter extends RecyclerView.Adapter<ProjectChapterAdapter.ViewHolder> {

  private static final String TAG = "CustomAdapter";
  private List<Project> projects = new ArrayList<>();


  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public ViewHolder(View v) {
      super(v);
      // Define click listener for the ViewHolder's View.
      v.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
        }
      });
      textView = (TextView) v.findViewById(R.id.textView);
    }

    public TextView getTextView() {
      return textView;
    }
  }
}
