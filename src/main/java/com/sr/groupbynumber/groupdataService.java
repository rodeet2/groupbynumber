package com.sr.groupbynumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class groupdataService {

    private final groupRepository groupRepository;

    @Autowired
    private EntityManager entityManager;

    public groupdataService(groupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void create(allgroups g){
        groupRepository.save(g);
    }

    public allgroups getgroup(Integer groupID) {
        String baseQuery = "SELECT * FROM groupbynumber.allgroups WHERE gorupid = :groupID LIMIT 1";
        Query query = entityManager.createNativeQuery(baseQuery, allgroups.class);
        query.setParameter("groupID", groupID);
        return (allgroups) query.getSingleResult();
    }

    @Transactional
    public void updateGroup(Integer count, Integer groupID) {
        String queryString = "UPDATE groupbynumber.allgroups SET count = :count WHERE gorupid = :groupID";
        Query query = entityManager.createNativeQuery(queryString);
         query.setParameter("count", count);
         query.setParameter("groupID", groupID);
        query.executeUpdate(); 
      }

}