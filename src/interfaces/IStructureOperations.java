package interfaces;


public interface IStructureOperations<T>{

    boolean IsVacia();
    void Transversa();
    void AgregarNodo(T dato);
    T BuscarPorReferencia(int pos);
    boolean EditarPorReferencia(int pos, T data);
    void EliminarPorReferencia(int pos);
    int Size();
    void OrdenarBurbuja();
}
