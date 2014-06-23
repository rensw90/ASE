package nl.han.dare2date.service.jms;

/**
 * Created by samuel on 16/06/14.
 */
public interface Queues {
    public final static String REQUEST_QUEUE = "RequestQueue";
    public final static String REPLY_QUEUE = "ReplyQueue";
    public final static String INVALID_QUEUE = "InvalidQueue";
    public final static String UPDATE_TOPIC_NAME = "Registration";
}
