package ca.cours5b5.oussamayoucefbokari.exceptions;


public class ErreurObservation extends RuntimeException {

    public ErreurObservation(Exception e){
        super(e);
    }

    public ErreurObservation(String message){
        super(message);
    }


}
