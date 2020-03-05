package com.example.technicalassesment.service;

import java.util.List;

import com.example.technicalassesment.models.TransactionEntity;

public interface RewardService {

	public TransactionEntity saveTransaction(TransactionEntity rewardEntity);
	public int calculateRewardPoint(int dollarSpend);
	public List<TransactionEntity> getMonthlyTransactionsPerCustomer(int customerId);
	public int getTotalRewardPointsPerTransaction(List<TransactionEntity> lastMonthTransactions);
	/**
	 * @param customerId
	 * @return
	 */
	List<TransactionEntity> getQuarterlyTransactionsPerCustomer(int customerId);
}
