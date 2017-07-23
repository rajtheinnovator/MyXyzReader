package me.abhishekraj.myxyzreader.data;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

/**
 * Helper for loading a list of articles or a single article.
 */
public class ArticleLoader extends CursorLoader {
    public static ArticleLoader newAllArticlesInstance(Context context) {
        return new ArticleLoader(context, me.abhishekraj.myxyzreader.data.ItemsContract.Items.buildDirUri());
    }

    public static ArticleLoader newInstanceForItemId(Context context, long itemId) {
        return new ArticleLoader(context, me.abhishekraj.myxyzreader.data.ItemsContract.Items.buildItemUri(itemId));
    }

    private ArticleLoader(Context context, Uri uri) {
        super(context, uri, Query.PROJECTION, null, null, me.abhishekraj.myxyzreader.data.ItemsContract.Items.DEFAULT_SORT);
    }

    public interface Query {
        String[] PROJECTION = {
                me.abhishekraj.myxyzreader.data.ItemsContract.Items._ID,
                me.abhishekraj.myxyzreader.data.ItemsContract.Items.TITLE,
                me.abhishekraj.myxyzreader.data.ItemsContract.Items.PUBLISHED_DATE,
                me.abhishekraj.myxyzreader.data.ItemsContract.Items.AUTHOR,
                me.abhishekraj.myxyzreader.data.ItemsContract.Items.THUMB_URL,
                me.abhishekraj.myxyzreader.data.ItemsContract.Items.PHOTO_URL,
                me.abhishekraj.myxyzreader.data.ItemsContract.Items.ASPECT_RATIO,
                me.abhishekraj.myxyzreader.data.ItemsContract.Items.BODY,
        };

        int _ID = 0;
        int TITLE = 1;
        int PUBLISHED_DATE = 2;
        int AUTHOR = 3;
        int THUMB_URL = 4;
        int PHOTO_URL = 5;
        int ASPECT_RATIO = 6;
        int BODY = 7;
    }
}
