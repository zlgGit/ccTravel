package cc.travel.com.cctravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.mapView)
    MapView mMapView;
    @BindView(R.id.user_profile)
    ImageView mUserProfile;
    @BindView(R.id.chat_access)
    ImageView mChatAccess;
    @BindView(R.id.title_first_levle)
    RelativeLayout mTitleFirstLevle;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;

    @BindView(R.id.title_levle)
    CardView mTitleLevle;
    @BindView(R.id.bottom_level)
    FrameLayout mBottomLevel;
    @BindView(R.id.user_action)
    FrameLayout mUserAction;
    @BindView(R.id.location)
    ImageView mLocation;
    private AMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMapView.onCreate(savedInstanceState);
        mMap = mMapView.getMap();

        mTablayout.addTab(mTablayout.newTab().setText("快车"));
        mTablayout.addTab(mTablayout.newTab().setText("顺风车"));
        mTablayout.addTab(mTablayout.newTab().setText("代驾"));
        mTablayout.addTab(mTablayout.newTab().setText("分时租赁"));
        mTablayout.addTab(mTablayout.newTab().setText("分时租赁"));
        mTablayout.addTab(mTablayout.newTab().setText("分时租赁"));
        mTablayout.addTab(mTablayout.newTab().setText("分时租赁"));
        mTablayout.addTab(mTablayout.newTab().setText("分时租赁"));
        mTablayout.addTab(mTablayout.newTab().setText("分时租赁"));

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
}
