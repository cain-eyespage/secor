package com.pinterest.secor.transformer;

import com.pinterest.secor.common.SecorConfig;
import com.pinterest.secor.io.KeyValue;
import com.pinterest.secor.message.Message;
import scala.util.parsing.combinator.testing.Str;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.util.ArrayList;

/**
 * Created by zn on 3/24/17.
 */
public class MutilLineDelimitedTextMessageTransformer implements MessageTransformer{

    private String DELIMITER;
    protected SecorConfig mConfig;

    public MutilLineDelimitedTextMessageTransformer(SecorConfig config) {
        mConfig = config;
        DELIMITER = mConfig.getFileReaderDelimiter();
    }

    @Override
    public ArrayList<Message> transform(Message message) {
        ArrayList messageGroup = new ArrayList<Message>();
        String payload = new String(message.getPayload());
        for (String item: payload.split(DELIMITER)){
            Message sub_message = new Message(message.getTopic(), message.getKafkaPartition(), message.getOffset(),
                    message.getKafkaKey(), item.getBytes());
            messageGroup.add(sub_message);
        }
        return messageGroup;
    }
}
