package com.example.mercedesf1app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import com.example.mercedesf1app.R;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);

        users = UserManager.loadUsers(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        for (User user : users) {
            if ((user.email.equals(username) || user.username.equals(username)) && user.password.equals(password)) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("USER_NAME", user.name);
                startActivity(intent);
                finish();
                return;
            }
        }
        Toast.makeText(this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
    }
}
