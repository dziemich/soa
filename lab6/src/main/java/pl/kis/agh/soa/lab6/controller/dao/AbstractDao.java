package pl.kis.agh.soa.lab6.controller.dao;

import javax.persistence.EntityManager;

public class AbstractDao {
  private EntityManager entityManager;

  public AbstractDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }
}
