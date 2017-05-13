package cs445.a4;

/**
 * This abstract data type is a predictive engine for video ratings in a streaming video system. It
 * stores a set of users, a set of videos, and a set of ratings that users have assigned to videos.
 *
 * ADD OTHER DETAILS HERE IF NECESSARY
 */
public interface VideoEngine {

    /**
     * The abstract methods below are declared as void methods with no parameters. You need to
     * expand each declaration to specify a return type and parameters, as necessary. You also need
     * to include a detailed comment for each abstract method describing its effect, its return
     * value, any corner cases that the client may need to consider, any exceptions the method may
     * throw (including a description of the circumstances under which this will happen), and so on.
     * You should include enough details that a client could use this data structure without ever
     * being surprised or not knowing what will happen, even though they haven't read the
     * implementation.
     */

    /**
     *
     * Adds a new video to the system.
     *
     * @param selectedVideo video to be added to the system
     * @throws IllegalArgumentException if selectedVideo is in system already
     * @throws NullPointerException if selecttedVideo is null
     */
    public void addVideo(Video selectedVideo);

    /**
     * Removes an existing video from the system.
     * 
     * @param selectedVideo video to be removed from the system
     * @throws NullPointerException if the video to be removed is null
     * @throws IllegalArgumentException if the video is already in the system
     */
    public void removeVideo(Video selectedVideo);

    /**
     * Adds an existing television episode to an existing television series.
     * @param addEpisode the TvEpisode to be added to the TvSeries
     * @param addToSeries the TvSeries chosen where the TvEpisode will be added to
     * @throws NullPointerException if TvEpisode or TvSeries is null
     * @throws IllegalArgumentException if addToSeries already contains addEpisode
     */
    public void addToSeries(TvEpisode addEpisode, TvSeries addToSeries);

    /**
     * Removes a television episode from a television series.
     * @param removeEpisode the TvEpisode to be removed to the TvSeries
     * @param removeFromSeries the TvSeries chosen where the TvEpisode will be removed from
     * @throws NullPointerException if TvEpisode or TvSeries is null
     * @throws IllegalArgumentException if removeFromSeries does not contains removeEpisode
     */
    public void removeFromSeries(TvEpisode removeEpisode, TvSeries removeFromSeries);

    /**
     * Sets a user's rating for a video, as a number of stars from 1 to 5.
     * @param rater user whose rating should be cleared
     * @param ratingVideo video to assign a rating to
     * @param rating the number of stars (1-5) to be given to a video
     * @throws IllegalArgumentException the rating is lower than 1 or greater than 5
     * @throws NullPointerException if either the user or the video is null
     */
    public void rateVideo(User rater, Video ratingVideo, int rating);

    /**
     * Clears a user's rating on a video. If this user has rated this video and the rating has not
     * already been cleared, then the rating is cleared and the state will appear as if the rating
     * was never made. If this user has not rated this video, or if the rating has already been
     * cleared, then this method will throw an IllegalArgumentException.
     *
     * @param theUser user whose rating should be cleared
     * @param theVideo video from which the user's rating should be cleared
     * @throws IllegalArgumentException if the user does not currently have a rating on record for
     * the video
     * @throws NullPointerException if either the user or the video is null
     */
    public void clearRating(User theUser, Video theVideo);

    /**
     * Predicts the rating a user will assign to a video that they have not yet rated, as a number
     * of stars from 1 to 5.
     * @param theRater user that the rating of predictingVideo will be predicted for
     * @param predictingVideo video that the rating to be predicted
     * @throws NullPointerException if either the user or the video is null
     * @return an integer rating between 1 and 5
     */
    public int predictRating(User theRater, Video predictingVideo);

    /**
     * Suggests a video for a user (e.g.,based on their predicted ratings).
     *
     * @param userNeedsSuggestions user that will be suggested a video
     * @throws NullPointerException if the user is null
     * @return Video that is suggested to the user
     */
    public Video suggestVideo(User userNeedsSuggestions);


}

