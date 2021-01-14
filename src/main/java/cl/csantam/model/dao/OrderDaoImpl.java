package cl.csantam.model.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cl.csantam.model.entity.Order;

public class OrderDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;
		
	public List<Order> getData(HashMap<String, Object> conditions)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> query= cb.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
			
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field,value) ->
		{
			switch (field)
			{
				case "store_id":
					predicates.add(cb.equal (root.get(field), (Integer)value));
					break;
				case "estado":
					predicates.add(cb.equal(root.get(field),(Integer)value));
					break;
				case "order_date":
					predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
					break;
				}
			});
		   System.out.println("Predicado:" + predicates.size());
			query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
			return entityManager.createQuery(query).getResultList(); 		
	}
}