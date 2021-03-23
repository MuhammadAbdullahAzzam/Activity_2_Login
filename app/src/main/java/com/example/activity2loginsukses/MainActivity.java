package com.example.activity2loginsukses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btSignIn);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fingfi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edemail.getText().toString();
                String password = edpassword.getText().toString();

                //mengeset email yang benar
                String email ="admin@mail.com";

                //mengeset password yang benar
                String pass = "123";

                if(nama.equals("admin@mail.com") && password.equals("123")) {
                    //jika login berhasil
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses", Toast.LENGTH_LONG);
                    t.show();
                    //membuat objek bundle
                    Bundle b = new Bundle();
                    //memasukkan value dari variabel nama dengan kunci "a"
                    // dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variable password dengan kunci "b"
                    // dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                    Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);

                }
                else if(!nama.equals("admin@mail.com") && password.equals("123")) {
                    //jika email salah
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else if(nama.equals("admin@mail.com") && !password.equals("123")) {
                    //jika password salah
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Password salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    //jika email dan password salah
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password salah", Toast.LENGTH_LONG);
                    t.show();

                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), daftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
