package mmk.crud.repostory;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class CustomizedRepositoryImpl<T> implements CustomizedRepository<T> {

	private EntityManager entityManager;
	
	public CustomizedRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	@Override
	public <S extends T> S merge(S entity) {
		return entityManager.merge(entity);
	}
	
	@Transactional
	@Override
	public void persist(T entity) {
		entityManager.persist(entity);
	}
}
