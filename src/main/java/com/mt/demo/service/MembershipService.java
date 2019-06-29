package com.mt.demo.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.demo.model.Member;

@Service
public class MembershipService {

	@Autowired
	private KieContainer kieContainer;

	public Member getMemberDiscount(Member member) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(member);
		kieSession.fireAllRules();
		kieSession.dispose();
		return member;

	}

}
