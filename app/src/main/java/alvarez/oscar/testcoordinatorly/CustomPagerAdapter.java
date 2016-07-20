package alvarez.oscar.testcoordinatorly;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Oscar Álvarez
 */
public class CustomPagerAdapter extends PagerAdapter {

    private List<String> imageUrls;
    private Activity context;
    private int screenWidth;

    public CustomPagerAdapter(Activity context) {
        imageUrls = new ArrayList<>();
        this.context = context;
        Display display = context.getWindowManager().getDefaultDisplay();
        screenWidth = display.getWidth();
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int pos) {
        final ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(screenWidth,
                context.getResources().getDimensionPixelSize(R.dimen.item_detail_transition_view_height)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        collection.addView(imageView, 0);


        Glide.with(context).load(imageUrls.get(pos)).into(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    public void addAll(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
