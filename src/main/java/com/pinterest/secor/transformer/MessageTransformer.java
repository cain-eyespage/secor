package com.pinterest.secor.transformer;

import com.pinterest.secor.message.Message;
import java.util.ArrayList;


public interface MessageTransformer {
    /**
     * Implement this method to add transformation logic at message level before
     * dumping it into Amazon S3
     */

    public ArrayList<Message> transform(Message message);

}
