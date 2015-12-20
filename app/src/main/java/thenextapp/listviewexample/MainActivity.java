package thenextapp.listviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import thenextapp.listviewexample.adapter.StudentAdapter;
import thenextapp.listviewexample.mockup.Test;
import thenextapp.listviewexample.model.Student;

public class MainActivity extends AppCompatActivity {

    private List<Student> studentList = new ArrayList<Student>();
    private LinearLayout llNavigation;
    private ImageView ivMenu;
    private ImageView ivClose;
    private Animation slideToRight;
    private Animation slideToLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        llNavigation = (LinearLayout) super.findViewById(R.id.myNavigation);
        ivMenu = (ImageView) super.findViewById(R.id.app_menu);
        ivClose = (ImageView) super.findViewById(R.id.close);
        ListView listView = (ListView) super.findViewById(R.id.listview);

        // init student data
        studentList = Test.getStudentList();

        // init adapter
        StudentAdapter studentAdapter = new StudentAdapter(this, studentList);

        // set adapter for listview
        listView.setAdapter(studentAdapter);

        slideToRight = AnimationUtils.loadAnimation(this, R.anim.slide_ltr);
        slideToLeft = AnimationUtils.loadAnimation(this, R.anim.slide_rtl);

        slideToRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                llNavigation.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        slideToLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                llNavigation.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llNavigation.setVisibility(View.VISIBLE);
                llNavigation.startAnimation(slideToRight);
            }
        });

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llNavigation.startAnimation(slideToLeft);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, studentList.get(position).getWebSite(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AuthorActivity.class);
                intent.putExtra(AuthorActivity.AUTHOR_AVATAR, studentList.get(position).getAvatar());
                intent.putExtra(AuthorActivity.AUTHOR_TITLE, studentList.get(position).getName());
                intent.putExtra(AuthorActivity.AUTHOR_WEBSITE, studentList.get(position).getWebSite());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        llNavigation.setVisibility(View.GONE);
    }
}
