package kieunga.com.hocpropertyanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyObjectAnimator(View view) {
        Button btnXuLyOA=findViewById(R.id.btnObjectAnimator);
        ObjectAnimator objectAnimator= (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.object_animator);
        objectAnimator.setTarget(btnXuLyOA);
        objectAnimator.start();
    }

    public void xuLyObjectAnimatorSet(View view) {
        Button btnOASet=findViewById(R.id.btnObjectAnimatorSet);
        AnimatorSet animatorSet= (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.object_animator_set);
        animatorSet.setTarget(btnOASet);
        animatorSet.start();

    }
}
