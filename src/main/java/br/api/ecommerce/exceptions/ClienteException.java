package br.api.ecommerce.exceptions;

import java.io.Serial;

public class ClienteException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -8871695414957146069L;

    public ClienteException(String message){
        super(message);
    }

}
