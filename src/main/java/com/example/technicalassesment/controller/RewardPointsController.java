package com.example.technicalassesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.technicalassesment.models.TransactionEntity;
import com.example.technicalassesment.service.RewardService;

@RestController
public class RewardPointsController {

	@Autowired
	RewardService rewardService;
	
	@GetMapping("/getLastMonthRewardPointsPerCustomer/{customerId}")
	public String getLastMonthRewardPointsPerCustomer(@PathVariable int customerId){
		List<TransactionEntity> lastMonthTransactions = rewardService.getMonthlyTransactionsPerCustomer(customerId);
		System.out.println("transactions ------ "+lastMonthTransactions.toString());
		int totalRewardPoints = rewardService.getTotalRewardPointsPerTransaction(lastMonthTransactions);
		return "Total reward points for last month for customer Id "+customerId+" is "+totalRewardPoints;
	}
	
	@GetMapping("/getThreeMonthRewardPointsPerCustomer/{customerId}")
	public String getLastThreeMonthRewardPointsPerCustomer(@PathVariable int customerId){
		List<TransactionEntity> lastThreeMonthTransactions = rewardService.getQuarterlyTransactionsPerCustomer(customerId);
		System.out.println("transactions ------ "+lastThreeMonthTransactions.toString());
		int totalRewardPoints = rewardService.getTotalRewardPointsPerTransaction(lastThreeMonthTransactions);
		return "Total reward points for last three months for customer Id "+customerId+" is "+totalRewardPoints;
	}
	
	
	@PostMapping("/insertTransaction")
	public TransactionEntity insertTransaction(@RequestBody TransactionEntity entity) {
		return rewardService.saveTransaction(entity);
	}
	
	
	
	
	
}
