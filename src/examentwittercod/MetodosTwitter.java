
package examentwittercod;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author rfernandezgonzalez
 */
public class MetodosTwitter {
    
    Twitter twitter;

    /**
     * Constructor, da acceso a nuestra cuenta en twitter.
     */
    public MetodosTwitter() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("cCwlXGbOea4tWifNEsWSYZowp")
                .setOAuthConsumerSecret("nVckoYIfas2ucRVUROQcB0s6ZDHCpjOdvw8G6i0v72ilKY0xKy")
                .setOAuthAccessToken("3055269988-3EClzoFaUspMzlM1O7tTebuGe3vyi5rCkSU3LiB")
                .setOAuthAccessTokenSecret("ibohhy5rRk0ue0SQ3zhCUpmvhfEXCooULhtKfs2PUEwL5");

        twitter = new TwitterFactory(cb.build()).getInstance();

    }
    
    /**
     * Nos da nuestro timeLine
     */
    public void verTL() throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }

    }
    
    /**
     * Busca tweets con el texto introducido
     */
    public void buscarTrending(String busqueda) throws TwitterException {

        Query query = new Query(busqueda);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }

    }
    
    /**
     * Crea y publica un tweet
     */
    public void tweetear(String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }

}
