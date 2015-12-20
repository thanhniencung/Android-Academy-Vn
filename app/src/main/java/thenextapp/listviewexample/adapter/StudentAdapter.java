package thenextapp.listviewexample.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import thenextapp.listviewexample.R;
import thenextapp.listviewexample.helper.ImageHelper;
import thenextapp.listviewexample.model.Student;

/**
 * Created by Sandy on 12/20/15.
 */
public class StudentAdapter extends BaseAdapter {

    private Activity mActivity;
    private List<Student> mStudentList;

    LayoutInflater inflater;

    public StudentAdapter(Activity activity, List<Student> studentList) {
        mActivity = activity;
        mStudentList = studentList;

        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mStudentList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStudentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class StudentHolder {
        public ImageView ivAvatar;
        public TextView tvStudentName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final StudentHolder studentHolder;

        if (convertView == null) {
            // init layout
            studentHolder = new StudentHolder();
            convertView = inflater.inflate(R.layout.adapter_student, parent, false);
            studentHolder.ivAvatar = (ImageView) convertView.findViewById(R.id.student_avatar);
            studentHolder.tvStudentName = (TextView) convertView.findViewById(R.id.student_name);

            convertView.setTag(studentHolder);
        } else {
            studentHolder = (StudentHolder) convertView.getTag();
        }

        studentHolder.tvStudentName.setText(mStudentList.get(position).getName());

        new AsyncTask<Void, Void, Void>() {

            Bitmap bm;

            @Override
            protected Void doInBackground(Void... params) {
                bm = ImageHelper.getBitmapFromURL(mStudentList.get(position).getAvatar());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (bm != null) {
                    studentHolder.ivAvatar.setImageBitmap(bm);
                } else {
                    studentHolder.ivAvatar.setImageResource(R.drawable.avatar_default);
                }
            }

        }.execute();

        return convertView;
    }
}
