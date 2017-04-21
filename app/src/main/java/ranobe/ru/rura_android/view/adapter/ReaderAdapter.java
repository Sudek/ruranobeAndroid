package ranobe.ru.rura_android.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ranobe.ru.rura_android.R;

public class ReaderAdapter extends RecyclerView.Adapter<ReaderAdapter.ReaderViewHolder>{

  @Override public ReaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.text_layout, parent, false);
    //context = viewGroup.getContext();
    return new ReaderViewHolder(view);
  }

  @Override public void onBindViewHolder(ReaderViewHolder holder, int position) {
    holder.textView.setText("Гигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небеГигантская крепость из камня и стали, парящая в бескрайнем небе");

  }

  @Override public int getItemCount() {
    return 3;
  }

  class ReaderViewHolder extends RecyclerView.ViewHolder{
    private TextView textView;
    public ReaderViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(R.id.reader_text);
    }
  }
}
