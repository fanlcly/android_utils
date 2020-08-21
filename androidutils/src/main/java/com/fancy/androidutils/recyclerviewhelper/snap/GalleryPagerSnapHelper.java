package com.fancy.androidutils.recyclerviewhelper.snap;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * pager的吸顶效果
 *
 * @author fanlei
 * @version 1.0 2019/4/16 0016
 * @since JDK 1.8
 */
public class GalleryPagerSnapHelper extends PagerSnapHelper {
    @NonNull
    private final GalleryDelegate delegate;

    public GalleryPagerSnapHelper(int gravity) {
        this(gravity, false, null);
    }

    public GalleryPagerSnapHelper(int gravity, boolean enableSnapLastItem) {
        this(gravity, enableSnapLastItem, null);
    }

    public GalleryPagerSnapHelper(int gravity, boolean enableSnapLastItem,
                                  @Nullable GallerySnapHelper.SnapListener snapListener) {
        delegate = new GalleryDelegate(gravity, enableSnapLastItem, snapListener);
    }

    @Override
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView)
            throws IllegalStateException {
        if (recyclerView != null
                && (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)
                || recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            throw new IllegalStateException("GravityPagerSnapHelper needs a RecyclerView" +
                    " with a LinearLayoutManager");
        }
        delegate.attachToRecyclerView(recyclerView);
        super.attachToRecyclerView(recyclerView);
    }

    @Nullable
    @Override
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager,
                                              @NonNull View targetView) {
        return delegate.calculateDistanceToFinalSnap(layoutManager, targetView);
    }

    @Nullable
    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return delegate.findSnapView(layoutManager);
    }

    /**
     * Enable snapping of the last item that's snappable.
     * The default value is false, because you can't see the last item completely
     * if this is enabled.
     *
     * @param snap true if you want to enable snapping of the last snappable item
     */
    public void enableLastItemSnap(boolean snap) {
        delegate.enableLastItemSnap(snap);
    }

    public void smoothScrollToPosition(int position) {
        delegate.smoothScrollToPosition(position);
    }

    public void scrollToPosition(int position) {
        delegate.scrollToPosition(position);
    }

}
