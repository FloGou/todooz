package fr.todooz.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.joda.time.Interval;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.todooz.domain.Task;

@Service
public class TaskServiceImpl implements TaskService {
	
	
	@Inject
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void save(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(task);
		
		
	}


	@Override
	@Transactional
	public void delete(Long id) {
		Session session =sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Task where id = :id");
		query.setLong( "id", id ).executeUpdate();
	}


	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Task> findAll() {
		Session session =sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Task.class);

		List<Task> maliste =  crit.list();
		return maliste;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Task> findByQuery(String query) {
		Session session =sessionFactory.getCurrentSession();

		Criteria crit = session.createCriteria(Task.class).add(Restrictions.or(Restrictions.ilike("title", query, MatchMode.ANYWHERE),Restrictions.ilike("text", query, MatchMode.ANYWHERE )));
		
		List<Task> maliste =  crit.list();
		return maliste;
	}


	@Override
	@Transactional(readOnly = true)
	public int count() {
		return findAll().size();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Task> findByTag(String query) {
		Session session =sessionFactory.getCurrentSession();

		Criteria crit = session.createCriteria(Task.class).add(Restrictions.ilike("tags", query, MatchMode.ANYWHERE));
		
		List<Task> maliste =  crit.list();
		return maliste;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Task> findByDay(Interval inter) {
		Session session =sessionFactory.getCurrentSession();

		Criteria crit = session.createCriteria(Task.class).add(Restrictions.between("date", inter.getStart().toDate(), inter.getEnd().toDate()));
		
		List<Task> maliste =  crit.list();
		return maliste;
	}


	@Override
	@Transactional(readOnly = true)
	public Task findById(Long id) {
		Session session =sessionFactory.getCurrentSession();
		
		return (Task)session.get(Task.class, id);
	}
	
}
