package com.mt.demo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.demo.model.Member;
import com.mt.demo.service.MembershipService;

@RestController
public class MembershipController {

	@Autowired
	MembershipService membershipService;

	@RequestMapping(value = "/discount/{type}", method = RequestMethod.GET, produces = "application/json")
	public Member getDiscount(@PathVariable("type") String type) {
		Member member = new Member();
		member.setType(type);

		return membershipService.getMemberDiscount(member);
	}

}
