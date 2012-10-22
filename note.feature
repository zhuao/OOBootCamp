GIVEN 3 available slots
WHEN  park 1
THEN  2 available slots

GIVEN 0 available slot
WHEN park 1
THEN Exception

GIVEN 3 available slots
WHEN unpark 1
THEN 4 available

GIVEN 3 available slots
WHEN unpark 1
THEN Exception



GIVEN 3 available slots
WHEN unpark 1
THEN Exception



GIVEN 3 available slots
WHEN unpark 1
THEN Exception


#### function programming, ATDD by example,
GIVEN 2 parking lots, 1 car park in one parking lot
WHEN 1 park
THEN