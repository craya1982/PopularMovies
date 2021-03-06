package com.christopherluc.popularmovies.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 *
 * Data contract for a movie in the favorite movies database
 *
 * Created by Chris on 5/25/2016.
 */
public class FavoriteMovieContract {

    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.
    public static final String CONTENT_AUTHORITY = "com.christopherluc.popularmovies.app";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_MOVIE = "favorite_movies";

    /* Inner class that defines the table contents of the movie table */
    public static final class FavoriteMovieEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;

        // Table name
        public static final String TABLE_NAME = "movie";

        public static final String COLUMN_POSTER_PATH = "poster_path";
        public static final String COLUMN_OVERVIEW = "overview";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_VOTE_AVERAGE = "vote_average";
        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String _ID = "id";

        public static Uri buildUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
