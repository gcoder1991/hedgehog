package org.ek.hedgehog.handler;

public interface MessageHandler<REQ, RESP> {


    RESP handle(REQ req);


}
