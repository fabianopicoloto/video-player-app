package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Esconder statusBar e colocar em full screen
        //getWindow recupera um objeto de tela e getDecorView recupera objeto que permite manipular elementos de tela
        View decorView = getWindow().getDecorView();
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION; //<-- Remove fundo lateral
        decorView.setSystemUiVisibility(uiOpcoes);

        //Esconder ActionBar
        getSupportActionBar().hide();

        //Definir os controladores do vídeo
        videoView.setMediaController(new MediaController(this));
        //Caminho padrão
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.love_death_robots_3);
        videoView.start();

    }
}