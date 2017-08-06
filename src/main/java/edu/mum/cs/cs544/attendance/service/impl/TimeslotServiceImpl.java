package edu.mum.cs.cs544.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.attendance.dao.TimeslotDAO;
import edu.mum.cs.cs544.attendance.entity.Timeslot;
import edu.mum.cs.cs544.attendance.service.TimeslotService;

@Transactional
@Service
public class TimeslotServiceImpl implements TimeslotService {

	@Autowired
	private TimeslotDAO timeslotDao;

	public Timeslot addTimeslot(Timeslot timeslot) {
		return timeslotDao.add(timeslot);
	}

	public Timeslot updateTimeslot(Timeslot timeslot) {
		return timeslotDao.update(timeslot);
	}

	public boolean deleteTimeslotById(int id) {
		return timeslotDao.delete(id);
	}

	public Timeslot getTimeslotById(int id) {
		return timeslotDao.get(id);
	}

	public List<Timeslot> getAllTimeslots() {
		return timeslotDao.getAll();
	}

	public boolean saveAll(List<Timeslot> timeslots) {
		// TODO Auto-generated method stub
		return false;
	}

}
