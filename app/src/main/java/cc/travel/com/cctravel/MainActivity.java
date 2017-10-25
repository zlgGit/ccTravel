package cc.travel.com.cctravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.travel.com.cctravel.CcHttp.CcHttp;
import cc.travel.com.cctravel.CcHttp.CcRequest;

public class MainActivity extends AppCompatActivity implements MyTabLayout.OnTabClickListener {


    @BindView(R.id.mapView)
    MapView mMapView;
    @BindView(R.id.user_profile)
    ImageView mUserProfile;
    @BindView(R.id.chat_access)
    ImageView mChatAccess;
    @BindView(R.id.title_first_levle)
    RelativeLayout mTitleFirstLevle;
    @BindView(R.id.tablayout)
    MyTabLayout mTablayout;
    @BindView(R.id.title_levle)
    LinearLayout mTitleLevle;

    @BindView(R.id.location)
    ImageView mLocation;
    @BindView(R.id.tltle_link)
    TransLationView mTltleLink;
    @BindView(R.id.bottom_level)
    FrameLayout mBottomLevel;
    @BindView(R.id.user_action)
    TransBottomView mUserAction;
    @BindView(R.id.user_action2)
    FrameLayout mUserAction2;
    private AMap mMap;
    private String mCurrentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMapView.onCreate(savedInstanceState);
        mMap = mMapView.getMap();
        mTablayout.setOnTabClickListener(this);
        mCurrentTab = MyTabLayout.TYPE_KUAICHE;
        CcHttp<Object> objectCcHttp = new CcHttp<>();
        CcRequest.Builder builder = new CcRequest.Builder();
        builder.url("http://10.51.9.14:8080/user/login")
                .addParam("username","root")
                .addParam("password","root");
        objectCcHttp.add(builder.build());

    }

    @OnClick({R.id.user_profile, R.id.chat_access})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_profile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
            case R.id.chat_access:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }


    @Override
    public void onTabClick(String tab) {
        Log.i("--", "tab click" + tab);
        switch (tab) {
            case MyTabLayout.TYPE_DAIJIA:
                mTltleLink.addView(MyTabLayout.TYPE_DAIJIA);
                mUserAction.addView(MyTabLayout.TYPE_DAIJIA);
                break;
            case MyTabLayout.TYPE_FENSHIZULIN:
                mTltleLink.addView(MyTabLayout.TYPE_FENSHIZULIN);
                mUserAction.addView(MyTabLayout.TYPE_FENSHIZULIN);
                break;
            case MyTabLayout.TYPE_KUAICHE:
                mTltleLink.addView(MyTabLayout.TYPE_KUAICHE);
                mUserAction.addView(MyTabLayout.TYPE_KUAICHE);
                break;
            case MyTabLayout.TYPE_SHUNFENGCHE:
                mTltleLink.addView(MyTabLayout.TYPE_SHUNFENGCHE);
                mUserAction.addView(MyTabLayout.TYPE_SHUNFENGCHE);
                break;
        }
        mCurrentTab = tab;
    }
}
