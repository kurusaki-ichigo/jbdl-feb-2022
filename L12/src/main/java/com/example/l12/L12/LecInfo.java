package com.example.l12.L12;

//import org.springframework.data.cassandra.core.mapping.BasicCassandraPersistentEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.Assert;

public class LecInfo {



//    @Transactional
//    public <S extends T> S save(S entity) {
//        Assert.notNull(entity, "Entity must not be null.");
//        if (this.entityInformation.isNew(entity)) {
//            this.em.persist(entity);
//            return entity;
//        } else {
//            return this.em.merge(entity);
//        }
//    }

//    public <S extends T> S save(S entity) {
//        Assert.notNull(entity, "Entity must not be null");
//        BasicCassandraPersistentEntity<?> persistentEntity = (BasicCassandraPersistentEntity)this.mappingContext.getPersistentEntity(entity.getClass());
//        return persistentEntity != null && persistentEntity.hasVersionProperty() && !this.entityInformation.isNew(entity) ? this.operations.update(entity) : this.operations.insert(entity, INSERT_NULLS).getEntity();
//    }

    /**
     *
     * spring-data-starter-jpa (SQL)
     *  JpaRepository <></>  -------------------> SQL relations
     *      |
     *  PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
     *          |
     *   CrudRepository
     *          |
     *   Repository
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * Mongo - spring-data-mongo (mongo)
     *
     //    public <S extends T> S save(S entity) {
     //        Assert.notNull(entity, "Entity must not be null!");
     //        return this.entityInformation.isNew(entity) ? this.mongoOperations.insert(entity, this.entityInformation.getCollectionName()) : this.mongoOperations.save(entity, this.entityInformation.getCollectionName());
     //    }

     *  MongoRepository <></>  -------------------> SQL relations
     *      |
     *  PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
     *          |
     *   CrudRepository
     *          |
     *   Repository
     *
     *
     * Cassandra - spring-data-cassandra (mongo)
     *
     //    public <S extends T> S save(S entity) {
     //        Assert.notNull(entity, "Entity must not be null");
     //        BasicCassandraPersistentEntity<?> persistentEntity = (BasicCassandraPersistentEntity)this.mappingContext.getPersistentEntity(entity.getClass());
     //        return persistentEntity != null && persistentEntity.hasVersionProperty() && !this.entityInformation.isNew(entity) ? this.operations.update(entity) :
     this.operations.insert(entity, INSERT_NULLS).getEntity();
     //    }

     *  CassandraRepository <></>  -------------------> SQL relations
     *          |
     *   CrudRepository
     *          |
     *   Repository
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
