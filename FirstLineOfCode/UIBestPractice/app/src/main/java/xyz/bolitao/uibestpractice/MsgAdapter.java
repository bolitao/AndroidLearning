package xyz.bolitao.uibestpractice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    //    private List<Msg> msgList;
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        LinearLayout leftLayout;
//        LinearLayout rightLayout;
//        TextView leftMsg;
//        TextView rightMsg;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            leftLayout = itemView.findViewById(R.id.left_layout);
//            rightLayout = itemView.findViewById(R.id.right_layout);
//            leftMsg = itemView.findViewById(R.id.left_msg);
//            rightMsg = itemView.findViewById(R.id.right_msg);
//        }
//    }
//
//    public MsgAdapter(List<Msg> msgList) {
//        msgList = msgList;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_item, viewGroup, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        Msg msg = msgList.get(i);
//        if (msg.getType() == Msg.TYPE_RECEIVED) {
//            viewHolder.leftLayout.setVisibility(View.VISIBLE);
//            viewHolder.rightLayout.setVisibility(View.GONE);
//            viewHolder.leftMsg.setText(msg.getContent());
//        } else if (msg.getType() == Msg.TYPE_SENT) {
//            viewHolder.rightLayout.setVisibility(View.VISIBLE);
//            viewHolder.leftLayout.setVisibility(View.GONE);
//            viewHolder.rightMsg.setText(msg.getContent());
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return msgList.size();
//    }
    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMsg;

        TextView rightMsg;

        public ViewHolder(View view) {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            leftMsg = (TextView) view.findViewById(R.id.left_msg);
            rightMsg = (TextView) view.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            // 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SENT) {
            // 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
