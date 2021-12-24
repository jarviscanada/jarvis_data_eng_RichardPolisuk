package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;

public class TwitterDao extends TwitterHttpHelper implements CrdDao{

  /**
   * Create an entity(Tweet) to the underlying storage
   *
   * @param entity entity that to be created
   * @return created entity
   */
  @Override
  public Object create(Object entity) {
    return null;
  }

  /**
   * Find an entity(Tweet) by its id
   *
   * @param o entity id
   * @return Tweet entity
   */
  @Override
  public Object findById(Object o) {
    return null;
  }

  /**
   * Delete an entity(Tweet) by its ID
   *
   * @param o of the entity to be deleted
   * @return deleted entity
   */
  @Override
  public Object deleteById(Object o) {
    return null;
  }
}
