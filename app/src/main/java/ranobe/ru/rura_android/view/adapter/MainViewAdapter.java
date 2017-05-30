package ranobe.ru.rura_android.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import ranobe.ru.rura_android.R;
import ranobe.ru.rura_android.presenter.vo.Preview;
import ranobe.ru.rura_android.view.ProjectActivity;

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder> {

  private final static String PROJECT_ID = "PROJECT_ID";
  private final static String PROJECT_URL = "PROJECT_URL";
  private List<Preview> previews = new ArrayList<>();
  private Context context;

  public void setProjects(List<Preview> previews) {
    this.previews = previews;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.main_card_view, viewGroup, false);
    context = viewGroup.getContext();
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(MainViewAdapter.ViewHolder holder, int position) {
    Preview preview = previews.get(position);
    holder.name.setText(preview.getProjectName());
    holder.author.setText(preview.getAuthor());
    Glide
        .with(holder.banner.getContext())
        .load("http:" + preview.getUrlBanner())
        .override(425, 120)
        .into(holder.banner);

    Intent intent = new Intent(context, ProjectActivity.class);
    intent.putExtra(PROJECT_ID, preview.getProjectId());
    intent.putExtra(PROJECT_URL, preview.getProjectUrl());

    holder.itemView.setOnClickListener(view -> context.startActivity(intent));
  }

  @Override public int getItemCount() {
    return previews.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.projectName) TextView name;
    @BindView(R.id.authorName) TextView author;
    @BindView(R.id.banner) ImageView banner;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
