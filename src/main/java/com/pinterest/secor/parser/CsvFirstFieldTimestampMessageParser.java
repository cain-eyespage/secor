package com.pinterest.secor.parser;

import com.pinterest.secor.common.SecorConfig;
import com.pinterest.secor.message.Message;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by zn on 3/24/17.
 */

public class CsvFirstFieldTimestampMessageParser extends TimestampedMessageParser{
    private static final Logger LOG = LoggerFactory.getLogger(CsvFirstFieldTimestampMessageParser.class);

    public CsvFirstFieldTimestampMessageParser(SecorConfig config) {
        super(config);
    }

    @Override
    public long extractTimestampMillis(final Message message) {
        String msg = new String(message.getPayload());
        Long timestamp = Long.parseLong(msg.split(",")[0]);
        return timestamp; //Daily Timestamp generation
    }

}
