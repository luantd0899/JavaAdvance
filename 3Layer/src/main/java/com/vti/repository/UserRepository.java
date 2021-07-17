package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.User;
import com.vti.utils.HibernateUtils;

@Repository
public class UserRepository implements IUserRepository {

	private HibernateUtils hibernateUtils;
	
	public UserRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	@Override
	public List<User> getAllUser() {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<User> query = session.createQuery("FROM User");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public User getUserByID(short id) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			User user = session.get(User.class, id);

			return user;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public User getUserByName(String name) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<User> query = session.createQuery("FROM User WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			User user = query.uniqueResult();

			return user;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void createUser(User user) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(user);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateUser(short id, String newName) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			User user = session.load(User.class, id);

			// update
			user.setUsername(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateUser(User user) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(user);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void deleteUser(short id) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			User user = session.load(User.class, id);

			// delete
			session.delete(user);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public boolean isUserExistsByID(short id) {
		// get department
				User user = getUserByID(id);

				// return result
				if (user == null) {
					return false;
				}

				return true;
	}

	@Override
	public boolean isUserExistsByName(String name) {
		User user = getUserByName(name);

		if (user == null) {
			return false;
		}
		return true;
	}

}
