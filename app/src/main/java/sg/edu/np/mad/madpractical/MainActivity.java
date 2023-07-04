package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User ("bruh", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.", 1, true);

        TextView name = findViewById(R.id.textView2);
        Intent receive = getIntent();
        int message = receive.getIntExtra("num", 0);
        name.setText(String.format("%s%d",  user.name, message));



        TextView desc = findViewById(R.id.textView);
        desc.setText((user.description));

        Button followBtn = findViewById(R.id.button);
        followBtn.setOnClickListener(v -> {
            user.followed = !user.followed;
            followBtn.setText(user.followed ? "UNFOLLOW" : "FOLLOW");
            Toast.makeText(getBaseContext(), user.followed ? "Followed" : "Unfollowed" , Toast.LENGTH_SHORT ).show();
        });
    }
}