package interfaces;

public interface IEstructureOperations<T>{

    boolean IsVacia();
    void Transversa();
    void AgregarNodo(T dato);
    T BuscarPorReferencia(int pos);
    void EditarPorReferencia(int pos, T data);
    void EliminarPorReferencia(int pos);
    int Size();
    void OrdenarBurbuja();

}
