package com.ts.dao;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Agent;

public class AgentDAO {

	public Agent getAgentByUserPass(String loginId, String password) {
		return (Agent)HibernateTemplate.getObjectByLogin(loginId,password);

	}

}
