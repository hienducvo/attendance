package edu.mum.cs.cs544.attendance.service;

import java.util.List;

import edu.mum.cs.cs544.attendance.entity.Timeslot;

public interface TimeslotService {
	public Timeslot addTimeslot(Timeslot timeslot);

	public Timeslot updateTimeslot(Timeslot timeslot);

	public boolean deleteTimeslotById(int id);

	public Timeslot getTimeslotById(int id);

	public List<Timeslot> getAllTimeslots();

	public boolean saveAll(List<Timeslot> timeslots);


}
