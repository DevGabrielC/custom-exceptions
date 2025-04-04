package model.exceptions;

// Quando a classe e uma excecao, damos o pos-fixo de "Exception"
public class DomainException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DomainException(String message) {
      super(message);
    }
}