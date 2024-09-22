import heapq

def maximize_job_profit(N, jobs):
    # Sort jobs by their deadlines
    jobs.sort(key=lambda x: x[0])
    
    max_profit = 0
    max_jobs = []
    
    for deadline, profit in jobs:
        if len(max_jobs) < deadline:
            # If there are fewer jobs than the current deadline, add the job
            heapq.heappush(max_jobs, profit)
            max_profit += profit
        elif max_jobs and max_jobs[0] < profit:
            # Replace the job with the smallest profit if the current job offers more profit
            max_profit += profit - heapq.heappop(max_jobs)
            heapq.heappush(max_jobs, profit)
    
    return max_profit

# Read input from user
N = int(input())
jobs = []
for _ in range(N):
    deadline, profit = map(int, input().split())
    jobs.append((deadline, profit))

# Calculate and print the result
result = maximize_job_profit(N, jobs)
print(result)