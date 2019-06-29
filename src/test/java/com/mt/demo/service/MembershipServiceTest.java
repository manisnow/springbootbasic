package com.mt.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mt.demo.model.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembershipServiceTest {

	@Autowired
	MembershipService membershipService;

	@Test
	public void testGetMemberDiscount() {

		Member member = new Member();
		member.setType("gold");
		member = membershipService.getMemberDiscount(member);

		assertNotNull(member);
		assertEquals(Integer.valueOf(25), Integer.valueOf(member.getDiscount()));
	}

}
