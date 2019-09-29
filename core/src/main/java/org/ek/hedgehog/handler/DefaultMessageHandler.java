package org.ek.hedgehog.handler;

import com.ek.hedgehog.core.proto.BasicTransform;
import com.ek.hedgehog.core.proto.MessageType;
import com.google.protobuf.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultMessageHandler implements MessageHandler<BasicTransform, BasicTransform> {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultMessageHandler.class);

    private Map<Integer, MessageHandler<byte[], byte[]>> handlerMap = new ConcurrentHashMap<>();

    @Override
    public BasicTransform handle(BasicTransform req) {
        BasicTransform.Builder resp = BasicTransform.newBuilder(req);
        resp.clearContent();

        MessageType messageType = req.getType();
        MessageHandler<byte[], byte[]> messageHandler = handlerMap.get(messageType.getNumber());
        if (messageHandler == null) {
            LOG.warn(String.format("MESSAGE ERROR :: no handler find with cmd %d - %s", messageType.getNumber(), messageType));

        } else {
            byte[] result = messageHandler.handle(req.getContent().toByteArray());
            resp.setContent(ByteString.copyFrom(result));
        }
        return resp.build();
    }

    public <H extends MessageHandler> boolean registerHandler(int cmd, H handler) {
        return handlerMap.putIfAbsent(cmd, handler) == null;
    }

    public boolean deregisterHandler(int cmd) {
        return handlerMap.remove(cmd) != null;
    }

}
