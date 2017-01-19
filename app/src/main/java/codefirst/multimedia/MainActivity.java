package codefirst.multimedia;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;        //通知管理对象
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send= (Button) findViewById(R.id.btn_sendMessage);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  //对象
                Notification.Builder builder=new Notification.Builder(getApplicationContext());
                Intent intent=new Intent(getApplicationContext(),MessageActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),
                        0,intent,0);        //延迟的intent
                builder.setContentIntent(pi);       //设置点击通知意图
                builder.setTicker("tricker");
                builder.setContentText("text");         //内容
                builder.setContentTitle("title");           //标题
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setDefaults(Notification.DEFAULT_ALL);  //默认提示音、振动方式、指示灯

                Notification notification=builder.build();      //利用Builder对象创建Notification
                manager.notify(1,notification);     //发送通知
                            //id,唯一
            }
        });



    }
}
