package com.pinterest.secor.transformer;

import com.pinterest.secor.common.SecorConfig;
import com.pinterest.secor.message.Message;

import java.util.ArrayList;

/**
 * Default message transformer class which does no transformation
 * 
 * @author Ashish (ashu.impetus@gmail.com)
 *
 */
public class IdentityMessageTransformer implements MessageTransformer {
    protected SecorConfig mConfig;
    /**
     * Constructor
     * 
     * @param config
     */
    public IdentityMessageTransformer(SecorConfig config) {
        mConfig = config;
    }
    @Override
    public ArrayList<Message> transform(Message message) {

        ArrayList messageGroup = new ArrayList<Message>();
        messageGroup.add(message);
        return messageGroup;
    }
}
