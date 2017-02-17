package it.latartaruga.sensoryturtles.repository.interf;

import it.framework.client.service.impl.SearchCriteriaApplicationLog;
import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IListPager;
import it.framework.core.repository.interf.IRepository;
import it.latartaruga.sensoryturtles.model.ApplicationLog;

public interface IApplicationLogRepository extends IRepository<ApplicationLog, Integer> {
	
	IListPager<? extends ApplicationLog> findByRoomTherapistMember(IOffset offset,SearchCriteriaApplicationLog criteria);

}
