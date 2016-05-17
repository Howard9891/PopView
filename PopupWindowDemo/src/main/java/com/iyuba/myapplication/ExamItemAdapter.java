package com.iyuba.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/4/20.
 */
public class ExamItemAdapter extends BaseAdapter {

    public List<String> datas = new ArrayList<String>();
    public ExamItemAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String year = datas.get(position);
        ViewHolder holder ;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(parent.getContext(),R.layout.item_listview,null);
             holder.tv_exam = (TextView) convertView.findViewById(R.id.tv_exam);
             convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_exam.setText(year);

        return convertView;
    }


    public class ViewHolder{
        public TextView tv_exam;
    }
}
