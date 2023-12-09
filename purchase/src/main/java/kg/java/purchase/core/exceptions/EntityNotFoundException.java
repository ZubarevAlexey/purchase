package kg.java.purchase.core.exceptions;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException (){
        super("Entity not found");
    }
}
