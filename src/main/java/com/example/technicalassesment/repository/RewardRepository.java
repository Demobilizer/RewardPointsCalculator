package com.example.technicalassesment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.technicalassesment.models.TransactionEntity;

@Repository
public interface RewardRepository extends JpaRepository<TransactionEntity, String> {

	@Query("select t from TransactionEntity t where t.customerId = :customerId and (t.date <= :todayDate AND t.date >= :oneMonthBackDate)")
	List<TransactionEntity> findAllLastMonthTransactionsPerCustomer(
			@Param("customerId") int customerId, 
			@Param("todayDate") Date todayDate, 
			@Param("oneMonthBackDate") Date oneMonthBackDate);

	/**
	 * @param customerId
	 * @param todayDate
	 * @param threeMonthBackDate
	 * @return
	 */
	
	@Query("select t from TransactionEntity t where t.customerId = :customerId and (t.date <= :todayDate AND t.date >= :threeMonthBackDate)")
	List<TransactionEntity> findAllQuarterlyTransactionsPerCustomer(int customerId, Date todayDate,
			Date threeMonthBackDate);
	
	/*
	 * @Query("select t from TransactionEntity t where t.customerId = :customerId and month(t.date) "
	 * ) List<TransactionEntity> findAllQuarterlyTransactionsPerCustomer(
	 * 
	 * @Param("customerId") int customerId);
	 */
	
	/*
	 * @Query("select t from TransactionEntity t where t.customerId = :customerId and month(t.date) = month(:currentDate)"
	 * ) List<TransactionEntity> findAllLastMonthTransactionsPerCustomer(
	 * 
	 * @Param("customerId") int customerId,@Param("currentDate") LocalDate localDate
	 * );
	 */

	/*
	 * public List<TransactionEntity>
	 * findAllByCustomerIdByStartDateLessThanEqualAndEndDateGreaterThanEqual(int
	 * custId, Date todayDate, Date oneMonthBackDate);
	 */
	
	
}
