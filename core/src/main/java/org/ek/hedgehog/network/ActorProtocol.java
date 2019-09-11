package org.ek.hedgehog.network;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ActorProtocol<MESSAGE extends Serializable> implements Serializable {

    public static enum Option {
        EXIT, MESSAGE, THROWABLE
    }

    private Option option;

    private MESSAGE message;

    private Throwable throwable;

    public ActorProtocol(Option option) {
        this.option = option;
    }

    public ActorProtocol(Throwable throwable) {
        this.option = Option.THROWABLE;
        this.throwable = throwable;
    }

    public ActorProtocol(MESSAGE msg) {
        this.option = Option.MESSAGE;
        this.message = msg;
    }

}
