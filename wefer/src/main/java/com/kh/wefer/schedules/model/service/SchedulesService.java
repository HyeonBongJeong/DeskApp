
package com.kh.wefer.schedules.model.service;

import java.util.List;
import com.kh.wefer.schedules.model.domain.Schedules;

public interface SchedulesService {
	// �����߰�
	int insertSchedules(Schedules schd);
	
	// ��������Ʈ
	List<Schedules> schedulesList();
	List<Schedules> schedulesstList(String type);
	List<Schedules> schedulesdeptList(String type);


	// ���� ����
	void updateSchedules(Schedules schd);
	
	// ���� ����
	void deleteSchedules(String scid);
}
