# Backtracking algorithm for Chronosite

The problem is that we have already created N timeslots and M people which you should assign to this timeslots. We should generate the combinations when all timeslots fulfilled by people. Also, it is known in advance if person can take such timeslot or not. If it is impossible then return error

Obviously, the best scenario, that is when all people were involved in schedule generation. We will use backtracking algorithm.

Generally, allgorithm starts from the first timeslot and person which potentailly can be assigned:

1) If we passed constraints, then we add person as an option for the next computation. 
2) If we cannot assign anyone, then we back to previous timeslot. If we reach out the end, then it is impossible to generate schedule.
3) We move forward in case of 1st scenario. Looping it until we will not fulfill all timeslots

Also, the issue to find out the most optimal schedules(in case of couple of them):

1) If N >= M, then we looking for involving of all people.
2) If N < M, then we just generate some options. We should understand that in that's scenario will cannot assign everyone.
