package it.latartaruga.sensoryturtles.dao.interf;

import it.framework.client.service.impl.SearchCriteriaApplicationLog;
import it.framework.client.service.inferf.IOffset;
import it.framework.core.dao.interf.IDao;
import it.framework.core.dao.interf.IListPager;
import it.latartaruga.sensoryturtles.entity.ApplicationLogEntity;

public interface IApplicationLogDAO<E,K> extends IDao<E, K>{
	
	public IListPager<ApplicationLogEntity> findByRoomTherapistMember(IOffset offset,SearchCriteriaApplicationLog criteria);

}
