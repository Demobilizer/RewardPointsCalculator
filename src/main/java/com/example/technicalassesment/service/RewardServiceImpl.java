package com.example.technicalassesment.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.technicalassesment.models.TransactionEntity;
import com.example.technicalassesment.repository.RewardRepository;

@Service
public class RewardServiceImpl implements RewardService {

	@Autowired
	RewardRepository rewardRepository;

	@Override
	public TransactionEntity saveTransaction(TransactionEntity transactionEntity) {
		TransactionEntity entity = rewardRepository.save(transactionEntity);
		return entity;
	}

	@Override
	public int calculateRewardPoint(int dollarSpend) {
		int totalRewards = 0;
		if (dollarSpend > 100) {
			int remaining = dollarSpend - 100;
			totalRewards = (remaining * 2) + (1 * 50);
		} else if (dollarSpend >= 50 && dollarSpend <= 100) {
			totalRewards = (dollarSpend - 50) * 1;
		}
		return totalRewards;
	}

	@Override
	public List<TransactionEntity> getMonthlyTransactionsPerCustomer(int custId) {
		
		Calendar c = Calendar.getInstance();
		Date todayDate = c.getTime();
		c.add(Calendar.MONTH, -1);
		Date oneMonthBackDate = c.getTime(); 
		
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    
	    System.out.println(formatter.format(todayDate));
	    System.out.println(formatter.format(oneMonthBackDate));

		return rewardRepository
				.findAllLastMonthTransactionsPerCustomer(custId, todayDate, oneMonthBackDate);
	}

	@Override
	public int getTotalRewardPointsPerTransaction(List<TransactionEntity> lastMonthTransactions) {
		int totalRewardPoints = 0;
		for (TransactionEntity transactionEntity : lastMonthTransactions) {
			totalRewardPoints += this.calculateRewardPoint(transactionEntity.getSpendDollar());
		}
		return totalRewardPoints;
	}
	
	@Override
	public List<TransactionEntity> getQuarterlyTransactionsPerCustomer(int customerId) {
	Calendar c = Calendar.getInstance();
	Date todayDate = c.getTime();
	c.add(Calendar.MONTH, -3);
	Date threeMonthBackDate = c.getTime();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	System.out.println(formatter.format(todayDate));
	System.out.println(formatter.format(threeMonthBackDate));

	return rewardRepository.findAllQuarterlyTransactionsPerCustomer(customerId,todayDate,threeMonthBackDate);
	}

}
