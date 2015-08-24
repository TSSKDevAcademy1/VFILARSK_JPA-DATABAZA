package model;

public class CelebrityDAO {

	public void createCelebrity(Celebrity celebrity){
		JPAHelper.beginTransaction();
		JPAHelper.getEntityManager().persist(celebrity);
		JPAHelper.commitTransaction();
	}
}
