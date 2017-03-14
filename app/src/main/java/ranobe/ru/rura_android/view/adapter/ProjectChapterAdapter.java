package ranobe.ru.rura_android.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.model.data.Volume;

public class ProjectChapterAdapter extends RecyclerView.Adapter<ProjectChapterAdapter.ViewHolder> {

  private static final String TAG = "CustomAdapter";
  private List<Volume> volumes = new ArrayList<>();

  public ProjectChapterAdapter(List<Volume> volumes) {
    Volume test = new Volume();
    test.setNameTitle("Неужели искать встречи в подземелье − неправильно? 1");
    volumes.add(0, test);
    Volume test1 = new Volume();
    test1.setNameTitle("Волчица и пряности 9: Город противостояния. Книга 2 из 2");
    volumes.add(1, test1);
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.chapter_element_layout, parent, false);

    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Volume volume = volumes.get(position);
    holder.volumeName.setText(volume.getNameTitle());
  }

  @Override public int getItemCount() {
    Log.d("Peka", String.valueOf(volumes.size()));
    return volumes.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    private TextView volumeName;

    public ViewHolder(View v) {
      super(v);
      volumeName = (TextView) v.findViewById(R.id.info_title_name);
      //v.setOnClickListener(v1 -> Log.d(TAG, "Element " + getAdapterPosition() + " clicked."));
    }
  }
}
