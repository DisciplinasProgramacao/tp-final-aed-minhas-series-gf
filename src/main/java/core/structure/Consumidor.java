package core.structure;

@FunctionalInterface
public interface Consumidor<T> {
    void aceitar(T t);
}
