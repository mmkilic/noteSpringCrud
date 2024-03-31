package mmk.crud.repostory;

public interface CustomizedRepository<T> {
	public <S extends T> S merge(S entity);
	public void persist(T entity);
}
