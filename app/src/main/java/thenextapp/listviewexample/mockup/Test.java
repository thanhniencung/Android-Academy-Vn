package thenextapp.listviewexample.mockup;

import java.util.ArrayList;
import java.util.List;

import thenextapp.listviewexample.model.Student;

/**
 * Created by Sandy on 12/20/15.
 */
public class Test {
    public static List<Student> getStudentList() {

        List<Student> studentList = new ArrayList<Student>();

        Student s = new Student();
        s.setName("Roman Nurik");
        s.setWebSite("http://roman.nurik.net/");
        s.setAvatar("http://androidweekly.net/assets/landingpage/testimonials/nurik-ef032225a9cfce1822d4058faa9fd8be.jpg");
        studentList.add(s);

        Student s1 = new Student();
        s1.setName("Lars Vogel");
        s1.setWebSite("http://vogella.com/");
        s1.setAvatar("http://androidweekly.net/assets/landingpage/testimonials/vogel-da91ed7332cec928853044a3817c25a2.jpg");
        studentList.add(s1);

        Student s2 = new Student();
        s2.setName("Mark Allison");
        s2.setWebSite("http://blog.stylingandroid.com/");
        s2.setAvatar("http://androidweekly.net/assets/landingpage/testimonials/allison-cbd43c874eaec8b48ba3e3cd5a287177.jpg");
        studentList.add(s2);

        Student s3 = new Student();
        s3.setName("Chris Banes");
        s3.setWebSite("http://chris.banes.me/");
        s3.setAvatar("http://androidweekly.net/assets/landingpage/testimonials/banes-4ce86cf28cceed1968f364b69c34e1e8.jpg");
        studentList.add(s3);

        return studentList;
    }
}
