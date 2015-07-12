package com.kenny.openimgur.api;

import com.kenny.openimgur.api.responses.CommentResponse;
import com.kenny.openimgur.api.responses.ConvoResponse;
import com.kenny.openimgur.api.responses.GalleryResponse;
import com.kenny.openimgur.api.responses.TopicResponse;
import com.kenny.openimgur.api.responses.UserResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by kcampagna on 7/10/15.
 */
public interface ImgurService {

    @GET("/gallery/{section}/{sort}/{page}")
    void getGallery(@Path("section") String section, @Path("sort") String sort, @Path("page") int page, @Query("showViral") boolean showViral, Callback<GalleryResponse> callback);

    @GET("/{section}/top/{window}/{page}")
    void getGalleryForTopSorted(@Path("section") String section, @Path("window") String window, @Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/gallery/{id}")
    void getGalleryDetails(@Path("id") String itemId);

    @GET("/image/{id}")
    void getImageDtails(@Path("id") String imageId);

    @GET("/gallery/{id}/images")
    void getAlbumImages(@Path("id") String albumId);

    @GET("/gallery/{id}/comments/{sort}")
    void getComments(@Path("id") String itemId, @Path("sort") String commentSort, Callback<CommentResponse> callback);

    @GET("/account/{user}")
    void getProfile(@Path("user") String username, Callback<UserResponse> callback);

    @GET("/account/{user}/favorites")
    void getProfileFavorites(@Path("user") String username, Callback<GalleryResponse> callback);

    @GET("/account/{user}/gallery_favorites/{page}/newest")
    void getProfileGalleryFavorites(@Path("user") String username, @Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/account/{user}/submissions/{page}")
    void getProfileSubmissions(@Path("user") String username, @Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/account/{user}/comments/{sort}/{page}")
    void getProfileComments(@Path("user") String username, @Path("sort") String sort, @Path("page") int page, Callback<CommentResponse> callback);

    @GET("/account/{user}/albums/{page}")
    void getProfileAlbums(@Path("user") String username, @Path("page") int page, Callback<GalleryResponse> callback);

    /**
     * User <b>MUST</b> be logged in for this endpoint to work
     */
    @GET("/account/{user}/images/{page}")
    void getProfileUploads(@Path("user") String username, @Path("page") int page, Callback<GalleryResponse> callback);

    /**
     * User <b>MUST</b> be logged in for this endpoint to work
     */
    @GET("/conversations")
    void getConversations(Callback<ConvoResponse> callback);

    @GET("/gallery/r/{subreddit}/{sort}/{page}")
    void getSubReddit(@Path("subreddit") String query, @Path("sort") String sort, @Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/gallery/r/{subreddit}/top/{window}/{page}")
    void getSubRedditForTopSorted(@Path("subreddit") String query, @Path("window") String window, @Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/gallery/random/{page}")
    void getRandomGallery(@Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/topics/defaults")
    void getDefaultTopics(Callback<TopicResponse> callback);

    @GET("/topics/{topic}/{sort}/{page}")
    void getTopic(@Path("topic") int topicId, @Path("sort") String sort, @Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/topics/{topic}/top/{window}/{page}")
    void getTopicForTopSorted(@Path("topic") int topicId, @Path("window") String window, @Path("page") int page, Callback<GalleryResponse> callback);

    @GET("/memegen/defaults")
    void getDefaultMemes(Callback<GalleryResponse> callback);

    @GET("/gallery/search/{sort}/{page}")
    void searchGallery(@Path("sort") String sort, @Path("page") int page, @Query("q") String query, Callback<GalleryResponse> callback);

    @GET("/gallery/search/top/{window}/{page}")
    void searchGalleryForTopSorted(@Path("window") String window, @Path("page") int page, @Query("q") String query, Callback<GalleryResponse> callback);

    @GET("/gallery/{id}/tags")
    void getTags(@Path("id") String itemId);
}