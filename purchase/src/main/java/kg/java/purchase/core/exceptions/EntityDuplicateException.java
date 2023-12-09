package kg.java.purchase.core.exceptions;

public class EntityDuplicateException extends Exception{
    public EntityDuplicateException(){
        super("Entity exist");
    }
}
