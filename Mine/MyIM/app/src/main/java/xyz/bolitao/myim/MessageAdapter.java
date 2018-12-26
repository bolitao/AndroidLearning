package xyz.bolitao.myim;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<Message> messageList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout receiveLayout;
        RelativeLayout sendLayout;
        TextView receiveMessage;
        TextView sendMessage;

        public ViewHolder(View view) {
            super(view);
            receiveLayout = view.findViewById(R.id.their_message_layout);
            sendLayout = view.findViewById(R.id.send_message_layout);
            receiveMessage = view.findViewById(R.id.their_message_body);
            sendMessage = view.findViewById(R.id.my_message_body);
        }
    }

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (message.getType() == Message.TYPE_RECEIVED) {
            holder.receiveLayout.setVisibility(View.VISIBLE);
            holder.sendLayout.setVisibility(View.GONE);
            holder.receiveMessage.setText(message.getMessageContent());
        } else if (message.getType() == Message.TYPE_SEND) {
            holder.receiveLayout.setVisibility(View.GONE);
            holder.sendLayout.setVisibility(View.VISIBLE);
            holder.sendMessage.setText(message.getMessageContent());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
