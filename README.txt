1) Json to send request to add the transaction:

	POST: localhost:8080/insertTransaction

	with following Json data:

			{
				"customerId":1,
				"custName":"c1",
				"spendDollar":120
			}

2)

	GET: localhost:8080/getLastMonthRewardPointsPerCustomer/1
	(here 1 is the customer ID)
