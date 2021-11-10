SELECT
	tb1.`name` AS Department,
	tb2.`name` AS Employee,
	tb2.salary AS Salary
FROM
	Department AS tb1,
	Employee AS tb2
WHERE
	tb1.id = tb2.departmentId
	AND
	(tb2.salary, tb1.id) IN
	(
		SELECT
			MAX(salary), departmentId
		FROM
			Employee
		GROUP BY departmentId
	)