package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.duzeming.noter.R;

import java.util.List;

/**
 * Created by DuZeming on 2017/2/22.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<String>titleList;
    private List<String>noteList;
    private List<String>writeTime;
    private List<String>finishTime;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    public RecyclerAdapter(Context context,List<String>titleList
            ,List<String>noteList,List<String>writeTime,List<String>finishTime){
        this.context=context;
        this.titleList=titleList;
        this.noteList=noteList;
        this.writeTime=writeTime;
        this.finishTime=finishTime;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_note,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }
    public void addData(int pos){
        notifyItemInserted(pos);
    }
    public void removeData(int pos){
        notifyItemRemoved(pos);
    }

    public void upDate(List<String > titleList,List<String > noteList,List<String > writeTime,
                       List<String > finishTime){
        this.titleList=titleList;
        this.noteList=noteList;
        this.writeTime=writeTime;
        this.finishTime=finishTime;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.title.setText(titleList.get(position));
        holder.note.setText(noteList.get(position));
        holder.writeTime.setText(writeTime.get(position));
        holder.finishTime.setText(finishTime.get(position));

        if(onItemClickListener!=null){

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(holder.itemView,position);
            }
        });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onItemLongClick(holder.itemView,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    TextView title;
    TextView note;
    TextView writeTime;
    TextView finishTime;


    public MyViewHolder(View itemView){
        super(itemView);
        title= (TextView) itemView.findViewById(R.id.tv_view_title);
        note= (TextView) itemView.findViewById(R.id.tv_view_note);
        writeTime= (TextView) itemView.findViewById(R.id.tv_view_writetime);
        finishTime= (TextView) itemView.findViewById(R.id.tv_view_finishtime);


    }
}